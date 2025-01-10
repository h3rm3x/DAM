import java.util.Scanner;

public class Biblioteca {
    static Scanner sc = new Scanner(System.in);
    // declaracion de los armarios
    static ArmarioLibros Aventura = new ArmarioLibros("Aventura");
    static ArmarioLibros CienciaFiccion = new ArmarioLibros("Ciencia Ficcion");
    static ArmarioLibros Historia = new ArmarioLibros("Historia");
    static ArmarioLibros NovelaNegra = new ArmarioLibros("Novela Negra");
    static ArmarioLibros Terror = new ArmarioLibros("Terror");
    static ArmarioLibros Fantasia = new ArmarioLibros("Fantasia");
    static ArmarioLibros Biografia = new ArmarioLibros("Biografia");

    public static void main(String[] args) {


        while (true) {
            System.out.println("1. Añadir libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Mostrar libros");
            System.out.println("4. Salir");
            Libro libro;
            int opcion = Integer.parseInt(System.console().readLine());
            switch (opcion) {
                case 1: {
                    System.out.println("Introduce el titulo del libro");
                    String titulo = sc.nextLine();
                    System.out.println("Introduce el autor del libro");
                    String autor = sc.nextLine();
                    System.out.println("Introduce el ISBN del libro");
                    int ISBN = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce el genero del libro");
                    String genero = sc.nextLine();
                    libro = new Libro(titulo, autor, ISBN, genero);
                    anadirLibro(libro);
                    break;
                }
                case 2: {
                    System.out.println("Introduce el ISBN del libro que quieres eliminar");
                    int ISBN = sc.nextInt();
                    eliminarLibro(ISBN);
                    break;
                }

                case 3: {
                    mostrarLibros();
                    break;
                }
                case 4: {
                    System.exit(0);
                }
            }
        }
    }

    public static void anadirLibro(Libro libro) {
        switch (libro.getGenero()) {
            case "Aventura":
                Aventura.anadirLibro(libro);
                break;
            case "Ciencia Ficcion":
                CienciaFiccion.anadirLibro(libro);
                break;
            case "Historia":
                Historia.anadirLibro(libro);
                break;
            case "Novela Negra":
                NovelaNegra.anadirLibro(libro);
                break;
            case "Terror":
                Terror.anadirLibro(libro);
                break;
            case "Fantasia":
                Fantasia.anadirLibro(libro);
                break;
            case "Biografia":
                Biografia.anadirLibro(libro);
                break;
        }

    }

    public static void eliminarLibro(int ISBN) {
        Aventura.eliminarLibro(ISBN);
        CienciaFiccion.eliminarLibro(ISBN);
        Historia.eliminarLibro(ISBN);
        NovelaNegra.eliminarLibro(ISBN);
        Terror.eliminarLibro(ISBN);
        Fantasia.eliminarLibro(ISBN);
        Biografia.eliminarLibro(ISBN);

    }

    public static void mostrarLibros() {
        System.out.println("Aventura");
        System.out.println(Aventura.toString());
        System.out.println("Ciencia Ficcion");
        System.out.println(CienciaFiccion.toString());
        System.out.println("Historia");
        System.out.println(Historia.toString());
        System.out.println("Novela Negra");
        System.out.println(NovelaNegra.toString());
        System.out.println("Terror");
        System.out.println(Terror.toString());
        System.out.println("Fantasia");
        System.out.println(Fantasia.toString());
        System.out.println("Biografia");
        System.out.println(Biografia.toString());
    }
}
