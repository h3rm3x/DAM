import java.util.Scanner;

public class OrdenarAscendent {
    private static final int[] llistaEnters = new int[10];

    public static void llegirLlista() {
        System.out.println("Escriu 10 valors enters i prem retorn.");
        Scanner lector = new Scanner(System.in);
        int index = 0;
        while (index < llistaEnters.length) {
            if (lector.hasNextInt()) {
                llistaEnters[index] = lector.nextInt();
                index++;
            } else {
                lector.next();
            }
        }
        lector.nextLine();
    }

    public static void ordenarLlista() {
        for (int i = 0; i < llistaEnters.length - 1; i++) {
            for (int j = i + 1; j < llistaEnters.length; j++) {
                // La posició tractada té un valor més alt que el de la cerca... Els intercanviem.
                if (llistaEnters[i] > llistaEnters[j]) {
                    int canvi = llistaEnters[i]; // Per intercanviar valors cal una variable auxiliar
                    llistaEnters[i] = llistaEnters[j];
                    llistaEnters[j] = canvi;
                }
            }
        }
    }

    public static void mostrarLlista(int lista []) {
        System.out.print("L'array ordenat és: [ ");
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println("]");
    }

    public static void menosquelamitad() {
        int   mayor = llistaEnters[llistaEnters.length - 1]; // El último elemento (el mayor después de ordenar)
        int menorquemitad = 0;
        int[] menoresqmitad = new int[10];
        int index = 0;
        float upperlimit = mayor/2;

        for (int num : llistaEnters) {
            if (num < upperlimit) {
                menoresqmitad[index] = num;
                index++;
                menorquemitad++;
            }
        }

        System.out.println("Los " + menorquemitad + " números menores que la mitad de " + mayor + " son:");
        System.out.print("[ ");
        for (int i = 0; i < menorquemitad; i++) {
            System.out.print(menoresqmitad[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        llegirLlista();
        ordenarLlista();
        mostrarLlista(llistaEnters);
        menosquelamitad();
    }
}
