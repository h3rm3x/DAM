import java.io.*;

public class ex_10_5 {
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

            FileInputStream fis = new FileInputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo_copia.txt");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((leidos = fis.read(datos)) != -1) {
                baos.write(datos, 0, leidos);
            }
            fis.close();
            byte[] contenido = baos.toByteArray();

            // Imprimir el contenido del array
            System.out.println("Contenido del archivo copiado:");
            for (byte b : contenido) {
                System.out.print((char) b);
            }


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
