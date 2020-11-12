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
		assertNull("La quantit� doit �tre renseign�e.", StockerService.ajoutEchant(0, "PL56", "IBU20"));
	}
	
	public final void testAjoutEchantQteSup() {
		assertEquals("Le d�pot l�gal doit �tre renseign�.", 0, StockerService.ajoutEchant(-1, "PL56", "IBU20"));
	}
	
	public final void testAjoutEchantMatriNull() {
		assertNull("Le amtricule doit �tre renseign�.", StockerService.ajoutEchant(2, null, "IBU20"));
	}

	public final void testAjoutEchantDepNull() {
		assertNull("Le d�pot l�gal doit �tre renseign�.", StockerService.ajoutEchant(2, "PL56", null));
	}
	
	public final void testAjoutEchantDepExistant() {
		assertNull("Le d�pot l�gal ne correspend � RIEN.", StockerService.ajoutEchant(1, "PL56", "blbl"));
	}
	
	public final void testAjoutEchantMatriExistant() {
		assertNull("Le d�pot l�gal ne correspend � RIEN.", StockerService.ajoutEchant(1, "blbl", "IBU20"));
	}
	
	public final void testRetournerLesStocksSpecifiquesMatriNull() {
		assertNull("Le matricule doit �tre renseign�.",StockerService.retournerLesStocksSpecifiques(null));
	}
}
