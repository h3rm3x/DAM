import java.util.Scanner;

public class Ninots_indultados {
    static Scanner in;
    static String ninotA = "EMPATE";
    static String ninotN = "empate";
    static int contadorA = 0;
    static int contadorN = 0;

    public static void casoDePrueba(int numCasos) {
        String[] ninotsA = new String[numCasos];
        String[] ninotsN = new String[numCasos];
        int[] numNinotsA = new int[numCasos];
        int[] numNinotsN = new int[numCasos];
        int indexA = 0;
        int indexN = 0;

        for (int i = 0; i < numCasos; i++) {
            String ninot = in.next();

            if (esAdulto(ninot)) {
                int pos = contienePalabra(ninotsA, ninot, indexA);
                if (pos >= 0) {
                    numNinotsA[pos]++;
                } else {
                    ninotsA[indexA] = ninot;
                    numNinotsA[indexA++] = 1;
                }
            } else if (esNino(ninot)) {
                int pos = contienePalabra(ninotsN, ninot, indexN);
                if (pos >= 0) {
                    numNinotsN[pos]++;
                } else {
                    ninotsN[indexN] = ninot;
                    numNinotsN[indexN++] = 1;
                }
            }
        }

        calcularMayor(ninotsA, numNinotsA, indexA, true);
        calcularMayor(ninotsN, numNinotsN, indexN, false);

        System.out.println(ninotA + " " + ninotN);
    }

    public static void calcularMayor(String[] ninots, int[] cantidades, int tamanio, boolean esAdulto) {
        int mayorCantidad = 0;
        String resultado = esAdulto ? "EMPATE" : "empate";
        boolean empate = false;

        for (int i = 0; i < tamanio; i++) {
            if (cantidades[i] > mayorCantidad) {
                mayorCantidad = cantidades[i];
                resultado = ninots[i];
                empate = false;
            } else if (cantidades[i] == mayorCantidad) {
                empate = true;
            }
        }

        if (empate) {
            resultado = esAdulto ? "EMPATE" : "empate";
        }

        if (esAdulto) {
            ninotA = resultado;
            contadorA = mayorCantidad;
        } else {
            ninotN = resultado;
            contadorN = mayorCantidad;
        }
    }

    public static int contienePalabra(String[] array, String palabra, int tamanio) {
        for (int i = 0; i < tamanio; i++) {
            if (array[i].equals(palabra)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean esAdulto(String ninot) {
        return ninot.equals(ninot.toUpperCase());
    }

    public static boolean esNino(String ninot) {
        return ninot.equals(ninot.toLowerCase());
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int numCasos = in.nextInt();
            if (numCasos < 1 || numCasos > 1000) { // Ajuste del rango de entrada
                break;
            }
            casoDePrueba(numCasos);
        }
    }
}
