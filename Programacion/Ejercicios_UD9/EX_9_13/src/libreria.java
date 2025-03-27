import java.util.*;

public class libreria {
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        HashSet<Cliente> clientes = new HashSet<>();
        HashMap<String, Libro> inventario = new HashMap<>();
        HashMap<Cliente, Libro> compra = new HashMap<>();


        libros.add(new Libro("El Quijote", "Cervantes", 123456, 10));
        libros.add(new Libro("El Señor de los Anillos", "Tolkien", 654321, 25));
        libros.add(new Libro("Harry Potter", "Rowling", 987654, 15));
        libros.add(new Libro("El Perfume", "Suskind", 456789, 20));
        libros.add(new Libro("A walk in the woods", "Bryson", 987654, 8));
        for (Libro libro : libros) {
            inventario.put(libro.getTitulo(), libro);
        }


        clientes.add(new Cliente("Juan", 12345));
        clientes.add(new Cliente("Pedro", 56789));
        clientes.add(new Cliente("Maria", 287451));
        clientes.add(new Cliente("Ana", 920751));
        clientes.add(new Cliente("Luis", 468032));

        System.out.println(libros);

        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        while (opcion != 4) {
            try {


                System.out.println("1. Mostrar inventario");
                System.out.println("2. Realizar compra");
                System.out.println("3. Mostrar compras");
                System.out.println("4. Salir");
                System.out.print("Opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println(inventario);
                        break;
                    case 2:
                        System.out.println("Escribe el nombre del cliente: ");
                        String nombre = sc.nextLine();

                        Cliente cliente = null;
                        for (Cliente c : clientes) {
                            if (c.getNombre().equals(nombre)) {
                                cliente = c;
                                break;
                            }
                        }
                        if (cliente == null) {
                            System.out.println("Cliente no registrado en el sistema");
                            System.out.println("Escribe el NIF  del cliente: ");
                            int NIF = sc.nextInt();
                            sc.nextLine();
                            cliente = new Cliente(nombre, NIF);
                            clientes.add(cliente);

                        }
                        System.out.print("Titulo del libro: ");
                        String titulo = sc.nextLine();
                        System.out.print("Introduce la cantidad que quiere comprar: ");
                        int cantidad = sc.nextInt();
                        sc.nextLine();
                        Libro libro = inventario.get(titulo);
                        if (libro != null) {
                            if (libro.getStock() >= cantidad) {
                                libro.setStock(libro.getStock() - cantidad);
                                compra.put(cliente, libro);
                            } else {
                                System.out.println("No hay suficiente stock");
                            }
                        } else {
                            System.out.println("Libro no encontrado");
                        }
                        break;
                    case 3:
                        for (Map.Entry<Cliente, Libro> entry : compra.entrySet()) {
                            System.out.println("Cliente: " + entry.getKey());
                            System.out.println("Libro: " + entry.getValue());
                        }
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Introduce una opcion valida");
                sc.nextLine();
            }
        }
    }
}
