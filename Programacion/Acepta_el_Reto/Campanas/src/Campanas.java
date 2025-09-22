public class Campanas {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        if (!in.hasNext())
            return false;
        else {
            String cadena = in.nextLine();

            char letra_repe;
            int repeticiones = 0;
            int max_repeticiones = 0;
            if (cadena.length() > 200) {
                return true;
            }
            for (int i = 0; i < cadena.length(); i++) {
                letra_repe = cadena.charAt(i);
                for (int j = i + 1; j < cadena.length(); j++) {
                    if (cadena.charAt(j) == letra_repe) {
                        repeticiones++;
                    }
                }
                if (repeticiones > max_repeticiones) {
                    max_repeticiones = repeticiones;
                }
                repeticiones = 0;
            }
            if (max_repeticiones < ((cadena.length()+1) / 2)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
            return true;
        }
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {

            // Continue reading and analyzing until there are no more data
        }
    }
}