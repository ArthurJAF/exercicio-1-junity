package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChatCalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    public void initialize() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Teste de soma")
    public void soma() {
        int resultado = calculadora.soma(10, 5);

        assertEquals(15, resultado);
    }

    @Test
    @DisplayName("Teste de subtração")
    public void subtracao() {
        int resultado = calculadora.subtracao(10, 5);

        assertEquals(5, resultado);
    }

    @Test
    @DisplayName("Teste de multiplicação")
    public void multiplicacao() {
        int resultado = calculadora.multiplicacao(10, 5);

        assertEquals(50, resultado);
    }

    @Test
    @DisplayName("Teste de divisão")
    public void divisao() {
        int resultado = calculadora.divisao(10, 5);

        assertEquals(2, resultado);
    }

    @Test
    @DisplayName("Teste de somatória")
    public void somatoria() {
        int resultado = calculadora.somatoria(5);

        assertEquals(15, resultado);
    }

    @Test
    @DisplayName("Teste número positivo")
    public void ehPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    @DisplayName("Teste número zero")
    public void ehPositivoZero() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    @DisplayName("Teste número negativo")
    public void ehNegativo() {
        assertFalse(calculadora.ehPositivo(-10));
    }

    @Test
    @DisplayName("Teste comparação quando os números são iguais")
    public void comparaIguais() {
        int resultado = calculadora.compara(10, 10);

        assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Teste comparação quando a > b")
    public void comparaMaior() {
        int resultado = calculadora.compara(10, 5);

        assertEquals(1, resultado);
    }

    @Test
    @DisplayName("Teste comparação quando a < b")
    public void comparaMenor() {
        int resultado = calculadora.compara(5, 10);

        assertEquals(-1, resultado);
    }

    @Test
    @DisplayName("Teste divisão por zero")
    public void divisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.divisao(10, 0);
        });
    }

}
