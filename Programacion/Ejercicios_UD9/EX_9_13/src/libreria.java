import java.util.*;

public class libreria {
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        TreeSet<Cliente> clientes = new TreeSet<>();
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


        clientes.add(new Cliente("Juan", 1));
        clientes.add(new Cliente("Pedro", 2));
        clientes.add(new Cliente("Maria", 3));
        clientes.add(new Cliente("Ana", 4));
        clientes.add(new Cliente("Luis", 5));

        System.out.println(inventario);








    }
}
