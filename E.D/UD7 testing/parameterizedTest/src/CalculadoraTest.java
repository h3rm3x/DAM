import org.junit.jupiter.params.*;

import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculadoraTest {

    @ParameterizedTest
    @CsvSource({"20,10,2", "10,5,2", "30,15,2", "40,20,2"})
    void testDividir(int a, int b, int resultado) {
        Calculadora calculadora = new Calculadora(a, b);
        assertEquals(resultado, calculadora.divideix());
    }


}