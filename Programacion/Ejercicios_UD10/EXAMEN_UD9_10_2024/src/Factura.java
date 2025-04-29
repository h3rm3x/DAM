import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private Date fecha;
    private double total;
    private ArrayList<LiniaDeFactura> linias;

    public Factura(Date fecha, double total, ArrayList<LiniaDeFactura> linias) {
        this.fecha = fecha;
        this.total = total;
        this.linias = linias;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public ArrayList<LiniaDeFactura> getLinias() {
        return linias;
    }
    public void setLinias(ArrayList<LiniaDeFactura> linias) {
        this.linias = linias;
    }

}
