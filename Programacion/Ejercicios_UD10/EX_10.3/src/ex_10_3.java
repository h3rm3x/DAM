import java.io.*;
public class ex_10_3 {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\EX_10.2\\src\\EX_10_2.java");
            OutputStream out = new FileOutputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ex_10_2_copia.java");
            byte[] datos = new byte[1024];
            int leidos = 0;
            while ((leidos = in.read(datos)) != -1) {
                out.write(datos, 0, leidos);
            }
            in.close();
            out.close();
            System.out.println("El archivo se ha copiado correctamente");
            System.out.println("Ruta del archivo copiado: " + new File("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ex_10_2_copia.java").getAbsolutePath());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
