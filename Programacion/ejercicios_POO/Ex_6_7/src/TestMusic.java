import java.util.Scanner;

public class TestMusic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la duracion de la cancion: ");
        double duracion = sc.nextDouble();
        sc.nextLine();
        Mp3 m = new Mp3(duracion);
        m.reproducir();
        Ogg o = new Ogg(duracion);
        o.reproducir();
    }
}
