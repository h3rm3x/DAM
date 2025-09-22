import java.util.Scanner;
public class ex4_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("entra el numero de filas de la piramide");
        int filas = sc.nextInt();
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= filas - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2*i-1); k++) {
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
