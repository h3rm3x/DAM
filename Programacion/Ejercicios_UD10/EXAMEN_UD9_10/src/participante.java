import java.util.*;
public class participante {
    private String nombre;
    private int edad;
    private String prueba;
    // constructor
    public participante(String nombre, int edad, String prueba) {
        this.nombre = nombre;
        this.edad = edad;
        this.prueba = prueba;
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getPrueba() {
        return prueba;
    }
    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }
    // metodo equals para comprobar que no haya repeticiones
    @Override
    public boolean equals(Object o) {  // dos objetos participantes seran igualis si ambos son de tipo participante y tienen el mismo nombre edad y prueba
        if (o == null || getClass() != o.getClass()) return false;
        participante p = (participante) o;
        return edad == p.edad && Objects.equals(nombre, p.nombre) && Objects.equals(prueba, p.prueba);
    }
    public int compareTo(participante p) { // se compara el nombre de cada participante
        return this.nombre.compareTo(p.nombre);
    }

    @Override
    public int hashCode() { //se utiliza el nombre edad y prueba para crear cada hash
        return Objects.hash(nombre, edad, prueba);
    }
}
