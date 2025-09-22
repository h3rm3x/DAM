import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultadoTest {

    @Test
    void mensajeResultado() {
        Resultado r = new Resultado(2,2, 10);
        assertFalse(r.mensajeResultado());
        Resultado r2 = new Resultado(4,0, 10);
        assertTrue(r2.mensajeResultado());
    }
}