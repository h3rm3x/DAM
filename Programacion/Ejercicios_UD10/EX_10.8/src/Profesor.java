import java.io.Serializable;

public class Profesor extends Persona implements Serializable {
    String asignatura;

    public Profesor(String nombre, String dni, int edad, String asignatura) {
        super(nombre, dni, edad);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return super.toString() + "Asignatura: " + asignatura + "\n";
    }
}
