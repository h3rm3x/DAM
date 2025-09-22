import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class ex_2 {
    public static void main(String[] args) {
        ArrayList<producto> productos = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\Examen_ejemplo\\datos_examen.txt"));
            String linea = br.readLine();
            double total = 0.0;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0];
                int cantidad = Integer.parseInt(datos[1]);
                double precio = Double.parseDouble(datos[2]);

                total += cantidad * precio;
                producto p = new producto(nombre, cantidad, precio);
                productos.add(p);
            }
            br.close();

            compra c = new compra(productos, total);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println("Fecha de compra: " + sdf.format(c.getFecha()));

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("compra_serializada.dat"));
            oos.writeObject(c);
            oos.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}