import java.util.Scanner;
public class ex4_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe la cantidad de dinero que quieres retirar (el numero ha de ser multiplo de 5): ");
        int cantidad_dinero = sc.nextInt();
        int numero_billetes = 0;

        int[] billetes = {5, 10, 20, 50, 100, 200, 500};
        int billete = billetes.length-1;
        if (cantidad_dinero % 5 != 0) {
            do {
                System.out.println("ERROR, el numero ha de ser multiplo de 5, ");
                System.out.print("Escribe la cantidad de dinero que quieres retirar: ");
                cantidad_dinero = sc.nextInt();
            } while (cantidad_dinero % 5 != 0);
        }
        System.out.println("Para tener " + cantidad_dinero + "€ en el minimo de billetes se necesitan:");
        while (cantidad_dinero > 0) {
            if(cantidad_dinero / billetes[billete] != 0) {
                System.out.print((cantidad_dinero / billetes[billete]) + " billetes de " + billetes[billete] + " ");
                }
            numero_billetes += cantidad_dinero / billetes[billete];
            cantidad_dinero %= billetes[billete];
            billete--;
        }
        System.out.println();
        System.out.println("en total se necesitan: " + numero_billetes + " billetes");
    }
}