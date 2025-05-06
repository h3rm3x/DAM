import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class ex_1 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("datos_examen.csv"));
            String linea = br.readLine();
            int cantidadTotal = 0;
            double sumaPrecioTotal = 0;
            double precioMayor = 0;
            String nombreMayor = "";
            double precioMenor = Double.MAX_VALUE;
            String nombreMenor = "";

            DecimalFormat df = new DecimalFormat("#.00");

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String producto = datos[0];
                int cantidad = Integer.parseInt(datos[1]);
                double precio = Double.parseDouble(datos[2]);

                if (precio > precioMayor) {
                    precioMayor = precio;
                    nombreMayor = producto;
                }
                if (precio < precioMenor) {
                    precioMenor = precio;
                    nombreMenor = producto;
                }
                cantidadTotal += cantidad;
                sumaPrecioTotal += precio * cantidad;
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("resumen_compra.txt"));
            bw.write("Cantidad total de productos: " + cantidadTotal + "\n");
            bw.write("Precio total de la compra: " + df.format(sumaPrecioTotal) + " €\n");
            bw.write("Producto con el precio mayor: " + nombreMayor + " - " + df.format(precioMayor) + " €\n");
            bw.write("Producto con el precio menor: " + nombreMenor + " - " + df.format(precioMenor) + " €\n");
            bw.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}