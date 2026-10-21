
package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes da Calculadora")
public class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }

    @Test
    public void testaSoma() {
        assertEquals(22, calc.soma(12, 10));
        assertEquals(0, calc.soma(-5, 5));
        assertEquals(-8, calc.soma(-3, -5));
    }

    @Test
    public void testaSubtracao() {
        assertEquals(2, calc.subtracao(12, 10));
        assertEquals(0, calc.subtracao(5, 5));
        assertEquals(-10, calc.subtracao(-5, 5));
    }

    @Test
    public void testaMultiplicacao() {
        assertEquals(20, calc.multiplicacao(4, 5));
        assertEquals(0, calc.multiplicacao(0, 10));
        assertEquals(-15, calc.multiplicacao(-3, 5));
    }

    @Test
    public void testaDivisao() {
        assertEquals(2, calc.divisao(8, 4));
        assertEquals(-2, calc.divisao(-8, 4));
        assertEquals(0, calc.divisao(3, 4));
    }

    @Test
    public void testaDivisaoPorZero() {
        assertThrows(ArithmeticException.class,
                () -> calc.divisao(8, 0));
    }

    @Test
    public void testaSomatoria() {
        assertEquals(15, calc.somatoria(5));
        assertEquals(0, calc.somatoria(0));
        assertEquals(0, calc.somatoria(-1));
    }

    @Test
    public void testaEhPositivo() {
        assertTrue(calc.ehPositivo(10));
        assertTrue(calc.ehPositivo(0));
        assertFalse(calc.ehPositivo(-1));
    }

    @Test
    public void testaCompara() {
        assertEquals(0, calc.compara(5, 5));
        assertEquals(1, calc.compara(10, 5));
        assertEquals(-1, calc.compara(3, 8));
    }
}
