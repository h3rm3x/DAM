import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest_7_3 {

    @Test
    void resta() {
        Calculadora c = new Calculadora(5, 3);
        assertEquals(2, c.resta());
        Calculadora c2 = new Calculadora(3, 5);
        assertEquals(2, c2.resta());
    }

    @Test
    void resta2() {
        Calculadora c = new Calculadora(5, 3);
        assertTrue(c.resta2());
        Calculadora c2 = new Calculadora(3, 5);
        assertFalse(c2.resta2());
    }

    @Test
    void divideix2() {
        Calculadora c = new Calculadora(5, 0);
        assertNull(c.divideix2());
        Calculadora c2 = new Calculadora(5, 2);
        assertEquals(2, c2.divideix2());
        Calculadora c3 = new Calculadora(5, 5);
        assertEquals(1, c3.divideix2());
    }
}