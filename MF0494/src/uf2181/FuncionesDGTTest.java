package uf2181;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FuncionesDGTTest {
	
	private static FuncionesDGT funcionesdgt;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
			funcionesdgt = new FuncionesDGT();
		
	}
 
	@Test
	void mediaPuntosTest() {
		int v[] = {8, 5 ,1 , 9, 4, 3};
		int v2[] = new int[0];
		assertEquals(5, funcionesdgt.mediaPuntos(v));
		assertThrows(ArrayIndexOutOfBoundsException.class, ()-> funcionesdgt.mediaPuntos(v2));
		int v3[] = {0, 0 ,0 , 0, 0, 0};
		assertEquals(0, funcionesdgt.mediaPuntos(v3));
	}
	
	@Test
	void maximaTasaPermitidaTest() {
		assertEquals(0.25, funcionesdgt.maximaTasaPermitida("General", true));
		assertEquals(0.5, funcionesdgt.maximaTasaPermitida("General", false));
		assertEquals(0.15, funcionesdgt.maximaTasaPermitida("Novel", true));
		assertEquals(0.3, funcionesdgt.maximaTasaPermitida("Novel", false));

		
	}

}
