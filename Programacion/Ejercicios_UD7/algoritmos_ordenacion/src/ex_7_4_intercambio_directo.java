import java.util.Arrays;

public class ex_7_4_intercambio_directo {
    public static void main(String[] args) {
        int[] array = {7,3,1,4,9,22,5,8,10,6,45,14,2,41};
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
            }


        }System.out.println(Arrays.toString(array));
    }
}
