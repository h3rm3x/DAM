import java.util.Scanner;

public class TrianguloPascal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de filas: ");
        int filas = scanner.nextInt();

        int[][] triangulo = new int[filas][filas]; // Matriz para almacenar el triángulo de Pascal

        // Generación del triángulo de Pascal
        for (int i = 0; i < filas; i++) {
            triangulo[i][0] = 1; // Primer elemento de cada fila es 1
            triangulo[i][i] = 1; // Último elemento de cada fila es 1
            for (int j = 1; j < i; j++) {
                triangulo[i][j] = triangulo[i - 1][j - 1] + triangulo[i - 1][j];
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < (filas -1)-i ; j++) {
                System.out.print(" ");
            }
            for (int j=0; j<=i; j++) {
                System.out.print(triangulo[i][j] + " ");
            }
            System.out.println();
            }


        }
    }

