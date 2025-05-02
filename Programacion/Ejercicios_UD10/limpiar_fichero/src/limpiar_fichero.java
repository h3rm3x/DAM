import java.io.*;
import java.util.*;

public class limpiar_fichero {
    public static void main(String[] args) {
        TreeSet<producto> almacen = new TreeSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion" +
                    "\\Ejercicios_UD10\\limpiar_fichero\\almacenBrut.txt"));
            String linea;
            String[] datos;
            while ((linea = br.readLine()) != null) {
                datos = linea.split(",");
                if (datos.length == 5) {
                    boolean vacio = false;
                    for (String dato : datos) {
                        if (dato.trim().isEmpty()) {
                            vacio = true;
                            break;
                        }
                    }
                    if (vacio) {continue;}

                    try {
                        almacen.add(new producto(Integer.parseInt(datos[0]),datos[1],datos[2],
                                Integer.parseInt(datos[3]),Double.parseDouble(datos[4])));
                    }catch (Exception e){
                        System.out.println("Error en la conversión de datos: " + e.getMessage());
                    }

                }
            }
            br.close();

            for (producto p : almacen) {
                System.out.println(p.getId() + "," + p.getNombre() + "," + p.getCategoria() + "," +
                        p.getCantidad() + "," + p.getPrecio());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
