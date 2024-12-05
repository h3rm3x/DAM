public class Director extends Trabajador {

    public Director(String nombre, double salario) {
        super(nombre, salario);
    }

    public void trabajar() {
        System.out.println("Supervisa los equipos y toma decisiones estrategicas");
    }
}
