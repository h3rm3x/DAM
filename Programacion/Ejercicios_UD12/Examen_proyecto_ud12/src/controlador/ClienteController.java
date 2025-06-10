package controlador;

import modelo.Cliente;
import modelo.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getString("NIE"),
                    rs.getString("forename"),
                    rs.getString("surname"),
                    rs.getString("phone_number"),
                    rs.getDate("birth_date").toLocalDate(),
                    rs.getString("email"),
                    rs.getBoolean("red_flag")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los clientes: " + e.getMessage());
        }
        return clientes;
    }
    
    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO customers (NIE, forename, surname, phone_number, birth_date, email, red_flag) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, cliente.getNIE());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getApellido());
            pstmt.setString(4, cliente.getTelefono());
            pstmt.setDate(5, Date.valueOf(cliente.getFechaNacimiento()));
            pstmt.setString(6, cliente.getEmail());
            pstmt.setBoolean(7, cliente.isRedFlag());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
            return false;
        }
    }
    
    public List<Cliente> buscarClientes(String busqueda) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE NIE LIKE ? OR forename LIKE ? OR surname LIKE ? OR email LIKE ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            String parametroBusqueda = "%" + busqueda + "%";
            pstmt.setString(1, parametroBusqueda);
            pstmt.setString(2, parametroBusqueda);
            pstmt.setString(3, parametroBusqueda);
            pstmt.setString(4, parametroBusqueda);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    clientes.add(new Cliente(
                        rs.getString("NIE"),
                        rs.getString("forename"),
                        rs.getString("surname"),
                        rs.getString("phone_number"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("email"),
                        rs.getBoolean("red_flag")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar clientes: " + e.getMessage());
        }
        return clientes;
    }
    
    public Cliente obtenerClientePorNIE(String nie) {
        String sql = "SELECT * FROM customers WHERE NIE = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nie);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                        rs.getString("NIE"),
                        rs.getString("forename"),
                        rs.getString("surname"),
                        rs.getString("phone_number"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("email"),
                        rs.getBoolean("red_flag")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener cliente: " + e.getMessage());
        }
        return null;
    }
    
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE customers SET forename = ?, surname = ?, phone_number = ?, " +
                     "birth_date = ?, email = ?, red_flag = ? WHERE NIE = ?";

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
            System.err.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCliente(String nie) {
        String sql = "DELETE FROM customers WHERE NIE = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nie);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean cambiarRedFlag(String nie, boolean redFlag) {
        String sql = "UPDATE customers SET red_flag = ? WHERE NIE = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setBoolean(1, redFlag);
            pstmt.setString(2, nie);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al cambiar red flag: " + e.getMessage());
            return false;
        }
    }
}