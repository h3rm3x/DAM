import java.util.ArrayList;
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
        System.out.println( copia_colores.stream().sorted());

        //

    }
}
