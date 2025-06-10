package modelo;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int paginas;
    private int edicion;
    private String genero;
    private int añoPublicacion;
    private String disponibilidad;
    
    // Constructor, getters y setters
    public Libro(String ISBN, String titulo, String autor, String editorial, 
                int paginas, int edicion, String genero, int añoPublicacion, 
                String disponibilidad) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.paginas = paginas;
        this.edicion = edicion;
        this.genero = genero;
        this.añoPublicacion = añoPublicacion;
        this.disponibilidad = disponibilidad;
    }
    
    // Getters y setters para todos los campos
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    public int getEdicion() {
        return edicion;
    }
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAñoPublicacion() {
        return añoPublicacion;
    }
    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }
    public String getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", paginas=" + paginas +
                ", edicion=" + edicion +
                ", genero='" + genero + '\'' +
                ", añoPublicacion=" + añoPublicacion +
                ", disponibilidad='" + disponibilidad + '\'' +
                '}';
    }
}