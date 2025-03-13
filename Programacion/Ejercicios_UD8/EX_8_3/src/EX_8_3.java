import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EX_8_3 {
    public static void main(String[] args) {
        System.out.println("Iniciando programa...");

        System.out.println("Llamando al método que puede lanzar NullPointerException:");
        try {
            provocarNullPointerException();
            System.out.println("Este mensaje no se mostrará si se lanza la excepción");
        } catch (NullPointerException e) {
            System.out.println("Se ha capturado NullPointerException: " + e.getMessage());
        }

        System.out.println("\nLlamando al método que puede lanzar IOException:");
        try {
            provocarIOException();
            System.out.println("Este mensaje no se mostrará si se lanza la excepción");
        } catch (IOException e) {
            System.out.println("Se ha capturado IOException: " + e.getMessage());
        }
        System.out.println("\nFin del programa");
    }

    public static void provocarNullPointerException() {
        String texto = null;
        System.out.println("Longitud del texto: " + texto.length()); // Lanza NullPointerException
    }

    public static void provocarIOException() throws IOException {
        File ficheroInexistente = new File("/ruta/inexistente/archivo.txt");
        FileWriter escritor = new FileWriter(ficheroInexistente); // Lanza IOException
        escritor.write("Este texto nunca se escribirá");
    }
}