public class Alumno extends Persona{
    String nivel;
    public Alumno(String nombre, String DNI, int edad,String nivel) {
        super(nombre, DNI, edad);
        this.nivel = nivel;
    }
    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public void imprimir() {
        super.mostrarInformacion();
        System.out.println("Nivel: " + nivel);
    }
}