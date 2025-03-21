public class alumno extends Persona{
    private String nivel;


    public alumno(String nombre, String DNI, int edad, String nivel) {
        super(nombre,DNI,edad);
        this.nivel = nivel;
    }
    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public void mostrar(){
        super.mostrar();
        System.out.println("Nivel: " + getNivel());
    }

}
