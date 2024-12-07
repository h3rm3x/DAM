public class Rectangulo extends Figuras_geometrticas {
    private double alto, ancho;

    public Rectangulo(double x, double y, double alto, double ancho) { // las coordenadas representan el vertice mas ceracano a 0,0 (x^2+y^2 mas pequeño)
        super(x, y);
        this.alto = alto;
        this.ancho = ancho;
    }

    public void area() {
        double area = alto * ancho;
        System.out.println("Area: " + area);
    }

    public void perimetro() {
        double perimetro = 2 * alto + 2 * ancho;
        System.out.println("Perimetro: " + perimetro);
    }

}
