public class ex_7_3_seleccion_directa {
    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Intercambiar el elemento más pequeño encontrado con el primer elemento no ordenado
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            System.out.println("Array ordenado: " + java.util.Arrays.toString(array));
        }
        System.out.println("Array ordenado final: " + java.util.Arrays.toString(array));
    }
}