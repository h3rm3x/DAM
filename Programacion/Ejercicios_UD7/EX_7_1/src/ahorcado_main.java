import java.util.Scanner;
public class ahorcado_main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] palabras = {
                "casa", "perro", "libro", "árbol", "mesa",
                "silla", "sol", "luna", "mar", "montaña",
                "ciudad", "coche", "flor", "reloj", "café",
                "música", "tiempo", "color", "papel", "agua",
                "fuego", "tierra", "aire", "luz", "noche",
                "día", "pan", "amor", "vida", "mano",
                "puerta", "ventana", "jardín", "cielo", "río",
                "piedra", "bosque", "playa", "estrella", "pájaro",
                "camino", "lluvia", "viento", "nube", "corazón",
                "familia", "amigo", "trabajo", "sueño", "paz"
        };

        Ahorcado ahorcado = new Ahorcado(palabras[(int) (Math.random() * palabras.length)]);

        while (!ahorcado.isJuegoTerminado()) {
            System.out.println(ahorcado.getPalabraOculta());
            System.out.println("Letras intentadas: " + Ahorcado.getLetrasIntentadas());
            Ahorcado.pintarLinea();
            System.out.println(Ahorcado.MostrarDibujo());

            if (Ahorcado.intentosIncorrectos == 6) {
                System.out.println("Has perdido");
                System.out.println("La palabra era: " + ahorcado.palabra);
                break;
            }
            if (Ahorcado.intentosIncorrectos > 3) {
                System.out.println("Cuidado, te quedan " + (6 - Ahorcado.intentos) + " intentos");
                System.out.println("Escribe * para adivinar la palabra");
                String respuesta = sc.nextLine();
                if (respuesta.equals("*")) {
                    System.out.println("Introduce la palabra: ");
                    String palabra = sc.nextLine();
                    if (palabra.equals(ahorcado.palabra)) {
                        System.out.println("Has ganado");
                        break;
                    } else {
                        System.out.println("Incorrecto, escriba otra letra");
                    }
                }
            }
            else {
                System.out.println("Introduce una letra: ");
                Ahorcado.pintarLinea();
                char letra = sc.nextLine().charAt(0);
                ahorcado.intentarLetra(letra);

            }

            if (ahorcado.isJuegoTerminado()) {
                System.out.println("Enhorabuena has adivinado correctamente la palabra: " + ahorcado.getPalabraOculta());
            }
        }
    }
}
