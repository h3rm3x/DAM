import java.util.Scanner;
public class GestionPersonas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        persona persona1 = new persona();
        persona persona2 = new persona();
        persona persona3 = new persona();
        persona persona4 = new persona();

        System.out.println("Ingrese el nombre de persona1: ");
        persona1.setNombre(sc.nextLine());
        System.out.println("Ingrese la edad de persona1: ");
        persona1.setEdad(sc.nextShort());
        sc.nextLine();
        System.out.println("Ingrese el DNI de persona1: ");
        persona1.setDNI(sc.nextLine());
        System.out.println("Ingrese el nombre de persona2: ");
        persona2.setNombre(sc.nextLine());
        System.out.println("Ingrese la edad de persona2: ");
        persona2.setEdad(sc.nextShort());
        sc.nextLine();
        System.out.println("Ingrese el DNI de persona2: ");
        persona2.setDNI(sc.nextLine());
        System.out.println("Ingrese el nombre de persona3: ");
        persona3.setNombre(sc.nextLine());
        System.out.println("Ingrese la edad de persona3: ");
        persona3.setEdad(sc.nextShort());
        sc.nextLine();
        System.out.println("Ingrese el DNI de persona3: ");
        persona3.setDNI(sc.nextLine());
        System.out.println("Ingrese el nombre de persona4: ");
        persona4.setNombre(sc.nextLine());
        System.out.println("Ingrese la edad de persona4: ");
        persona4.setEdad(sc.nextShort());
        sc.nextLine();
        System.out.println("Ingrese el DNI de persona4: ");
        persona4.setDNI(sc.nextLine());

        persona1.mostrar();
        System.out.println();
        persona2.mostrar();
        System.out.println();
        persona3.mostrar();
        System.out.println();
        persona4.mostrar();
    }
}
