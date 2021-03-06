package gsb.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

public class VisiteService {

	public static Visite rechercherVisite(String referenceVisite) {

		Visite LaVisite = null;

		try {

			if (referenceVisite == null) {

				throw new Exception("Donn�e obligatoire : La r�f�rence de la visite ne peut �tre vide");

			}

			LaVisite = VisiteDao.rechercher(referenceVisite);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return LaVisite;

	}

	public static Visiteur rechercherVisiteur(String LeMatriculeVisiteur) {

		Visiteur LeVisiteur = null;

		try {
			if (LeMatriculeVisiteur == null) {

				throw new Exception("Donn�e obligatoire : Le Matricule du Visiteur ne peut �tre vide");

			}

			LeVisiteur = VisiteurDao.rechercher(LeMatriculeVisiteur);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return LeVisiteur;
	}

	public static Medecin rechercherMedecin(String LecodeMedecin) {

		Medecin LeMedecin = null;

		try {
			if (LecodeMedecin == null) {

				throw new Exception("Donn�e obligatoire :Le code du medecin ne peut �tre vide");

			}
			LeMedecin = MedecinService.rechercherMedecin(LecodeMedecin);
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		return LeMedecin;
	}

	public static int creerVisite(String UneReference, String UneDate, String UnCommentaire, String codeMedecin,
			String MatriculeVisiteur) {

		int resultat = 0;
		Visite UneVisite;

	
		

		try {

			if (UneReference == null || UneDate == null || UnCommentaire == null || codeMedecin == null || MatriculeVisiteur == null) {

				throw new Exception(
						"Donn�es obligatoires :Une Reference, Une Date, Un Commentaire, Le code du Medecin, le Matricule du Visiteur ");
			}

			if (VisiteDao.rechercher(UneReference) != null) {

				throw new Exception("La r�f�rence " + UneReference + " existe d�j�");

			}
			
			// Creer l'expression r�guli�re pour la date
			
			String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(UneDate);
            
			// fin de la cr�ation de l'expression r�guli�re
			
			if (!matcher.matches()) {

				throw new Exception("Le format de la date doit �tre : jj/mm/yyyy");

			}

			if (rechercherMedecin(codeMedecin) == null) {

				throw new Exception("Le code du Medecin " + codeMedecin + " est introuvable");

			}

			if (rechercherVisiteur(MatriculeVisiteur) == null) {

				throw new Exception("Le matricule du visteur " + MatriculeVisiteur + " est introuvable");

			}

			UneVisite = new Visite(UneReference, UneDate, UnCommentaire, MedecinDao.rechercher(codeMedecin),
					VisiteurDao.rechercher(MatriculeVisiteur));
			resultat = VisiteDao.creer(UneVisite);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		return resultat;

	}
	
	public static int modifierVisite(String UneReference, String UneDate, String UnCommentaire, String codeMedecin,
			String MatriculeVisiteur) {

		int resultat = 0;

		
		try {

			if (UneReference == null || UneDate == null || UnCommentaire == null || codeMedecin == null || MatriculeVisiteur == null) {

				throw new Exception(
						"Donn�es obligatoires :Une Reference, Une Date, Un Commentaire, Le code du Medecin, le Matricule du Visiteur ");
			}

			if(rechercherVisite(UneReference) == null) {
				
				throw new Exception("La reference de la visite " + UneReference +" n'existe pas");
			}

			// Creer l'expression r�guli�re pour la date

			String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
	
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(UneDate);
	
			// fin de la cr�ation de l'expression r�guli�re

			if (!matcher.matches()) {

				throw new Exception("Le format de la date doit �tre : jj/mm/yyyy");

			}

			if (rechercherMedecin(codeMedecin) == null) {

				throw new Exception("Le code du Medecin " + codeMedecin + " est introuvable");

			}

			if (rechercherVisiteur(MatriculeVisiteur) == null) {

				throw new Exception("Le matricule du visteur " + MatriculeVisiteur + " est introuvable");

			}
			
			resultat = VisiteDao.modifier(UneReference,UneDate,UnCommentaire,codeMedecin,MatriculeVisiteur);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return resultat;
	}
	
	public static ArrayList<Visite> rechercherListeVisite(String matricule, String date){
		ArrayList<Visite> lesVisites = null;
		try {
			if(matricule == null) {
				throw new Exception("Le matricule du visiteur est obligatoire");
			}
			if(date == null) {
				throw new Exception("La date est obligatoire");
			}
			String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(date);
			
			if (!matcher.matches()) {
				throw new Exception("Le format de la date doit �tre : jj/mm/yyyy");
			}
			if(rechercherVisiteur(matricule) == null) {
				throw new Exception("Le matricule du visiteur " +matricule + " est introuvable");
			}
			lesVisites = VisiteDao.rechercherVisite(matricule,date);
			if(lesVisites == null) {
				throw new Exception("Aucun visite pour le visiteur "+matricule+" � la date "+date);
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return lesVisites;
	}

}
