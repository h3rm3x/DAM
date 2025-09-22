import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Escribe 3 numeros ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el primer numero: ");
        int num1 = sc.nextInt();
        System.out.println("Escribe el segundo numero: ");
        int num2 = sc.nextInt();
        System.out.println("Escribe el tercer numero: ");
        int num3 = sc.nextInt();
        if (num1 > num2 && num2 > num3) {
            System.out.println("El numero mas grande es "+ num1 +" el sigueinte es "+ num2 + " y el mas pequeño es " + num3);
        }
        else if (num2 > num1 && num1 > num3) {
            System.out.println("El numero mas grande es "+ num2 +" el sigueinte es "+ num1 + " y el mas pequeño es " + num3);
        }
        else if (num3 > num1 && num1 > num2) {
            System.out.println("El numero mas grande es "+ num3 +" el sigueinte es "+ num1 + " y el mas pequeño es " + num2);
        }
        else if (num1 > num2 && num3 > num2) {
            System.out.println("El numero mas grande es "+ num1 +" el sigueinte es "+ num3 + " y el mas pequeño es " + num2);
        }
        else if (num2 > num1 && num2 > num3) {
            System.out.println("El numero mas grande es " + num2 + " el sigueinte es " + num3 + " y el mas pequeño es " + num1);
        }
        else if (num3 > num2 && num2 > num1) {
            System.out.println("El numero mas grande es " + num3 + " el sigueinte es " + num2 + " y el mas pequeño es " + num1);
        }
    }
}