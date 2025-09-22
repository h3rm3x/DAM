import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
public class manipulacion_datos_linkedlist {
    public static void main(String[] args) {
        // crear linkedlist de colores
        LinkedList<String> colores = new LinkedList<>();
        // añadir colores
        colores.add("Rojo");
        colores.add("Azul");
        colores.add("Verde");
        colores.add("Amarillo");
        colores.add("Blanco");

        System.out.println(colores);
        // iterar para todos los elementos
        colores.iterator().forEachRemaining(System.out::println);

        //iterar para todos los elementos a partir de un index
        colores.listIterator(2).forEachRemaining(System.out::println);
        // itera para todos los elementos en orden inverso
        colores.descendingIterator().forEachRemaining(System.out::println);

        // añadir un elemento en una posicion especifica
        colores.add(5,"Negro");

        // añadir una elemento al final
        colores.addLast("Verde");

        // añadir elementos en posiciones especifica
        colores.add(6, "Azul");
        colores.add(7," Morado");

        // recuperar la primera y ultima instancia de un elemento
        System.out.println(colores.lastIndexOf("Azul") +" "+ colores.indexOf("Azul"));

        // muestra los elementos y sus indices
        Iterator<String> iterator = colores.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            System.out.println("Index: " + index + ", Element: " + iterator.next());
            index++;
        }

        // elimina un elemento especifico de la linkedlist
        colores.remove(5);

        // elimina el primer y ultimo elemento de la linkedlist
        colores.removeFirst();
        colores.removeFirst();

        // elimina todos los elementos de una linkedlist
        LinkedList<String> copia_colores = colores;
        copia_colores.clear();

        // cambia dos elementos de la linkedlist
        colores.set(0,"Amarillo");
        colores.set(1,"Rojo");

        // mezcla los elementos de la linkedlist
        Collections.sort(colores);

        // une dos linkedlist
        colores.addAll(copia_colores);

        // clona una linkedlist
        copia_colores = new LinkedList<>(colores);

        // elimina y devuelve el primer elemento de la linkedlist
        System.out.println(colores.pollFirst());

        // recupera y no elimina el primer elemento de la linkedlist
        System.out.println(colores.peekFirst());

        // recupera y no elimina el ultimo elemento de la linkedlist
        System.out.println(colores.peekLast());

        // comprueba si un elemento esta en la linkedlist
        System.out.println(colores.contains("Rojo"));

        // convierte la linkedlist en un arrayList
        ArrayList<String> colores_array = new ArrayList<>(colores);
        System.out.println(colores_array);

        // compara dos linkedlist
        System.out.println(colores.equals(copia_colores));

        // comprueba si la linkedlist esta vacia
        System.out.println(colores.isEmpty());

        // sustituye un elemento de la linkedlist
        colores.set(0,"Azul");

    }
}
