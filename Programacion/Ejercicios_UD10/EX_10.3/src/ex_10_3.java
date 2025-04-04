import java.io.*;
public class ex_10_3 {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\EX_10.2\\src\\EX_10_2.java");
            OutputStream out = new FileOutputStream("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ex_10_2_copia.java");
            byte[] datos = new byte[1024];
            int leidos = 0;
            int iteraciones = 0;
            int bytesleidos = 0;
            while ((leidos = in.read(datos)) != -1) {
                out.write(datos, 0, leidos);
                iteraciones++;
                for (int i = 0; i < datos.length; i++) {
                    if (datos[i]== 0) {
                        bytesleidos= i;
                    }

                }
                bytesleidos+=(iteraciones-1)*1024;
            }
            in.close();
            out.close();
            File original = new File("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\EX_10.2\\src\\EX_10_2.java");
            File copia = new File("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ex_10_2_copia.java");
            System.out.println("El archivo se ha copiado correctamente");
            System.out.println("longitud del archivo original: " + original.length()+" longitud del archivo copia: " + copia.length()+ " bytes copiados " + bytesleidos+" bytes");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
