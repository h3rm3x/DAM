public class Jugador extends Persona{
    private int dorsal;
    private String posicion;
    public Jugador(String nombre, String apellido, int edad, int dorsal, String posicion){
        super(nombre, apellido, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;

    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public void mostrar(){
        super.mostrar();
        System.out.println("Dorsal: " + dorsal);
        System.out.println("Posicion: " + posicion);
    }
}
