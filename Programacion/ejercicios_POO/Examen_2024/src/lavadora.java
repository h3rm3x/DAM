public class lavadora extends Electrodomesticos implements enReparacion {
    private int capacidad;
    private int revoluciones;
    private boolean tieneSecadora;


    public lavadora(String marca, String modelo, int precio, int capacidad, int revoluciones, boolean tieneSecadora) {
        super(marca, modelo, precio);
        this.capacidad = capacidad;
        this.revoluciones = revoluciones;
        this.tieneSecadora = tieneSecadora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getRevoluciones() {
        return revoluciones;
    }

    public boolean TieneSecadora() {
        return tieneSecadora;
    }


    public String toString() {
        if (enReparacion) {
            return "lavadora{" +
                    "marca:'" + marca + '\'' +
                    ", modelo:'" + modelo + '\'' +
                    ", precio:" + precio +
                    ", capacidad:" + capacidad +
                    ", revoluciones:" + revoluciones +
                    ", tieneSecadora:" + tieneSecadora +
                    ", Estado: en reparacion" +
                    '}';
        } else {
            return "lavadora{" +
                    "marca:'" + marca + '\'' +
                    ", modelo:'" + modelo + '\'' +
                    ", precio:" + precio +
                    ", capacidad:" + capacidad +
                    ", revoluciones:" + revoluciones +
                    ", tieneSecadora:" + tieneSecadora +
                    ", Estado: reparado" +
                    '}';
        }

    }
}
