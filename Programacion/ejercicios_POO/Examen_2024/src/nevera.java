public class nevera extends Electrodomesticos implements enReparacion {
    private int capacidad;
    private boolean tieneCongelador;
    private boolean enReparacion;

    public nevera(String marca, String modelo, int precio, int capacidad, boolean tieneCongelador) {
        super(marca, modelo, precio);
        this.capacidad = capacidad;
        this.tieneCongelador = tieneCongelador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean TieneCongelador() {
        return tieneCongelador;
    }


    public String toString() {
        return "nevera{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", capacidad=" + capacidad +
                ", tieneCongelador=" + tieneCongelador +
                '}';
    }
}
