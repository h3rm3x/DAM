public abstract class Obradearte {
    private String nombre;
    private int ano_creacion;
    private String autor;
    private boolean se_exhibe = false;

    // contructor
    public Obradearte(String nombre, int añoCreacion, String autor) {
        this.nombre = nombre;
        this.autor = autor;
        this.ano_creacion = añoCreacion;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAno_creacion() {
        return ano_creacion;
    }

    public void setAno_creacion(int ano_creacion) {
        this.ano_creacion = ano_creacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // metodos exhibir y vender (vender a diferencia de en el diagrama es declarado en el objeto y no en una interfaz para facilitar mas el trabajo
    public void exhibir() {
        se_exhibe = true;
    }

    public void vender(int precio, String nombre_comprador) {
        System.out.println(precio + " " + nombre_comprador);
    }

    ;

    // metodo tostring
    @Override
    public String toString() {
        return
                "nombre" + nombre + '\n' +
                        ", año creacion" + ano_creacion + '\n' +
                        ", autor" + autor + '\n' +
                        ", se_exhibe=" + se_exhibe
                ;

    }
}