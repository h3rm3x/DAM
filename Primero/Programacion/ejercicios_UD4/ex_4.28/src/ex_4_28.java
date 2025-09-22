import java.util.Scanner;
public class ex_4_28 {
    static Scanner sc = new Scanner(System.in);
    public static int[][] leer_matriz(){
        System.out.println("Ingrese la medida de la matriz: ");
        int medida = sc.nextInt();
        while (medida<2){
            System.out.println("ERROR, la matriz ha de ser minimo de 2x2: ");
            System.out.println("Ingrese de nuevo la medida de la matriz: ");
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
    public static boolean comprobar_matriz(int[][] matriz){
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
    public static void main(String[] args) {
        int[][] matriz_usuario = leer_matriz();
        boolean es_identidad = comprobar_matriz(matriz_usuario);
        if(es_identidad){
            System.out.println("la matriz: ");
            for (int i = 0; i < matriz_usuario.length; i++) {
                for (int j = 0; j < matriz_usuario.length; j++) {
                    System.out.print(matriz_usuario[i][j] + " ");

                }
                System.out.println();
            }
            System.out.println("es la matriz identidad de " + matriz_usuario.length + "x" + matriz_usuario.length);

        }
        else {
            System.out.println("la matriz  no es la matriz identidad");
        }
    }
}