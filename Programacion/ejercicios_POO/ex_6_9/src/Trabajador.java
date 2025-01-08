public class Trabajador {
    private String nombre;
    private double salario;

    public Trabajador(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void cobrar() {
        System.out.println("El trabajador " + nombre + " ha cobrado su salaio de " + salario + "€");
    }

    public void trabajar() {
        System.out.println("Este trabajador realiza tareas generales");
    }

    public String toString() {
        return "Nombre: " + nombre + "\n" + ", Salario: " + salario;
    }


}
