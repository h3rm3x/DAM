import java.io.*;
import java.util.*;

public class libreria {
    public static void main(String[] args) {
        HashSet<libro> libros = new HashSet<>();

        try {
            BufferedReader br_libros1 = new BufferedReader(new FileReader(
                    "C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo_examen\\libros1.txt"));
            String linea = br_libros1.readLine();
            while ((linea = br_libros1.readLine()) != null) {
                String[] datos = linea.split(";");
                int ISBN = Integer.parseInt(datos[0]);
                String titulo = datos[1];
                String autor = datos[2];

                libro nuevoLibro = new libro(ISBN, titulo, autor);
                libros.add(nuevoLibro);
            }
            br_libros1.close();
            BufferedReader br_libros2 = new BufferedReader(new FileReader(
                    "C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo_examen\\libros2.txt"));
            String campo;
            while ((linea = br_libros2.readLine()) != null) {

                String[] datos = linea.split(";");
                if (datos.length == 3) {
                    boolean vacio = false;
                    try {
                        for(String dato : datos){
                            if(dato.trim().isEmpty()){
                                vacio = true;
                            }
                        }
                        if(vacio){ continue;}
                        try {
                            libros.add(new libro(Integer.parseInt(datos[0]), datos[1], datos[2]));
                        }catch (Exception e){
                            System.out.println("Error en la conversión de datos: " + e.getMessage());
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: ISBN no es un número válido en la línea: " + linea);
                        continue;
                    }

                }

            }
            br_libros2.close();
            // Guardar los libros en un nuevo archivo
            BufferedWriter ois = new BufferedWriter(new FileWriter("C:\\Users\\alanr\\Documents\\DAM" +
                    "\\Programacion\\Ejercicios_UD10\\ejemplo_examen\\libros_final.dat"));
            for (libro l : libros) {
                ois.write("ISBN: " + l.getISBN() + ", Titulo: " + l.getTitulo() + ", Autor: " + l.getAutor());

                System.out.println(l);
            }
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado"+ e.getMessage());
        }catch (IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
