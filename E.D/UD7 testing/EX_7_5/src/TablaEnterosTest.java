import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class TablaEnterosTest {
    static TablaEnteros tablaEnteros;

    @BeforeAll
    public static void CrearTabla() throws Exception {
        Integer[] tabla = new Integer[]{1, 2, 3, 4, 5};
         tablaEnteros = new TablaEnteros(tabla);
    }

    @AfterAll
    public static void BorrarTabla() throws Exception {
        tablaEnteros = null;
    }
    @org.junit.jupiter.api.Test
    void sumaTabla()  {

        int resultado = tablaEnteros.sumaTabla();
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

        int resultado = tablaEnteros.mayorTabla();
        assertAll(
                () -> assertEquals(5, resultado),
                () -> assertTrue(resultado > 0),
                () -> assertFalse(resultado < 0) ,
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    new TablaEnteros(null);
                })
        );
    }

    @org.junit.jupiter.api.Test
    void posicionTabla() {
        int resultado = tablaEnteros.posicionTabla(3);
        assertAll(
                () -> assertEquals(2, resultado),
                () -> assertTrue(resultado >= 0),
                () -> assertFalse(resultado < 0) ,
                () -> assertThrows(java.util.NoSuchElementException.class, () -> {
                    tablaEnteros.posicionTabla(10);
                })
        );
    }
}