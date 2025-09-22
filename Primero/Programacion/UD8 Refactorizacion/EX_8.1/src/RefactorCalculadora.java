public class RefactorCalculadora {
    public double calcular(int a, int b) {
        int dobleA = a * 2;
        int tripleB = b * 3;
        int diferencia = a - b;
        double raizCuadrada = Math.sqrt(a * a + b * b);
        return (double) (dobleA + tripleB) / diferencia + raizCuadrada;
    }
    public static void main(String[] args) {
        RefactorCalculadora calc = new RefactorCalculadora();
        System.out.println(calc.calcular(5, 3));
    }
}