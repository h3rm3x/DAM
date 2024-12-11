import java.util.Scanner;
public class Asalto_al_castillo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int No_soldados = sc.nextInt();
            int combinaciones=1;
            if (No_soldados==0){
                break;
            }
            for (int i = 1; i < (No_soldados/2) +1; i++) {
                if (No_soldados%i==0){
                    combinaciones++;
                }

            }

            System.out.println(combinaciones);

        }
    }

}
