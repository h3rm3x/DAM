public class Profesor extends Persona{
    private String asignatura;

    public Profesor(String nombre, String DNI, int edad, String asignatura) {
        super(nombre, DNI, edad);
        this.asignatura = asignatura;
    }
    public String getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    public void mostrar() {
        super.mostrar();
        System.out.println("Asignatura: " + asignatura);
    }
}
