import java.util.Objects;
import java.util.Scanner;
public class ex_4_26 {
    static Scanner sc = new Scanner(System.in);
    public static String leer_texto() {
        String texto ;
        System.out.print("Introduzca el texto: ");
        texto=sc.nextLine();
        texto=texto.toLowerCase();
        return texto;
    }
    public static String[] contar_letras() {
        String texto = leer_texto();
        String letramasrepetida = "";
        String letra ;
        String[] letras_comprobadas = new String[texto.length()];

        int repeticiones = 0;
        int maxrepeticiones= 0;
        int indiceComprobadas = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (Objects.equals(texto.charAt(i), ' ') || Objects.equals(texto.charAt(i), (char) 9)) {continue;}
            letra = String.valueOf(texto.charAt(i));
            boolean yaComprobada = false;
            for (int k = 0; k < indiceComprobadas; k++) {

                if (letra.equals(letras_comprobadas[k])) {
                    yaComprobada = true;
                    break;
                }
            }
            if (yaComprobada) {
                continue;
            }
            letras_comprobadas[indiceComprobadas] = letra;
            indiceComprobadas++;


            for (int j = 0; j < texto.length(); j++) {

                if (Objects.equals(letra, Objects.toString(texto.charAt(j)))) {
                    repeticiones++;
                }
            }

            if (repeticiones>maxrepeticiones) {
                maxrepeticiones = repeticiones;
                letramasrepetida = letra;

            }
            repeticiones=0;
        }



        return new String[]{letramasrepetida, Objects.toString(maxrepeticiones) };
    }
    public static void main(String[] args) {
       while (true) {
          String[] letras_repetidas = contar_letras();
           System.out.println("La letra mas repetida es la " + letras_repetidas[0] + " ,que se repite "+ letras_repetidas[1] + " veces");

           System.out.println();
           System.out.println("Escribe 0 para finalizar el programa, si quieres continuar pulsa enter: ");
           String finalizar = sc.nextLine();
           if (finalizar.equals("0")) {
               break;
           }
       }
    }
}