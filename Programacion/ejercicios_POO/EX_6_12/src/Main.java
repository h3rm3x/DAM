import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Cola cola_concierto = new Cola(250);
        Cola cola_cine = new Cola(100);

        while (true) {
            System.out.println("Elige una opción: ");
            System.out.println("1. Añadir persona a la cola del concierto");
            System.out.println("2. Añadir persona a la cola del cine");
            System.out.println("3. Sacar persona de la cola del concierto");
            System.out.println("4. Sacar persona de la cola del cine");
            System.out.println("5. Mostrar cola del concierto");
            System.out.println("6. Mostrar cola del cine");
            System.out.println("7. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre de la persona: ");
                    String nombre_concierto = sc.nextLine();
                    Persona persona_concierto = new Persona(nombre_concierto);
                    cola_concierto.PersonaEntra(persona_concierto);
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la persona: ");
                    String nombre_cine = sc.nextLine();
                    Persona persona_cine = new Persona(nombre_cine);
                    cola_cine.PersonaEntra(persona_cine);
                    break;
                case 3:
                    cola_concierto.Persona_sale_de_la_cola();
                    break;
                case 4:
                    cola_cine.Persona_sale_de_la_cola();
                    break;
                case 5:
                    System.out.println(cola_concierto);
                    break;
                case 6:
                    System.out.println(cola_cine);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }


        }
    }
}
