import java.io.Serializable;
import java.util.Objects;

public class libro implements Comparable<libro>, Serializable {


    private int ISBN;
    private String titulo;
    private String autor;

    public libro(int ISBN, String titulo, String autor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
    }
    public int getISBN() {
        return ISBN;
    }
    public void setISBN(int ISBN) {
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
    @Override
    public String toString() {
        return  "ISBN:" + ISBN +
                ", titulo:'" + titulo + '\'' +
                ", autor:'" + autor + '\'' ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof libro)) return false;
        libro libro = (libro) o;
        return ISBN == libro.ISBN && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor);
    }
    @Override
    public int hashCode() {
        return Objects.hash(ISBN, titulo, autor);
    }
    @Override
    public int compareTo(libro o) {
        return (Integer.compare(this.ISBN, o.ISBN));
    }


}
