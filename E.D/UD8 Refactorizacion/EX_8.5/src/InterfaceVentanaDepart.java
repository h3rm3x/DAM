import java.io.IOException;

public interface InterfaceVentanaDepart {
    boolean consultar(int dep) throws IOException // fin consultar
    ;

    void visualiza(int dep) // fin visualiza
    ;

    void borrar(int dep) // fin borrar
    ;

    void modificar(int dep) // fin modificar
    ;
}
