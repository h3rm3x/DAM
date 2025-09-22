import java.io.Serializable;
import java.util.*;

public class compra implements Serializable {
    private Date fecha;
    private ArrayList<producto> listaProductos;
    private double total;

    public compra( ArrayList<producto> listaProductos, double total) {
        this.fecha = new Date();
        this.listaProductos = listaProductos;
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }
    public ArrayList<producto> getListaProductos() {
        return listaProductos;
    }
    public double getTotal() {
        return total;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void setListaProductos(ArrayList listaProductos) {
        this.listaProductos = listaProductos;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Lista de productos:\n");
        for (producto p : listaProductos) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("Total: ").append(total).append("\n");
        return sb.toString();
    }
}
