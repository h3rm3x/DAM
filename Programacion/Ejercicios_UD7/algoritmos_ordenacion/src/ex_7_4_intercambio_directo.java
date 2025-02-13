public class ex_7_4_intercambio_directo {
    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int n = array.length;
        int i, j, aux;
        for (i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                aux = array[i];
                array[i] = array[i + 1];
                array[i + 1] = aux;
            }
            for (j = i + 1; j < n; j++) {
                if (array[j] < array[i]) {
                    aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
                System.out.println("Iteración " + (i + 1) + ": " + java.util.Arrays.toString(array));

            }

        }
    }
}
