import java.util.Scanner;

import static java.lang.Float.parseFloat;

public class Examen_Alan_rabinerson {
    public static float[] notas = new float[300]; // array para guardar todas las notas introducidas
    public static int index = 0; // se define una variable para guardar el numero de notas introducidas
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion=1;
        while(opcion!=0){ // menu de opciones
            System.out.println("MENU");
            System.out.println("0. Salir");
            System.out.println("1. Introocir notas");
            System.out.println("2. Mostrar notas");
            System.out.println("3. Mostrar estadisticas");

            System.out.println();
            System.out.print("Introduzca una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();


            switch(opcion){
                case 0: {
                    System.out.println("¿Seguro que quiere salir del programa? ");
                    String salir = sc.nextLine();
                    salir = salir.toLowerCase();
                    if(salir.equals("no")){
                        opcion= 4;
                    }
                    break;
                }

                case 1:{
                    notas[index]=añadirnotas();
                    break;
                }
                case 2: {
                    mostrarNotas();
                    break;
                }
                case 3: {
                    calcularEstadisticas();
                    break;
                }
                default: System.out.println("Opción no válida. Por favor, ingrese un número entre 0 y 3.");
            }
        }
        System.out.println("Programa finalizado.");
    }


    public static float añadirnotas(){
        System.out.println("Introduzca una nota: ");
        float nota= sc.nextFloat();
        while (nota>10 || nota<0){ // mientras la nota no este entre 0 y 10 se pide que entre un nuevo valor
            System.out.println("ERROR, la nota ha de ser entre 0 y 10 ");
            System.out.println("Introduzca una nota: ");
            nota = sc.nextFloat();
        }
        index++; // despues introdocir una nota se aumenta el valor de la variable index
        return nota;
    }


    public static void mostrarNotas(){
        if (index==0){
            System.out.println("la lista de notas esta vacia. Introduzca notas y vuelva a llamar a esta funcion");
            return;
        }
        System.out.println("Las notas introducidas hasta ahora son: ");

        for (int i = 0; i < index; i++) {
            System.out.print(notas[i] +", ");
        }

        System.out.println();
    }


    public static void calcularEstadisticas(){
        float nota,notamax=0, notamin=10; // se define la variable de nota maxima con la nota minima introducible tal que la primera vez que se compare con la variable temporal se introducira el valor de esta en la variable.
        // se hace lo mismo pero a la inversa para la nota maxima
        float media=0;
        if (index==0){
            System.out.println("No se pueden calcular estadisticas si la lista de notas esta vacia. Introduzca notas y vuelva a llamar a esta funcion");
            return;
        }
        System.out.println("Las estadisticas de las "+ index+ " notas introducidas hasta ahora son: ");

        for (int i = 0; i < index; i++) {
            nota = notas[i];
            media+=nota; //se suman todas las notas para posteriormente dividarlas entre index+1, el numero total de notas introducidas
            if(nota>notamax){ // si el valor de la variable temporal es mayor que el valor actual de notamax se introduce en notamax el valor de la primera
                notamax=nota;
            }
            if(nota<notamin){ // se realiza la inversa de la condicion anterior con notamin
                notamin=nota;
            }
        }
        media/=index;
        System.out.println("La media de todas las notas es: "+media);
        System.out.println("La nota maxima introducida es: "+notamax);
        System.out.println("La nota minima introducida es: "+notamin);

    }
}