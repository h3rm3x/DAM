import java.util.Scanner;
public class ex_4_25 {
static Scanner sc = new Scanner(System.in);
    public static int leer_numero() {
        System.out.print("Ingrese un numero positivo de hasta 15 digitos: ");
        int numero= sc.nextInt();
        sc.nextLine();
        return numero;
    }

        // Función para encontrar el dígito más grande y su posición
        public static int[] digito_mas_grande(int numero) {
            int digitoMayor = -1;
            int posicionMayor = -1;
            int posicionActual = 1;

            while (numero > 0) {
                int digito = numero % 10;
                if (digito > digitoMayor) {
                    digitoMayor = digito;
                    posicionMayor = posicionActual;
                }
                numero /= 10;
                posicionActual++;
            }

            return new int[]{digitoMayor, posicionMayor};
        }

        // Función para encontrar el dígito más pequeño y su posición
        public static int[] digito_mas_pequeno(int numero) {
            int digitoMenor = 10;
            int posicionMenor = -1;
            int posicionActual = 1;

            while (numero > 0) {
                int digito = numero % 10;
                if (digito < digitoMenor) {
                    digitoMenor = digito;
                    posicionMenor = posicionActual;
                }
                numero /= 10;
                posicionActual++;
            }

            return new int[]{digitoMenor, posicionMenor};
        }


    public static void main(String[] args) {
        while (true) {
            int numero = leer_numero();
            if (numero <= 0) {
                System.out.println("Debe ingresar un número entero positivo.");
            } else {
                int[] resultadoMayor = digito_mas_grande(numero);
                int[] resultadoMenor = digito_mas_pequeno(numero);


                System.out.println("Dígito más grande: " + resultadoMayor[0] + " en la posición " + resultadoMayor[1]);
                System.out.println("Dígito más pequeño: " + resultadoMenor[0] + " en la posición " + resultadoMenor[1]);
            }

            System.out.println();
            System.out.println("Si quieres terminar el programa esribe 0, para continuar presiona enter");
            String finalizar = sc.nextLine();
            if (finalizar.equals("0")) {
                break;
            }
        }
    }
}