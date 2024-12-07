public abstract class Figuras_geometrticas {
    private double x;
    private double y;

    public Figuras_geometrticas(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void area();

    public abstract void perimetro();
}
