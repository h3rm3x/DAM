public class Libro  implements Comparable<Object> {



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

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String toString() {
        return "Titulo: " + titulo + "\nAutor: " + autor + "\nISBN: " + ISBN + "\nStock: " + stock;
    }

    public int compareTo(Object obj) {
        if (this == obj) {
            return 0;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return 1;
        }
        Libro libro = (Libro) obj;
        return this.titulo.compareTo(libro.titulo);


    }
}
