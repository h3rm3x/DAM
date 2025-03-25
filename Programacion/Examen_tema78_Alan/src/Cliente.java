import java.io.Serializable;

public class Cliente implements Comparable<Cliente> {
    private String nombre;
    private String apellidos;
    private double gastoTotal;

    public Cliente(String nombre, String apellidos, double gastoTotal) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.gastoTotal = gastoTotal;
    }
    public Cliente(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public double getGastoTotal() {
        return gastoTotal;
    }
    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public String toString() {
        return nombre + " " + apellidos + " " + gastoTotal;
    }

    @Override
    public int compareTo(Cliente c) {
        return Double.compare(this.gastoTotal, c.gastoTotal) ;
    }
}
