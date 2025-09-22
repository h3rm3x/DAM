import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ex_4 {
    public static void main(String[] args) {
        try {
            // Leer datos originales y calcular total
            double totalCompra = 0;
            ArrayList<producto> productos = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\Examen_ejemplo\\datos_examen.txt"));
            br.readLine(); // Saltar cabecera

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0];
                int cantidad = Integer.parseInt(datos[1]);
                double precio = Double.parseDouble(datos[2]);

                productos.add(new producto(nombre, cantidad, precio));
                totalCompra += cantidad * precio;
            }
            br.close();

            // Escribir en binario
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream("productos.dat"));

            for (producto p : productos) {
                dos.writeInt(p.getNombre().length());
                dos.writeChars(p.getNombre());
                dos.writeInt(p.getCantidad());
                dos.writeDouble(p.getPrecio());
            }
            dos.close();

            // Comprimir
            FileInputStream fis = new FileInputStream("productos.dat");
            GZIPOutputStream gzos = new GZIPOutputStream(
                    new FileOutputStream("productos.dat.gz"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                gzos.write(buffer, 0, len);
            }
            fis.close();
            gzos.close();

            // Leer comprimido y analizar
            GZIPInputStream gzis = new GZIPInputStream(
                    new FileInputStream("productos.dat.gz"));
            DataInputStream dis = new DataInputStream(gzis);

            // Escribir análisis
            BufferedWriter bw = new BufferedWriter(new FileWriter("analisis_productos.txt"));

            bw.write("ANÁLISIS DE PRODUCTOS\n");
            bw.write("====================\n\n");

            for (int i = 0; i < productos.size(); i++) {
                int longNombre = dis.readInt();
                StringBuilder nombre = new StringBuilder();
                for (int j = 0; j < longNombre; j++) {
                    nombre.append(dis.readChar());
                }
                int cantidad = dis.readInt();
                double precio = dis.readDouble();
                double valor = cantidad * precio;
                double porcentaje = (valor / totalCompra) * 100;

                if (i == 2) { // Tercer producto
                    System.out.println("Tercer producto:");
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Cantidad: " + cantidad);
                    System.out.println("Precio: " + precio);
                }

                bw.write(String.format("%s: %.2f%% del total\n",
                        nombre.toString(), porcentaje));
            }

            dis.close();
            bw.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}