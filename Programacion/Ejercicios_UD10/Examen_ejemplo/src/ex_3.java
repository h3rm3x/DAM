import java.io.*;
import java.util.ArrayList;

public class ex_3 {
    public static void main(String[] args) {
        try {
            // Deserializar
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("compra_serializada.dat"));
            compra c = (compra) ois.readObject();
            ois.close();

            // Añadir nuevos productos
            ArrayList<producto> lista = c.getListaProductos();
            lista.add(new producto("Leche", 2, 1.30));
            lista.add(new producto("Pan", 3, 0.95));

            // Actualizar total
            double nuevoTotal = c.getTotal();
            nuevoTotal += (2 * 1.30) + (3 * 0.95);
            c.setTotal(nuevoTotal);

            // Serializar de nuevo
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("compra_actualizada.dat"));
            oos.writeObject(c);
            oos.close();

            // Mostrar información
            System.out.println("--- COMPRA ACTUALIZADA ---");
            System.out.println(c);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Clase no encontrada");
        }
    }
}