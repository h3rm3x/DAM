public class ArmarioLibros {

    private Libro[] libros;
    private String genero;


    public ArmarioLibros(String genero) {
        libros = new Libro[100];
    }

    public void anadirLibro(Libro libro) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                libros[i] = libro;
                break;
            }
            if (i == libros.length - 1) {
                System.out.println("No hay espacio para más libros");
            }

        }
    }

    public void eliminarLibro(int ISBN) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getISBN() == ISBN) {
                libros[i] = null;
                break;
            }
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                str += libros[i].toString() + "\n";
            }
        }
        return str;
    }

}

