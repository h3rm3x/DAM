public class Monos extends animales {
    public String especie;
    public String color;

    public Monos(String nombre, int edad, String genero, String especie, String color) {
        this.especie = especie;
        this.color = color;
        super(nombre, edad, genero);
    }

    public void saltar() {
        System.out.println("El mono " + super.nombre + " está saltando.");
    }

    public String toString() {
        return super.toString() + ", Especie: " + especie + ", Color: " + color;
    }
}
