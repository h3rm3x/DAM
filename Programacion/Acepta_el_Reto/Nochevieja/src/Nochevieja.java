import java.util.Scanner;

public class Nochevieja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String entrada = sc.nextLine();

            if (entrada.equals("00:00")) {
                break; // Termina si la entrada es medianoche exacta
            }

            // Convertimos la entrada en horas y minutos
            int horas = Integer.parseInt(entrada.substring(0, 2));
            int minutos = Integer.parseInt(entrada.substring(3, 5));

            // Calculamos los minutos transcurridos en el día
            int minutosTranscurridos = horas * 60 + minutos;

            // Total de minutos en un día menos los minutos transcurridos
            int minutosRestantes = 1440 - minutosTranscurridos;

            System.out.println(minutosRestantes);
        }
    }
}