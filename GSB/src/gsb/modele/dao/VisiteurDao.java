package gsb.modele.dao;

import java.sql.ResultSet;

import java.util.ArrayList;


import gsb.modele.Localite;
import gsb.modele.Visiteur;

public class VisiteurDao {

	
	public static Visiteur rechercher(String matricule){
		
		Visiteur UnVisiteur=null;
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM VISITEUR WHERE MATRICULE='"+matricule+"'");
			
			if(ResultatReq.next()){

				UnVisiteur=new Visiteur(ResultatReq.getString(1),ResultatReq.getString(2),ResultatReq.getString(3),ResultatReq.getString(4),ResultatReq.getString(5),ResultatReq.getString(6),LocaliteDao.rechercher(ResultatReq.getString(7)),"",ResultatReq.getString(8),ResultatReq.getString(9));
				
			}
			
			
		}catch(Exception e){
			
			System.out.println("Erreur lors de la requête : SELECT * FROM VISITEUR WHERE MATRICULE='+matricule+'");
			
		}
		
		return UnVisiteur;
	}
	
	
	
	public static int creer(Visiteur UnVisiteur){
		
		 String matricule=UnVisiteur.getMatricule();
		 String nom=UnVisiteur.getNom();
         String prenom=UnVisiteur.getPrenom();
		 String login=UnVisiteur.getLogin();
	     String mdp=UnVisiteur.getMdp();
		 String adresse=UnVisiteur.getAdresse();
		 Localite uneLocalite=UnVisiteur.getUneLocalite();
		 String codePostal=uneLocalite.getCodePostal();
		// String telephone=UnVisiteur.getTelephone();
		 
		 String dateEntree=UnVisiteur.getDateEntree();	 
		 
		 //int prime=UnVisiteur.getPrime();
		 String codeUnite=UnVisiteur.getCodeUnite();
		 String nomUnite=UnVisiteur.getNomUnite();
		
		 int ResultatReq=0;
		 
		 try{
			 
			 ResultatReq=ConnexionMySql.execReqMaj("INSERT INTO VISITEUR VALUES('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+codePostal+"','"+dateEntree+"','"+codeUnite+"','"+nomUnite+"')");
			 ConnexionMySql.fermerConnexionBd();
			 
		 }catch(Exception e){
			 
			 
			 System.out.println("Erreur lors de l'insertion : INSERT INTO VISITEUR VALUES('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+codePostal+"','"+dateEntree+"','"+codeUnite+"','"+nomUnite+"')");
			 
		 }
		
		return ResultatReq;
	}
	
	
	public static ArrayList<Visiteur> retournerLesVisiteurs(){
		
		ArrayList<Visiteur> LesVisiteurs;
		LesVisiteurs=new ArrayList<Visiteur>();
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM VISITEUR");
			
			while(ResultatReq.next()){
				
			    Visiteur UnVisiteur=new Visiteur(ResultatReq.getString(1),ResultatReq.getString(2),ResultatReq.getString(3),ResultatReq.getString(4),ResultatReq.getString(5),ResultatReq.getString(6),LocaliteDao.rechercher(ResultatReq.getString(7)),"",ResultatReq.getString(8),ResultatReq.getString(9));
				LesVisiteurs.add(UnVisiteur);
				
			}
			
		}catch(Exception e){
			
			System.out.println(" Erreur lors de la requête : SELECT * FROM VISITEUR");
			
			
		}
		
		return LesVisiteurs;
		
	}
	
}
