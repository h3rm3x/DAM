import java.util.Scanner;
public class Hola_Mundo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeticiones= sc.nextInt();

        if (repeticiones>=0 && repeticiones<=5){
            for (int i=0; i<repeticiones; i++) {
                System.out.println("Hola mundo.");
            }
        }

    }
}
