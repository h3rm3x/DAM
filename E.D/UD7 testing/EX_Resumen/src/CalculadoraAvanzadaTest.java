import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraAvanzadaTest {
    static CalculadoraAvanzada calc;
    @BeforeAll
    public static void inicio() {
         calc = new CalculadoraAvanzada();
    }
    @ParameterizedTest
    @CsvSource ({
            "1, 2, 3",
            "0, 0, 0",
            "-1, -1, -2",
            "10, 5, 15",
            "100, 200, 300",})
    void sumar(int a, int b, int resultado) {
        assertEquals(resultado, calc.sumar(a, b));
    }

    @ParameterizedTest
    @CsvSource ({
            "1, 2, -1",
            "0, 0, 0",
            "-1, -1, 0",
            "10, 5, 5",
            "100, 200, -100",})
    void restar(int a, int b, int resultado) {
        assertEquals(resultado, calc.restar(a, b));
    }

    @ParameterizedTest
    @CsvSource ({
            "1, 2, 2",
            "0, 0, 0",
            "-1, -1, 1",
            "10, 5, 50",
            "100, 200, 20000",
            "100, 0, 0",})
    void multiplicar(int a, int b, int resultado) {
        assertEquals(resultado, calc.multiplicar(a, b));

    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 0.5",
            "0, 1, 0",
            "-1, -1, 1",
            "10, 5, 2",
            "100, 200, 0.5",
            "100, 0, Infinity",})

    void dividir(double a, double b, double resultado) {
        if (b == 0) {
            assertThrows(ArithmeticException.class, () -> calc.dividir(a, b));
        } else {
            assertEquals(resultado, calc.dividir(a, b));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1, false",
            "2, true",
            "3, false",
            "4, true",
            "5, false",
            "6, true",})
    void esPar(int a, boolean b) {
        assertEquals(b, calc.esPar(a));
    }

    @ParameterizedTest
    @CsvSource({
            "S, Suma",
            "R, Resta",
            "M, Multiplicación",
            "D, División",
            "X, Desconocido",
            " A, Desconocido",})
    void obtenerNombreOperacion(String operacion, String nombre) {
        assertEquals(nombre, calc.obtenerNombreOperacion(operacion));

    }

    @ParameterizedTest
    @CsvSource({
            "true, null",
            "false, 0",})
    void obtenerValorNulo(boolean valor, String resultado) {
        assertEquals(resultado, calc.obtenerValorNulo(valor));

    }

    @ParameterizedTest
    @CsvSource({
            "1, false",
            "2, true",
            "3, true",
            "4, false",
            "5, true",
            "6, false",
            "7, true",
            "11, true",})
    void esNumeroPrimo(int n, boolean valor) {
        assertEquals(valor, calc.esNumeroPrimo(n));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, Negativo",
            "0, Cero",
            "1, Positivo",
            "2, Positivo",
            "-2, Negativo",
            "3, Positivo",
            "-3, Negativo",})
    void clasificarNumero(int n, String valor) {
        assertEquals(valor, calc.clasificarNumero(n));

    }
}