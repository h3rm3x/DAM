import java.util.*;
public class operaciones_con_treeset {
    public static void main(String[] args) {
        // Creamos un TreeSet
        TreeSet<String> ts = new TreeSet<>();
        // Añadimos elementos
        ts.add("Hola");
        ts.add("Adiós");
        ts.add("Buenos días");
        ts.add("Buenas noches");
        ts.add("Hasta luego");

        // Mostramos el TreeSet
        ts.iterator().forEachRemaining(System.out::println);

        // Comprobamos si el TreeSet contiene el elemento "Adiós" y "Hasta luego"
        System.out.println("¿Contiene el elemento \"Adiós\"? " + ts.contains("Adiós"));
        System.out.println("¿Contiene el elemento \"Hasta luego\"? " + ts.contains("Hasta luego"));

        // intentar añadir un elemento que ya existe
        ts.add("Buenas noches");

        // eliminar un elemento
        ts.remove("Buenos días");

        // Mostramos el TreeSet
        ts.iterator().forEachRemaining(System.out::println);


    }
}
