import java.util.List;

public class ComprobarCombinacion {
    private int aciertos = 0;
    private int coincidencias = 0;
    boolean[] usadosSecreto = new boolean[4];
    boolean[] usadosIntento = new boolean[4];
    private String[] partes;
    private List<Integer> intento;
    private List<Integer> secreto;


    public ComprobarCombinacion(String[] partes, List<Integer> intento, List<Integer> secreto) {
        this.partes = partes;
        this.intento = intento;
        this.secreto = secreto;

    }

    public int[] comprobarCombinacion() {
        for (int i = 0; i < 4; i++) {
            if (intento.get(i).equals(secreto.get(i))) {
                aciertos++;
                usadosSecreto[i] = true;
                usadosIntento[i] = true;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (usadosIntento[i]) continue;
            for (int j = 0; j < 4; j++) {
                if (usadosSecreto[j]) continue;
                if (intento.get(i).equals(secreto.get(j))) {
                    coincidencias++;
                    usadosSecreto[j] = true;
                    break;
                }
            }
        }
        return new int[]{aciertos, coincidencias};
    }


}
