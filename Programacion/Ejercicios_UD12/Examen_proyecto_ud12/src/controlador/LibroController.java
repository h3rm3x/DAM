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

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

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

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public List<Libro> obtenerLibrosDisponibles() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE availiability = 'available'";

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

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

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener libros disponibles: " + e.getMessage());
        }
        return libros;
    }

    public List<Libro> buscarLibros(String busqueda) {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR ISBN LIKE ? OR genre LIKE ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            String parametroBusqueda = "%" + busqueda + "%";
            pstmt.setString(1, parametroBusqueda);
            pstmt.setString(2, parametroBusqueda);
            pstmt.setString(3, parametroBusqueda);
            pstmt.setString(4, parametroBusqueda);

            ResultSet rs = pstmt.executeQuery();

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

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Error al buscar libros: " + e.getMessage());
        }
        return libros;
    }

    public Libro obtenerLibroPorISBN(String isbn) {
        String sql = "SELECT * FROM books WHERE ISBN = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
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
                rs.close();
                pstmt.close();
                return libro;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener libro por ISBN: " + e.getMessage());
        }
        return null;
    }

    public boolean agregarLibro(Libro libro) {
        String sql = "INSERT INTO books (ISBN, title, author, editorial, number_of_pages, edition, genre, year_released, availiability) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

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
            pstmt.close();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar libro: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarLibro(Libro libro) {
        String sql = "UPDATE books SET title = ?, author = ?, editorial = ?, number_of_pages = ?, edition = ?, genre = ?, year_released = ?, availiability = ? WHERE ISBN = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setString(3, libro.getEditorial());
            pstmt.setInt(4, libro.getPaginas());
            pstmt.setInt(5, libro.getEdicion());
            pstmt.setString(6, libro.getGenero());
            pstmt.setInt(7, libro.getAñoPublicacion());
            pstmt.setString(8, libro.getDisponibilidad());
            pstmt.setString(9, libro.getISBN());

            int affectedRows = pstmt.executeUpdate();
            pstmt.close();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar libro: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarLibro(String isbn) {
        String sql = "DELETE FROM books WHERE ISBN = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, isbn);
            int affectedRows = pstmt.executeUpdate();
            pstmt.close();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar libro: " + e.getMessage());
            return false;
        }
    }

    // buscar libros disponibles
    public List<Libro> buscarLibrosDisponibles(String busqueda) {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE availiability = 'available' AND " +
                "(title LIKE ? OR author LIKE ? OR ISBN LIKE ? OR genre LIKE ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String parametroBusqueda = "%" + busqueda + "%";
            for (int i = 1; i <= 4; i++) {
                pstmt.setString(i, parametroBusqueda);
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                libros.add(crearLibroDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar libros disponibles: " + e.getMessage());
        }
        return libros;
    }

    private Libro crearLibroDesdeResultSet(ResultSet rs) throws SQLException {
        return new Libro(
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
    }
}