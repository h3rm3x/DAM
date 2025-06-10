package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Cambiamos la URL para especificar MariaDB
    private static final String URL = "jdbc:mariadb://localhost:3306/public_library";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Cargar el driver JDBC específico para MariaDB
                Class.forName("mariadb-java-client-3.5.3.jar");
                // Establecer la conexión
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión establecida con éxito con MariaDB");
            } catch (ClassNotFoundException e) {
                System.err.println("Error al cargar el driver JDBC de MariaDB: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Error al conectar con MariaDB: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada");
                connection = null; // Para permitir una nueva conexión
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}