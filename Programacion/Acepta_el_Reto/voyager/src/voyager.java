public class voyager {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        if (!in.hasNextLine()) {
            return false;
        } else {
            String linea = in.nextLine().trim();

            if (!linea.isEmpty()) {
                String[] numeros = linea.split(" ");
                if (numeros.length != 3) {
                    System.out.println("RUIDO COSMICO");
                    return true;
                }

                if (esNumeroValido(numeros[0]) || esNumeroValido(numeros[1]) || esNumeroValido(numeros[2])) {
                    System.out.println("RUIDO COSMICO");
                    return true;
                }

                String resultado = procesarNumeros(numeros[0], numeros[1], numeros[2]);
                System.out.println(resultado);
            }
            return true;
        }
    } // casoDePrueba

    public static boolean esNumeroValido(String numero) {
        try {
            if (numero.isEmpty() || numero.length() > 10) {
                return true;
            }
            long valor = Long.parseLong(numero);
            return valor < 0 || valor >= 1000000000;

        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static String procesarNumeros(String num1, String num2, String num3) {
        int maxLength = Math.max(num1.length(), Math.max(num2.length(), num3.length()));

        // Pad numbers with leading zeros to ensure equal length
        num1 = String.format("%" + maxLength + "s", num1).replace(' ', '0');
        num2 = String.format("%" + maxLength + "s", num2).replace(' ', '0');
        num3 = String.format("%" + maxLength + "s", num3).replace(' ', '0');

        StringBuilder numfinal = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            char c1 = num1.charAt(i);
            char c2 = num2.charAt(i);
            char c3 = num3.charAt(i);

            if (c1 == c2 || c1 == c3) {
                numfinal.append(c1);
            } else if (c2 == c3) {
                numfinal.append(c2);
            } else {
                return "RUIDO COSMICO";
            }
        }

        // Remove leading zeros in the final number
        String resultado = numfinal.toString();
        return resultado.replaceFirst("^0+(?!$)", "");
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

} // class solution
