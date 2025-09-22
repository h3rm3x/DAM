public class Jugador extends Miembros_equipo{

    private String posicion;
    private int dorsal;

    public Jugador(String nombre_equipo ,String nombre, String apellido, String DNI, String fecha_nac, String posicion, int dorsal) {
        super(nombre_equipo, nombre, apellido, DNI, fecha_nac );
        this.posicion = posicion;
        this.dorsal = dorsal;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.print(", Posicion: " + posicion+ ", Dorsal: " + dorsal);
    }
}
