import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorEntradaTest {

    private final int TAMANO = 4;
    private final int MIN = 1;
    private final int MAX = 6;

    @Test
    void entradaCorrectaDevuelveCombinacion() {
        Combinacion combinacion = ValidadorEntrada.leer("1 2 3 4", TAMANO, MIN, MAX);

        assertNotNull(combinacion);
        assertEquals(List.of(1, 2, 3, 4), combinacion.getNumeros());
    }

    @Test
    void entradaConNumerosFueraDeRangoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidadorEntrada.leer("0 2 3 4", TAMANO, MIN, MAX);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ValidadorEntrada.leer("1 2 3 9", TAMANO, MIN, MAX);
        });
    }

    @Test
    void entradaConCantidadIncorrectaLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidadorEntrada.leer("1 2 3", TAMANO, MIN, MAX);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ValidadorEntrada.leer("1 2 3 4 5", TAMANO, MIN, MAX);
        });
    }

    @Test
    void entradaConCaracteresNoNumericosLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidadorEntrada.leer("a b c d", TAMANO, MIN, MAX);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ValidadorEntrada.leer("1 2 x 4", TAMANO, MIN, MAX);
        });
    }

    @Test
    void entradaVaciaOLargaDevuelveNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidadorEntrada.leer("", TAMANO, MIN, MAX);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ValidadorEntrada.leer(" ", TAMANO, MIN, MAX);
        });
    }

    @Test
    void entradaNullDevuelveNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidadorEntrada.leer(null, TAMANO, MIN, MAX);
        });
    }
}
