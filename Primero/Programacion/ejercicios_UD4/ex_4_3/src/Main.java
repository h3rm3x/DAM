import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero: ");
        int n = sc.nextInt();
        if (n <= 10 && n >= 0) {
            System.out.println(" el numero " + n + " esta entre 0 y 10 ");
        }
        else {
            System.out.println(" el numero " + n + " NO esta entre 0 y 10 ");
        }
    }
}