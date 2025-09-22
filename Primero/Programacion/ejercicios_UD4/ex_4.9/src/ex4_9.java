import java.util.Scanner;
public class ex4_9 {
    public static void main (String[] args) {
        Scanner lector = new Scanner(System.in);
//PAS 1 i 2
        System.out.print("Quin és el dividend? ");
        int dividend = lector.nextInt();
        lector.nextLine();
//PAS 3 i 4
        System.out.print("Quin és el divisor? ");
        int divisor = lector.nextInt();
        lector.nextLine();
        int contador = 0;
//PAS 5
        while (dividend >= divisor) {
//PAS 6
            contador++;
            dividend = dividend - divisor;
            System.out.println("Bucle: per ara el dividend val " + dividend + ".");
//PAS 7: Simplement equival a dir que fem la volta al
            System.out.println( "bucle: per ara el dividend val "+ dividend + ".");
        }
        System.out.println("El quocient de la divisio es " + contador + " y el dividend final es " + dividend + ".");
    }
}