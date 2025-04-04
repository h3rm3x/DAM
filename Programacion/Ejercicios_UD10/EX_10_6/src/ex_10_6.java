import java.io.*;
import java.util.zip.GZIPOutputStream;

public class ex_10_6 {
    public static void main(String[] args)  {

        try {
            GZIPOutputStream gis = new GZIPOutputStream(new FileOutputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo.gz"));
            FileInputStream fis = new FileInputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo.txt");
            byte[] datos = new byte[1024];
            int leidos = 0;
            while ((leidos = fis.read(datos)) != -1) {
                gis.write(datos, 0, leidos);
            }
            fis.close();
            gis.close();
            System.out.println("El archivo se ha comprimido correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
