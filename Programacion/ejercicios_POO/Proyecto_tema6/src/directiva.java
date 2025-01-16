public class directiva extends Miembros_equipo {

    private String cargo;

    public directiva(String nombre_equipo, String nombre, String apellido, String dni, String fecha_nac, String cargo) {
        super(nombre_equipo, nombre, apellido, dni, fecha_nac);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String toString() {
        return super.toString() + ", Cargo: " + cargo;
    }
}
