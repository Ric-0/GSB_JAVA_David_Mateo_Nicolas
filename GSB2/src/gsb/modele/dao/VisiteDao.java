package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteDao {

	public static Visite rechercher(String reference){
		
		Visite UneVisite=null;
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM VISITE WHERE REFERENCE='"+reference+"'");
			
			if(ResultatReq.next()){

				UneVisite= new Visite(ResultatReq.getString(1),ResultatReq.getString(2),ResultatReq.getString(3),MedecinDao.rechercher(ResultatReq.getString(5)),VisiteurDao.rechercher(ResultatReq.getString(4)));
				
			}
			ConnexionMySql.fermerConnexionBd();
			
		}catch(Exception e){
			
			System.out.println("Erreur lors de la requête SELECT * FROM VISITE WHERE REFERENCE='"+reference+"'");
			
			
		}
		
		return UneVisite;
	}
	
	public static ArrayList<Visite> rechercherVisite(String unMatVisiteur, String uneDate){
		ArrayList<Visite> liste = retournerLesVisites();
		ArrayList<Visite> listeVisite = new ArrayList<Visite>();
		for(int i = 0; i < liste.size();i++) {
			if(liste.get(i).getDate().equals(uneDate) && liste.get(i).getUnVisiteur().getMatricule().equals(unMatVisiteur)) {
				listeVisite.add(liste.get(i));
			}
		}
		return listeVisite;
	}
	
	public static int creer(Visite uneVisite){
		
	     String reference=uneVisite.getReference();
		 String date=uneVisite.getDate();
		 String commentaire=uneVisite.getCommentaire();
		 Medecin unMedecin=uneVisite.getUnMedecin();
		 String codeMed=unMedecin.getCodeMed();
		 Visiteur unVisiteur=uneVisite.getUnVisiteur();
		 String matricule=unVisiteur.getMatricule();
		int ResultatReq=0;
		
		try{
			
			ResultatReq=ConnexionMySql.execReqMaj("INSERT INTO VISITE VALUES('"+reference+"','"+date+"','"+commentaire+"','"+matricule+"','"+codeMed+"')");
			ConnexionMySql.fermerConnexionBd();
			
		}catch(Exception e){
			
			
			System.out.println("Erreur lors de la requête : INSERRT INTO VISITE VALUES('"+reference+"','"+date+"','"+commentaire+"','"+matricule+"','"+codeMed+"')" );
			
		}
		
		return ResultatReq;
	}
	
	
	public static ArrayList<Visite> retournerLesVisites(){
		
		ArrayList<Visite> LesVisites;
		LesVisites=new ArrayList<Visite>();
		
		try{
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM VISITE");
			while(ResultatReq.next()){

			    Visite	UneVisite= new Visite(ResultatReq.getString(1),ResultatReq.getString(2),ResultatReq.getString(3),MedecinDao.rechercher(ResultatReq.getString(5)),VisiteurDao.rechercher(ResultatReq.getString(4)));
				LesVisites.add(UneVisite);
			}
			ConnexionMySql.fermerConnexionBd();
			
		}catch(Exception e){
			
			System.out.println("Erreur lors de la requête : SELECT * FROM VISITE");
			
			
		}
		
		return LesVisites;
	}
	
	public static int modifier(String reference, String date, String commentaire, String codeMed, String matricule) {
		int ResultatReq = 0;
		
		try {
			ResultatReq = ConnexionMySql.execReqMaj("update VISITE set DATEVISITE = '"+date+"', COMMENTAIRE = '"+commentaire+"', MATRICULE = '"+matricule+"', CODEMED = '"+codeMed+"' where REFERENCE = '"+reference+"';");
			ConnexionMySql.fermerConnexionBd();
		}catch(Exception e) {
			System.out.println("Erreur lors de la requête : update VISITE set DATEVISITE = '"+date+"', COMMENTAIRE = '"+commentaire+"', MATRICULE = '"+matricule+"', CODEMED = '"+codeMed+"' where REFERENCE = '"+reference+"';");
		}
		
		return ResultatReq;
	}
	
}
