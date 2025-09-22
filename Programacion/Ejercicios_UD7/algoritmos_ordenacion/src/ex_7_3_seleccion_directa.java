public class ex_7_3_seleccion_directa {
    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int iteraciones = 1;
        for (int i = 0; i < array.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }
            int aux = array[menor];
            array[menor] = array[i];
            array[i] = aux;
            System.out.println("Iteración " + iteraciones + ": " + java.util.Arrays.toString(array));
            iteraciones++;
        }
    }
}
