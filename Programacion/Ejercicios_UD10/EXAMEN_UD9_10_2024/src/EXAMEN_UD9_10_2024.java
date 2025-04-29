import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.time.LocalTime.now;

public class EXAMEN_UD9_10_2024 {
    public static void main(String[] args) {
        try {
            FileReader fr_compra1 = new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\EXAMEN_UD9_10_2024\\compra1.csv");
            BufferedReader br_compra1 = new BufferedReader(fr_compra1);
            String linea;
            // crear un array de LiniaDeFactura
            ArrayList<LiniaDeFactura> lineasFactura = new ArrayList<>();
            //fecha de la factura
            Date fecha = new Date();
            Factura factura = new Factura(fecha, 0, lineasFactura);

            Boolean linea1 = br_compra1.readLine() != null;
            leerLineas(lineasFactura, factura, br_compra1);


            br_compra1.close();
            fr_compra1.close();

            FileReader fr_compra2 = new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\EXAMEN_UD9_10_2024\\compra2.csv");
            BufferedReader br_compra2 = new BufferedReader(fr_compra2);

            Boolean linea2 = br_compra2.readLine() != null;

            leerLineas(lineasFactura, factura, br_compra2);
            factura.setLinias(lineasFactura);

            br_compra2.close();
            fr_compra2.close();

            FileWriter fw = new FileWriter("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\EXAMEN_UD9_10_2024\\factura.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat df = new DecimalFormat("#.00");
            bw.write("Fecha: " + sdf.format(factura.getFecha()) + "\n");
            bw.write("Total: " + df.format(factura.getTotal()) + "\n");
            bw.write("Líneas de la factura:\n");
            for (LiniaDeFactura linia : factura.getLinias()) {
                bw.write("- "+ linia.getDescripcion() + ", " + linia.getCantidad() + ", " + linia.getPrecioUnitario() + "\n");
            }
            bw.close();

            FileReader fr_factura = new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\EXAMEN_UD9_10_2024\\factura.dat");
            BufferedReader br_factura = new BufferedReader(fr_factura);
            String lineaFactura;
            while ((lineaFactura = br_factura.readLine()) != null) {
                System.out.println(lineaFactura);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo");
        }
    }

    public static void leerLineas(ArrayList<LiniaDeFactura> lineasFactura, Factura factura, BufferedReader br_compra2) throws IOException {
        String linea;
        while ((linea = br_compra2.readLine()) != null) {
            String[] partes = linea.split(";");
            String descripcion = partes[0];
            double cantidad = Double.parseDouble(partes[1]);
            double precioUnitario = Double.parseDouble(partes[2]);
            LiniaDeFactura linia = new LiniaDeFactura(descripcion, cantidad, precioUnitario);
            factura.setTotal(factura.getTotal() + (linia.getCantidad() * linia.getPrecioUnitario()));
            lineasFactura.add(linia);
        }
    }
}
