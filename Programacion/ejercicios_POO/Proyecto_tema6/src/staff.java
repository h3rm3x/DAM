public class staff extends Miembros_equipo {
    private String ambito;
    private String rol;

    public staff(String nombre_equipo, String nombre, String apellido, String fecha_nac, String DNI, String ambito, String rol) {
        super(nombre_equipo, nombre, apellido, fecha_nac, DNI);
        this.rol = rol;
        this.ambito = ambito;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String toString() {
        return "Staff: " + super.toString() + ", Ambito: " + ambito + ", Rol: " + rol;
    }

}
