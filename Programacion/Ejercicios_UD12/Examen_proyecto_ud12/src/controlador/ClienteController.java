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

    // ... (otros métodos similares con el mismo patrón)

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