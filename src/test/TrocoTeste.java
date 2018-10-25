package test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import troco.Troco;

class TrocoTeste {

	@Test
	public void darTrocoContabilizadoTeste()
	{
		Map<String, Integer> quantidade = Troco.darTrocoContabilizado(500);
		Troco.imprimirTroco(quantidade);
		
		Map.Entry<String, Integer> someEntry = quantidade.entrySet().iterator().next();
	    Integer value = someEntry.getValue();  

		assertEquals(5, value.intValue());
		
		quantidade = Troco.darTrocoContabilizado(0.5);
		Troco.imprimirTroco(quantidade);
		
		someEntry = quantidade.entrySet().iterator().next();
	    value = someEntry.getValue();  

		assertEquals(1, value.intValue());
	}
	
	@Test
	public void entradaDadosTeste() throws Exception
	{
		assertEquals(500.0, Troco.lerValor(500.0));
	}
	

}
