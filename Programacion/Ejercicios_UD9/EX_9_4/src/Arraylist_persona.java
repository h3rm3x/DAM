import java.util.ArrayList;
public class Arraylist_persona {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", 20, "12345678A"));
        personas.add(new Persona("Ana", 30, "87654321B"));
        personas.add(new Persona("Luis", 40, "11111111C"));

        for (Persona persona : personas) {
            System.out.println(persona);
        }

        personas.add(new Persona("Maria", 50, "22222222D"));

        for (Persona persona : personas) {
            System.out.println(persona);
        }

        System.out.println("Eliminando persona con DNI 11111111C");
        personas.removeIf(persona -> persona.getDni().equals("11111111C"));

        for (Persona persona : personas) {
            System.out.println(persona);
        }




    }
}
