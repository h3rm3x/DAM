import java.io.*;
import java.util.*;

public class limpiar_fichero {
    public static void main(String[] args) {
         TreeSet<producto> almacen = new TreeSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion" +
                    "\\Ejercicios_UD10\\limpiar_fichero\\almacenBrut.txt"));
            String campo;
            String[] linea;
            int cont = 0;
            while ((campo = br.readLine()) != null) {

                linea = campo.split(",");
                if (linea.length == 5) {
                    boolean vacio = false;
                    for (String dato : linea) {
                        if (dato.trim().isEmpty()) {
                            vacio = true;
                            break;
                        }
                    }
                    if (vacio) {continue;}

                    try {
                        almacen.add(new producto(Integer.parseInt(linea[0]),linea[1],linea[2],
                               Integer.parseInt(linea[3]),Double.parseDouble(linea[4])));
                        cont++;
                       // System.out.println(cont +"--> ID: "+ Integer.parseInt(linea[0]) +" Producto: " + linea[1]  +
                        //        " " +
                        //        "Categoria" +
                        //        ": " + linea[2] +
                         //       " Cantidad: " + Integer.parseInt(linea[3]) + " Precio: " + Double.parseDouble
                        //       (linea[4]));

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
