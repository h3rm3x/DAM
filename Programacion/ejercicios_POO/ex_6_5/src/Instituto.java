import java.util.Scanner;

public class Instituto {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Persona[] personas = new Persona[100];
        int index = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("MENU");
        System.out.println("0 - Salir");
        System.out.println("1 - Crear Persona");
        System.out.println("2 - Listar todas las personas");
        System.out.println();
        int opcion = 1;
        while (opcion != 0) {
            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    break;
                case 1: {
                    System.out.println("Introduzca el si quiere añadir una persona, alumno o profesor");
                    String persona = sc.nextLine().toLowerCase();
                    if (persona.equals("alumno")) {
                        System.out.println("Escribe el nombre del alumno");
                        String nombre = sc.nextLine();
                        System.out.println("Escribe el DNI");
                        String dni = sc.nextLine();
                        System.out.println("Escribe la edad");
                        int edad = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Escribe el nivel: ESO, CFGM, CFGS, Universidad");
                        String nivel = sc.nextLine();
                        personas[index] = new Alumno(nombre, dni, edad, nivel);
                        index++;
                    }
                    else if (persona.equals("profesor")) {
                        System.out.println("Escribe el nombre del profesor");
                        String nombre = sc.nextLine();
                        System.out.println("Escribe el DNI");
                        String dni = sc.nextLine();
                        System.out.println("Escribe la edad");
                        int edad = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Escribe la asignatura imparte");
                        String asignatura = sc.nextLine();
                        index++;
                    }
                    else {
                        System.out.println("Escribe el nombre de la persona");
                        String nombre = sc.nextLine();
                        System.out.println("Escribe el DNI");
                        String dni = sc.nextLine();
                        System.out.println("Escribe la edad");
                        int edad = sc.nextInt();
                        sc.nextLine();
                        personas[index] = new Persona(nombre, dni, edad);
                        index++;
                    }
                    break;
                    }
                    case 2:{
                        for ( int i = 0; i < index; i++ ) {
                            personas[i].mostrarInformacion();
                        }
                        break;

                    }
                }
            }
        }
    }



