import java.io.*;
import java.util.*;
public class ex_10_11 {
    public static void main(String[] args) {
        try {
            // Create a FileWriter object to write to the file
            FileWriter fw_par = new FileWriter("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ex_10_11_pares.txt");
            FileWriter fw_impar = new FileWriter("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ex_10_11_impares.txt", true);
            BufferedWriter bw_par = new BufferedWriter(fw_par);
            BufferedWriter bw_impar = new BufferedWriter(fw_impar);

            Random rand = new Random();
            // Generar 1000 integers aleatorios entre 1 y 1000
            for (int i = 0; i < 1000; i++) {
                int randomInt = rand.nextInt(1000) + 1; // Random integer between 1 and 1000
                if (randomInt % 2 == 0) {
                    // Si el número es par, escribirlo en el archivo de pares
                    bw_par.write(randomInt + " ");
                } else {
                    // Si el número es impar, escribirlo en el archivo de impares
                    bw_impar.write(randomInt + " ");
                }

            }
            // Cerrar los BufferedWriter y FileWriter
            bw_par.close();
            bw_impar.close();
            fw_par.close();
            fw_impar.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
