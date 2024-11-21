import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static String[] leer_nombres(){
        System.out.println("Ingrese el nombre: ");
        String nombres = sc.nextLine();
        System.out.println("Ingrese el apellido: ");
        String apellidos = sc.nextLine();
        String[] nombre_apellido = new String[2];
        nombre_apellido[0] = nombres;
        nombre_apellido[1] = apellidos;
        return nombre_apellido;
    }
    public static void main(String[] args) {
        String[] nombres = {
                "Alejandro", "María", "Carlos", "Lucía", "Juan", "Ana", "Pedro", "Laura", "Miguel", "Sofía","Diego", "Carmen", "Javier", "Valeria", "Fernando", "Paula", "Luis", "Sara", "Antonio", "Elena","Ricardo", "Marta", "Sergio", "Claudia", "Pablo", "Isabel", "Jorge", "Ángela", "Manuel", "Eva", "Hugo", "Adriana", "Andrés", "Noelia", "Roberto", "Patricia", "Álvaro", "Cristina", "Francisco", "Rocío","Rafael", "Irene", "José", "Julia", "David", "Beatriz", "Víctor", "Sandra", "Mario", "Natalia"};


        String[] apellidos = {
                "García", "Rodríguez", "Martínez", "Hernández", "López", "González", "Pérez", "Sánchez", "Ramírez", "Torres", "Flores", "Rivera", "Gómez", "Díaz", "Morales", "Cruz", "Ortiz", "Jiménez", "Reyes", "Ruiz", "Alvarez", "Vargas", "Castro", "Mendoza", "Romero", "Serrano", "Delgado", "Guerrero", "Vega", "Silva", "Iglesias", "Ríos", "Navarro", "Campos", "Medina", "Fernández", "Carrillo", "Blanco", "Moreno", "Nieto", "Lara", "Pardo", "Marín", "Cabrera", "Ramos", "León", "Molina", "Santos", "Peña", "Palacios" };
        String[] nombre_apellido = leer_nombres();
        for (int i = 0; i < nombres.length; i++) {
            if (nombre_apellido[0].equals(nombres[i]) && nombre_apellido[1].equals(apellidos[i])) {
                for (int j = 0; j < nombre_apellido[0].length(); j++) {
                    char letra = nombre_apellido[0].charAt(j);
                    
                }

            }

        }
    }
}