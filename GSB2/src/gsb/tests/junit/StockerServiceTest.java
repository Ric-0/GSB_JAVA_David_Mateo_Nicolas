package gsb.tests.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.service.StockerService;
import junit.framework.TestCase;

public class StockerServiceTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public final void testAjoutEchantQteNull() {
		assertEquals(0,StockerService.ajoutEchant(null, "PL56", "IBU20"));
	}
	
	public final void testAjoutEchantQteSup() {
		assertEquals(0,StockerService.ajoutEchant("-1", "PL56", "IBU20"));
	}
	
	public final void testAjoutEchantMatriNull() {
		assertEquals(0,StockerService.ajoutEchant("2", null, "IBU20"));
	}

	public final void testAjoutEchantDepNull() {
		assertEquals(0,StockerService.ajoutEchant("2", "PL56", null));
	}
	
	public final void testAjoutEchantDepExistant() {
		assertEquals(0, StockerService.ajoutEchant("1", "PL56", "blbl"));
	}
	
	public final void testAjoutEchantMatriExistant() {
		assertEquals(0, StockerService.ajoutEchant("1", "blbl", "IBU20"));
	}
	public final void testQteNonNulle() {
		assertEquals(0, StockerService.ajoutEchant("0", "PL56", "IBU20"));
	}
	
	public final void testRetournerLesStocksSpecifiquesMatriNull() {
		assertNull(StockerService.retournerLesStocksSpecifiques(null));
	}
	
}
