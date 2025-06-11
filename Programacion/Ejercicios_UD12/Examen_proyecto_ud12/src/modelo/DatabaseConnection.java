package modelo;


import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/public_library";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    static {
        try {
            // Crear la base de datos y tablas si no existen
            inicializarBaseDatos();
        } catch (SQLException e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    private static void inicializarBaseDatos() throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/", USER, PASSWORD)) {
            // Crear base de datos si no existe
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE DATABASE IF NOT EXISTS public_library");
            stmt.close();

            // Conectar a la base de datos específica
            try (Connection libConn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                Statement libStmt = libConn.createStatement();

                // Crear tabla clients
                libStmt.execute("CREATE TABLE IF NOT EXISTS clients (" +
                        "NIE VARCHAR(20) PRIMARY KEY, " +
                        "first_name VARCHAR(50) NOT NULL, " +
                        "last_name VARCHAR(50) NOT NULL, " +
                        "phone VARCHAR(20), " +
                        "birth_date DATE, " +
                        "email VARCHAR(100), " +
                        "red_flag BOOLEAN DEFAULT FALSE)");

                // Crear tabla books
                libStmt.execute("CREATE TABLE IF NOT EXISTS books (" +
                        "ISBN VARCHAR(20) PRIMARY KEY, " +
                        "title VARCHAR(100) NOT NULL, " +
                        "author VARCHAR(100) NOT NULL, " +
                        "editorial VARCHAR(50), " +
                        "number_of_pages INT, " +
                        "edition INT, " +
                        "genre VARCHAR(50), " +
                        "year_released INT, " +
                        "availiability ENUM('available', 'unavailable') DEFAULT 'available')");

                // Crear tabla reservations
                libStmt.execute("CREATE TABLE IF NOT EXISTS reservations (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "book_ISBN VARCHAR(20), " +
                        "client_NIE VARCHAR(20), " +
                        "start_date DATE NOT NULL, " +
                        "end_date DATE NOT NULL, " +
                        "returned_late BOOLEAN DEFAULT FALSE, " +
                        "real_start_date DATE, " +
                        "real_end_date DATE, " +
                        "status ENUM('pendientes', 'activas', 'devueltas', 'canceladas') DEFAULT 'pendientes', " +
                        "FOREIGN KEY (book_ISBN) REFERENCES books(ISBN), " +
                        "FOREIGN KEY (client_NIE) REFERENCES clients(NIE))");

                libStmt.close();
            }
        }
    }
}