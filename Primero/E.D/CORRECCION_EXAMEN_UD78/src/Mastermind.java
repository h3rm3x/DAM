import java.util.Scanner;

public class Mastermind {
    private static final int LONGITUD_COMBINACION = 4;
    private static final int NUMERO_MINIMO = 1;
    private static final int NUMERO_MAXIMO = 6;

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        Combinacion secreta = Combinacion.generarAleatoria(LONGITUD_COMBINACION, NUMERO_MINIMO, NUMERO_MAXIMO);
        int intentos = 0;

        System.out.println("�Bienvenido a Mastermind!");
        System.out.println("Adivina la combinaci�n secreta de " + LONGITUD_COMBINACION + " n�meros entre " + NUMERO_MINIMO + " y " + NUMERO_MAXIMO + ".");

        while (true) {
            System.out.println("Introduce tu intento (4 n�meros separados por espacios):");
            String linea = scanner.nextLine();

            Combinacion intento;
            try {
                intento = ValidadorEntrada.leer(linea, LONGITUD_COMBINACION, NUMERO_MINIMO, NUMERO_MAXIMO);
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inv�lida: " + e.getMessage());
                continue;
            }

            intentos++;
            EvaluadorResultado evaluador = new EvaluadorResultado(secreta);
            Resultado resultado = evaluador.evaluar(intento);

            if (resultado.getAciertos() == LONGITUD_COMBINACION) {
                System.out.println("�Has adivinado la combinaci�n secreta en " + intentos + " intentos!");
                break;
            } else {
                System.out.println("Aciertos en posici�n correcta: " + resultado.getAciertos());
                System.out.println("Aciertos en posici�n incorrecta: " + resultado.getCoincidencias());
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Mastermind().jugar();
    }
}

