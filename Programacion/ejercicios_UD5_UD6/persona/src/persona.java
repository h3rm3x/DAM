public class persona {
     public String nombre;
    public int edad;

    public void caminar(){
        System.out.println("Caminando");
    }
    public void imprimirDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
    public void personas(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
}
