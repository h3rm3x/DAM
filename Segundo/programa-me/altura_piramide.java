public class altura_piramide {
    
    static java.util.Scanner in;

    // Calcula el total de bloques necesarios hasta alcanzar el nivel dado
    public static long totalBloques(int nivel) {
        long n = nivel;
        return n * (2 * n - 1) * (2 * n + 1) / 3;
    }

    // Usa búsqueda binaria para encontrar el nivel mínimo que consume "bloques" piedras
    public static int encontrarNivel(long bloques) {
        int izquierda = 1;
        int derecha = 100_000; // Suficiente para cubrir el límite del problema
        int resultado = 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            long total = totalBloques(medio);

            if (total >= bloques) {
                resultado = medio;
                derecha = medio - 1;
            } else {
                izquierda = medio + 1;
            }
        }

        return resultado;
    }

    public static boolean casoDePrueba() {
        long num_piedras = in.nextLong();
        if (num_piedras == 0) {
            return false;
        }

        int nivel = encontrarNivel(num_piedras);
        System.out.println(nivel);
        return true;
    } // casoDePrueba

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

} // class solution

