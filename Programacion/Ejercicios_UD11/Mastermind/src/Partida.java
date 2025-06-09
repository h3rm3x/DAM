import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Partida implements Serializable {
    private final String nombreJugador;
    private final char[] combinacionSecreta;
    private ArrayList<Tirada> listaTiradas;
    private int puntuacion=0;
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

    public char[] getColores() {
        return colores;
    }

    public int[] comprobar(Tirada tirada) {
        int aciertos = 0;
        int malColocados = 0;
        boolean[] controlSecreta = {false, false, false, false};
        boolean[] controlIntentada = {false, false, false, false};
        char[] combinacionIntentada = tirada.getCombinacionInentada();

        for (int i = 0; i < combinacionSecreta.length; i++) {
            if (combinacionIntentada[i] == combinacionSecreta[i]) {
                aciertos++;
                controlSecreta[i] = true;
                controlIntentada[i] = true; // Marcar como verificada en la intentada
            }
        }
// Contar mal colocados
        for (int i = 0; i < combinacionSecreta.length; i++) {
            if (!controlSecreta[i]) { // Solo considerar posiciones no verificadas en la secreta
                for (int j = 0; j < combinacionIntentada.length; j++) {
                    if (!controlIntentada[j] && combinacionSecreta[i] == combinacionIntentada[j]) {
                        malColocados++;
                        controlIntentada[j] = true; // Marcar como verificada en la intentada
                        break;
                    }
                }
            }
        }
        tirada.setResultadoTirada(aciertos*2+malColocados);
        puntuacion += tirada.getResultadoTirada();
        tirada.setRespuestaOrdenador(new int[]{aciertos, malColocados});
        listaTiradas.add(tirada);
        if (aciertos == 4) {
            EstadoFinal = true;
        }

        return new int[]{aciertos, malColocados};
    }

    @Override
    public String toString() {
        String tiradas = "";
        for (Tirada tir : listaTiradas) {
            tiradas += tir.toString() + "aciertos " + tir.getRespuestaOrdenador()[0]+ " mal colocados "+ tir.getRespuestaOrdenador()[1] +"\n";
        }
        return "Partida:\n" +
                "Jugador: " + nombreJugador + "\n" +
                "Combinación secreta: " + Arrays.toString(combinacionSecreta) + "\n" +
                "Puntuación: " + puntuacion + "\n" +
                "Estado: " + (EstadoFinal ? "Ganada" : "Perdida") + "\n" +
                "Tiradas: " + tiradas;
    }

}
