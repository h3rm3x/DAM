import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest_7_4 {

    @ParameterizedTest
    @CsvSource(value = {"4,24", "3,6", "5,120", "6,720", "7,5040", "8,40320", "9,362880", "10,3628800"})
    void calculoTest(int a, int resultado) {
        assertEquals(Factorial.calculo(a), resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, -10, -20})
    void calculoNegatius(int num) {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculo(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {9999,20})
    void calculoOverflow(int num) {
        assertThrows(ArithmeticException.class, () -> Factorial.calculo(num));
    }
}