import java.util.*;
public class Mastermind {
    static Scanner sc = new Scanner(System.in);
    static Partida partida = new Partida("Jugador1");
    static HashMap<String, Partida> partidas = new HashMap<>();
    static char[] combinacionIntentada = new char[4];
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Jugar");
            System.out.println("2. Ver partidas");
            System.out.println("3. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del jugador: ");
                    Partida partida = new Partida(sc.nextLine());
                    partida();
                    break;
                case 2:
                    verPartidas();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }


    public static boolean esColorValido(String color) {
        return color.equals("R") || color.equals("B") || color.equals("G") || color.equals("M") || color.equals("Y") || color.equals("C");
    }

    public static void partida() {
        int intentos = 0;
        while (intentos < 16) {
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
        }
        partidas.put(partida.getNombreJugador(), partida);
        if (partida.getEstadoFinal()) {
            System.out.println("Has ganado la partida");
        } else {
            System.out.println("Has perdido la partida");
            System.out.println(" La combinacion secreta es" + Arrays.toString(partida.getCombinacionSecreta()));
        }
    }

    public static void verPartidas() {
        for (Partida partida : partidas.values()) {
            System.out.println(partida);
        }
    }
}

