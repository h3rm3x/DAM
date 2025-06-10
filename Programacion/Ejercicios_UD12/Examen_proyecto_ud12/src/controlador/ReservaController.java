package controlador;

import modelo.Reserva;
import modelo.DatabaseConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaController {
    public List<Reserva> obtenerTodasLasReservas() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                reservas.add(mapearReserva(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas: " + e.getMessage());
        }
        return reservas;
    }
    
    public List<Reserva> filtrarReservasPorEstado(String estado) {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE reservation_state = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, estado);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    reservas.add(mapearReserva(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al filtrar reservas: " + e.getMessage());
        }
        return reservas;
    }
    
    public List<Reserva> obtenerReservasDeHoy() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE date_in = CURDATE()";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                reservas.add(mapearReserva(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas de hoy: " + e.getMessage());
        }
        return reservas;
    }
    
    public List<Reserva> obtenerReservasAtrasadas() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE date_out < CURDATE() AND reservation_state = 'collected'";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                reservas.add(mapearReserva(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas atrasadas: " + e.getMessage());
        }
        return reservas;
    }
    
    public boolean crearReserva(String isbn, String nie, LocalDate fechaInicio, LocalDate fechaFin) {
        String sql = "INSERT INTO reservations (book_ISBN, customer_NIE, date_in, date_out, reservation_state) " +
                     "VALUES (?, ?, ?, ?, 'pending')";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, isbn);
            pstmt.setString(2, nie);
            pstmt.setDate(3, Date.valueOf(fechaInicio));
            pstmt.setDate(4, Date.valueOf(fechaFin));
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al crear reserva: " + e.getMessage());
            return false;
        }
    }
    
    public boolean registrarDevolucion(int idReserva, boolean devueltoTarde) {
        String sql = "UPDATE reservations SET real_date_in = CURDATE(), returned_late = ?, " +
                     "reservation_state = 'returned' WHERE reservation_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setBoolean(1, devueltoTarde);
            pstmt.setInt(2, idReserva);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar devolución: " + e.getMessage());
            return false;
        }
    }
    
    public boolean cancelarReserva(int idReserva) {
        String sql = "DELETE FROM reservations WHERE reservation_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idReserva);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al cancelar reserva: " + e.getMessage());
            return false;
        }
    }
    
    private Reserva mapearReserva(ResultSet rs) throws SQLException {
        return new Reserva(
            rs.getInt("reservation_id"),
            rs.getString("book_ISBN"),
            rs.getString("customer_NIE"),
            rs.getDate("date_in").toLocalDate(),
            rs.getDate("date_out").toLocalDate(),
            rs.getBoolean("returned_late"),
            rs.getDate("real_date_out") != null ? rs.getDate("real_date_out").toLocalDate() : null,
            rs.getDate("real_date_in") != null ? rs.getDate("real_date_in").toLocalDate() : null,
            rs.getString("reservation_state")
        );
    }
}