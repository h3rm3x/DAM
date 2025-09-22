import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        char car;
        Scanner lector = new Scanner(System.in);
        System.out.println("Introdueix una lletra");
        car = lector.next().charAt(0);
        int caracter = (int)car;
        caracter++;
        car = (char)caracter;
        System.out.println("La següent lletra del abecedari  és: " + car);
    }
}

