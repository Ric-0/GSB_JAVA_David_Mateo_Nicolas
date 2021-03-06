package gsb.tests;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Stocker;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.utils.AffichageModele;

public class TestsDesModeles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Localite LocaliteVisiteur =new Localite("56290","Port-Louis");
		Localite LocaliteMedecin=new Localite("56570","Locmiqu�lic");
		
		AffichageModele.afficher(LocaliteVisiteur);
		System.out.println("------------------------------------");
		AffichageModele.afficher(LocaliteMedecin);
		System.out.println("=====================================");
		
		Medecin UnMedecin=new Medecin("474921JFRA56","Jean","Pierre","38 rue de l'�glise","02-48-78-90-74","test","virulogie",LocaliteMedecin );
		AffichageModele.afficher(UnMedecin);
		System.out.println("=====================================");
		
		Visiteur UnVisiteur=new Visiteur("PLL56","Lego","Philipe","plego","cbhjds","17 rue j-f de surville",LocaliteVisiteur,"02-97-17-38-16","10/09/2019","uo863");
		AffichageModele.afficher(UnVisiteur);
		System.out.println("=====================================");
		
		Medicament UnMedicament=new Medicament("IBU20","ibuprofen","Excipients : Acide st�arique, Amidon pr�g�latinis�, Cellulose microcristalline, Hypromellose, Macrogol 40 st�arate, Povidone K 90, Sepifilm blanc, Silice collo�dale anhydre, Sodium carboxym�thylamidon, Titane dioxyde","Ce m�dicament est un anti-inflammatoire non st�ro�dien (AINS). Il lutte contre l inflammation et la douleur, fait baisser la fi�vre et fluidifie le sang.","grossesse",(float) 0.30,"","Anti-inflammatoire non st�ro�dien");
		AffichageModele.afficher(UnMedicament);
		System.out.println("=====================================");
		
		Visite UneVisite=new Visite("JPPLL56","01/01/2020","RAS",UnMedecin,UnVisiteur);
		AffichageModele.afficher(UneVisite);
		System.out.println("=====================================");
		
		Offrir UneOffre=new Offrir(UnMedicament,UneVisite,200);
		AffichageModele.afficher(UneOffre);
		System.out.println("=====================================");
		
		Stocker UnStock=new Stocker("25",UnVisiteur,UnMedicament);
		AffichageModele.afficher(UnStock);
	}

}
