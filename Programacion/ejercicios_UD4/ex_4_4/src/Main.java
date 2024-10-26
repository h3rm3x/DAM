import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Escribe 3 numeros ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el primer numero: ");
        int num1 = sc.nextInt();
        System.out.println("Escribe el segundo numero: ");
        int num2 = sc.nextInt();
        System.out.println("Escribe el terci numero: ");
        int num3 = sc.nextInt();
        if (num1 > num2 && num1 > num3) {
            System.out.println("El numero "+ num1 +" es mayor que "+ num2 + " y " + num3);
        }
        else if (num2 > num1 && num2 > num3) {
            System.out.println("El numero "+ num2 +" es mayor que "+ num1+ " y " + num3);
        }
        else if (num3 > num1 && num3 > num2) {
            System.out.println("El numero "+ num3 +" es mayor que "+ num2 + " y " + num1);
        }
    }
}