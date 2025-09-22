import java.util.Scanner;
/**
 * <h1>Programa càlcul descomptes</h1>
 * el programa demanará el preu de la compra i mostrara al final el pru a pagar amb el descompte fet si es conpleix la condició d'aplicar-lo
 * cerca info de jvadoc a <a href="https://google.com>GOOGLE</a>
 * @since 16-10-2024
 * @version 1.0
 * @author Alan Rabinerson
 *
 */
public class Descompte {
    /**
     * Constant per definir el descompte aplicat
     */
    //Es fa un descompte del 8%.
    public static final float DESCOMPTE = 8;
    /**
     *Constant per inidicar el preu minim a partir de la qual aplicar el descompte
     */
    //Es fa descompte per compres d'un mínim de 100 euros.
    public static final float COMPRA_MIN = 100;
    //metodes publics
    /**
     *Funcio principal del programa
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print(";Quin és el preu del producte, en euros?");
        float preu = lector.nextFloat();

        lector.nextLine();
//Estructura de selecció simple.
//Si l'expressió avalua true, executa el bloc dins l&#39;if.
//En cas contrari, ignora&#39;l.
        if (preu <= COMPRA_MIN) {
            float descompteFet = preu * DESCOMPTE / 100;
            preu = preu - descompteFet;
        }
        System.out.println("El preu final per pagar és de " + preu + " euros");
    }
}
