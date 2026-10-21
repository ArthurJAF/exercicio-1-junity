
package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes do Produto")
class ProdutoTest {

    private Produto produto;

    @BeforeEach
    void inicializa() {
        produto = new Produto("Introdução ao Teste de Software", 100.00);
    }

    @Test
    @DisplayName("Deve criar produto com nome e preço corretos")
    void deveCriarProdutoCorretamente() {
        assertEquals("Introdução ao Teste de Software",
                produto.getNome());
        assertEquals(100.00, produto.getPreco(), 0.001);
    }

    @Test
    @DisplayName("O nome do produto não deve ser nulo")
    void nomeNaoDeveSerNulo() {
        assertNotNull(produto.getNome());
    }

    @Test
    @DisplayName("O preço do produto deve ser positivo")
    void precoDeveSerPositivo() {
        assertTrue(produto.getPreco() > 0);
    }

    @Test
    @DisplayName("Produtos criados separadamente são objetos distintos")
    void produtosDevemSerObjetosDistintos() {
        Produto outroProduto =
                new Produto("Introdução ao Teste de Software", 100.00);

        assertNotSame(produto, outroProduto);
    }

    @Test
    @DisplayName("Deve preservar o nome e o preço informados")
    void devePreservarDadosInformados() {
        Produto outroProduto = new Produto("Livro de Java", 75.50);

        assertEquals("Livro de Java", outroProduto.getNome());
        assertEquals(75.50, outroProduto.getPreco(), 0.001);
    }
}
