package jokenpo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

	public Main jogo;
	
	@BeforeEach
	public void objeto() {
		
		jogo = new Main();
	}
	
	@Test
	public void vencedor() {
		
		Assertions.assertEquals(1, jogo.jogar(1, 2));
		System.out.println("Rodei o teste Vencedor");
		
	}
	
	@Test
	public void perdedor() {
		
		Assertions.assertNotSame(1, jogo.jogar(2, 1));
		System.out.println("Rodei o teste Perdedor");
		
	}

}
