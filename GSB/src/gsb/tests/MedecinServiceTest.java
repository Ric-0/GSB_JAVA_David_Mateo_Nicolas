package gsb.tests;

import gsb.modele.Medecin;
import gsb.service.MedecinService;


public class MedecinServiceTest {


	public static void main(String[] args) {
		Medecin unMedecin = MedecinService.rechercherMedecin("m002");
		System.out.println(unMedecin.getNom());
		System.out.println(unMedecin.getPrenom());
		System.out.println(unMedecin.getAdresse());
		System.out.println(unMedecin.getUneLocalite().getCodePostal());
		System.out.println(unMedecin.getUneLocalite().getVille());
		System.out.println(unMedecin.getTelephone());
		System.out.println(unMedecin.getPotentiel());
		System.out.println(unMedecin.getSpecialite());
		
		

	}

}
