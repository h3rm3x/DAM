public class Cliente {
    private String nombre;
    private Integer NIF;

    public Cliente(String nombre, Integer ID) {
        this.nombre = nombre;
        this.NIF = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNIF() {
        return NIF;
    }

    public void setNIF(Integer NIF) {
        this.NIF = NIF;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nNIF: " + NIF;
    }
}
