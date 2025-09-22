import java.util.*;
public class manipulacion_datos_arraylist {
    public static void main(String[] args) {
        // crear arraylist de colores
        ArrayList<String> colores = new ArrayList<>();
        // añadir colores
        colores.add("Rojo");
        colores.add("Azul");
        colores.add("Verde");
        colores.add("Amarillo");
        colores.add("Blanco");

        System.out.println(colores);
        // iterar para todos los elementos
        colores.iterator().forEachRemaining(System.out::println);

        colores.addFirst("Negro");

        // recuperar un elemento a traves de su index
        System.out.println(colores.get(3));

        // reemplazar un elemento matriz especifico por otro elemento determinado
        colores.set(3, "morado");

        // eliminar el 3er elemento de la lista
        colores.remove(2);

        // buscar un elemento en la lista
        System.out.println( colores.contains("Negro"));

        //ordenar una arraylist
        colores.sort(String::compareTo);
        // copiar la arraylist en otra y desordenarla automaticamente
        ArrayList<String> copia_colores = colores;
        Collections.shuffle(copia_colores);
        System.out.println( copia_colores);

        // invertir los elementos de la lista
        Collections.reverse(colores);
        System.out.println( colores);
        // extraer una parte del ArrayList

        copia_colores.subList(1,3);
        System.out.println(copia_colores);
        // comparar dos arraylists
        System.out.println( colores.equals(copia_colores));
        // unir dos arraylists
        colores.addAll(copia_colores);

        // intercambiar dos elementos de un Arraylist
        Collections.swap(colores,0,1);

        // clonar una arraylist en otra
        copia_colores = new ArrayList<>(colores);

        // vaciar una arraylist
        colores.clear();

        // comprobar si un arraylist esta vacio
        System.out.println(copia_colores.isEmpty());

        //recortar una arraylist a la longitud actual
        colores.trimToSize();

        // aumentar la capacidad de una arraylist
        copia_colores.ensureCapacity(10);

        // sustituir un elemento de la arraylist por otro
        copia_colores.set(0, "Naranja");
        // imprimir la arraylist por los indices
        for (int i = 0; i < copia_colores.size(); i++) {
            System.out.println(copia_colores.get(i));
        }


    }
}
