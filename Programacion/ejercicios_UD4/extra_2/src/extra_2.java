import java.util.Scanner;
public class extra_2 {
    static Scanner sc = new Scanner(System.in);
    public static int sumatorio(int n) {
        int sum = 0;
        if (n==0) return sum;
        else return sumatorio(n-1) +n;

    }
    public static void main(String[] args) {
        System.out.println("Escribe el numero hasta el que quiere realizar el sumatorio: ");
        int n = sc.nextInt();
        System.out.println("El sumatorio de "+ n+ " es "+sumatorio(n));
    }
}