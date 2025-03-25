import java.util.LinkedList;
public class LinkedList_ciudades {
    public static void main(String[] args) {
        LinkedList<String> ciudades = new LinkedList<>();

        ciudades.add("Barcelona");
        ciudades.add("Madrid");
        ciudades.add("Valencia");
        ciudades.add("Sevilla");

        System.out.println(ciudades);
        // añadir al principio la ciudad de Bilbao
        ciudades.addFirst("Bilbao");

        // añadir al final la ciudad de Malaga
        ciudades.addLast("Malaga");

        // mostrar la primera y la ultima ciudad
        System.out.println(ciudades.getFirst() +" "+ ciudades.getLast());

        //eliminar la primera ciudad
        ciudades.removeFirst();
        //eliminar la ultima ciudad
        ciudades.removeLast();
        // mostrar todas las ciudades
        System.out.println(ciudades);
    }
}