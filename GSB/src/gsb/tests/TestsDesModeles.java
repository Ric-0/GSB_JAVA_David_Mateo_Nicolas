package gsb.tests;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

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
		Localite LocaliteMedecin=new Localite("56570","Locmiquélic");
		
		AffichageModele.afficher(LocaliteVisiteur);
		System.out.println("------------------------------------");
		AffichageModele.afficher(LocaliteMedecin);
		System.out.println("=====================================");
		
		Medecin UnMedecin=new Medecin("474921JFRA56","Jean","Pierre","38 rue de l'église","02-48-78-90-74","test","virulogie",LocaliteMedecin );
		AffichageModele.afficher(UnMedecin);
		System.out.println("=====================================");
		
		String dateString ="23/04/2005 23:11:59";
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date=null;
		try {
			date = df.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Visiteur UnVisiteur=new Visiteur("PLL56","Lego","Philipe","plego","cbhjds","17 rue j-f de surville",LocaliteVisiteur,"02-97-17-38-16",date,300,"uo863","test");
		AffichageModele.afficher(UnVisiteur);
		System.out.println("=====================================");
		
		Medicament UnMedicament=new Medicament("IBU20","ibuprofen","Excipients : Acide stéarique, Amidon prégélatinisé, Cellulose microcristalline, Hypromellose, Macrogol 40 stéarate, Povidone K 90, Sepifilm blanc, Silice colloïdale anhydre, Sodium carboxyméthylamidon, Titane dioxyde","Ce médicament est un anti-inflammatoire non stéroïdien (AINS). Il lutte contre l inflammation et la douleur, fait baisser la fièvre et fluidifie le sang.","grossesse",(float) 0.30,"","Anti-inflammatoire non stéroïdien");
		AffichageModele.afficher(UnMedicament);
		System.out.println("=====================================");
		
		Visite UneVisite=new Visite("JPPLL56",date,"RAS",UnMedecin,UnVisiteur);
		AffichageModele.afficher(UneVisite);
		System.out.println("=====================================");
		
		Offrir UneOffre=new Offrir(UnMedicament,UneVisite,200);
		AffichageModele.afficher(UneOffre);
		System.out.println("=====================================");
		
		Stocker UnStock=new Stocker(25,UnVisiteur,UnMedicament);
		AffichageModele.afficher(UnStock);
	}

}
