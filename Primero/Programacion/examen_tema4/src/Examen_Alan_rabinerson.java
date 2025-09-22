import java.util.Scanner;
public class Examen_Alan_rabinerson {
    public static int[] notas = new int[300];
    public static int index = 0;
    static Scanner sc = new Scanner(System.in);
    public static int añadirnotas(){
        System.out.println("Introduzca una nota: ");
        int nota = sc.nextInt();
        while (nota>10 || nota<0){
            System.out.println("ERROR, la nota ha de ser entre 0 y 10 ");
            System.out.println("Introduzca una nota: ");
            nota = sc.nextInt();
        }
        index++;
        return nota;
    }
    public static void mostrarNotas(){
        if (index==0){
            System.out.println("la lista de notas esta vacia. Introduzca notas y vuelva a llamar a esta funcion");
            return;
        }
        for (int i = 0; i < index; i++) {
            System.out.print(notas[i] +", ");
        }
    }
    public static void calcularEstadisticas(){
        int nota,notamax=0, notamin=10;
        float media=0;
        if (index==0){
            System.out.println("No se pueden calcular estadisticas si la lista de notas esta vacia. Introduzca notas y vuelva a llamar a esta funcion");
            return;
        }
        for (int i = 0; i < index; i++) {
            nota = notas[i];
            media+=nota;
            if(nota>notamax){
                notamax=nota;
            }
            if(nota<notamin){
                notamin=nota;
            }
        }
        media/=index;
        System.out.println("La media de todas las notas es: "+media);
        System.out.println("La nota maxima introducida es: "+notamax);
        System.out.println("La nota minima introducida es: "+notamin);

    }

    public static void main(String[] args) {
        int opcion=1;
        while(opcion!=0){
            System.out.println("MENU");
            System.out.println("1. Introocir notas");
            System.out.println("2. Mostrar notas");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 0: break;
                case 1:{
                    notas[index]=añadirnotas();
                }
                case 2: {
                    System.out.println("Las notas introducidas hasta ahora son: ");
                    mostrarNotas();
                }
                case 3: {
                    System.out.println("Las estadisticas de las notas introducidas hasta ahora son: ");
                    calcularEstadisticas();
                }
                default: System.out.println("Opción no válida. Por favor, ingrese un número entre 0 y 4.");
            }
        }
        System.out.println("Programa finalizado.");
    }

}