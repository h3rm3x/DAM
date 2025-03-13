import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Mastermind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Partida partida = new Partida("Jugador1");

        char[] combinacionIntentada = new char[4];
        int intentos = 0;

            while (intentos < 16) {
                try {
                System.out.println("Introduce tu combinación de colores: (R red, B blue, G green, M magenta, Y yellow, C cyan)");
                for (int i = 0; i < 4; i++) {
                    System.out.println("escribe el color " + (i + 1) + ": ");
                    String color = sc.nextLine();
                    if (!esColorValido(color)) {
                        System.out.println("Color no válido");
                        i--;
                    } else {
                        combinacionIntentada[i] = color.charAt(0);
                    }

                }
                Tirada tirada = new Tirada(combinacionIntentada);
                int[] resultado = partida.comprobar(tirada);
                System.out.println("Aciertos: " + resultado[0] + " Mal colocados: " + resultado[1]);
                System.out.println("Puntuación: " + partida.getPuntuacion());
                intentos++;
                if (partida.getEstadoFinal()) {
                    break;
                }
            }catch (InputMismatchException e) {
                    System.out.println("Error entrada incorrecta ");
                    continue;
            }
            if (partida.getEstadoFinal()) {
                System.out.println("Has ganado la partida");
            } else {
                System.out.println("Has perdido la partida");
                System.out.println(" La combinacion secreta es" + Arrays.toString(partida.getCombinacionSecreta()));
            }
        }
    }


    public static boolean esColorValido(String color) {
        return color.equals("R") || color.equals("B") || color.equals("G") || color.equals("M") || color.equals("Y") || color.equals("C");
    }
}

