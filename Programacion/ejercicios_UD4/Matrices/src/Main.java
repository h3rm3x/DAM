import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    private static int[][] leer_matriz() {
        System.out.println("Ingrese la filas de la matriz: ");
        int filas = sc.nextInt();
        System.out.println("Ingrese la columna de la matriz: ");
        int columnas = sc.nextInt();
        int[][] matriz = new int [filas][columnas];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++) {
                System.out.println("Ingrese el valor de la celda " + (i + 1) + " " + (j + 1));
                matriz[i][j] = sc.nextInt();
            }

        }
        return matriz;
    }
    public static int[][] leer_matriz_identidad(){
        int[][] matriz = leer_matriz();
        while (matriz.length != matriz[0].length && matriz.length<2 && matriz[0].length<2) {
            System.out.println("ERROR, la matriz identidad ha de ser simetrica  ");
            System.out.println("Ingrese la matriz de nuevo");
            matriz = leer_matriz();
        }
        return matriz;
    }

    public static boolean comprobar_matriz_identidad(int[][] matriz){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                if(i==j && matriz[i][j] !=1){
                    return false;
                }
                if(i!=j && matriz[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static int[][] leer_matriz_triangular(){
        int matriz[][] = leer_matriz();
        int medida;
         while (matriz.length<3 && matriz[0].length<3){
            System.out.println("ERROR, una matriz triangular solo puede ser 3x3 o mayor");


            matriz = leer_matriz();
        }
  return matriz ;
    }


    public static boolean comprobar_triangular_sup (int[][] matriz){ // matriz triangular superior es una matriz donde todos los elementos por debajo de la diagonal son 0
        for(int i=1;i<matriz.length;i++){
            for(int j=0;j<i;j++){ // recorre todos las columnas por debajo de la diagonal pincipal
                if( matriz[i][j] !=0){ // si alguno no es igual a 0 la matriz no es triangular superior
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean comprobar_triangular_inf (int[][] matriz){ // matriz triangular inferior es una matriz donde todos los elementos por encima de la diagonal son 0
        for(int i=0;i<matriz.length;i++){
            for(int j=i+1;j< matriz.length;j++){ // si alguno no es igual a 0 la matriz no es triangular inferior
                if( matriz[i][j] !=0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void imprimir_matriz(int[][] matriz) {
        // Determinar el número de dígitos más grande en la matriz
        int maxWidth = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                maxWidth = Math.max(maxWidth, String.valueOf(matriz[i][j]).length());
            }
        }

        // Imprimir la matriz con formato
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(String.format("%" + (maxWidth + 1) + "d", matriz[i][j]));
            }
            System.out.println();
        }
    }


        // Método para calcular el determinante de una matriz de forma recursiva
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

        // Método para obtener la submatriz eliminando la fila y columna especificadas
        public static int[][] obtenerSubMatriz(int[][] matriz, int filaExcluir, int columnaExcluir) {
            int n = matriz.length;
            int[][] subMatriz = new int[n - 1][n - 1];
            int filaSub = 0;
            int columnaSub = 0;

            for (int i = 0; i < n; i++) {
                if (i == filaExcluir) {
                    continue;
                }

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
        int programa=1;
        while(programa!=0){
            System.out.print("ESCRIBE 1 PARA EL PROGRAMA DE COMPROBACION DE MATRIZ IDENTIDAD, 2 PARA EL PROGRAMA DE COMPROBACION DE MATRIZ TRIANGULAR, 3 PARA EL PROGRAMA DEL DETERMINANTE DE UNA MATRIZ, 4 PARA EL PROGRAMA DEL PRODUCTO DE MATRICES O 0 PARA FINALIZAR EL PROGRAMA: ");
            programa = sc.nextInt();
            switch(programa){
                case 0: break;
                case 1:{
                    System.out.println("PROGRAMA 1: comprobacion de matriz identidad");
                    int[][] matriz_usuario = leer_matriz();
                    boolean es_identidad = comprobar_matriz_identidad(matriz_usuario);
                    if(es_identidad){
                        System.out.println("la matriz: ");
                        imprimir_matriz(matriz_usuario);
                        System.out.println("es la matriz identidad de " + matriz_usuario.length + "x" + matriz_usuario.length);

                    }
                    else {
                        System.out.println("la matriz  no es la matriz identidad");
                    }
                }
                case 2:{
                    System.out.println("PROGRAMA 2: comprobacion de matriz triangular");
                        int[][] matriz_usuario = leer_matriz_triangular();
                        boolean es_triangular_sup = comprobar_triangular_sup(matriz_usuario);
                        boolean es_triangular_inf = comprobar_triangular_inf(matriz_usuario);
                        if (es_triangular_sup || es_triangular_inf) {
                            System.out.println("la matriz: ");
                            imprimir_matriz(matriz_usuario);
                            System.out.println("es una matriz triangular de " + matriz_usuario.length + "x" + matriz_usuario.length);

                        }


                        if (es_triangular_sup && es_triangular_inf) { // tambien se considera una matriz triangular aquellas donde todos los elementos por enciima y debajo de la diagonal son 0
                            System.out.println("la matriz: ");
                            imprimir_matriz(matriz_usuario);
                            System.out.println("es una matriz triangular de " + matriz_usuario.length + "x" + matriz_usuario.length);
                        } else {
                            imprimir_matriz(matriz_usuario);
                            System.out.println("la matriz  no es una matriz triangular");
                        }
                        System.out.println();
                        System.out.println("para fianlizar escribe 0, para continuar pulsa enter");
                        String finalizar = sc.nextLine();
                        if (finalizar.equals("0")) {
                            break;
                        }


                }
                case 3:{
                    System.out.println("PROGRAMA 3: calculo del determinante de una matriz");
                    int[][] matriz = leer_matriz();
                    int determinante = calcularDeterminante(matriz);

                    System.out.print("El determinante de la matriz ");
                    imprimir_matriz(matriz);
                    System.out.print(" es "+ determinante);
                }
                case 4: {
                    System.out.println("PROGRAMA 4: producto de dos matrices");
                    System.out.println("Para multiplicar la matriz por si misma escribe 1 y para multiplicar dos matrices distintos");
                    int multiplicacion = sc.nextInt();
                    switch (multiplicacion){
                        case 1: {
                            int[][] matriz1 = leer_matriz();
                            System.out.print("El producto de dos matrices  ");
                            imprimir_matriz(matriz1);
                            System.out.println("*");
                            imprimir_matriz(matriz1);
                            System.out.println("es ");
                            imprimir_matriz(Productomatriz(matriz1, matriz1));
                        }
                        case 2: {
                            int[][] matriz1 = leer_matriz();
                            int[][] matriz2 = leer_matriz();
                            System.out.print("El producto de dos matrices  ");
                            imprimir_matriz(matriz1);
                            System.out.println("*");
                            imprimir_matriz(matriz2);
                            System.out.println("es ");
                            imprimir_matriz(Productomatriz(matriz1, matriz2));
                        }
                    }
                }
            }
        }
    }
}

