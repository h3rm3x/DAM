public class ex_7_5 {
    public static void main(String[] args) {
        System.out.println("Algoritmos de ordenación");
        System.out.println("1. Burbuja");
        System.out.println("2. Selección directa");
        System.out.println("3. Inserción");
        System.out.println("4. Salir");

        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Introduce una opción: ");
            int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            int n = array.length;
            opcion = new java.util.Scanner(System.in).nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("Has seleccionado Burbuja");
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
                    break;
                case 2: {
                    System.out.println("Has seleccionado Selección directa");
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
                    break;
                case 3: {
                    System.out.println("Has seleccionado Inserción");
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
                    break;
                case 4: {
                    System.out.println("Has seleccionado Salir");
                    break;
                }
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
