import java.io.*;
import java.util.*;
public class estadistica_letras {
    public static void main(String[] args) {
        HashMap<Character, Integer> letras_es = new HashMap<Character, Integer>();
        HashMap<Character, Integer> letras_en = new HashMap<Character, Integer>();

        int ASCIIleido;
        char letra;
        try{
            FileReader fr_es = new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo_estadistica_letra\\textExempleCastella.txt");
            FileReader fr_en = new FileReader("C:\\Users\\alanr\\Documents\\DAM\\Programacion\\Ejercicios_UD10\\ejemplo_estadistica_letra\\textExempleAngles.txt");

        while((ASCIIleido= fr_es.read())!= -1) {
            letra = (char) ASCIIleido;
            if(letras_es.containsKey(letra)) {
                letras_es.put(letra, letras_es.get(letra)+1);
            } else {
                letras_es.put(letra, 1);
            }
        }

        while((ASCIIleido= fr_en.read())!= -1) {
            letra = (char) ASCIIleido;
            if (letras_en.containsKey(letra)) {
                letras_en.put(letra, letras_en.get(letra) + 1);
            } else {
                letras_en.put(letra, 1);
            }
        }
        fr_es.close();
        fr_en.close();
        System.out.println("letras español");
        letras_es.forEach((k, v) -> {System.out.println("Letra: " + k + " - Frecuencia: " + v); });
        System.out.println("letras ingles");
        letras_en.forEach((k, v) -> {System.out.println("Letra: " + k + " - Frecuencia: " + v); });
        }catch (IOException e){
            System.out.println("Error al abrir el archivo");
        }

    }
}
