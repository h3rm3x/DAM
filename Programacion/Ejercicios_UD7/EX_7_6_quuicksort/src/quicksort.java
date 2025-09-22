import java.util.Arrays;

public class quicksort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 3, 4, 6, 2};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            System.out.println("QS1"+Arrays.toString(arr));
            quickSort(arr, pi + 1, high);
            System.out.println("QS2"+Arrays.toString(arr));
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println("P"+Arrays.toString(arr));
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        System.out.println("P final"+Arrays.toString(arr));
        return i + 1;
    }

}
