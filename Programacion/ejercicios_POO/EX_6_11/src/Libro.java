public class Libro extends ArmarioLibros {
    private String titulo;
    private String autor;
    private int ISBN;
    private String genero;

    public Libro(String titulo, String autor, int ISBN, String genero) {

        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        super(genero);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String toString() {
        return "Titulo: " + titulo + "\nAutor: " + autor + "\nISBN: " + ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
