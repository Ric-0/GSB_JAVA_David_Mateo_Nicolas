package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteDao {

	public static Visite rechercher(String reference){
		
		Visite UneVisite=null;
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM visite WHERE REFERENCE='"+reference+"'");
			
			if(ResultatReq.next()){
				
				Date date=new Date(ResultatReq.getTimestamp(2).getTime());
				//String UneReference,Date UneDate,String UnCommentaire, Medecin UnMedecin, Visiteur UnVisiteur
				UneVisite= new Visite(ResultatReq.getString(1),date,ResultatReq.getString(3),MedecinDao.rechercher(ResultatReq.getString(5)),VisiteurDao.rechercher(ResultatReq.getString(4)));
				
			}
			
		}catch(Exception e){
			
			System.out.println("Erreur lors de la requête SELECT * FROM visite WHERE REFERENCE='"+reference+"'");
			
			
		}
		
		return UneVisite;
	}
	
	
	public static int creer(Visite uneVisite){
		
	     String reference=uneVisite.getReference();
		 Date date=uneVisite.getDate();
		 
		 Timestamp ts= new Timestamp(date.getTime());
		 
		 String commentaire=uneVisite.getCommentaire();
		 Medecin unMedecin=uneVisite.getUnMedecin();
		 String codeMed=unMedecin.getCodeMed();
		 Visiteur unVisiteur=uneVisite.getUnVisiteur();
		 String matricule=unVisiteur.getMatricule();
		int ResultatReq=0;
		
		try{
			
			ResultatReq=ConnexionMySql.execReqMaj("INSERT INTO visite VALUES('"+reference+"','"+ts+"','"+commentaire+"','"+matricule+"','"+codeMed+"')");
			ConnexionMySql.fermerConnexionBd();
			
		}catch(Exception e){
			
			
			System.out.println("Erreur lors de la requête : INSERRT INTO visite VALUES('"+reference+"','"+ts+"','"+commentaire+"','"+matricule+"','"+codeMed+"')" );
			
		}
		
		return ResultatReq;
	}
	
	
	public static ArrayList<Visite> retournerLesVisites(){
		
		ArrayList<Visite> LesVisites;
		LesVisites=new ArrayList<Visite>();
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM visite");
			while(ResultatReq.next()){
				
				Date date=new Date(ResultatReq.getTimestamp(2).getTime());
				//String UneReference,Date UneDate,String UnCommentaire, Medecin UnMedecin, Visiteur UnVisiteur
			    Visite	UneVisite= new Visite(ResultatReq.getString(1),date,ResultatReq.getString(3),MedecinDao.rechercher(ResultatReq.getString(5)),VisiteurDao.rechercher(ResultatReq.getString(4)));
				LesVisites.add(UneVisite);
			}
			
		}catch(Exception e){
			
			System.out.println("Erreur lors de la requête : SELECT * FROM visite");
			
			
		}
		
		return LesVisites;
	}
	
}
