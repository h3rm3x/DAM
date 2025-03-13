public class Puntuacion {
    private String nombre;
    private String apellidos;
    private int puntos;
    private String fecha;

    public Puntuacion(String nombre, String apellidos, String fecha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puntos = 0;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String toString() {
        return "Nombre: " + nombre + " " + apellidos + " Puntos: " + puntos + " Fecha: " + fecha;
    }



}
