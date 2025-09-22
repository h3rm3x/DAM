import java.util.Scanner;
import java.util.Random;
public class ex4_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        final int numero_SECRETO = rand.nextInt(100) + 1;
        int numero_adivinado = 0;
        int intentos=0;
        boolean correcte= false;
        while ( !correcte) {
            System.out.print("Adivina un numero ente 1 and 20: ");
            numero_adivinado = sc.nextInt();
            sc.nextLine();
            intentos++;
            if ( numero_adivinado == numero_SECRETO ) {
                System.out.println("Felicidades! Has acertado el nuemero secreto " + numero_SECRETO+ " en "+ intentos +" intentos.");
                correcte = true;
            }
            else {
                System.out.println("El numero "+ numero_adivinado +" NO es correcto");
            }
            if (intentos == 10) {
                System.out.println("Has agotado los intentos.");
                correcte = true;
            }
        }

    }
}