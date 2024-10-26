import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double resultado =1;
        for (int i = 1; i<4; i++ ) {
            System.out.println("Entra el nuemero "+(i)+": ");
        double numero= scanner.nextDouble();
        resultado *= numero;
        }
        System.out.println("El resultado del producto es :"+ resultado);
        }
    }
