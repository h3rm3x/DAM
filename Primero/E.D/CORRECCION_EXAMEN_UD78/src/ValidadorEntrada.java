import java.util.*;

public class ValidadorEntrada {
    public static Combinacion leer(String linea, int longitud, int min, int max) {
        String[] partes = linea.trim().split(" ");
        if (partes.length != longitud) {
            throw new IllegalArgumentException("Se esperaban " + longitud + " n�meros.");
        }

        List<Integer> numeros = new ArrayList<>();
        for (String parte : partes) {
            try {
                int num = Integer.parseInt(parte);
                if (num < min || num > max) {
                    throw new IllegalArgumentException("N�mero fuera de rango: " + num);
                }
                numeros.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Formato inv�lido: " + parte);
            }
        }
        return new Combinacion(numeros);
    }
}

