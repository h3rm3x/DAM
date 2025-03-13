import java.text.ParseException;
import java.util.*;

public class Main {
    // declaramos el array y los objetos random y scanner como static para poder usarlos en el main y en las funciones
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);
    static Cliente[] clientes = {
            new Cliente("Carlos", "Fernández"), new Cliente("Ana", "Rodríguez"),
            new Cliente("Luis", "García"), new Cliente("María", "Sánchez"),
            new Cliente("Pedro", "Martínez"), new Cliente("Sofía", "López"),
            new Cliente("Javier", "Pérez"), new Cliente("Lucía", "Gómez"),
            new Cliente("Daniel", "Díaz"), new Cliente("Elena", "Hernández"),
            new Cliente("Alberto", "Castro"), new Cliente("Beatriz", "Romero"),
            new Cliente("Fernando", "Ortega"), new Cliente("Gabriela", "Jiménez"),
            new Cliente("Héctor", "Molina"), new Cliente("Isabel", "Navarro"),
            new Cliente("Joaquín", "Rubio"), new Cliente("María", "Méndez"),
            new Cliente("Leonardo", "Ríos"), new Cliente("Mónica", "Vega"),
            new Cliente("Nicolás", "Herrera"), new Cliente("Olivia", "Flores"),
            new Cliente("Pablo", "Suárez"), new Cliente("Raquel", "Torres"),
            new Cliente("Sergio", "Álvarez"), new Cliente("Teresa", "Domínguez"),
            new Cliente("Ulises", "Reyes"), new Cliente("Verónica", "Soto"),
            new Cliente("William", "Márquez"), new Cliente("Ximena", "Paredes"),
            new Cliente("Yahir", "Vargas"), new Cliente("Zoe", "Medina"),
            new Cliente("Andrés", "Guzmán"), new Cliente("Brenda", "Espinoza"),
            new Cliente("César", "Cordero"), new Cliente("Diana", "Fuentes"),
            new Cliente("Esteban", "Montes"), new Cliente("Fabiola", "Salinas"),
            new Cliente("Gerardo", "León"), new Cliente("Helena", "Carrasco"),
            new Cliente("Ignacio", "Del Río"), new Cliente("Juliana", "Aguirre"),
            new Cliente("Kevin", "Navas"), new Cliente("Lorena", "Barrios"),
            new Cliente("Martín", "Velázquez"), new Cliente("Natalia", "Cabrera"),
            new Cliente("Octavio", "Peralta"), new Cliente("Patricia", "Estévez"),
            new Cliente("Ricardo", "Palma"), new Cliente("Susana", "Villalobos")
    };

    public static void main(String[] args) {
        // variables principales
        int opcion = 0;
        long tiempoAnterior;
        long tiempoFinal;
        while (opcion != 6) {

            mostrarMenu();

            try {
                //para una mayor limpieza del codigo la muestra del menu y la lectura de opcion se hacen mediante funciones
                opcion = leerOpcion();


                // switch para poder ejecutar las diferentes opciones del menu
                switch (opcion) {
                    case 1:
                        insertarGastotal();
                        //for (Cliente cliente : clientes) { // si uno de los clientes no tiene asignado gastototal se lanza la excepcion MissingDataException
                        //    if ((cliente.getGastoTotal().isNull)) { // no recuerdo el metodo para comprobar si un atributo existe o si es nulo
                        //    throw new  MissingDataException() }}


                        break;
                    case 2:
                        //imprime la lista sin ordenar
                        mostrarClientes(clientes);
                        break;
                    case 3:
                         tiempoAnterior = System.nanoTime();
                        mostrarlistaOrdenadaInsercionDirecta();
                         tiempoFinal = System.nanoTime();
                        System.out.println("Ordenar la lista mediante Insercion directa ha costado: "+ (tiempoFinal-tiempoAnterior)+ " Nano Segundos");
                        break;
                    case 4:
                        tiempoAnterior = System.nanoTime();
                        mostrarlistaOrdenadaBurbija();
                        tiempoFinal = System.nanoTime();
                        System.out.println("Ordenar la lista mediante el metodo Burbuja ha costado: "+ (tiempoFinal-tiempoAnterior)+ " Nano Segundos");
                        break;
                    case 5:
                        Cliente[] clientes_ordenada = clientes.clone();
                        tiempoAnterior = System.nanoTime();
                        Arrays.sort(clientes_ordenada);
                        tiempoFinal = System.nanoTime();
                        mostrarClientes(clientes_ordenada);
                        System.out.println("Ordenar la lista mediante Arrays.sort ha costado: "+ (tiempoFinal-tiempoAnterior)+ "Nano Segundos");


                    case 6:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

            } catch (InputMismatchException e) { // si hay un error se imprime el mensaje y se sale del loop
                System.out.println("Error opción no válida");
                break;
        //       } catch (MissingDataException m) {
        //            System.out.println("Error faltan cleintes por introducir el gasto total");
            }
        }
    }
    public static int leerOpcion() {
        System.out.println("Introduce una opcion");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public static void mostrarMenu() {
        System.out.println("1. Asignar Gasto Total aleatorio para todos los clientes");
        System.out.println("2. Mostrar la lista de clientes sin ordenar");
        System.out.println("3. Mostrar la lista ordenada de mayor a menor segun el gasto total mediante el metodo Insercion directa");
        System.out.println("4. Mostrar la lista ordenada de mayor a menor segun el gasto total mediante el metodo Burbuja");
        System.out.println("5. Mostrar la lista ordenada mediante Arrays.sort");
        System.out.println("6. Salir");
    }

    public static void insertarGastotal() { // metodo para asignar un gasto total  a todos los clientes
        for (Cliente cliente : clientes) {
            cliente.setGastoTotal(rand.nextInt(100) + 1); // asignamos un entero entre 1 y 100 al gasto de cada cliente
        }
    }


    public static void mostrarClientes(Cliente[] clientes) { // imprime todos los elementos de un array de clientes
        for (Cliente c : clientes) {
            if (c != null) {
                System.out.println(c);
            }

        }
    }

    public static void mostrarlistaOrdenadaInsercionDirecta() {
        Cliente[] clientes_copia = clientes.clone(); // creamos una copia para mantener la lista original desordenada


        for (int i = 0; i < clientes_copia.length - 1; i++) { // recorremos el array
            int menor = i;
            for (int j = i + 1; j < clientes_copia.length; j++) { // desde el index i+1 se busca cual es el numero mas pequeño y se intercambia por la posicion i
                if (clientes_copia[j].getGastoTotal() < clientes_copia[menor].getGastoTotal()) {
                    menor = j;
                }
            }
            Cliente aux = clientes_copia[menor];
            clientes_copia[menor] = clientes_copia[i];
            clientes_copia[i] = aux;
        }

        mostrarClientes(clientes_copia); //mostramos la lista ordenada

    }

    public static void mostrarlistaOrdenadaBurbija() {
        int i, j;
        Cliente[] clientes_copia = clientes.clone(); // creamos una copia de la lista
        Cliente aux;
        for (i = 0; i <  clientes_copia.length-1; i++) { // se recorre el array y se comprueba cada pareja de numeros
            if (clientes_copia[i].getGastoTotal() > clientes_copia[i + 1].getGastoTotal()) {
                aux = clientes_copia[i];
                clientes_copia[i] = clientes_copia[i + 1];
                clientes_copia[i + 1] = aux;
            }
            for (j = i + 1; j < clientes_copia.length; j++) { // una vez ordenada la primera pareja de cada iteracion se recorre de nuevo el array desde el primer elemento desordenado
                if (clientes_copia[j].getGastoTotal() < clientes_copia[i].getGastoTotal()) {
                    aux = clientes_copia[i];
                    clientes_copia[i] = clientes_copia[j];
                    clientes_copia[j] = aux;
                }
            }

        }mostrarClientes(clientes_copia); // se imprime la lista ordenada
    }
}
