import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest_7_4 {

    @Test
    void calculo() {
        assertAll(
                () -> assertEquals(1, Factorial.calculo(0)),
                () -> assertEquals(1, Factorial.calculo(1)),
                () -> assertEquals(2, Factorial.calculo(2)),
                () -> assertEquals(6, Factorial.calculo(3)),
                () -> assertEquals(24, Factorial.calculo(4)),
                () -> assertEquals(120, Factorial.calculo(5)),
                () -> assertEquals(720, Factorial.calculo(6)),
                () -> assertEquals(5040, Factorial.calculo(7)),
                () -> assertEquals(40320, Factorial.calculo(8)),
                () -> assertEquals(362880, Factorial.calculo(9)),
                () -> assertEquals(3628800, Factorial.calculo(10)),
                //() -> assertEquals(2.6525285981219105863630848e+32, Factorial.calculo(30)),
                // per damunt de 20 dona o error de calcul o numero massa gran
                () -> assertThrows(ArithmeticException.class, () -> Factorial.calculo(20))

        );
    }
}