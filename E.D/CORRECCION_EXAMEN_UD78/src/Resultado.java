public class Resultado {
    private final int aciertos;
    private final int coincidencias;

    public Resultado(int aciertos, int coincidencias) {
        this.aciertos = aciertos;
        this.coincidencias = coincidencias;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getCoincidencias() {
        return coincidencias;
    }
}

