import java.util.Scanner;
public class ex_4_29 {
    static Scanner sc = new Scanner(System.in);
    public static int[][] leer_matriz(){
        System.out.println("Ingrese la medida de la matriz: ");
        int medida = sc.nextInt();
        while (medida<3){
            System.out.println("ERROR, una matriz triangular solo puede ser 3x3 o mayor");
            System.out.println("Ingrese la medida de la matriz: ");
            medida = sc.nextInt();
        }

        int[][] matriz = new int[medida][medida];

        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++) {
                System.out.println("Ingrese el valor de la celda " + (i + 1) + " " + (j + 1));
                matriz[i][j] = sc.nextInt();
            }

        }
        return matriz;
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


    public static void main(String[] args) {
        while (true) {
            int[][] matriz_usuario = leer_matriz();
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
    }
}