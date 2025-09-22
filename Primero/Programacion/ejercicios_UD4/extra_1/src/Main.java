import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    // Método para verificar si un número es primo
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Ingrese la filas de la matriz: ");
        int filas = sc.nextInt();
        System.out.println("Ingrese la columna de la matriz: ");
        int columnas = sc.nextInt();
        int[][] matriz = new int[filas][columnas];
        System.out.println(matriz.length);
    }
}
