public class fotografia extends Obradearte implements Restauracion {
    private String tipo;
    private boolean restaurada = false;

    public fotografia(String nombre, int ano_creacion, String autor, String tipo) {
        super(nombre, ano_creacion, autor);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return " Fotografia {" + super.toString() + "\nTipo: " + tipo;
    }

    public void restaurar() {
        System.out.println("La fotografia " + getNombre() + "de tipo" + tipo + "hecha por " + getAutor() + "ha sido restaurada");
        restaurada = true;
    }
}
