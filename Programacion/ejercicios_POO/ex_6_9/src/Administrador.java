public class Administrador extends Trabajador {

    public Administrador(String nombre, double salario) {
        super(nombre, salario);
    }

    public void trabajar() {
        System.out.println("Gestiona tareas administrativas y documentacion");
    }
}
