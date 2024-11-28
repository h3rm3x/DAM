import java.util.Scanner;
public class persona {
     private String nombre;
     private int edad;
    Scanner sc = new Scanner(System.in);
    public persona(){
        System.out.println("escribe el nombre");
        nombre=sc.nextLine();
        System.out.println("escribe el edad");
        edad=sc.nextInt();
    }
    public persona(String nombre){
        this.nombre = nombre;
    }
    public persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public void caminar(){
        System.out.println(nombre +"Caminando");
    }
    public void imprimirDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad(){
        return this.edad;
    }
}
