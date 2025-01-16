public abstract class Miembros_equipo {
    private String nombre_equipo;
    private String nombre;
    private String apellido;
    private String DNI;
    private String fecha_nac;

    public Miembros_equipo(String nombre_equipo, String nombre, String apellido, String dni, String fecha_nac) {
        this.nombre = nombre;
        this.DNI = dni;
        this.fecha_nac = fecha_nac;
        this.apellido = apellido;
        this.nombre_equipo = nombre_equipo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getDni() {
        return DNI;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.DNI = dni;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }


    // Método para mostrar información
    public String toString() {
        return "Nombre Equipo" + nombre_equipo + "Nombre: " + nombre + ", Apellido: " + apellido + ", DNI: " + DNI + ", Edad: " + fecha_nac;
    }
}



