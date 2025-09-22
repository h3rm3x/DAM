import java.util.*;

public class Mastermind {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    public void jugarMastermind() {

        int intentos = 0;
        List<Integer> secreto = CrearCombinacionSecreta(random);

        System.out.println("�Bienvenido a Mastermind!");
        System.out.println("Adivina la combinaci�n secreta de 4 n�meros entre 1 y 6.");

        while (true) {
            String[] partes = Combinacion.leerIntento();
            if (partes == null) continue;


            List<Integer> intento = new ArrayList<>();
            ValidarEntrada validacion = new ValidarEntrada(partes, intento);
            intento = validacion.getIntento();
            partes = validacion.getPartes();
            intentos++;

            ComprobarCombinacion comprobacion = new ComprobarCombinacion(partes, intento, secreto);
            int aciertos = comprobacion.comprobarCombinacion()[0];
            int coincidencias = comprobacion.comprobarCombinacion()[1];


            Resultado resultado = new Resultado(aciertos,coincidencias,intentos);


            if (resultado.mensajeResultado()){
                break;
            }
        }
        scanner.close();
    }

    private static List<Integer> CrearCombinacionSecreta(Random random) {
        List<Integer> secreto = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            secreto.add(random.nextInt(6) + 1);
        }
        return secreto;
    }


    public static void main(String[] args) {
        new Mastermind().jugarMastermind();
    }
}
