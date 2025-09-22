import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class EvaluadorResultadoTest {

    @Test
    public void devuelve4AciertosSiCombinacionesSonIguales() {
        Combinacion secreta = new Combinacion(List.of(1, 2, 3, 4));
        Combinacion intento = new Combinacion(List.of(1, 2, 3, 4));

        EvaluadorResultado evaluador = new EvaluadorResultado(secreta);
        Resultado resultado = evaluador.evaluar(intento);

        assertEquals(4, resultado.getAciertos());
        assertEquals(0, resultado.getCoincidencias());
    }

    @Test
    public void devuelveCoincidenciasCorrectasConNumerosDesordenados() {
        Combinacion secreta = new Combinacion(List.of(1, 2, 3, 4));
        Combinacion intento = new Combinacion(List.of(4, 3, 2, 1));

        EvaluadorResultado evaluador = new EvaluadorResultado(secreta);
        Resultado resultado = evaluador.evaluar(intento);

        assertEquals(0, resultado.getAciertos());
        assertEquals(4, resultado.getCoincidencias());
    }

    @Test
    public void mezclaDeAciertosYCoincidencias() {
        Combinacion secreta = new Combinacion(List.of(1, 2, 3, 4));
        Combinacion intento = new Combinacion(List.of(1, 3, 2, 4));

        EvaluadorResultado evaluador = new EvaluadorResultado(secreta);
        Resultado resultado = evaluador.evaluar(intento);

        assertEquals(2, resultado.getAciertos());      // 1 y 4
        assertEquals(2, resultado.getCoincidencias()); // 2 y 3 en posiciones cambiadas
    }

    @Test
    public void sinAciertosNiCoincidenciasDevuelveCeros() {
        Combinacion secreta = new Combinacion(List.of(1, 2, 3, 4));
        Combinacion intento = new Combinacion(List.of(5, 6, 7, 8));

        EvaluadorResultado evaluador = new EvaluadorResultado(secreta);
        Resultado resultado = evaluador.evaluar(intento);

        assertEquals(0, resultado.getAciertos());
        assertEquals(0, resultado.getCoincidencias());
    }

    @Test
    public void intentoParcialmenteCoincidente() {
        Combinacion secreta = new Combinacion(List.of(1, 1, 2, 3));
        Combinacion intento = new Combinacion(List.of(1, 2, 4, 1));

        EvaluadorResultado evaluador = new EvaluadorResultado(secreta);
        Resultado resultado = evaluador.evaluar(intento);

        assertEquals(1, resultado.getAciertos());      // 1 en pos 0
        assertEquals(2, resultado.getCoincidencias()); // 2 y 1 en posiciones equivocadas
    }

    @Test
    public void evaluarConIntentoNullDevuelveNull() {
        Combinacion secreta = new Combinacion(List.of(1, 2, 3, 4));
        EvaluadorResultado evaluador = new EvaluadorResultado(secreta);

        Resultado resultado = evaluador.evaluar(null);

        assertNull(resultado);
    }

    @Test
    public void evaluarConIntentoDeLongitudIncorrectaLanzaExcepcion() {
        Combinacion secreta = new Combinacion(List.of(1, 2, 3, 4));
        Combinacion intento = new Combinacion(List.of(1, 2)); // longitud incorrecta

        EvaluadorResultado evaluador = new EvaluadorResultado(secreta);

        assertThrows(IllegalArgumentException.class, () -> {
            evaluador.evaluar(intento);
        });
    }

    @Test
    public void evaluarConIntentoVacioDevuelveNull() {
        Combinacion secreta = new Combinacion(List.of(1, 2, 3, 4));
        Combinacion intento = new Combinacion(List.of()); // combinaci�n vac�a

        EvaluadorResultado evaluador = new EvaluadorResultado(secreta);
        Resultado resultado = evaluador.evaluar(intento);

        assertNull(resultado);
    }
}
