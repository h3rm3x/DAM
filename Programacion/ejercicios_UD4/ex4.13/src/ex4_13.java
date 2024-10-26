import java.util.Scanner;
public class ex4_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1= 0, n2= 0;
        do {
            if (n1 > n2) {
                System.out.println("ERROR: el primer numero ha de ser menor que el segundo numero");
            }
            System.out.println("Escribe el primer numero");
            n1 = sc.nextInt();
            System.out.println("Escribe el segundo numero mayor que el anterior");
            n2 = sc.nextInt();



        } while (n1>n2 );
        for (int i = n1; i < n2; i++) {
            System.out.print(i + " ");
        }
    }
}