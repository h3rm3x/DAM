import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class CalculadoraTest {

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "4, 5, 9", "10, 20, 30", "0, 0, 0", "-1, -1, -2"})
    void Testsuma(int a, int b, int expected) {
        Calculadora calculadora = new Calculadora(a, b);
        int resultado = calculadora.suma();
        assertEquals(expected, resultado);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, -1", "4, 5, -1", "10, 20, -10", "0, 0, 0", "-1, -1, 0"})
    void resta(int a, int b, int expected) {
        Calculadora calculadora = new Calculadora(a, b);
        int resultado = calculadora.resta();
        assertEquals(expected, resultado);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 2", "4, 5, 20", "10, 20, 200", "0, 0, 0", "-1, -1, 1"})
    void multiplica(int a, int b, int expected) {
        Calculadora calculadora = new Calculadora(a, b);
        int resultado = calculadora.multiplica();
        assertEquals(expected, resultado);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 0", "4, 5, 0", "10, 20, 0", "-1, -1, 1"})
    void divideix(int a, int b, int expected) {
        Calculadora calculadora = new Calculadora(a, b);
        int resultado = calculadora.divideix();
        assertEquals(expected, resultado);
    }
}