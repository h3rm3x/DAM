import java.util.InputMismatchException;
import java.util.Scanner;

public class ex_8_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = {1, 2, 3, 4, 5};

        try {
            // Posible InputMismatchException
            System.out.print("Introduce un número entero: ");
            int numero = scanner.nextInt();

            // Posible ArithmeticException
            System.out.println("División: 100 / " + numero + " = " + (100 / numero));

            // Posible IndexOutOfBoundsException
            System.out.print("Introduce un índice para acceder al array (0-4): ");
            int indice = scanner.nextInt();
            System.out.println("El valor en la posición " + indice + " es: " + numeros[indice]);

        } catch (InputMismatchException e) {
            System.out.println("Error: Tipo de dato incorrecto.");
            System.out.println("Detalles: Debes introducir un número entero.");
            System.out.println("Excepción: " + e.toString());
        } catch (ArithmeticException e) {
            System.out.println("Error: Operación aritmética inválida.");
            System.out.println("Detalles: No se puede dividir por cero.");
            System.out.println("Excepción: " + e.toString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Índice fuera de límites.");
            System.out.println("Detalles: El índice debe estar entre 0 y " + (numeros.length - 1) + ".");
            System.out.println("Excepción: " + e.toString());
        } finally {
            scanner.close();
            System.out.println("Fin del programa.");
        }
    }
}
