import java.util.Scanner;

public class anillamiiento {
    static Scanner in;
    static int numAnilladas = 0;

    public static void casoDePrueba() {
        // Validar que haya más datos antes de leer
        if (in.hasNextInt()) {
            int numAves = in.nextInt();
            if (in.hasNextInt()) {
                int numAnillos = in.nextInt();
                // Validar que los valores sean no negativos
                if (numAves<=10000) {
                    numAnilladas += numAves - numAnillos;
                }
            }
        }
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        // Validar que haya más datos antes de leer
        if (in.hasNextInt()) {
            int numCasos = in.nextInt();

            do {
                if(numCasos>10000 || numCasos<1){
                    numCasos = 0;
                }
                else {
                    for (int i = 0; i < numCasos; i++) {
                        casoDePrueba();
                    }
                    System.out.println(numAnilladas);
                    numAnilladas = 0;
                    if (in.hasNextInt()) {
                        numCasos = in.nextInt();
                    }
                }
            } while (numCasos != 0);
        }
    }
}
