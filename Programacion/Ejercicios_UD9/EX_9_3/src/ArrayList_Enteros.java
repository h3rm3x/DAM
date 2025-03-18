import java.util.*;
public class ArrayList_Enteros {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        System.out.println("Elementos de la lista: ");
        for (Integer numero : numeros) {
            System.out.println(numero);
        }
        numeros.remove(2);
        System.out.println("Eliminado el numero 30: ");

        System.out.println("Elementos de la lista: ");
        for (Integer numero : numeros) {
            System.out.println(numero);
        }

        System.out.println(numeros.getFirst());

        numeros.add(1,25);
        System.out.println("Añadido el numero 25 en la posicion 2: ");
        System.out.println("Elementos de la lista: ");
        for (Integer numero : numeros) {
            System.out.println(numero);
        }

        System.out.println("El tamaño de la lista es: " + numeros.size());

        System.out.println("El numero 40 esta en la lista? ");
        System.out.println(numeros.contains(40));

        numeros.clear();

        System.out.println("La lista esta vacia? ");
        System.out.println(numeros.isEmpty());




    }
}
