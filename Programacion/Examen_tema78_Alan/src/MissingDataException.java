public class MissingDataException extends Exception {
    public MissingDataException() {
        super("Error faltan cleintes por introducir el gasto total");
    }
    public MissingDataException(String mensaje) {
        super(mensaje);
    }




}
