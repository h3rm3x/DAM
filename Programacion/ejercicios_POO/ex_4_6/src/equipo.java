import java.util.Scanner;

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Miembros_equipo[] equipo = new Miembros_equipo[1000];
        int index= 0;
        System.out.println("MENU");
        System.out.println("0. Salir");
        System.out.println("1. Ingresar nuevo Jugador");
        System.out.println("2. Ingresar nuevo miembro del Staff");
        System.out.println("3. Ingresar nuevo miembro de la directiva");
    System.out.println("4. Ver equipo");
        int opcion;
        do{
            opcion = sc.nextInt();
            switch(opcion){
                case 0:
                    break;
                case 1: {
                    System.out.println("Ingresar nuevo Jugador");
                    System.out.println("Escriba el nombre del equipo");
                    String nombre_equipo = sc.next();
                    System.out.println("Escriba el nombre del Jugador");
                    String nombre = sc.nextLine();
                    System.out.println("Escriba el apellido del Jugador");
                    String apellido = sc.nextLine();
                    System.out.println("Escriba el DNI del Jugador");
                    String dni = sc.nextLine();
                    System.out.println("Escriba la fecha de nacimiento");
                    String fecha_nacimiento = sc.nextLine();
                    System.out.println("Escriba la posicion del jugador");
                    String posicion = sc.nextLine();
                    System.out.println("Escriba el dorsal del jugador");
                    int dorsal = sc.nextInt();
                    sc.nextLine();
                    equipo[index] = new Jugador(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, posicion, dorsal);
                    index++;
                    break;
                }
                case 2: {
                    System.out.println("Ingresar nuevo Miembro del Staff");
                    System.out.println("Escriba el nombre del miembro del Staff");
                    String nombre_equipo = sc.next();
                    System.out.println("Escriba el nombre del miembro del Staff");
                    String nombre = sc.nextLine();
                    System.out.println("Escriba el apellido del miembro del staff");
                    String apellido = sc.nextLine();
                    System.out.println("Escriba el DNI del miembro del staff");
                    String dni = sc.nextLine();
                    System.out.println("Escriba la fecha de nacimiento");
                    String fecha_nacimiento = sc.nextLine();
                    System.out.println("Escriba el ambito de trabajo del miembro del staff (tecnico/medico)");
                    String ambito = sc.nextLine();
                    System.out.println("Escriba el rol del miembro del staff");
                    String rol = sc.nextLine();
                    sc.nextLine();
                    equipo[index] = new staff(nombre_equipo,nombre, apellido, dni, fecha_nacimiento, ambito, rol);
                    index++;
                    break;
                }
                case 3: {
                    System.out.println("Ingresar nuevo Miembro de la directiva");

                    System.out.println("Escriba el nombre del miembro de la directiva");
                    String nombre_equipo = sc.next();
                    System.out.println("Escriba el nombre del miembro de la directiva");
                    String nombre = sc.nextLine();
                    System.out.println("Escriba el apellido del miembro de la directiva");
                    String apellido = sc.nextLine();
                    System.out.println("Escriba el DNI del miembro de la directiva  ");
                    String dni = sc.nextLine();
                    System.out.println("Escriba la fecha de nacimiento");
                    String fecha_nacimiento = sc.nextLine();
                    System.out.println("Escriba el cargo del directivo");
                    String cargo = sc.nextLine();
                    sc.nextLine();
                    equipo[index] = new directiva(nombre_equipo,nombre, apellido, dni, fecha_nacimiento, cargo);
                    index++;
                    break;
                }
                case 5: {
                    System.out.println("Los miembros del equipo son :");
                    for (int i = 0; i < index; i++) {
                        equipo[i].mostrarInformacion();
                        System.out.println();
                    }
                }
                default: {
                    System.out.println("ERROR, la opcion indicada no existe. Escribe una opcion valida");
                    break;
                }



            }
        }while (opcion!=0);

    }

