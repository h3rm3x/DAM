import java.util.Scanner;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Trabajador[] trabajadores = new Trabajador[4];


    trabajadores[0] = new Administrador("nombre_admin", 5412.45);
    trabajadores[1] = new ingeniero("nombre_ing1", 4412.45);
    trabajadores[2] = new comercial("nombre_com1", 4166.78);
    trabajadores[3] = new Director("nombre_dir", 7156.82);

    for (Trabajador trabajador : trabajadores) {
        System.out.println(trabajador.getNombre() + " " + trabajador.getSalario());
        trabajador.trabajar();
        trabajador.cobrar();
    }


}

