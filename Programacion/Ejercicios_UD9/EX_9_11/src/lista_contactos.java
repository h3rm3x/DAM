import java.util.*;
public class lista_contactos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> contactos = new HashMap<>();
        try {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Mostrar contactos");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Teléfono: ");
                    int telefono = sc.nextInt();
                    contactos.put(nombre, telefono);
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    if (contactos.containsKey(nombre)) {
                        System.out.println("Teléfono: " + contactos.get(nombre));
                    } else {
                        System.out.println("No se ha encontrado el contacto");
                    }
                    break;
                case 3:
                    for (Map.Entry<String, Integer> contacto : contactos.entrySet()) {
                        System.out.println(contacto.getKey() + ": " + contacto.getValue());
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
        catch (InputMismatchException e) {
            System.out.println("Error: Debes introducir un número entero");
        }
    }
}
