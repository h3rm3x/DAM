import java.util.Scanner;

public class Combinacion {
        private static Scanner scanner = new Scanner(System.in);
        public static String[] leerIntento() {
        System.out.println("Introduce tu intento (4 n�meros separados por espacios):");
        String linea = scanner.nextLine();
        String[] combinacionIntentada = linea.trim().split(" ");
        if (combinacionIntentada.length != 4) {
            System.out.println("Debes introducir exactamente 4 n�meros.");
            return null;
        }
        return combinacionIntentada;
    }

}

