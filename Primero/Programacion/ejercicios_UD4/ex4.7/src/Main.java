import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escribe el numero de veces que quieres que se imprima el guion: ");
    int veces = sc.nextInt();
    while (veces > 0) {
        veces--;
        System.out.println("-");
    }
    }
}
