import java.util.Scanner;
public class Mastermind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Partida partida = new Partida("Jugador1");
        System.out.println("Introduce tu combinación de colores: (R red, B blue, G green, M magenta, Y yellow, C cyan)");
        char[] combinacionIntentada = new char[4];
        int intentos = 0;
        while (intentos < 16) {
            for (int i = 0; i < 4; i++) {
                combinacionIntentada[i] = sc.nextLine().charAt(0);
            }
            Tirada tirada = new Tirada(combinacionIntentada);
            int[] resultado = partida.comprobar(tirada);
            System.out.println("Aciertos: " + resultado[0] + " Mal colocados: " + resultado[1]);
            System.out.println("Puntuación: " + partida.getPuntuacion());
            intentos++;
        }
    }
}
