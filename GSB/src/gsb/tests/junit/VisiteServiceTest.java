package gsb.tests.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.service.VisiteService;

public class VisiteServiceTest {
 
	
 @Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	
	@Test
	public final void testRechercherVisiteur() {
		
		assertNull("Resultat recherche",VisiteService.rechercherVisiteur(null));
	}

	@Test
	public final void testRechercherMedecin() {
		 
		assertNull("Resultat recherche : ",VisiteService.rechercherMedecin(null));
	}
	
    @Test
	public final void testRechercherVisite() {
	
		assertNull("Resultat recherche : ",VisiteService.rechercherVisite(null));
		
	}

	@Test
	public final void testCreerVisiterRefNull() {
		 
		assertEquals("Resultat insertion : ",0,VisiteService.creerVisite(null,"08/10/2020","RAS","m001",VisiteService.rechercherVisiteur("a131").getMatricule()));
		
	}
	
	@Test
	public final void testCreerVisiteDateNull() {
		
		assertEquals("Resultat insertion : ",0,VisiteService.creerVisite("v0054",null,"RAS","m001",VisiteService.rechercherVisiteur("a131").getMatricule()));
		
	}
	
	@Test
	public final void testCreerVisiteCommentNull() {
		
		assertEquals("Resultat insertion : ",0,VisiteService.creerVisite("v0054","08/10/2020",null,"m001",VisiteService.rechercherVisiteur("a131").getMatricule()));
		
	}
	
	@Test
	public final void testCreerVisiteCodeMedNull() {
		
		assertEquals("Resultat insertion : ",0,VisiteService.creerVisite("v0054","08/10/2020","RAS",null,VisiteService.rechercherVisiteur("a131").getMatricule()));
	
	}
	
	@Test
	public final void testCreerVisiteMatriculeNull() {
		
		assertEquals("Resultat insertion : ",0,VisiteService.creerVisite("v0054","08/10/2020","RAS","m001",null));
			
	}
	
	@Test
	public final void testCreerVisiteRefExiste() {
		
		assertEquals("Resultat insertion : ",0,VisiteService.creerVisite("v0001","08/10/2020","RAS","m001",VisiteService.rechercherVisiteur("a131").getMatricule()));
			
	}
	
	@Test
	public final void testCreerVisiteDateForm() {
		
		assertEquals("Resultat insertion : ",0,VisiteService.creerVisite("v0054","08//2020","RAS","m001",VisiteService.rechercherVisiteur("a131").getMatricule()));
		
	}
	
	@Test
	public final void testCreerVisiteCodeMedIntrouvable() {
		
		assertEquals("Resultat insertion : ",0,VisiteService.creerVisite("v0054","08/10/2020","RAS","m050",VisiteService.rechercherVisiteur("a131").getMatricule()));
	}
	
	@Test
	public final void testCreerVisiteMatriculeIntrouvable() {
		
		assertEquals("Resultat insertion : ",0,VisiteService.creerVisite("v0054","08/10/2020","RAS","m001","blblbl"));
		
	}

}