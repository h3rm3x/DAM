public class Circulo extends Figuras_geometrticas {
    private double radio;

    public Circulo(double radio, double centroX, double centroY) {
        super(centroX, centroY);
        this.radio = radio;
    }

    public void area() {
        double area = Math.PI * radio * radio;
        System.out.println("Area del circul : " + area);
    }

    public void perimetro() {
        double perimetro = 2 * Math.PI * radio;
    }

    public String toString() {
        return "Circulo con radio " + radio + " y centro en " + super.toString();
    }
}
