import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest_7_3 {

    @Test
    void resta() {
        Calculadora_7_3 c = new Calculadora_7_3(5, 3);
        assertEquals(2, c.resta());
        Calculadora_7_3 c2 = new Calculadora_7_3(3, 5);
        assertEquals(2, c2.resta());
    }

    @Test
    void resta2() {
        Calculadora_7_3 c = new Calculadora_7_3(5, 3);
        assertTrue(c.resta2());
        Calculadora_7_3 c2 = new Calculadora_7_3(3, 5);
        assertFalse(c2.resta2());
    }

    @Test
    void divideix2() {
        Calculadora_7_3 c = new Calculadora_7_3(5, 0);
        assertNull(c.divideix2());
        Calculadora_7_3 c2 = new Calculadora_7_3(5, 2);
        assertEquals(2, c2.divideix2());
        Calculadora_7_3 c3 = new Calculadora_7_3(5, 5);
        assertEquals(1, c3.divideix2());
    }
}