import java.util.Scanner;

public class Main {

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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();
        scanner.close();

        int contador = 0;
        int numero = 2; // El primer número primo

        System.out.println("Los primeros " + n + " números primos son:");

        while (contador < n) {
            if (esPrimo(numero)) {
                System.out.println(numero);
                contador++;
            }
            numero++;
        }
    }
}
