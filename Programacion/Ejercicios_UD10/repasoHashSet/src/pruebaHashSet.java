import java.util.*;

public class pruebaHashSet {
    public static void main(String[] args) {
        // Crear un HashSet de objetos Persona
        HashSet<Persona> personas = new HashSet<>();

        // Crear objetos Persona
        Persona p1 = new Persona("Juan", "12345678A", 25);
        Persona p2 = new Persona("Ana", "87654321B", 30);
        Persona p3 = new Persona("Luis", "11223344C", 28);
        Persona p4 = new Persona("Juan", "12345678A", 25);

        // Añadir personas al HashSet
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);

        System.out.println("Hay " + personas.size() + " personas en el HashSet.");

    }
}
