import java.io.Serializable;
import java.util.ArrayList;

public class Tirada implements Serializable {
    private static char[] combinacionInentada;
    private static ArrayList<String> listacombinacionIntentada = new ArrayList<>();
    private int[] respuestaOrdenador;

    private static int resultadoTirada;

    public Tirada(char[] combinacionInentada) {
        Tirada.combinacionInentada = combinacionInentada;
        this.respuestaOrdenador = new int[2];
        resultadoTirada = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : combinacionInentada) {
            sb.append(c);
        }
        listacombinacionIntentada.add(sb.toString());

    }

    public static char[] getCombinacionInentada() {
        return combinacionInentada;
    }

    public int[] getRespuestaOrdenador() {
        return respuestaOrdenador;
    }

    public static int getResultadoTirada() {
        return resultadoTirada;
    }

    public static void setResultadoTirada(int resultadoTirada) {
        Tirada.resultadoTirada = resultadoTirada;
    }

    public void setRespuestaOrdenador(int[] respuestaOrdenador) {
        this.respuestaOrdenador = respuestaOrdenador;
    }

    public String toString() {
        String sb = " ";
        for (char c : combinacionInentada) {
            sb += c + "\n";
        }
        return sb;
    }

}
