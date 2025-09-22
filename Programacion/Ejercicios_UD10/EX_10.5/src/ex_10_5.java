import java.io.*;

public class ex_10_5 {
    public static void main(String[] args) {
        try {
            byte[] datos = new byte[1024];
            int leidos = 0;
            FileInputStream fis = new FileInputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo.txt");
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
