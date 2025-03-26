public class Libro {
    private String titulo;
    private String autor;
    private Integer ISBN;
    private Integer stock;

    public Libro(String titulo, String autor, Integer ISBN, Integer stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.stock = stock;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public Integer getStock() {
        return stock;
    }

    public String toString() {
        return "Titulo: " + titulo + "\nAutor: " + autor + "\nISBN: " + ISBN + "\nStock: " + stock;
    }
}
