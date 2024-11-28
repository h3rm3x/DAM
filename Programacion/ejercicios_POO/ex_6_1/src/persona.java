public class persona {
    private String nombre;
    private String DNI;
    private short edad;

    public persona() {
    }
    public persona(String nombre, String DNI, short edad) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
    }


    public String getNombre() {
        return this.nombre;
    }

    public String getDNI() {
        return this.DNI;
    }

    public short getEdad() {
        return this.edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }
    public void mostrar() {
        System.out.println("Visualizacion de los datos de persona");
        System.out.println("Nombre:....... " + this.nombre);
        System.out.println("DNI:.......... " + this.DNI);
        System.out.println("Edad:......... " + this.edad);
    }
}

