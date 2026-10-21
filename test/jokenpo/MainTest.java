
package jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes do Jokenpo")
class MainTest {

    private Main jogo;

    @BeforeEach
    void inicializa() {
        jogo = new Main();
    }

    @Test
    @DisplayName("Deve retornar empate quando as escolhas forem iguais")
    void deveRetornarEmpate() {
        assertEquals(0, jogo.jogar(1, 1));
        assertEquals(0, jogo.jogar(2, 2));
        assertEquals(0, jogo.jogar(3, 3));
    }

    @Test
    @DisplayName("Deve identificar as vitórias do jogador 1")
    void deveIdentificarVitoriaJogador1() {
        assertEquals(1, jogo.jogar(1, 2));
        assertEquals(1, jogo.jogar(2, 3));
        assertEquals(1, jogo.jogar(3, 1));
    }

    @Test
    @DisplayName("Deve identificar as vitórias do jogador 2")
    void deveIdentificarVitoriaJogador2() {
        assertEquals(2, jogo.jogar(2, 1));
        assertEquals(2, jogo.jogar(3, 2));
        assertEquals(2, jogo.jogar(1, 3));
    }

    @Test
    @DisplayName("Deve rejeitar escolhas menores que 1")
    void deveRejeitarEscolhasMenoresQueUm() {
        assertEquals(-1, jogo.jogar(0, 1));
        assertEquals(-1, jogo.jogar(-1, 2));
        assertEquals(-1, jogo.jogar(1, 0));
        assertEquals(-1, jogo.jogar(2, -1));
    }

    @Test
    @DisplayName("Deve rejeitar escolhas maiores que 3")
    void deveRejeitarEscolhasMaioresQueTres() {
        assertEquals(-1, jogo.jogar(4, 1));
        assertEquals(-1, jogo.jogar(1, 4));
        assertEquals(-1, jogo.jogar(5, 6));
    }
}
