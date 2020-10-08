package gsb.utils;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Stocker;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class AffichageModele {

	//TEST 5000
	public static void afficher(Localite UneLocalite){
		
		System.out.println("Le code postal : "+UneLocalite.getCodePostal());
		System.out.println("La ville : "+UneLocalite.getVille());
		
	}
	
	public static void afficher(Medecin UnMedecin){
		
		System.out.println("Le code du médecin : "+UnMedecin.getCodeMed());
		System.out.println("Le nom du médecin : "+UnMedecin.getNom());
		System.out.println("Le prénom du médecin : "+UnMedecin.getPrenom());
		System.out.println("L'adresse du médecin :"+UnMedecin.getAdresse());
		System.out.println("Le numéro de téléphone du médecin : "+UnMedecin.getTelephone());
		System.out.println("Le potentiel : "+UnMedecin.getPotentiel());
		System.out.println("La spécialité du médecin : "+UnMedecin.getSpecialite());
		System.out.println("La localité du médecin : "+UnMedecin.getUneLocalite().getVille());
		
		
		
	}
	
	public static void afficher(Medicament UnMedicament){
		
		System.out.println("Le depot légal du médicament : "+UnMedicament.getDepotLegal());
		System.out.println("Le nom commercial du médicament : "+UnMedicament.getNomCommercial());
		System.out.println("La composition : "+UnMedicament.getComposition());
		System.out.println("Les effets : "+UnMedicament.getEffets());
		System.out.println("La contre indication : "+UnMedicament.getContreIndication());
		System.out.println("Le prix de l'échantillon : "+UnMedicament.getPrixEchantillon()+"€");
		System.out.println("Le code famille : "+UnMedicament.getCodeFamille());
		System.out.println("Le libelle de la famille : "+UnMedicament.getLibellefamille());
		
		
	}
	
	
	public static void afficher(Visite UneVisite){
		
		System.out.println("La référence de la visite : "+UneVisite.getReference());
		System.out.println("La date de la visite : "+UneVisite.getDate());
		System.out.println("Commentaire de la visite : "+UneVisite.getCommentaire());
		System.out.println("le médecin de la visite : "+UneVisite.getUnMedecin().getNom());
		System.out.println("Le visiteur de la visite : "+UneVisite.getUnVisiteur().getNom());
		
		
	}
	
	public static void afficher(Visiteur UnVisiteur){
		
		System.out.println("le matricule du visiteur : "+UnVisiteur.getMatricule());
		System.out.println("Le nom du visiteur : "+UnVisiteur.getNom());
		System.out.println("Le prénom du visiteur : "+UnVisiteur.getPrenom());
		System.out.println("Le login du visiteur : "+UnVisiteur.getLogin());
		System.out.println("Le mot de passe du visiteur : "+UnVisiteur.getMdp());
		System.out.println("L'adresse du visiteur : "+UnVisiteur.getAdresse());
		System.out.println("La localite du visiteur : "+UnVisiteur.getUneLocalite().getVille());
		System.out.println("Le numéro de téléphone du visiteur : "+UnVisiteur.getTelephone());
		System.out.println("La date d'entrée : "+UnVisiteur.getDateEntree());
		System.out.println("La prime : "+UnVisiteur.getPrime());
		System.out.println("Le code d'unite : "+UnVisiteur.getCodeUnite());
		System.out.println("Le nom de l'Unite : "+UnVisiteur.getNomUnite());
		
	}
	
	public static void afficher(Offrir UneOffre){
		
		System.out.println("Le médicament offert : "+UneOffre.getUnMedicament().getNomCommercial());
		System.out.println("La visite : "+UneOffre.getUneVisite().getReference());
		System.out.println("La quantité offerte : "+UneOffre.getQteOfferte()+"g");
		
	} 
	
	public static void afficher(Stocker UnStock){
		
		System.out.println("La quantité stocker : "+UnStock.getQteStock()+" boîte(s)");
		System.out.println("Le visiteur : "+UnStock.getUnVisiteur().getNom());
		System.out.println("Le médicament stocker : "+UnStock.getUnMedicament().getNomCommercial());
		
	}
	
	
}
