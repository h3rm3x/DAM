import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double preu;
        final double PREU_MAx =30;
        System.out.print("Introdueix el preu del producte: ");
        preu = sc.nextDouble();
        if (preu > PREU_MAx) {
            preu +=2 ;
        }
        System.out.println("El preu final del producte es: " + preu);
    }
}