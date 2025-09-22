import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NUMERO_SECRETO1 = sc.nextInt();
        final int NUMERO_SECRETO2 = sc.nextInt();
        System.out.println("introduce el numero que adivinas: ");
        int numerousuario = sc.nextInt();

        if (numerousuario == NUMERO_SECRETO1) {
            System.out.println("Has adivinado el numero secreto 1");
        }
        else if (numerousuario == NUMERO_SECRETO2) {
            System.out.println("Has adivinado el numero secreto 2");
        }
        else {
            System.out.println("Has no adivinado el numero secreto");
        }

    }
}