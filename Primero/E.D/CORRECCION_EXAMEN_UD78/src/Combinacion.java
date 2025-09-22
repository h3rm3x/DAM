import java.util.*;

public class Combinacion {
    private final List<Integer> numeros;

    public Combinacion(List<Integer> numeros) {
        this.numeros = new ArrayList<>(numeros);
    }

    public List<Integer> getNumeros() {
        return Collections.unmodifiableList(numeros);
    }

    public static Combinacion generarAleatoria(int longitud, int min, int max) {
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < longitud; i++) {
            lista.add(random.nextInt(max - min + 1) + min);
        }
        return new Combinacion(lista);
    }
}

