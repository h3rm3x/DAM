import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class problema_8_reinasv2 {
    static int[] solucion = new int[8];
    static int totalQueens = 8;
    static boolean solucionEncontrada = false; // Variable de control para detener la búsqueda
    static Scanner sc = new Scanner(System.in);
    static int reinas = 0;


    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(9));
        check(0); // Comienza el proceso de colocación de reinas
    }

    private static void check(int n) {
        if (solucionEncontrada) return; // Detiene la búsqueda si ya se encontró una solución
        if (n == totalQueens) { // Si todas las reinas están colocadas
            imprimirTablero(); // Imprime la solución
            solucionEncontrada = true; // Marca que se encontró una solución
            return;
        }
        for (int i = 0; i < totalQueens; i++) { // Intenta colocar una reina en cada fila de la columna actual
            solucion[n] = i; // Coloca la reina en la fila i de la columna n
            //System.out.println("intento colocar la reina en la posicion" + n + " "+ i);
            if (judge(n)) { // Verifica si no hay conflicto
                reinas++;
              //  System.out.println("reina nº" + reinas +" colocada en la fila " + n + " columna "+ i);
                check(n + 1); // Llama recursivamente para colocar la siguiente reina
            }
        }
    }

    private static boolean judge(int n) {
        for (int i = 0; i < n; i++) { // Verifica todas las reinas colocadas anteriormente
            if (solucion[i] == solucion[n] || Math.abs(solucion[i] - solucion[n]) == Math.abs(i - n)) {
                return false; // Hay conflicto si están en la misma fila o en la misma diagonal
            } else {
             //   System.out.println("hay conflicto entre la reina"+ solucion[n] + " " + solucion[i]+" y la poscicion" + n +"."+ i);
            }
        }
        return true; // No hay conflicto
    }

    private static void imprimirTablero() {
        int[][] tablero = new int[totalQueens][totalQueens];
        for (int i = 0; i < totalQueens; i++) {
            tablero[i][solucion[i]] = 1;
        }
        System.out.println("Solucion:");
        System.out.println(Arrays.toString(solucion));
        for (int[] fila : tablero) {
            for (int celda : fila) {
                System.out.print(" " + celda + " ");
            }
            System.out.println();
        }
    }
}