public class Profesor extends Persona {
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
       return super.toString() +'\n' + "Asignatura: " + asignatura + '\n';
    }
}
