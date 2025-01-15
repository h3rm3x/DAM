public abstract class animales {
    public String nombre;
    private int edad;
    private String genero;

    public animales(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Genero: " + genero;
    }

}
