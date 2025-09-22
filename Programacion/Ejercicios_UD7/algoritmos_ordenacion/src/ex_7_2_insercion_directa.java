public class ex_7_2_insercion_directa {
    public static void main(String[] args) {
        int[] array = {10,9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arrayOrdenado = new int[array.length];
        int i, j, aux;

        for (i=0; i<array.length; i++) {
            aux = array[i];
            for (j=i-1; j>=0 && array[j]>aux; j--) {
                array[j+1] = array[j];
                System.out.println("Array ordenado:"+ java.util.Arrays.toString(array));
            }
            array[j+1] = aux;
        }
        System.out.println("Array ordenado:"+ java.util.Arrays.toString(array));

    }
}
