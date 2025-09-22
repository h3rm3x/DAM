// Entrar una frase i treure quina és la paraula que conté més vocals.
import java.util.Scanner;

public class ex_4_27 {
    static Scanner sc = new Scanner(System.in);
    public static String leer_frase(){
        System.out.print("Escriba una frase: ");
        return sc.nextLine();
    }
    public static String[] mas_vocales(String frase){
        String palabra = "";
        int vocales = 0;
        int maxvocales = 0;
        String palabra_max_vocales = "";
        for (int i = 0; i < frase.length(); i++){

            if (frase.charAt(i) != ' '){
                palabra += frase.charAt(i);

            }

            if (frase.charAt(i) == ' ' || i == frase.length() - 1){
                for (int j = 0 ; j < palabra.length(); j++){

                    if (palabra.charAt(j) == 'a' || palabra.charAt(j) == 'e' || palabra.charAt(j) == 'i'|| palabra.charAt(j) == 'o'|| palabra.charAt(j) == 'u' ){
                        vocales++;
                    }

                } if (vocales > maxvocales){
                    maxvocales = vocales;
                    palabra_max_vocales = palabra;

                }

                vocales = 0;
                palabra = "";
            }


        }
        return new String[]{palabra_max_vocales, String.valueOf(maxvocales)};
    }
    public static void main(String[] args) {
        while (true) {
            String[] palabra_vocales = mas_vocales(leer_frase());
            System.out.println("la palabra con mas vocales es " + palabra_vocales[0] + ", que tiene " + palabra_vocales[1] + " vocales");
            System.out.println();
            System.out.println("Para finalizar el programa escribe 0, para continuar pulsa enter");
            String finalizar = sc.nextLine();
            if (finalizar.equals("0")){
                break;
            }
        }
    }
}