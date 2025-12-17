public class jeroglificos {
    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int numero = in.nextInt();
        if (numero == 0)
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            while (true) {
                int cifra = numero % 10;
                System.out.print(cifra);
                numero = numero / 10;
                if (numero == 0)
                    break;
                
            }
            System.out.println();
            return true;
         }
    } // casoDePrueba

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main
}
