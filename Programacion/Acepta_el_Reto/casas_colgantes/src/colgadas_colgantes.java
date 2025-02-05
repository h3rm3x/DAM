

public class colgadas_colgantes {
    // Asume fichero llamado solution.java

        static java.util.Scanner in;

        public static void casoDePrueba() {
            String colgadas = in.nextLine();

            colgadas = colgadas.toLowerCase();

            if (colgadas.equals("colgadas")) {
                System.out.println("Bien");
            } else if(colgadas.equals("colgantes")) {
                System.out.println("Mal");
            }
            // TU CÓDIGO AQUÍ

        } // casoDePrueba

        public static void main(String[] args) {

            in = new java.util.Scanner(System.in);

            int numCasos = in.nextInt();
            for (int i = 0; i <= numCasos; i++)
                casoDePrueba();
        } // main
} // class solution

