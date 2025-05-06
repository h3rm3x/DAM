import java.io.Serializable;

public class producto implements Serializable {
    private String nombre;
    private int cantidad;
    private double precio;

    public producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String toString() {
        return "Producto: " + nombre + ", Cantidad: " + cantidad + ", Precio: " + precio;
    }
}
