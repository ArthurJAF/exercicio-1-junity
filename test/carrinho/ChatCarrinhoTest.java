package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class ChatCarrinhoTest {


    private Carrinho carrinho;
    private Produto cpu;
    private Produto gpu;

    @BeforeEach
    public void initialize() {
        carrinho = new Carrinho();

        cpu = new Produto("Ryzen 7", 900.00);
        gpu = new Produto("RTX 3060", 1600.00);
    }

    @Test
    @DisplayName("Teste adiciona item")
    public void addItem() {

        carrinho.addItem(cpu);
        carrinho.addItem(gpu);

        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Teste remove item")
    public void removeItem() throws ProdutoNaoEncontradoException {

        carrinho.addItem(cpu);
        carrinho.addItem(gpu);

        carrinho.removeItem(cpu);

        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Teste remove item que não existe")
    public void removeItemNaoExistente() {

        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(cpu);
        });
    }

    @Test
    @DisplayName("Teste valor total do carrinho")
    public void valorTotal() {

        carrinho.addItem(cpu);
        carrinho.addItem(gpu);

        double resultado = carrinho.getValorTotal();

        assertEquals(2500.00, resultado);
    }

    @Test
    @DisplayName("Teste carrinho vazio")
    public void carrinhoVazio() {

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Teste esvaziar carrinho")
    public void esvazia() {

        carrinho.addItem(cpu);
        carrinho.addItem(gpu);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Teste valor total do carrinho vazio")
    public void valorTotalCarrinhoVazio() {

        assertEquals(0.0, carrinho.getValorTotal());
    }
	

}
