import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void suma() {
        double valorEsperat = 30;
        Calculadora calcu = new Calculadora(20, 10);
        double resultat = calcu.suma();
        assertEquals(valorEsperat, resultat, 0, "Error en la suma");
    }

    @Test
    void resta() {
        double valorEsperat = 10;
        Calculadora calcu = new Calculadora(20, 10);
        double resultat = calcu.resta();
        assertEquals(valorEsperat, resultat, 0, "Error en la resta");
    }

    @Test
    void multiplica() {
        double valorEsperat = 200;
        Calculadora calcu = new Calculadora(20, 10);
        double resultat = calcu.multiplica();
        assertEquals(valorEsperat, resultat, 0, "Error en la multiplicació");
    }

    @Test
    void divideix() {
        double valorEsperat = 2;
        Calculadora calcu = new Calculadora(20, 10);
        double resultat = calcu.divideix();
        assertEquals(valorEsperat, resultat, 0, "Error en la divisió");
    }
}