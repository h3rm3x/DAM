public class ex_8_4  {
    public static void main(String[] args) {
        try {
            System.out.println("Verificando edades...");
            verificarEdad(15);
            verificarEdad(22);
            verificarEdad(17);
            System.out.println("Este mensaje no se mostrará si hay error");
        } catch (EdadInvalidaException e) {
            System.out.println("Se ha capturado una excepción personalizada:");
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("ToString: " + e);
            System.out.println("Edad que causó el error: " + e.getEdad());
            System.out.println("Edad mínima requerida: " + e.getEdadMinima());
            System.out.println("Traza de pila:");
            e.printStackTrace();
        }
    }

    public static void verificarEdad(int edad) throws EdadInvalidaException {
        final int EDAD_MINIMA = 18;

        System.out.println("Verificando edad: " + edad);

        if (edad < EDAD_MINIMA) {
            throw new EdadInvalidaException("La edad debe ser al menos " + EDAD_MINIMA + " años", edad, EDAD_MINIMA);
        }

        System.out.println("La edad " + edad + " es válida");
    }
}