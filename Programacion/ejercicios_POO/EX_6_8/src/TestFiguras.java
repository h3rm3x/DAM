import java.awt.*;
import java.util.Scanner;

public class TestFiguras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Figuras f = new Figuras();

        Circulo c = new Circulo();
        c.dibujar();
        Rectangulo r = new Rectangulo();
        r.dibujar();

        Figuras f1 = new Circulo();
        Figuras f2 = new Rectangulo();

        f1.dibujar();
        f2.dibujar();

    }
}
