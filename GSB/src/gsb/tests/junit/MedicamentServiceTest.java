package gsb.tests.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.service.MedicamentService;

public class MedicamentServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testRechercherDepExistant() {
		assertNull("Le d�pot l�gal ne correspend � RIEN.", MedicamentService.rechercher("blbl"));
	}
	@Test
	public final void testRechercherDepNull() {
		assertNull("Le d�pot l�gal doit �tre renseign�.", MedicamentService.rechercher(null));
	}

}
