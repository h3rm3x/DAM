public class Cuadrado extends Figuras_geometrticas {
    private double lado;

    public Cuadrado(double lado, double x, double y) { // las coordenadas representan el vertice mas ceracano a 0,0 (x^2+y^2 mas pequeño)
        super(x, y);
        this.lado = lado;
    }

    public void area() {
        double area = lado * lado;
        System.out.println("Area del cuadrado: " + area);
    }

    public void perimetro() {
        double perimetro = lado * 4;
    }

}
