import java.util.*;
import java.io.*;
public class ex_10_9 {
    public static void main(String[] args) {
        // Crear un archivo de texto con 1000 números aleatorios
        // y recuperar un número aleatorio de ese archivo

        String rutaArchivo = "C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\randomInts.txt";

        try {
            // Crear y escribir varias líneas en el archivo
            FileWriter fw = new FileWriter(rutaArchivo);
            fw.write("Primera línea\n");
            fw.write("Segunda línea\n");
            fw.write("Tercera línea\n");
            fw.write("Cuarta línea\n");
            fw.close();
            System.out.println("Archivo creado y escrito correctamente.");

            // Leer un carácter aleatorio del archivo
            RandomAccessFile raf = new RandomAccessFile(rutaArchivo, "r");
            long longitudArchivo = raf.length();
            Random random = new Random();
            long posicionAleatoria = random.nextLong(longitudArchivo);
            raf.seek(posicionAleatoria);
            char caracterAleatorio = (char) raf.read();
            raf.close();

            System.out.println("Carácter aleatorio recuperado: " + caracterAleatorio);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}
