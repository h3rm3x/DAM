public class ex_7_3_seleccion_directa {
    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int n = array.length;
        int i, j, menor;
        for (i = 0; i < n - 1; i++) {
            menor = i;
            for (j = i + 1; j < n; j++) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }

        }
    }
}