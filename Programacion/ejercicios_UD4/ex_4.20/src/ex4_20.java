import java.util.Scanner;
public class ex4_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // declaracion de variables
        System.out.print("Escribe el numero de primos que quieres: ");
        int numero_de_primos= sc.nextInt();
        boolean esPrimo = false;
        int numero = 0;

        for (int j =1 ; j <=numero_de_primos; j++) {// contador de primos
            esPrimo=false;
            while (!esPrimo) { //aumentar el numero hasta encontrar el siguiente primo
                numero++;
                for (int i = (int) (Math.sqrt(numero)+1); i > 1; i--) {//comprobar si es primo
                    if (numero % i == 0 && numero!=2) {//comprobar si es divisible por i y no es 2
                        i=1;
                    }
                    if ((i == 2 && numero % i != 0 )|| numero==2) {// si hemos llegado al i=2 y el resto todavia no es 0 es primo
                        esPrimo = true;
                        System.out.println("El numero " + numero + " es el "+j+"º primo");
                    }
                }
            }
        }
    }
}

