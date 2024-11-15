import java.util.Scanner;

public class Matrices {
    static Scanner sc = new Scanner(System.in);

    private static int[][] leer_matriz() {
        System.out.println("Ingrese la filas de la matriz: ");
        int filas = sc.nextInt();
        System.out.println("Ingrese la columna de la matriz: ");
        int columnas = sc.nextInt();
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Ingrese el valor de la celda " + (i + 1) + " " + (j + 1));
                matriz[i][j] = sc.nextInt();
            }
        }
        return matriz;
    }

    public static int[][] leer_matriz_identidad() {
        int[][] matriz = leer_matriz();
        while (matriz.length != matriz[0].length || matriz.length < 2) { // Corregido: Condición de chequeo
            System.out.println("ERROR, la matriz identidad ha de ser simetrica y de al menos 2x2");
            System.out.println("Ingrese la matriz de nuevo");
            matriz = leer_matriz();
        }
        return matriz;
    }

    public static boolean comprobar_matriz_identidad(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j && matriz[i][j] != 1) {
                    return false;
                }
                if (i != j && matriz[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] leer_matriz_triangular() {
        int[][] matriz = leer_matriz();

        while (matriz.length < 3 || matriz[0].length < 3) { // Corregido: Condición de chequeo
            System.out.println("ERROR, una matriz triangular solo puede ser 3x3 o mayor");
            matriz = leer_matriz();
        }
        return matriz;
    }

    public static boolean comprobar_triangular_sup(int[][] matriz) {
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < i && j < matriz[i].length; j++) { // Corregido: Condición para evitar out of bounds
                if (matriz[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean comprobar_triangular_inf(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = i + 1; j < matriz[i].length; j++) { // Corregido: Aseguramos que j no exceda la longitud
                if (matriz[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void imprimir_matriz(int[][] matriz) {
        int maxWidth = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                maxWidth = Math.max(maxWidth, String.valueOf(matriz[i][j]).length());
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(String.format("%" + (maxWidth + 1) + "d", matriz[i][j]));
            }
            System.out.println();
        }
    }

    public static int calcularDeterminante(int[][] matriz) {
        int n = matriz.length;
        if (n == 1) {
            return matriz[0][0];
        }
        if (n == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }

        int determinante = 0;
        for (int i = 0; i < n; i++) {
            int[][] subMatriz = obtenerSubMatriz(matriz, 0, i);
            determinante += Math.pow(-1, i) * matriz[0][i] * calcularDeterminante(subMatriz);
        }
        return determinante;
    }

    public static int[][] obtenerSubMatriz(int[][] matriz, int filaExcluir, int columnaExcluir) {
        int n = matriz.length;
        int[][] subMatriz = new int[n - 1][n - 1];
        int filaSub = 0;

        for (int i = 0; i < n; i++) {
            if (i == filaExcluir) {
                continue;
            }
            int columnaSub = 0;
            for (int j = 0; j < n; j++) {
                if (j == columnaExcluir) {
                    continue;
                }
                subMatriz[filaSub][columnaSub] = matriz[i][j];
                columnaSub++;
            }
            filaSub++;
        }
        return subMatriz;
    }

    public static int[][] Productomatriz(int[][] matriz1, int[][] matriz2) {
        if (matriz1[0].length != matriz2.length) { // Corregido: Validación de la compatibilidad de dimensiones
            System.out.println("ERROR, las columnas de la primera matriz y las filas de la segunda deben coincidir");
            return null;
        }
        int[][] producto = new int[matriz1.length][matriz2[0].length];
        for (int i = 0; i < producto.length; i++) {
            for (int j = 0; j < producto[0].length; j++) {
                for (int k = 0; k < matriz1[0].length; k++) {
                    producto[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return producto;
    }

    public static void main(String[] args) {
        int programa = 1;
        while (programa != 0) {
            System.out.print("ESCRIBE 1 PARA EL PROGRAMA DE COMPROBACION DE MATRIZ IDENTIDAD, 2 PARA EL PROGRAMA DE COMPROBACION DE MATRIZ TRIANGULAR, 3 PARA EL PROGRAMA DEL DETERMINANTE DE UNA MATRIZ, 4 PARA EL PROGRAMA DEL PRODUCTO DE MATRICES O 0 PARA FINALIZAR EL PROGRAMA: ");
            programa = sc.nextInt();
            switch (programa) {
                case 0:
                    break;
                case 1: {
                    System.out.println("PROGRAMA 1: comprobacion de matriz identidad");
                    int[][] matriz_usuario = leer_matriz();
                    boolean es_identidad = comprobar_matriz_identidad(matriz_usuario);
                    if (es_identidad) {
                        System.out.println("La matriz: ");
                        imprimir_matriz(matriz_usuario);
                        System.out.println("es la matriz identidad de " + matriz_usuario.length + "x" + matriz_usuario.length);
                    } else {
                        System.out.println("La matriz no es la matriz identidad");
                    }
                    break;
                }
                case 2: {
                    System.out.println("PROGRAMA 2: comprobacion de matriz triangular");
                    int[][] matriz_usuario = leer_matriz_triangular();
                    boolean es_triangular_sup = comprobar_triangular_sup(matriz_usuario);
                    boolean es_triangular_inf = comprobar_triangular_inf(matriz_usuario);
                    if (es_triangular_sup || es_triangular_inf) {
                        System.out.println("La matriz: ");
                        imprimir_matriz(matriz_usuario);
                        System.out.println("es una matriz triangular de " + matriz_usuario.length + "x" + matriz_usuario.length);
                    } else {
                        imprimir_matriz(matriz_usuario);
                        System.out.println("La matriz no es una matriz triangular");
                    }
                    break;
                }
                case 3: {
                    System.out.println("PROGRAMA 3: calculo del determinante de una matriz");
                    int[][] matriz = leer_matriz();
                    if (matriz.length != matriz[0].length) { // Nueva validación para asegurar matriz cuadrada
                        System.out.println("ERROR: La matriz debe ser cuadrada para calcular el determinante.");
                        break;
                    }
                    int determinante = calcularDeterminante(matriz);
                    System.out.println("La matriz es: ");
                    imprimir_matriz(matriz);
                    System.out.println("El determinante de la matriz es: " + determinante);
                    break;
                }
                case 4: {
                    System.out.println("PROGRAMA 4: producto de matrices");
                    System.out.println("Ingrese la primera matriz:");
                    int[][] matriz1 = leer_matriz();
                    System.out.println("Ingrese la segunda matriz:");
                    int[][] matriz2 = leer_matriz();
                    int[][] producto = Productomatriz(matriz1, matriz2);
                    if (producto != null) {
                        System.out.println("El producto de las matrices es:");
                        imprimir_matriz(producto);
                    }
                    break;
                }
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número entre 0 y 4.");
                    break;
            }
        }
        System.out.println("Programa finalizado.");

    }
}

