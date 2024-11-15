import java.util.Scanner;
public class Extra_1 {
    static Scanner sc = new Scanner(System.in);
    public static String leer_frase(){
        System.out.print("Ingrese una frase: ");
        return sc.nextLine();
    }
    public static boolean comprobar_palindromo(String frase){
        frase = frase.toLowerCase();
        for (int i = 0; i < frase.length()/2 ; i++) {
            if (frase.charAt(i) != frase.charAt(frase.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String frase = leer_frase();
        if (comprobar_palindromo(frase)){
            System.out.println("la frase "+ frase+ " es un palindromo");
        } else System.out.println("la frase "+ frase+ " NO es un palindromo");
    }
}