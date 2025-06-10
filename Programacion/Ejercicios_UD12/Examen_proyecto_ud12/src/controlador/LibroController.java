package controlador;

import modelo.DatabaseConnection;
import modelo.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroController {
    public List<Libro> obtenerTodosLosLibros() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM books";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Libro libro = new Libro(
                    rs.getString("ISBN"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("editorial"),
                    rs.getInt("number_of_pages"),
                    rs.getInt("edition"),
                    rs.getString("genre"),
                    rs.getInt("year_released"),
                    rs.getString("availiability")
                );
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }
    
    public List<Libro> obtenerLibrosDisponibles() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE availiability = 'available'";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Libro libro = new Libro(
                    rs.getString("ISBN"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("editorial"),
                    rs.getInt("number_of_pages"),
                    rs.getInt("edition"),
                    rs.getString("genre"),
                    rs.getInt("year_released"),
                    rs.getString("availiability")
                );
                libros.add(libro);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener libros disponibles: " + e.getMessage());
        }
        return libros;
    }
    
    public boolean agregarLibro(Libro libro) {
        String sql = "INSERT INTO books (ISBN, title, author, editorial, number_of_pages, " +
                     "edition, genre, year_released, availiability) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, libro.getISBN());
            pstmt.setString(2, libro.getTitulo());
            pstmt.setString(3, libro.getAutor());
            pstmt.setString(4, libro.getEditorial());
            pstmt.setInt(5, libro.getPaginas());
            pstmt.setInt(6, libro.getEdicion());
            pstmt.setString(7, libro.getGenero());
            pstmt.setInt(8, libro.getAñoPublicacion());
            pstmt.setString(9, libro.getDisponibilidad());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}