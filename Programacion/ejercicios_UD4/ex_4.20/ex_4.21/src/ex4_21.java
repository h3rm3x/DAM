import java.util.Scanner;
public class ex4_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe la cantidad de dinero que quieres retirar (el numero ha de ser multiplo de 5): ");
        int cantidad_dinero = sc.nextInt();
        int numero_billetes = 0,numero_billetes500=0,numero_billetes200=0,numero_billetes100=0,numero_billetes50=0,numero_billetes10=0,numero_billetes5 =0;

        if  (cantidad_dinero%5 !=0) {
            do {
                System.out.println("ERROR, el numero ha de ser multiplo de 5, ");
                System.out.print("Escribe la cantidad de dinero que quieres retirar: ");
                cantidad_dinero = sc.nextInt();
            }while (cantidad_dinero%5 !=0);
        }
        System.out.println("Para tener "+ cantidad_dinero+ "€ en el minimo de billetes se necesitan:");
        if (cantidad_dinero/500>0) {
            System.out.println((cantidad_dinero/500)+" billetes de 500 ");
            numero_billetes+=cantidad_dinero/500;
            cantidad_dinero%=500;

        }
        if (cantidad_dinero/200>0) {
            System.out.println((cantidad_dinero/200)+" billetes de 200 ");
            numero_billetes+=cantidad_dinero/200;
            cantidad_dinero%=200;

        }
        if (cantidad_dinero/100>0) {
            System.out.println((cantidad_dinero/100)+" billetes de 100 ");
            numero_billetes+=cantidad_dinero/100;
            cantidad_dinero%=100;

        }
        if (cantidad_dinero/50>0) {
            System.out.println((cantidad_dinero/50)+" billetes de 50 ");
            numero_billetes+=cantidad_dinero/50;
            cantidad_dinero%=50;

        }
        if (cantidad_dinero/20>0) {
            System.out.println((cantidad_dinero/20)+" billetes de 20 ");
            numero_billetes+=cantidad_dinero/20;
            cantidad_dinero%=20;

        }
        if (cantidad_dinero/10>0) {
            System.out.println((cantidad_dinero/10)+" billetes de 10 ");
            numero_billetes+=cantidad_dinero/10;
            cantidad_dinero%=10;

        }
        if (cantidad_dinero/5>0) {
            System.out.println((cantidad_dinero / 5) + " billetes de 5 ");
            numero_billetes += cantidad_dinero / 5;


        }

        System.out.println("Con un total de: " + numero_billetes + " billetes");
    }
}