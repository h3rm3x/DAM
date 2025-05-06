import java.util.Objects;

public class producto implements Comparable<producto>{
    private int id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precio;

    public producto(int id, String nombre, String categoria, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof producto)) return false;
        producto p = (producto) o;
        return this.id == p.getId() && this.nombre.equals(p.getNombre()) && this.categoria.equals(p.getCategoria()) && this.cantidad == p.getCantidad() && this.precio == p.getPrecio();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, categoria, cantidad, precio);
    }

    @Override
    public String toString() {
        return "producto [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", cantidad=" + cantidad + ", precio=" + precio + "]";
    }
    @Override
    public int compareTo(producto p) {
        return Integer.compare(this.id, p.getId());
    }
}
