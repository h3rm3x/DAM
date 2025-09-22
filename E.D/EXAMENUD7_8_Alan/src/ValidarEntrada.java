import java.util.ArrayList;
import java.util.List;

public class ValidarEntrada {
    private String[] partes;
    private List<Integer> intento;
    public ValidarEntrada(String[] partes, List<Integer> intento) {
        this.partes = partes;
        this.intento = intento;
    }

    public String[] getPartes() {
        return partes;
    }

    public List<Integer> getIntento() {
        return intento;
    }

    public void validar() {
        try {
            for (String parte : partes) {
                int num = Integer.parseInt(parte);
                if (num < 1 || num > 6) {
                    throw new NumberFormatException();
                }
                intento.add(num);
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inv�lida. Usa solo n�meros entre 1 y 6.");
            partes = Combinacion.leerIntento();
        }
    }


}
