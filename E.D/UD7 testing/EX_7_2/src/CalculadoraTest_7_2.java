import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



class CalculadoraTest_7_2 {
    @Test
    void divideix() {
        Calculadora calcu = new Calculadora(20, 0);
        Exception exception = assertThrows(ArithmeticException.class, calcu::divideix);
        assertEquals("Divisió per 0", exception.getMessage());

        calcu = new Calculadora(20, 2);
        int result = calcu.divideix();
        assertEquals(10, result);

        calcu = new Calculadora(20, 5);
        result = calcu.divideix();
        assertEquals(4, result);
    }
}
