public class piramides { // Asume fichero llamado solution.java

    static java.util.Scanner in;

    public static void casoDePrueba() {
        int año1 = in.nextInt();
        int año2 = in.nextInt();
        int año3 = in.nextInt();
        int diferencia1 = año2 - año1;
        int diferencia2 = año3 - año2;
        if (año2 >0 && año1 <0 || año2 <0 && año1 >0) {
            diferencia1 -=1;
        } else if (año2 <0 && año3 >0 || año2 >0 && año3 <0) {
            diferencia2 -=1;
        }

        if (diferencia1 < diferencia2) {
            System.out.println(año1);
        } else if (diferencia1 > diferencia2) {
            System.out.println(año3);
        } else {
            System.out.println("EMPATE");
        }
      
        

    } // casoDePrueba

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    } // main
} // class solution