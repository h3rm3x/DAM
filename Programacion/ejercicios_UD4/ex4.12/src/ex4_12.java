import java.util.Scanner;

//Anem a sumar un seguit de múltiples de tres.
public class ex4_12 {
    public static void main (String[] args) {
        Scanner lector = new Scanner(System.in);
//PAS 1 i 2
        System.out.print("Fins a quin valor vols sumar múltiples de 3?");

        int limit = lector.nextInt();
        lector.nextLine();
        int resultat = 0;
//PAS 3: Anar mirant els valors desde 0 fins el valor desitjat.
        for (int i = 0; i <= limit; i+=3) {
                System.out.println("Afegim " + i +"...");
                resultat = resultat + i;
        }
        System.out.println("El resultat final és " + resultat + ".");
    }
}