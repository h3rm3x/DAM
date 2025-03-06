import java.util.ArrayList;
import java.util.Random;
public class Partida {
    private final String nombreJugador;
    private final char[] combinacionSecreta;
    private ArrayList<Tirada> listaTiradas;
    private int puntuacion;
    private boolean EstadoFinal;
    private char[] colores = {'R', 'B', 'G', 'M', 'Y', 'C'};

    public Partida(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.combinacionSecreta = new char[4];
        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int index = random.nextInt(6);
            combinacionSecreta[i] = colores[index];
        }
        this.listaTiradas = new ArrayList<Tirada>();
        this.puntuacion = 0;
        this.EstadoFinal = false;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public boolean getEstadoFinal() {
        return EstadoFinal;
    }

    public ArrayList<Tirada> getListaTiradas() {
        return listaTiradas;
    }

    public char[] getCombinacionSecreta() {
        return combinacionSecreta;
    }

    public int[] comprobar(Tirada tirada) {
        int aciertos = 0;
        int malColocados = 0;
        boolean[] control = {false, false, false, false};
        char[] combinacionIntentada = Tirada.getCombinacionInentada();

        for (int i = 0; i < combinacionSecreta.length; i++) {
            if (combinacionIntentada[i] == combinacionSecreta[i]) {
                aciertos++;
                control[i] = true;
            }
        }

        for (int i=0; i<3; i++) {
            if (!control[i]) {
                for (int j = 0; j < 3; j++) {
                    if (combinacionSecreta[i] == combinacionIntentada[j]) {
                        malColocados++;
                    }
                }
            }
        }
        Tirada.setResultadoTirada(aciertos*2+malColocados);
        if (aciertos == 4) {
            EstadoFinal = true;
        }
        return new int[]{aciertos, malColocados};
    }

}
