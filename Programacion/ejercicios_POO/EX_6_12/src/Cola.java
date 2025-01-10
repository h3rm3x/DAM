public class Cola {
    private Persona[] personas;
    private int inicio;
    private int fin;


    public Cola(int capacidad) {
        personas = new Persona[capacidad];
        fin = 0;
    }

    public void PersonaEntra(Persona persona) {
        personas[fin] = persona;
        if (fin == personas.length - 1) {
            Persona_sale_de_la_cola(personas[0]);
            fin = personas.length - 1;
        } else {
            fin++;
        }

    }

    public void Persona_sale_de_la_cola(Persona persona) {
        for (int i = 0; i < fin; i++) {
            personas[i] = personas[i + 1];
        }
        fin--;

    }

    public String toString() {
        String cola = "";
        for (int i = 0; i < fin; i++) {
            cola += personas[i] + " ";
        }
        return cola;
    }

}
