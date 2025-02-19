public class problema_8_reinas {
    public static void main(String[] args) {
        int N = 8;
        int[][] tablero = new int[N][N];
        if (resolverProblema(tablero, 0, N)) {
            imprimirTablero(tablero);
        } else {
            System.out.println("No hay solución");
        }
    }

    public static boolean resolverProblema(int[][] tablero, int columna, int N) {
        if (columna >= N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (esSeguro(tablero, i, columna, N)) {
                tablero[i][columna] = 1;
                if (resolverProblema(tablero, columna + 1, N)) {
                    return true;
                }
                tablero[i][columna] = 0;
            }
        }
        return false;
    }

    public static boolean esSeguro(int[][] tablero, int fila, int columna, int N) {
        for (int i = 0; i < columna; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }
        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        for (int i = fila, j = columna; i < N && j >= 0; i++, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(" " + tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
