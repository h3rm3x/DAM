// Clase base Persona
public class Persona {
    private String nombre;
    private String dni;
    private int edat;

    // Constructor
    public Persona(String nombre, String dni, int edat) {
        this.nombre = nombre;
        this.dni = dni;
        this.edat = edat;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edat;
    }

    public void setEdat(int edad) {
        this.edat = edad;
    }



    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "DNI: " + dni + "\n" +
               "Edad: " + edat;
    }
}

