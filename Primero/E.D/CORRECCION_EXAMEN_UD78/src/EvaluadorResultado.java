import java.util.List;

public class EvaluadorResultado {
    private final Combinacion secreta;

    public EvaluadorResultado(Combinacion secreta) {
        this.secreta = secreta;
    }

    public Resultado evaluar(Combinacion intento) {
        List<Integer> s = secreta.getNumeros();
        List<Integer> i = intento.getNumeros();

        int aciertos = 0;
        int coincidencias = 0;
        boolean[] usadosS = new boolean[s.size()];
        boolean[] usadosI = new boolean[i.size()];

        // Aciertos exactos
        for (int j = 0; j < s.size(); j++) {
            if (s.get(j).equals(i.get(j))) {
                aciertos++;
                usadosS[j] = true;
                usadosI[j] = true;
            }
        }

        // Coincidencias fuera de lugar
        for (int j = 0; j < s.size(); j++) {
            if (usadosI[j]) continue;
            for (int k = 0; k < s.size(); k++) {
                if (!usadosS[k] && i.get(j).equals(s.get(k))) {
                    coincidencias++;
                    usadosS[k] = true;
                    break;
                }
            }
        }

        return new Resultado(aciertos, coincidencias);
    }
}
