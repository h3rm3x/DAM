public class Rombo extends Figuras_geometrticas {
    private double Dmayor, Dmenor;

    public Rombo(double Dmayor, double Dmenor, double x, double y) {
        super(x, y);
        this.Dmayor = Dmayor;
        this.Dmenor = Dmenor;
    }

    public void area() {
        double area = Dmayor * Dmenor / 2;
        System.out.println("Area Rombo: " + area);
    }

    public void perimetro() {
        double perimetro = Math.sqrt(Math.pow(Dmayor, 2) + Math.pow(Dmenor, 2));
        System.out.println("Perimetro Rombo: " + perimetro);
    }

    public String toString() {
        return "Rombo: " + super.toString();
    }
}
