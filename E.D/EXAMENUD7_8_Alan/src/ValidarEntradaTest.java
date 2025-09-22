import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidarEntradaTest {

    @Test
    void validar() {
        List<Integer> lista = new ArrayList<>();
        ValidarEntrada vE = new ValidarEntrada(new String[]{"1", "8", "9", "2"}, lista );
        assertThrows(IllegalArgumentException.class, vE::validar);
        ValidarEntrada vE2 = new ValidarEntrada(new String[]{"1", "4", "5", "2"}, lista );


    }
}