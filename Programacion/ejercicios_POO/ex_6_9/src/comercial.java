public class comercial extends Trabajador {
    public comercial(String nombre, double salario) {
        super(nombre, salario);
    }

    public void trabajar() {
        System.out.println("Atiende clientes y genera ventas");
    }

    public String toString() {
        return "Comercial: " + super.toString();
    }
}
