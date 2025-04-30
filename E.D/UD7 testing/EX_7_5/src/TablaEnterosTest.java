import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class TablaEnterosTest {


    @BeforeAll
    public static void CrearArray() throws Exception {
        Integer[] tabla = {1, 2, 3, 4, 5};
    }
    @org.junit.jupiter.api.Test
    void sumaTabla() {
        TablaEnteros tabla = new TablaEnteros(new Integer[]{1, 2, 3, 4, 5});
        int resultado = tabla.sumaTabla();
        assertAll(
                () -> assertEquals(15, resultado),
                () -> assertTrue(resultado > 0),
                () -> assertFalse(resultado < 0) ,
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    new TablaEnteros(null);
                })
        );
        assertEquals(15, resultado);

    }

    @org.junit.jupiter.api.Test
    void mayorTabla() {
    }

    @org.junit.jupiter.api.Test
    void posicionTabla() {
    }
}