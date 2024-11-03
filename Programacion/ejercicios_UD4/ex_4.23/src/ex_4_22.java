import java.util.Scanner;

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
        System.out.print("Escribe el numero de primos que quieres: ");
        int numero_de_primos = sc.nextInt();
        int contador = 0;
        int numero = 1;

        while (true) {
            while (contador < numero_de_primos) {
                if (esPrimo(numero)) {
                    System.out.println("el " + (contador + 1) + "º numero primo es " + numero);
                    contador++;

                }
                numero++;
            }
            float porcentaje = (float) numero_de_primos / (numero - 1) * 100;
            System.out.println("el porcentaje de primos hasta " + (numero - 1) + " es " + porcentaje);
            System.out.println();
            System.out.println("Escribe caulquier numero para continuar con el programa o 0 para finalizar ");
            int terminar = sc.nextInt();
            if (terminar == 0) {
                break;
            }
        }

    }
