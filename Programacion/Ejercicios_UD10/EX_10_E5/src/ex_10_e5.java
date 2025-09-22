import java.util.*;
import java.io.*;

public class ex_10_e5 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\EX_10_E5\\UD10-temperatures.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;

            // Crear un HashMap para almacenar las medias de cada mes
            HashMap<String, Double> temperaturasMedias = new HashMap<>();
            String[] nombresMeses = null;

            // Leer la primera línea del archivo para obtener los nombres de los meses
            if ((linea = br.readLine()) != null) {
                nombresMeses = linea.split(",");
                for (String mes : nombresMeses) {
                    temperaturasMedias.put(mes, 0.0);
                }
            }

            // Contador para el número de años (filas de datos)
            int numeroAnios = 0;

            // Procesar las temperaturas en las líneas siguientes
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                for (int i = 0; i < partes.length; i++) {
                    double temperatura = Double.parseDouble(partes[i]);
                    String mes = nombresMeses[i];

                    // Sumar la temperatura al acumulador del mes correspondiente
                    temperaturasMedias.put(mes, temperaturasMedias.get(mes) + temperatura);
                }
                numeroAnios++;
            }

            // Calcular la media para cada mes
            for (String mes : nombresMeses) {
                double suma = temperaturasMedias.get(mes);
                temperaturasMedias.put(mes, suma / numeroAnios);
            }

            // Mostrar las medias de cada mes
            System.out.println("Media de temperaturas por mes:");
            for (String mes : nombresMeses) {
                System.out.println(mes + ": " + temperaturasMedias.get(mes));
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo");
        } catch (NumberFormatException e) {
            System.out.println("Error al procesar un valor numérico del archivo");
        }
    }
}