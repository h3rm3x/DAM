package controlador;

import modelo.DatabaseConnection;
import modelo.Cliente;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private static final String TABLE_NAME = "clients";

    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getString("NIE"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("email"),
                        rs.getBoolean("red_flag")
                ));
            }
        } catch (SQLException e) {
            handleSQLException("Error al obtener clientes", e);
        }
        return clientes;
    }

    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO " + TABLE_NAME + " (NIE, first_name, last_name, phone, birth_date, email, red_flag) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            setClienteParameters(pstmt, cliente);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException("Error al agregar cliente", e);
            return false;
        }
    }

    public Cliente obtenerClientePorNIE(String nie) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE NIE = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nie);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getString("NIE"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("phone"),
                            rs.getDate("birth_date").toLocalDate(),
                            rs.getString("email"),
                            rs.getBoolean("red_flag")
                    );
                }
            }
        } catch (SQLException e) {
            handleSQLException("Error al obtener cliente por NIE", e);
        }
        return null;
    }

    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE " + TABLE_NAME + 
                " SET first_name = ?, last_name = ?, phone = ?, birth_date = ?, email = ?, red_flag = ? " +
                " WHERE NIE = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.setDate(4, Date.valueOf(cliente.getFechaNacimiento()));
            pstmt.setString(5, cliente.getEmail());
            pstmt.setBoolean(6, cliente.isRedFlag());
            pstmt.setString(7, cliente.getNIE());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException("Error al actualizar cliente", e);
            return false;
        }
    }

    public boolean eliminarCliente(String nie) {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE NIE = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nie);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException("Error al eliminar cliente", e);
            return false;
        }
    }

    public List<Cliente> obtenerTodosLosClientesPorNombre(String nombre) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + 
                " WHERE LOWER(first_name) LIKE ? OR LOWER(last_name) LIKE ? OR LOWER(NIE) LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String busqueda = "%" + nombre.toLowerCase() + "%";
            pstmt.setString(1, busqueda);
            pstmt.setString(2, busqueda);
            pstmt.setString(3, busqueda);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    clientes.add(new Cliente(
                            rs.getString("NIE"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("phone"),
                            rs.getDate("birth_date").toLocalDate(),
                            rs.getString("email"),
                            rs.getBoolean("red_flag")
                    ));
                }
            }
        } catch (SQLException e) {
            handleSQLException("Error al buscar clientes por nombre", e);
        }
        return clientes;
    }

    private void setClienteParameters(PreparedStatement pstmt, Cliente cliente) throws SQLException {
        pstmt.setString(1, cliente.getNIE());
        pstmt.setString(2, cliente.getNombre());
        pstmt.setString(3, cliente.getApellido());
        pstmt.setString(4, cliente.getTelefono());
        pstmt.setDate(5, Date.valueOf(cliente.getFechaNacimiento()));
        pstmt.setString(6, cliente.getEmail());
        pstmt.setBoolean(7, cliente.isRedFlag());
    }

    private void handleSQLException(String message, SQLException e) {
        System.err.println(message + ": " + e.getMessage());
        e.printStackTrace();
    }
}