public class EdadInvalidaException extends Exception {
    private int edad;
    private int edadMinima;

    // Constructor con información completa
    public EdadInvalidaException(String mensaje, int edad, int edadMinima) {
        super(mensaje);
        this.edad = edad;
        this.edadMinima = edadMinima;
    }

    // Constructor solo con mensaje
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }

    // Constructor sin argumentos
    public  EdadInvalidaException() {
        super("Edad inválida");
    }

    // Getters para acceder a los campos específicos
    public int getEdad() {
        return edad;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    // Sobrescritura de getMessage para incluir información adicional
    public String getMessage() {
        return super.getMessage() + " (Recibida: " + edad + ", Requerida: " + edadMinima + ")";
    }

    // Sobrescritura de toString para mostrar detalles específicos

    public String toString() {
        return "EdadInvalidaException: " + getMessage();
    }
}