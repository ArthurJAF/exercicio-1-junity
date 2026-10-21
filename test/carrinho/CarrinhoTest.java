
package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Testes do Carrinho")
class CarrinhoTest {

    private Carrinho carrinho;
    private Produto cpu;
    private Produto gpu;

    @BeforeEach
    void initialize() {
        carrinho = new Carrinho();
        cpu = new Produto("Ryzen 7", 900.00);
        gpu = new Produto("RTX 3060", 1600.00);
    }

    @Test
    @DisplayName("Deve iniciar vazio")
    void deveIniciarVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Deve adicionar um produto")
    void deveAdicionarUmProduto() {
        carrinho.addItem(cpu);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(900.00, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Deve adicionar vários produtos")
    void deveAdicionarVariosProdutos() {
        carrinho.addItem(cpu);
        carrinho.addItem(gpu);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(2500.00, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Deve remover um produto existente")
    void deveRemoverProdutoExistente()
            throws ProdutoNaoEncontradoException {
        carrinho.addItem(cpu);
        carrinho.addItem(gpu);

        carrinho.removeItem(cpu);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(1600.00, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Deve lançar exceção ao remover produto inexistente")
    void deveLancarExcecaoAoRemoverProdutoInexistente() {
        assertThrows(ProdutoNaoEncontradoException.class,
                () -> carrinho.removeItem(cpu));
    }

    @Test
    @DisplayName("Deve esvaziar o carrinho")
    void deveEsvaziarCarrinho()
            throws ProdutoNaoEncontradoException {
        carrinho.addItem(cpu);
        carrinho.addItem(gpu);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }
}
