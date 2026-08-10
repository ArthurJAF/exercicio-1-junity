package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;

class CarrinhoTest {

	private Carrinho carrinho;
	private Produto cpu;
	private Produto gpu;
	
	
	@BeforeAll
	static public void print() {
		System.out.println("Iniciando o teste com 'BeforeAll'");
	}
	@AfterAll
	static public void print_after() {
		System.out.println("Encerrando o teste com AfterAll");
	}
	@BeforeEach
	public void initialize() {
		carrinho = new Carrinho();
		cpu = new Produto("Ryzen 7", 900.00);
		gpu = new Produto("RTX 3060", 1600.00);
	}
	
	@DisplayName("Teste adiciona item")
	@Test
	public void addItem() {	
		carrinho.addItem(cpu);
		carrinho.addItem(gpu);
		
		Assertions.assertEquals(2, carrinho.getQtdeItems());
		System.out.println("Rodei o teste 'addItem'");

	}
	
	@Test
	public void deleteItem() {
		
	}

}
