import java.util.Scanner;
public static boolean esPrimo(int numero) {
    for (int i = (int) (Math.sqrt(numero) + 1); i > 1; i--) {//comprobar si es primo
        if (numero == 1 || numero == 2 || numero == 3 || numero == 5) {
            return true;
        }
        if (numero % i == 0) {//comprobar si es divisible por i y no es 2
            return false;

        }
    }
    return true;

}

public static void Nprimos(int n) {
    Scanner sc = new Scanner(System.in);
    int contador = 0;
    int numero = 1;


        while (contador < n) {
            if (esPrimo(numero)) {
                System.out.println("el " + (contador + 1) + "º numero primo es " + numero);
                contador++;

            }
            numero++;
        }
        float porcentaje = (float) n / (numero - 1) * 100;
        System.out.println("el porcentaje de primos hasta " + (numero - 1) + " es " + porcentaje);
        System.out.println();

    }



public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.print("Escribe el numero de primos que quieres: ");
        int numero_de_primos = sc.nextInt();
        Nprimos(numero_de_primos);
        System.out.println("Escribe caulquier numero para continuar con el programa o 0 para finalizar ");
        String terminar = sc.nextLine();
        if (Objects.equals(terminar,"0")) {
            break;
        }
    }
}