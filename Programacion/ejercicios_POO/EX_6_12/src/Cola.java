public class Cola {
    private Persona[] personas;
    private int fin;


    public Cola(int capacidad) {
        personas = new Persona[capacidad];
        fin = 0;
    }

    public void PersonaEntra(Persona persona) {
        if (fin == personas.length - 1) {
            System.out.println("La cola está llena");
        } else {
            personas[fin] = persona;
            fin++;
        }

    }

    public void Persona_sale_de_la_cola() {
        for (int i = 0; i < fin; i++) {
            personas[i] = personas[i + 1];
        }
        fin--;
    }

    public String toString() {
        String cola = "";
        for (int i = 0; i < fin; i++) {
            cola += (i + 1) + ". " + personas[i] + "\n";
        }
        return cola;
    }

}
