import java.io.*;
public class ex_10_4 {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo.txt");
            OutputStream out = new FileOutputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo_copia.txt");
            byte[] datos = new byte[1024];
            int leidos = 0;
            while ((leidos = in.read(datos)) != -1) {
                out.write(datos, 0, leidos);
            }
            in.close();
            out.close();
            System.out.println("El archivo se ha copiado correctamente");
            System.out.println("Ruta del archivo copiado: " + new File("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo_copia.txt").getAbsolutePath());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
