import java.util.Arrays;
import java.util.Scanner;

public class problema_8_reinas {
    static int[] solucion = new int[8];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = 8; // Define el tamaño del tablero
        int[][] tablero = new int[N][N]; // Crea un tablero vacío de NxN
        if (resolverProblema(tablero, 0, N)) { // Intenta resolver el problema comenzando desde la primera columna
            imprimirTablero(tablero); // Si se encuentra una solución, imprime el tablero
        } else {
            System.out.println("No hay solución"); // Si no se encuentra solución, imprime un mensaje
        }
    }

    public static boolean resolverProblema(int[][] tablero, int columna, int N) {
        if (columna >= N) { // Si todas las columnas están llenas, se ha encontrado una solución
            return true;
        }
        for (int i = 0; i < N; i++) { // Intenta colocar una reina en cada fila de la columna actual
            if (esSeguro(tablero, i, columna, N)) { // Verifica si es seguro colocar una reina en la posición (i, columna)
                tablero[i][columna] = 1; // Coloca la reina en la posición (i, columna)
                solucion[columna] = i;
                if (resolverProblema(tablero, columna + 1, N)) { // Llama recursivamente para colocar el resto de las reinas
                    return true;
                }
                tablero[i][columna] = 0; // Si no se encuentra solución, quita la reina (backtracking)
            }
        }
        return false; // Si no se puede colocar una reina en ninguna fila de la columna actual, devuelve false
    }

    public static boolean esSeguro(int[][] tablero, int fila, int columna, int N) {
        for (int i = 0; i < columna; i++) { // Verifica la fila actual a la izquierda de la columna dada
            if (tablero[fila][i] == 1) {
                return false; // Hay otra reina en la misma fila
            }
        }
        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) { // Verifica la diagonal superior izquierda
            if (tablero[i][j] == 1) {
                return false; // Hay otra reina en la diagonal superior izquierda
            }
        }
        for (int i = fila, j = columna; i < N && j >= 0; i++, j--) { // Verifica la diagonal inferior izquierda
            if (tablero[i][j] == 1) {
                return false; // Hay otra reina en la diagonal inferior izquierda
            }
        }
        return true; // Si no se encontró ninguna reina en conflicto, es seguro colocar la reina
    }

    public static void imprimirTablero(int[][] tablero) {
        System.out.println("Solucion:");
        System.out.println(Arrays.toString(solucion));
        for (int[] celda : tablero) { // Recorre cada fila del tablero
            for (int j = 0; j < tablero.length; j++) { // Recorre cada columna del tablero
                System.out.print(" " + celda[j] + " "); // Imprime el valor de la celda
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }
}