import java.util.LinkedList;
public class Cola {
    private  LinkedList<Persona> personas ;
    private int fin;


    public Cola() {
        personas = new LinkedList<>();

    }

    public void PersonaEntra(Persona persona) {
        personas.add(persona);
    }

    public void Persona_sale_de_la_cola() {
        personas.removeLast();
    }

    public String toString() {
        String cola = "";
        for (int i = 0; i < fin; i++) {
            cola += (i + 1) + ". " + personas.get(i) + "\n";
        }
        return cola;
    }

}
