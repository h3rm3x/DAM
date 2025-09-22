public class Ahorcado {
    protected String palabra;
    protected String palabraOculta;
    protected static   char[] letrasIntentadas;
    protected static boolean juegoTerminado;
    public static String dibujo;
    protected static int intentos;
    protected static int intentosIncorrectos=0;

    public Ahorcado(String palabra) {
        this.palabra = palabra;
        this.palabraOculta = "-".repeat(palabra.length());
        letrasIntentadas = new char[26];
        this.juegoTerminado = false;

    }

    public String getPalabraOculta() {
        return palabraOculta;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public void intentarLetra(char letra) {
        if (juegoTerminado) {
            return;
        }
        if (letraYaIntentada(letra)) {
            return;
        }
        if (palabra.contains(String.valueOf(letra))) {
            destaparLetra(letra);
            letrasIntentadas[intentos] = letra;
            intentos++;


        } else {
            letrasIntentadas[intentos] = letra;
            intentosIncorrectos++;
            intentos++;
            pintarLinea();
        }
        if (palabraOculta.equals(palabra)) {
            juegoTerminado = true;
        }
    }

    private boolean letraYaIntentada(char letra) {
        for (char letraIntentada : letrasIntentadas) {
            if (letraIntentada == letra) {
                return true;
            }
        }
        return false;
    }

    private void destaparLetra(char letra) {
        char[] palabraOcultaArray = palabraOculta.toCharArray();
        char[] palabraArray = palabra.toCharArray();
        for (int i = 0; i < palabraArray.length; i++) {
            if (palabraArray[i] == letra) {
                palabraOcultaArray[i] = letra;
            }
        }
        palabraOculta = String.valueOf(palabraOcultaArray);
    }

    public static String getLetrasIntentadas() {
        return String.valueOf(letrasIntentadas);
    }

    public String getPalabra() {
        return palabra;
    }

    public static void pintarLinea() {
        switch (intentosIncorrectos) {
            case 1:
                dibujo = "______\n" +
                        "|    |\n" +
                        "|    O\n" +
                        "|    \n" +
                        "|______\n";
                break;
            case 2:
                dibujo = "______\n" +
                        "|    |\n" +
                        "|    O\n" +
                        "|    |\n" +
                        "|______\n";
                break;
            case 3:
                dibujo = "______\n" +
                        "|    |\n" +
                        "|    O\n" +
                        "|   /|\n" +
                        "|______\n";
                break;
            case 4:
                dibujo = "______\n" +
                        "|    |\n" +
                        "|    O\n" +
                        "|   /|\\\n" +
                        "|______\n";
                break;
            case 5:
                dibujo = "______\n" +
                        "|    |\n" +
                        "|    O\n" +
                        "|   /|\\\n" +
                        "|   /   \n" +
                        "|______\n";
                break;
            case 6:
                dibujo = "______\n" +
                        "|    |\n" +
                        "|    O\n" +
                        "|   /|\\\n" +
                        "|   / \\\n" +
                        "|______\n";
                juegoTerminado = true;
                break;

            case 0:
                dibujo = "______\n" +
                        "|    |\n" +
                        "|    \n" +
                        "|    \n" +
                        "|______\n";
                break;
        }
    }

    public static String MostrarDibujo() {
        return dibujo;

    }





}
