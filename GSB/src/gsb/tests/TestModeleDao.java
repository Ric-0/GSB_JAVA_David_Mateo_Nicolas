package gsb.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.AffichageModele;

public class TestModeleDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(LocaliteDao.rechercher("13012"));
		
		System.out.println("----------------------------------------------");
		
		Localite uneLocalite= new Localite("54621","test");
		
		System.out.println("----------------------------------------------");
		
		LocaliteDao.creer(uneLocalite);
		
		
		System.out.println(LocaliteDao.retournerLesLocalites());
		
		System.out.println("========================================");
		
		AffichageModele.afficher(MedecinDao.rechercher("m001"));
		
		System.out.println("----------------------------------------------");
		
		Medecin UnMedecin=new Medecin("m021","Jean","Pierre","38 rue de la forêt","02-48-78-90-74","test","virulogie",uneLocalite);
		MedecinDao.creer(UnMedecin);
		
		System.out.println("----------------------------------------------");
		
		
		System.out.println(MedecinDao.retournerLesMedecins());
		
		System.out.println("========================================");
		
		AffichageModele.afficher(MedicamentDao.rechercher("3MYC7"));
		
		System.out.println("----------------------------------------------");
		
		Medicament UnMedicament=new Medicament("IBU20","ibuprofen","Excipients : Acide stéarique, Amidon prégélatinisé, Cellulose microcristalline, Hypromellose, Macrogol 40 stéarate, Povidone K 90, Sepifilm blanc, Silice colloïdale anhydre, Sodium carboxyméthylamidon, Titane dioxyde","Ce médicament est un anti-inflammatoire non stéroïdien (AINS). Il lutte contre l inflammation et la douleur, fait baisser la fièvre et fluidifie le sang.","grossesse",(float) 0.30,"","Anti-inflammatoire non stéroïdien");
		MedicamentDao.creer(UnMedicament);
		
		System.out.println("----------------------------------------------");
		
		System.out.println(MedicamentDao.retournerLesMedicaments());
		
		System.out.println("========================================");
		
		
		AffichageModele.afficher(VisiteDao.rechercher("v0001"));
		System.out.println("----------------------------------------------");
		String DateStr1="17/03/2001 15:55:59";
		DateFormat df1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date1=null;
		try{
			date1=df1.parse(DateStr1);
		}catch(ParseException e){
			
			e.printStackTrace();
		}
		
		Visite UneVisite=new Visite("v0024",date1,"RAS",UnMedecin,VisiteurDao.rechercher("a131"));
		VisiteDao.creer(UneVisite);
		
		System.out.println("----------------------------------------------");
		
		System.out.println(VisiteDao.retournerLesVisites());
		
		System.out.println("========================================");
		
		AffichageModele.afficher(VisiteurDao.rechercher("a131"));
		
		
		String DateStr2="17/03/2001 15:30:00";
		DateFormat df2=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date2=null;
		try{
			date2=df2.parse(DateStr2);
		}catch(ParseException e){
			
			e.printStackTrace();
		}
		
		Visiteur UnVisiteur=new Visiteur("PL56","Lego","Philipe","plego","cbhjds","17 rue j-f de surville",uneLocalite,"02-97-17-38-16",date2,300,"uo863","test");
		
		System.out.println("----------------------------------------------");
		
		VisiteurDao.creer(UnVisiteur);
		
		System.out.println("----------------------------------------------");
		
		System.out.println(VisiteurDao.retournerLesVisiteurs());
		
		
	}

}
