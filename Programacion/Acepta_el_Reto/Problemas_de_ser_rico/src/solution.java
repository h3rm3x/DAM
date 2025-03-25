public class solution { // Asume fichero llamado solution.java

    static java.util.Scanner in;

    public static void casoDePrueba() {
        int No_compartimentos = in.nextInt();
        int capacida_max= in.nextInt();
        int dif_adyacentes = in.nextInt();
        int capacidad_total=0 ;
        for (int i = 0; i < No_compartimentos; i++) {
            capacidad_total += capacida_max;
            capacida_max-=dif_adyacentes;
        }
        System.out.println(capacidad_total);

    } // casoDePrueba

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    } // main
} // class solution