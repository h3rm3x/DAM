import java.util.Scanner;

public class Liga {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Definir los equipos de la liga
        equipo FC_barcelona = new equipo("FC Barcelona");
        equipo Real_madrid = new equipo("Real Madrid");
        equipo Atletico_madrid = new equipo("Atletico Madrid");
        equipo Sevilla = new equipo("Sevilla");
        equipo Valencia = new equipo("Valencia");
        // Crear un array con los equipos de la liga
        equipo[] Liga = {FC_barcelona, Real_madrid, Atletico_madrid, Sevilla, Valencia};
        int index = 0;
        // Menú

        int opcion;
        do {
            System.out.println("MENU");
            System.out.println("0. Salir");
            System.out.println("1. Ingresar nuevo Jugador");
            System.out.println("2. Ingresar nuevo miembro del Staff");
            System.out.println("3. Ingresar nuevo miembro de la directiva");
            System.out.println("4. Ver equipo");
            System.out.println("5. Ver Liga");
            System.out.println("6. Jugar partido");
            System.out.println("7. Ver clasificación");
            System.out.println("Escriba el número de la opción que desea realizar");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 0:
                    break;
                case 1: {
                    System.out.println("Ingresar nuevo Jugador");
                    System.out.println("Escriba el nombre del equipo");
                    String nombre_equipo = sc.nextLine();
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
                    switch (nombre_equipo) {
                        case "FC Barcelona":
                            FC_barcelona.ingresarJugador(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, posicion, dorsal);
                            break;
                        case "Real Madrid":
                            Real_madrid.ingresarJugador(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, posicion, dorsal);
                            break;
                        case "Atletico Madrid":
                            Atletico_madrid.ingresarJugador(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, posicion, dorsal);
                            break;
                        case "Sevilla":
                            Sevilla.ingresarJugador(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, posicion, dorsal);
                            break;
                        case "Valencia":
                            Valencia.ingresarJugador(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, posicion, dorsal);
                            break;
                        default:
                            System.out.println("El equipo no existe");
                            break;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Ingresar nuevo Miembro del Staff");

                    System.out.println("Escriba el nombre del equipo al que pertenece miembro del Staff");
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
                    switch (nombre_equipo) {
                        case "FC Barcelona":
                            FC_barcelona.ingresarStaff(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, ambito, rol);
                            break;
                        case "Real Madrid":
                            Real_madrid.ingresarStaff(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, ambito, rol);
                            break;
                        case "Atletico Madrid":
                            Atletico_madrid.ingresarStaff(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, ambito, rol);
                            ;
                            break;
                        case "Sevilla":
                            Sevilla.ingresarStaff(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, ambito, rol);
                            break;
                        case "Valencia":
                            Valencia.ingresarStaff(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, ambito, rol);
                            break;
                        default:
                            System.out.println("El equipo no existe");
                            break;
                    }
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
                    switch (nombre_equipo) {
                        case "FC Barcelona":
                            FC_barcelona.ingresarDirectiva(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, cargo);
                            break;
                        case "Real Madrid":
                            Real_madrid.ingresarDirectiva(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, cargo);
                            break;
                        case "Atletico Madrid":
                            Atletico_madrid.ingresarDirectiva(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, cargo);
                            break;
                        case "Sevilla":
                            Sevilla.ingresarDirectiva(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, cargo);
                            break;
                        case "Valencia":
                            Valencia.ingresarDirectiva(nombre_equipo, nombre, apellido, dni, fecha_nacimiento, cargo);
                            break;
                        default:
                            System.out.println("El equipo no existe");
                            break;
                    }
                    break;
                }
                case 4: {
                    System.out.println("Ver equipo");
                    System.out.println("Escriba el nombre del equipo");
                    String nombre_equipo = sc.nextLine();
                    switch (nombre_equipo) {
                        case "FC Barcelona":
                            FC_barcelona.verEquipo();
                            break;
                        case "Real Madrid":
                            Real_madrid.verEquipo();
                            break;
                        case "Atletico Madrid":
                            Atletico_madrid.verEquipo();
                            break;
                        case "Sevilla":
                            Sevilla.verEquipo();
                            break;
                        case "Valencia":
                            Valencia.verEquipo();
                            break;
                        default:
                            System.out.println("El equipo no existe");
                            break;
                    }
                    break;
                }
                case 5: {
                    System.out.println("Ver Liga");
                    for (equipo equipo : Liga) {
                        equipo.verEquipo();
                    }
                    break;
                }
                case 6: {
                    System.out.println("Jugar partido");
                    System.out.println("Escriba el nombre del equipo local");
                    String nombre_equipo_local = sc.next();
                    System.out.println("Escriba el nombre del equipo visitante");
                    String nombre_equipo_visitante = sc.next();
                    System.out.println("Escriba el resultado del partido");
                    int resultado = sc.nextInt();
                    switch (resultado) {
                        case 1:
                            switch (nombre_equipo_local) {
                                case "FC Barcelona":
                                    FC_barcelona.PartidoGanado();
                                    break;
                                case "Real Madrid":
                                    Real_madrid.PartidoGanado();
                                    break;
                                case "Atletico Madrid":
                                    Atletico_madrid.PartidoGanado();
                                    break;
                                case "Sevilla":
                                    Sevilla.PartidoGanado();
                                    break;
                                case "Valencia":
                                    Valencia.PartidoGanado();
                                    break;
                                default:
                                    System.out.println("El equipo no existe");
                                    break;
                            }
                            switch (nombre_equipo_visitante) {
                                case "FC Barcelona":
                                    FC_barcelona.PartidoPerdido();
                                    break;
                                case "Real Madrid":
                                    Real_madrid.PartidoPerdido();
                                    break;
                                case "Atletico Madrid":
                                    Atletico_madrid.PartidoPerdido();
                                    break;
                                case "Sevilla":
                                    Sevilla.PartidoPerdido();
                                    break;
                                case "Valencia":
                                    Valencia.PartidoPerdido();
                                    break;
                                default:
                                    System.out.println("El equipo no existe");
                                    break;
                            }
                            break;
                        case 0:
                            switch (nombre_equipo_local) {
                                case "FC Barcelona":
                                    FC_barcelona.PartidoEmpatado();
                                    break;
                                case "Real Madrid":
                                    Real_madrid.PartidoEmpatado();
                                    break;
                                case "Atletico Madrid":
                                    Atletico_madrid.PartidoEmpatado();
                                    break;
                                case "Sevilla":
                                    Sevilla.PartidoEmpatado();
                                    break;
                                case "Valencia":
                                    Valencia.PartidoEmpatado();
                                    break;
                                default:
                                    System.out.println("El equipo no existe");
                                    break;
                            }
                            switch (nombre_equipo_visitante) {
                                case "FC Barcelona":
                                    FC_barcelona.PartidoEmpatado();
                                    break;
                                case "Real Madrid":
                                    Real_madrid.PartidoEmpatado();
                                    break;
                                case "Atletico Madrid":
                                    Atletico_madrid.PartidoEmpatado();
                                    break;
                                case "Sevilla":
                                    Sevilla.PartidoEmpatado();
                                    break;
                                case "Valencia":
                                    Valencia.PartidoEmpatado();
                                    break;
                                default: {
                                    System.out.println("El equipo no existe");
                                    break;
                                }
                            }
                    }
                }
                case 7: {
                    System.out.println("Ver clasificación");
                    for (int i = 0; i < Liga.length - 1; i++) {
                        for (int j = 0; j < Liga.length - 1 - i; j++) {
                            if (Liga[j].getPuntos() < Liga[j + 1].getPuntos()) {
                                equipo temp = Liga[j];
                                Liga[j] = Liga[j + 1];
                                Liga[j + 1] = temp;
                            }
                        }
                    }
                    for (equipo equipo : Liga) {
                        System.out.println(equipo.getNombre_equipo() + " " + equipo.getPuntos());
                    }
                    break;


                }
                default: {
                    System.out.println("ERROR, la opcion indicada no existe. Escribe una opcion valida");
                    break;
                }


            }
        } while (opcion != 0);

    }
}
