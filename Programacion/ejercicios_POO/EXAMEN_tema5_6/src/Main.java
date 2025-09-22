import com.sun.source.tree.InstanceOfTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Obradearte[] obras = new Obradearte[10];

        int opc = 0;
        int index = 0;
        do {
            System.out.println("1. Agregar Obra de Arte");
            System.out.println("2. Mostrar todas las Obras de Arte");
            System.out.println("3. Mostrar las Pinturas");
            System.out.println("4. Mostrar las Esculturas");
            System.out.println("5. Mostrar las Fotgrafias");
            System.out.println("6. Exhibir una Obra");
            System.out.println("7. Vender Una Pintura");
            System.out.println("8. Restaura Una Fotografia");
            System.out.println("9. Salir");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1: {
                    System.out.println("Agregar Obra de Arte");
                    System.out.println("Escriba el tipo de Obra de Arte (Escultura, Fotografia, Pintura: ");
                    String tipo_obra = sc.nextLine();
                    switch (tipo_obra) {
                        case "Escultura": {
                            System.out.println("Escriba el nombre de la Escultura: ");
                            String nombre = sc.nextLine();
                            System.out.println("Escriba el nombre del Escultor: ");
                            String autor = sc.nextLine();
                            System.out.println("Escriba el año de creacion ");
                            int ano = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba el Material sobre el cual se esculpio: ");
                            String material = sc.nextLine();
                            if (index < 10) {
                                obras[index] = new escultura(material, nombre, ano, autor);
                                index++;
                            } else {
                                System.out.println(" no hay mas espacio en la galeria");
                            }
                            break;
                        }
                        case "Fotografia": {
                            System.out.println("Escriba el nombre de la Fotografia: ");
                            String nombre = sc.nextLine();
                            System.out.println("Escriba el nombre del fotografo: ");
                            String autor = sc.nextLine();
                            System.out.println("Escriba el año de creacion ");
                            int ano = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba el tipo de fotografia: ");
                            String tipo = sc.nextLine();
                            if (index < 10) {
                                obras[index] = new fotografia(nombre, ano, autor, tipo);
                                index++;
                            } else {
                                System.out.println(" no hay mas espacio en la galeria");
                            }

                        }
                        break;
                        case "Pintura": {
                            System.out.println("Escriba el nombre de la Pintura: ");
                            String nombre = sc.nextLine();
                            System.out.println("Escriba el nombre del pintor: ");
                            String autor = sc.nextLine();
                            System.out.println("Escriba el año de creacion ");
                            int ano = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba la tecnica utilizada para pintar el cuadro ");
                            String tecnica = sc.nextLine();
                            if (index < 10) {
                                obras[index] = new Pintura(nombre, ano, autor, tecnica);
                                index++;
                            } else {
                                System.out.println(" no hay mas espacio en la galeria");
                            }
                        }
                        break;
                    }

                }
                break;
                case 2: {
                    //recorremos el array e imprimimos cada objeto
                    for (Obradearte obra : obras) {

                        System.out.println(obra);
                    }
                }
                break;
                case 3: {
                    for (Obradearte obra : obras) {
                        // recorremos el array y comprabamos las instancias de pintura
                        if (obra instanceof Pintura) {
                            System.out.println(obra);
                        }
                    }
                }
                break;
                case 4: {
                    // recorremos el array y comprabamos las instancias de escultura

                    for (Obradearte obra : obras) {
                        if (obra instanceof escultura) {
                            System.out.println(obra);
                        }
                    }
                }
                break;
                // recorremos el array e comprabamos las instancias de fotografia

                case 5: {
                    for (Obradearte obra : obras) {
                        if (obra instanceof fotografia) {
                            System.out.println(obra);
                        }
                    }
                }
                break;
                case 6: {
                    System.out.println("Exhibir una Obra: ");

                    System.out.println("Escriba el nombre de la Obra: ");
                    String nombre = sc.nextLine();
                    for (Obradearte obra : obras) {
                        if (obra.getNombre().equals(nombre)) {
                            obra.exhibir();
                        }
                    }
                }
                break;
                case 7: {
                    System.out.println("Vender una pintura: ");

                    System.out.println("Escriba el nombre de la Pintura: ");
                    String nombre = sc.nextLine();
                    for (Obradearte obra : obras) {
                        if (obra.getNombre().equals(nombre)) {
                            System.out.println("Escriba el precio de venta de la Pintura: ");
                            int precio = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba el nombre del comprador: ");
                            String comprador = sc.nextLine();
                            obra.vender(precio, comprador);
                        }
                    }
                }
                break;
                case 8: {
                    System.out.println("Restaurar una Fotografia: ");
                    System.out.println("Escriba el nombre de la Fotografia: ");
                    String nombre = sc.nextLine();
                    for (Obradearte obra : obras) {
                        if (obra.getNombre().equals(nombre) && obra instanceof fotografia) {
                            ((fotografia) obra).restaurar();
                        }
                    }
                }
                break;
                case 9: {
                    break;
                }
            }
        } while (opc != 9);
    }
}
