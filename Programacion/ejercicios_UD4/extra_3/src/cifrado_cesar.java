import java.util.Scanner;
public class cifrado_cesar {
    static Scanner sc = new Scanner(System.in);
   public static String cifrado(String frase, int n) {
        frase = frase.toLowerCase();
        char[] abecedario = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 0; i < abecedario.length; i++) {
            for (int j = 0; j < frase.length(); j++) {
                if (frase.charAt(j) == abecedario[i]) {
                    frase.toCharArray()[j]= abecedario[i+n];
                }
            }
        }
        return frase;
    }
    public static String descifrado(String frase, int n) {
       frase = frase.toLowerCase();
        char[] abecedario = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 0; i < frase.length(); i++) {
            for (int j = 0; j < abecedario.length; j++) {
                if (frase.charAt(j) == abecedario[i]) {
                    frase.toCharArray()[j]= abecedario[i-n];
                }
            }
        }
        return frase;
    }
    public static void main(String[] args) {
       System.out.println("Introduzca una frase para cifrar: ");
       String frase = sc.nextLine();
       System.out.println("Introduzca el numero de desplazamientos que desea: ");
       int n = sc.nextInt();
       String frase_cifrada = cifrado(frase, n);
       System.out.println("la frase cifrada es "+frase_cifrada);
       
    }
}