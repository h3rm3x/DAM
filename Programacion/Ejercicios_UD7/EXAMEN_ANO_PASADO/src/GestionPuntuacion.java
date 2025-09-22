import java.util.Scanner;
import java.util.ArrayList;
public class GestionPuntuacion {
    static Scanner sc = new Scanner(System.in);
    static int numPuntuaciones = 0;
    static Puntuacion[] ListaPuntuaciones = new Puntuacion[100];
    public static void main(String[] args) {
        int opcion = 0;


        try {


            while (opcion != 5) {
                mostrarMenu();
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Introduce el nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Introduce los apellidos: ");
                        String apellidos = sc.nextLine();
                        System.out.println("Introduce la fecha (dia-mes-año): ");
                        String fecha = sc.nextLine();
                        Puntuacion p = new Puntuacion(nombre, apellidos, fecha);
                        System.out.println("Introduce los puntos: ");
                        int puntos = sc.nextInt();
                        p.setPuntos(puntos);
                        numPuntuaciones++;
                        break;
                    case 2:
                        mostrarPuntuaciones();
                        break;
                    case 3:
                        mostrarPuntuacionesOrdenadas();
                        break;
                    case 4:
                        mostrarPuntuacionesOrdenadasApellidos();
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }

        }catch (NumberFormatException e){
            System.out.println("Error opción no válida");
            System.out.println("Introduce otra opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void mostrarMenu() {
        System.out.println("1. Añadir puntuación");
        System.out.println("2. Mostrar puntuaciones por orden de llegada");
        System.out.println("3. Mostrar puntuaciones por orden de puntuación en orden descendente");
        System.out.println("4. Mostrar puntuaciones por orden de puntuación en orden alfabetico de los apellidos");
        System.out.println("5. Salir");
    }

    public static void mostrarPuntuaciones() {
        for (Puntuacion p : ListaPuntuaciones) {
            if (p != null) {
                System.out.println(p);
            }

        }

    }

    public static void mostrarPuntuacionesOrdenadas() {
        int[] array = new int[numPuntuaciones];
        for (int i = 0; i < numPuntuaciones; i++) {
            array[i] = ListaPuntuaciones[i].getPuntos();
        }
        for (int i = 0; i < array.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }
            int aux = array[menor];
            array[menor] = array[i];
            array[i] = aux;
        }

        for (int i = 0; i < array.length; i++) {
            for (Puntuacion p : ListaPuntuaciones) {
                System.out.println(p);
            }
        }

    }

    public static void mostrarPuntuacionesOrdenadasApellidos() {
        String[] array = new String[numPuntuaciones];
        for (int i = 0; i < numPuntuaciones; i++) {
            array[i] = ListaPuntuaciones[i].getApellidos();
        }

        int n = array.length;
        int i, j;
        String aux;
        for (i = 0; i < n - 1; i++) {
            if (array[i].compareTo(array[i + 1])>0) {
                aux = array[i];
                array[i] = array[i + 1];
                array[i + 1] = aux;
            }
            for (j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[j + 1])>0) {
                    aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }


        }

    }

}
