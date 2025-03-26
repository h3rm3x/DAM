public class Cliente {
    private String nombre;
    private Integer ID;

    public Cliente(String nombre, Integer ID) {
        this.nombre = nombre;
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nID: " + ID;
    }
}
