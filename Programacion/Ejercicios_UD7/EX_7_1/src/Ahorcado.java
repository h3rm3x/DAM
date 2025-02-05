public class Ahorcado {
    private String palabra;
    private String palabraOculta;
    private char[] letrasIntentadas;
    private boolean juegoTerminado;

    public Ahorcado(String palabra) {
        this.palabra = palabra;
        this.palabraOculta = palabra.replaceAll(" ", "_");
        this.letrasIntentadas = new char[26];
        this.juegoTerminado = false;

    }




}
