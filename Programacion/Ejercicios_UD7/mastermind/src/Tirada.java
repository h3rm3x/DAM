public class Tirada {
    private static char[] combinacionInentada;
    private int[] respuestaOrdenador;
    private static int resultadoTirada;

    public Tirada(char[] combinacionInentada) {
        Tirada.combinacionInentada = combinacionInentada;
        this.respuestaOrdenador = new int[2];
        this.resultadoTirada = 0;
    }

    public static char[] getCombinacionInentada() {
        return combinacionInentada;
    }

    public int[] getRespuestaOrdenador() {
        return respuestaOrdenador;
    }

    public int getResultadoTirada() {
        return resultadoTirada;
    }

    public static void setResultadoTirada(int resultadoTirada) {
        Tirada.resultadoTirada = resultadoTirada;
    }

    public void setRespuestaOrdenador(int[] respuestaOrdenador) {
        this.respuestaOrdenador = respuestaOrdenador;
    }

}
