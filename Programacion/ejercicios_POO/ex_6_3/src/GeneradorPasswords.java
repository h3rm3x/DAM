import java.util.Scanner;

public class GeneradorPasswords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero de contaseñas que quiere introducir: ");
        int numerocontrasenas = sc.nextInt();
        sc.nextLine();
        Password[] contrasenas = new Password[numerocontrasenas];
        boolean[] robusta = new boolean[numerocontrasenas];
        for (int i = 0; i < numerocontrasenas; i++) {
            System.out.println("Generar Password");
            System.out.println("1. Generar contraseña de 8 digitos");
            System.out.println("2. Generar contraseña de la longitud que se elija");
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion == 1) {
                contrasenas[i] = new Password();
            }
            if (opcion == 2) {
                System.out.println("Escribe la longitud de la contraeña que quiere");
                int longitud = sc.nextInt();
                sc.nextLine();
                contrasenas[i] = new Password(longitud);


            }
            robusta[i] = contrasenas[i].esRobusta();
            if (robusta[i]) {
                System.out.println("la contraseña " + contrasenas[i].getPassword() + " es robusta");
            } else {
                System.out.println("la contraseña " + contrasenas[i].getPassword() + "  NO es robusta");
            }
        }
        System.out.println();




    }
}




