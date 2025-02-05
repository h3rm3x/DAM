public abstract class Electrodomesticos {
    protected String marca;
    protected String modelo;
    protected int precio;
    protected boolean enReparacion;

    public Electrodomesticos(String marca, String modelo, int precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public boolean enReparacion() {
        enReparacion = true;
        return enReparacion;
    }

    public boolean reparado() {
        enReparacion = false;
        return enReparacion;
    }


}
