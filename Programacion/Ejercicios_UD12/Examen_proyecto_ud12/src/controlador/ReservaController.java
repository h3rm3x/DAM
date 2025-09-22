package controlador;

import modelo.DatabaseConnection;
import modelo.Reserva;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaController {

    public List<Reserva> obtenerTodasLasReservas() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservations ORDER BY start_date DESC";

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Reserva reserva = crearReservaDesdeResultSet(rs);
                reservas.add(reserva);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas: " + e.getMessage());
            e.printStackTrace();
        }
        return reservas;
    }

    public List<Reserva> filtrarReservasPorEstado(String estado) {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE status = ? ORDER BY start_date DESC";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, estado);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Reserva reserva = crearReservaDesdeResultSet(rs);
                reservas.add(reserva);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Error al filtrar reservas por estado: " + e.getMessage());
            e.printStackTrace();
        }
        return reservas;
    }

    public List<Reserva> obtenerReservasDeHoy() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE start_date = ? ORDER BY start_date DESC";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, Date.valueOf(LocalDate.now()));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Reserva reserva = crearReservaDesdeResultSet(rs);
                reservas.add(reserva);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas de hoy: " + e.getMessage());
            e.printStackTrace();
        }
        return reservas;
    }

    public List<Reserva> obtenerReservasAtrasadas() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE end_date < ? AND status != 'devueltas' ORDER BY end_date ASC";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, Date.valueOf(LocalDate.now()));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Reserva reserva = crearReservaDesdeResultSet(rs);
                reservas.add(reserva);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas atrasadas: " + e.getMessage());
            e.printStackTrace();
        }
        return reservas;
    }

    public boolean crearReserva(String isbn, String nie, LocalDate fechaInicio, LocalDate fechaFin) {
        String sql = "INSERT INTO reservations (book_ISBN, client_NIE, start_date, end_date, returned_late, status) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, isbn);
            pstmt.setString(2, nie);
            pstmt.setDate(3, Date.valueOf(fechaInicio));
            pstmt.setDate(4, Date.valueOf(fechaFin));
            pstmt.setBoolean(5, false);
            pstmt.setString(6, "pendientes");

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                actualizarDisponibilidadLibro(isbn, "unavailable");
            }

            pstmt.close();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al crear reserva: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean registrarDevolucion(int idReserva, boolean devueltoTarde) {
        String sql = "UPDATE reservations SET status = 'devueltas', returned_late = ?, real_end_date = ? WHERE id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setBoolean(1, devueltoTarde);
            pstmt.setDate(2, Date.valueOf(LocalDate.now()));
            pstmt.setInt(3, idReserva);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                String isbn = obtenerISBNDeReserva(idReserva);
                if (isbn != null) {
                    actualizarDisponibilidadLibro(isbn, "available");
                }
            }

            pstmt.close();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar devolución: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean cancelarReserva(int idReserva) {
        String sql = "UPDATE reservations SET status = 'canceladas' WHERE id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, idReserva);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                String isbn = obtenerISBNDeReserva(idReserva);
                if (isbn != null) {
                    actualizarDisponibilidadLibro(isbn, "available");
                }
            }

            pstmt.close();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al cancelar reserva: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private Reserva crearReservaDesdeResultSet(ResultSet rs) throws SQLException {
        Date fechaRealInicio = rs.getDate("real_start_date");
        Date fechaRealFin = rs.getDate("real_end_date");

        return new Reserva(
                rs.getInt("id"),
                rs.getString("book_ISBN"),
                rs.getString("client_NIE"),
                rs.getDate("start_date").toLocalDate(),
                rs.getDate("end_date").toLocalDate(),
                rs.getBoolean("returned_late"),
                fechaRealFin != null ? fechaRealFin.toLocalDate() : null,
                fechaRealInicio != null ? fechaRealInicio.toLocalDate() : null,
                rs.getString("status")
        );
    }

    private String obtenerISBNDeReserva(int idReserva) {
        String sql = "SELECT book_ISBN FROM reservations WHERE id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, idReserva);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String isbn = rs.getString("book_ISBN");
                rs.close();
                pstmt.close();
                return isbn;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener ISBN de reserva: " + e.getMessage());
        }
        return null;
    }

    private void actualizarDisponibilidadLibro(String isbn, String disponibilidad) {
        String sql = "UPDATE books SET availiability = ? WHERE ISBN = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, disponibilidad);
            pstmt.setString(2, isbn);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Error al actualizar disponibilidad del libro: " + e.getMessage());
        }
    }
}