import java.util.Scanner;
public class Main {


public static boolean esPrimo(int numero) {
    for (int i = (int) (Math.sqrt(numero) + 1); i > 1; i--) {//comprobar si es primo
        if (numero ==1 ||numero==2 ||numero==3 ||numero==5) {
            return true;
        }
        if (numero % i == 0) {//comprobar si es divisible por i y no es 2
            return false;

        }
    }
    return true;

}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Escribe el limite superior: ");
    int limite_superior = sc.nextInt();
    System.out.print("Escribe el limite inferior: ");
    int numero = sc.nextInt();
    int contador = 0;
    while (numero < limite_superior) {
        if (esPrimo(numero)) {
            System.out.println("el "+ (contador+1) + "º numero primo es "+ numero);
            contador++;

        }
        numero++;
    }



}

}