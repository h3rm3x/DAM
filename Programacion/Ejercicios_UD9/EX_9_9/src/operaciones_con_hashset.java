import java.util.*;
public class operaciones_con_hashset {
    public static void main(String[] args) {
        // Creamos un HashSet
        HashSet<Integer> hs = new HashSet<>();
        // Añadimos elementos
        hs.add(10);
        hs.add(20);
        hs.add(30);
        hs.add(40);
        hs.add(50);

        // Mostramos el HashSet
        hs.iterator().forEachRemaining(System.out::println);

        // Comprobamos si el HashSet contiene el elemento 20 y 35
        System.out.println("¿Contiene el elemento 20? " + hs.contains(20));
        System.out.println("¿Contiene el elemento 35? " + hs.contains(35));

        // Eliminamos el elemento 40
        hs.remove(40);

        // Mostramos el HashSet
        hs.iterator().forEachRemaining(System.out::println);

        // intentar añadir un elemento que ya existe
        hs.add(50);

        // Mostramos el HashSet
        hs.iterator().forEachRemaining(System.out::println);

        // mostrar el tamaño del HashSet
        System.out.println("Tamaño del HashSet: " + hs.size());

        // limpiar el HashSet
        hs.clear();

        // verificar si el HashSet está vacío
        System.out.println("¿El HashSet está vacío? " + hs.isEmpty());
    }
}
