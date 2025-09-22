import java.util.Scanner;
public class ex4_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el numero de filas que quieres");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("a");
            }
            System.out.println(" ");
        }
    }
}