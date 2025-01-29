import java.util.Scanner;

public class inventario {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Electrodomesticos[] lista_electrodomesticos = new Electrodomesticos[10];


        System.out.println("Bienvenido al inventario de electrodomesticos");

        int opcion = 0;
        do {
            System.out.println("1. Añadir electrodomesticos:");
            System.out.println("2. Mostrar electrodomesticos:");
            System.out.println("3. Mostrar nº de electrodomesticos de cada tipo:");
            System.out.println("4. Mostrar lavadoras:");
            System.out.println("5. Mostrar neveras:");
            System.out.println("6. Precio total por categoria:");
            System.out.println("7. Precio total :");
            System.out.println("8. Enviar electrodomestico a reparacion:");
            System.out.println("9. Electrodomestico Reparado:");
            System.out.println("10. Salir");

            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce el tipo de electrodomestico (lavadora/nevera):");
                    String tipo = sc.nextLine();
                    System.out.println("Introduce la marca:");
                    String marca = sc.nextLine();
                    System.out.println("Introduce el modelo:");
                    String modelo = sc.nextLine();
                    System.out.println("Introduce el precio:");
                    int precio = sc.nextInt();
                    sc.nextLine();
                    if (tipo.equals("lavadora")) {
                        System.out.println("Introduce la capacidad:");
                        int capacidad = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce las revoluciones:");
                        int revoluciones = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Tiene secadora ?:");
                        String tieneSecadora_ = sc.nextLine();
                        boolean tieneSecadora = tieneSecadora_.equals("si");

                        for (int i = 0; i < lista_electrodomesticos.length; i++) {
                            if (lista_electrodomesticos[i] == null) {

                                lista_electrodomesticos[i] = new lavadora(marca, modelo, precio, capacidad, revoluciones, tieneSecadora);
                                break;
                            }
                        }
                    } else if (tipo.equals("nevera")) {
                        System.out.println("Introduce la capacidad:");
                        int capacidad = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Tiene congelador ?:");
                        String tieneCongelador_ = sc.nextLine();
                        System.out.println(tieneCongelador_);
                        boolean tieneCongelador = tieneCongelador_.equals("si");
                        System.out.println(tieneCongelador);
                        for (int i = 0; i < lista_electrodomesticos.length; i++) {
                            if (lista_electrodomesticos[i] == null) {
                                System.out.println("Añadiendo nevera");
                                lista_electrodomesticos[i] = new nevera(marca, modelo, precio, capacidad, tieneCongelador);
                                System.out.println("Nevera añadida");
                                break;
                            } else {
                                System.out.println("El inventario esta lleno, no se ha podido añadir el electrodomestico");
                            }
                        }
                    }
                    break;
                case 2: {
                    for (Electrodomesticos listaElectrodomestico : lista_electrodomesticos) {
                        if (listaElectrodomestico != null) {
                            System.out.println(listaElectrodomestico);
                        }
                    }
                    break;
                }
                case 3: {
                    int lavadoras = 0;
                    int neveras = 0;
                    for (Electrodomesticos listaElectrodomestico : lista_electrodomesticos) {
                        if (listaElectrodomestico instanceof lavadora) {
                            lavadoras++;
                        } else if (listaElectrodomestico instanceof nevera) {
                            neveras++;
                        }
                    }
                    System.out.println("Numero de lavadoras: " + lavadoras);
                    System.out.println("Numero de neveras: " + neveras);
                    break;
                }
                case 4: {
                    for (Electrodomesticos listaElectrodomestico : lista_electrodomesticos) {
                        if (listaElectrodomestico instanceof nevera) {
                            System.out.println(listaElectrodomestico);
                        }
                    }
                    break;
                }
                case 5: {
                    for (Electrodomesticos listaElectrodomestico : lista_electrodomesticos) {
                        if (listaElectrodomestico instanceof lavadora) {
                            System.out.println(listaElectrodomestico);
                        }
                    }
                }
                case 6: {
                    int precio_lavadoras = 0;
                    int precio_neveras = 0;
                    for (Electrodomesticos listaElectrodomestico : lista_electrodomesticos) {
                        if (listaElectrodomestico instanceof lavadora) {
                            precio_lavadoras += listaElectrodomestico.getPrecio();
                        } else if (listaElectrodomestico instanceof nevera) {
                            precio_neveras += listaElectrodomestico.getPrecio();
                        }
                    }
                    System.out.println("Precio total de lavadoras: " + precio_lavadoras);
                    System.out.println("Precio total de neveras: " + precio_neveras);

                }
                break;
                case 7: {
                    int precio_total = 0;
                    for (Electrodomesticos listaElectrodomestico : lista_electrodomesticos) {
                        if (listaElectrodomestico != null) {
                            precio_total += listaElectrodomestico.getPrecio();
                        }
                    }
                    System.out.println("Precio total: " + precio_total);
                    break;
                }
                case 8: {
                    System.out.println("Introduce el tipo de electrodomestico (lavadora/nevera):");
                    tipo = sc.nextLine();
                    sc.nextLine();
                    if (tipo.equals("lavadora")) {
                        System.out.println("Introduce la posicion de la lavadora a reparar:");
                        int posicion = sc.nextInt();
                        sc.nextLine();
                        if (lista_electrodomesticos[posicion] instanceof lavadora) {
                            lista_electrodomesticos[posicion].enReparacion();
                        }
                    } else if (tipo.equals("nevera")) {
                        System.out.println("Introduce la posicion de la nevera a reparar:");
                        int posicion = sc.nextInt();
                        sc.nextLine();
                        if (lista_electrodomesticos[posicion] instanceof nevera) {
                            lista_electrodomesticos[posicion].enReparacion();
                        }
                    }
                }
                break;
                case 9: {
                    System.out.println("Introduce la posicion del electrodomestico reparado:");
                    int posicion = sc.nextInt();
                    sc.nextLine();
                    lista_electrodomesticos[posicion].reparado();
                    System.out.println("Introduce las horas de reparacion:");
                    int horas = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Precio de la reparacion: " + enReparacion.reparar(horas));


                }
                break;
                case 10: {
                    System.out.println("Saliendo...");
                    break;
                }

                default: {
                    System.out.println("Opcion no valida");

                }
                break;
            }


        } while (opcion != 10);


    }
}
