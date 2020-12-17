package gsb.service;

import java.util.ArrayList;

import gsb.modele.Offrir;
import gsb.modele.dao.OffrirDao;

public class OffrirService {
	public static Offrir rechercherOffre(String depLeg,String ref) {
		Offrir uneOffre = null;
		try {
			if(ref == null) {
				throw new Exception("Donnée obligatoire : La référence de la visite ne peut être vide");
			}
			if(depLeg == null) {
				throw new Exception("Donnée obligatoire : Le depot legal ne peut être vide");
			}
			uneOffre = OffrirDao.rechercher(depLeg,ref);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return uneOffre;
	}
	public static ArrayList<Offrir> rechercherOffreViaVisite(String ref){
		ArrayList<Offrir> lesOffres = null;
		try {
			if(ref == null) {
				throw new Exception("Donnée obligatoire : La référence de la visite ne peut être vide");
			}
			if(OffrirDao.rechercherViaVisite(ref) == null) {
				throw new Exception("La reference de la visite "+ref+" est introuvable");
			}
			lesOffres = OffrirDao.rechercherViaVisite(ref);
			if(lesOffres == null) {
				throw new Exception("Aucun offre pour la visite "+ref);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lesOffres;
	}
	public static void creerOffre(String depLeg,String ref,int qte) {
		Offrir uneOffre;
		try {
			if(depLeg == null || ref == null || Integer.toString(qte) == null) {
				throw new Exception("Données obligatoires : Depot Legal, Reference, Quantité offerte");
			}
			if(MedicamentService.rechercher(depLeg) == null) {
				throw new Exception("Le dépot legal "+depLeg+" est inexistant");
			}
			if(VisiteService.rechercherVisite(ref) == null) {
				throw new Exception("La visite "+ref+" n'existe pas");
			}
			uneOffre = new Offrir(MedicamentService.rechercher(depLeg),VisiteService.rechercherVisite(ref),qte);
			OffrirDao.creer(uneOffre);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void modifierOffre(String refB,String dlB, String depLeg, int qte) {
		System.out.println("Service : "+qte);
		try {
			if(depLeg == null || Integer.toString(qte) == null || refB == null) {
				throw new Exception("Données obligatoires : Depot Legal, Reference, Quantité offerte");
			}
			if(MedicamentService.rechercher(depLeg) == null) {
				throw new Exception("Le dépot legal "+depLeg+" est inexistant");
			}
			if(VisiteService.rechercherVisite(refB) == null) {
				throw new Exception("La visite "+refB+" n'existe pas");
			}
			OffrirDao.modifier(refB,dlB,depLeg,qte);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
