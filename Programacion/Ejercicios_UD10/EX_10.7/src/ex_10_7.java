import java.io.*;
public class ex_10_7 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("ejemplo.txt"));
            int contador_lineas = 1;
            String linea;
            while ((null != (linea = br.readLine()))) {
                System.out.println("linea " + contador_lineas + ": " + linea);
                contador_lineas++;
            }
            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
