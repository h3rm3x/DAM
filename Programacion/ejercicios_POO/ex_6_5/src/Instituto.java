import java.util.Scanner;

public class Instituto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas= new Persona[100];
        int index=0;

        int opcion=1;
        while(opcion!=0){
            System.out.println("MENU");
            System.out.println("0. Salir");
            System.out.println("1. Añadir Persona");
            System.out.println("2. Crear alumno");
            System.out.println("3. Crear profesor");
            System.out.println("4. Ver todas las personas");
            System.out.println("\nIntroduce la opcion: ");
            opcion=sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 0: break;
                case 1: {
                    System.out.println("AÑADIR NUEVA PERSONA");
                    System.out.println("Introduzca un Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Introduzca el DNI");
                    String dni = sc.nextLine();
                    System.out.println("Introduzca la edad");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    personas[index] = new Persona(nombre, dni, edad);
                    index++;
                    break;

                }
                case 2: {
                    System.out.println("AÑADIR NUEVO ALUMNO");
                    System.out.println("Introduzca un Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Introduzca el DNI");
                    String dni = sc.nextLine();
                    System.out.println("Introduzca la edad");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduzca el nivel educativo del alumno");
                    String nivel = sc.nextLine();
                    personas[index] = new alumno(nombre, dni, edad, nivel);
                    index++;
                    break;

                }
                case 3: {
                    System.out.println("AÑADIR NUEVO PROFESOR");
                    System.out.println("Introduzca un Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Introduzca el DNI");
                    String dni = sc.nextLine();
                    System.out.println("Introduzca la edad");
                    int edad = sc.nextInt();
                    System.out.println("Introduzca la asignatura que imparte el profesor");
                    String asignatura = sc.nextLine();
                    personas[index] = new Profesor(nombre, dni, edad, asignatura);
                    index++;
                    break;

                }
                case 4: {
                    System.out.println("Ver todas las personas");
                    for (int i = 0; i < index; i++) {
                            personas[i].mostrar();
                            System.out.println();
                    }
                }
            }
        }
    }
}
