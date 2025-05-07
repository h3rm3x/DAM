import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // hashset para guardar la lista de participantes
        HashSet<participante> participantes = new HashSet<>();
        // Hashmap para guardar todos los participantes de cada Salida
        TreeMap<String, ArrayList<participante>> listaParticipantesCompeticiones = new TreeMap<>();
        try {
            // declaracion de flujos
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\EXAMEN_UD9_10\\participantes.txt"));
            String linea;
            String[] campos;
            int cont = 0;
            // bucle para recorrer todos el fichero linea por linea
            while ((linea = br.readLine()) != null) {

                campos = linea.split(";"); // dividimos la linea en un array donde cada elemento sera cada uno de los cmpos separados por ;
                if (campos.length == 3) { //si la linea tiene los 3 campos comprobamos si cada uno de ellos tiene contenido
                    boolean vacio = false;
                    for (String dato : campos) {
                        if (dato.trim().isEmpty()) {
                            vacio = true;
                            break;
                        }
                    }
                    if (vacio) {
                        continue;
                    }

                    try { //una vez comprobado que tiene contenido comprobamos que cada campo tiene los datos en el formato deseado
                        participantes.add(new participante(campos[0], Integer.parseInt(campos[1]), campos[2]));
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }
            br.close(); //cerramos el flujo
            for (participante participante : participantes) { //recorremos la lista de participantes para rellenar el hashmap

                if(!listaParticipantesCompeticiones.containsKey(participante.getPrueba())) { // si la prueba todavia no ha sido insertada introducimos una nueva clava con la prueba actual y un arraylist con el participante

                    listaParticipantesCompeticiones.put(participante.getPrueba(), new ArrayList<participante>());
                    listaParticipantesCompeticiones.get(participante.getPrueba()).add(participante);
                }else { // si se ha introducido la prueba se añade el participante al arraylis
                    listaParticipantesCompeticiones.get(participante.getPrueba()).add(participante);
                }
            }
            double edad_media=0;

            System.out.println("Participantes de la prueba: ");
            for (String competicon : listaParticipantesCompeticiones.keySet()) { // recorremos cada elemento del hashmap y el arraylist que contiene para obtener la edad media y el numero de participantes
                for(participante participante : listaParticipantesCompeticiones.get(competicon)) {
                    edad_media += participante.getEdad();
                }
                edad_media=edad_media/listaParticipantesCompeticiones.get(competicon).size();
                System.out.println(competicon+": "+listaParticipantesCompeticiones.get(competicon).size()+" participantes, edad promedio:"+String.format("%.2f",edad_media)+ " años");
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}