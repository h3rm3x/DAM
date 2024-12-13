import java.util.Scanner;
public class Asalto_al_castillo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int No_soldados = sc.nextInt();

            if (No_soldados==0){
                break;
            }
            if (No_soldados>3){
                int combinaciones=2;
                double raiz = Math.sqrt(No_soldados);
                if (raiz == Math.floor(raiz)){ // raiz cuadrada no son 2 divisores diferentes
                    combinaciones++;
                }
                for (int i = 2; i < raiz; i++) {
                    if (No_soldados%i==0){

                        combinaciones+=2;
                    }
                }

                System.out.println(combinaciones);

            } else if (No_soldados>1){
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
    }
}