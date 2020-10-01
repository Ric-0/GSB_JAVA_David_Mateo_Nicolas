package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import gsb.modele.Localite;
import gsb.modele.Visiteur;

public class VisiteurDao {

	
	public static Visiteur rechercher(String matricule){
		
		Visiteur UnVisiteur=null;
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM visiteur WHERE MATRICULE='"+matricule+"'");
			
			if(ResultatReq.next()){
				
				Date date=new Date(ResultatReq.getTimestamp(8).getTime());
				UnVisiteur=new Visiteur(ResultatReq.getString(1),ResultatReq.getString(2),ResultatReq.getString(3),ResultatReq.getString(4),ResultatReq.getString(5),ResultatReq.getString(6),LocaliteDao.rechercher(ResultatReq.getString(7)),"",date,0,ResultatReq.getString(9),ResultatReq.getString(10));
				
			}
			
			
		}catch(Exception e){
			
			System.out.println("Erreur lors de la requête : SELECT * FROM visiteur WHERE MATRICULE='"+matricule+"'");
			
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
		 String telephone=UnVisiteur.getTelephone();
		 
		 Date dateEntree=UnVisiteur.getDateEntree();
		 
		 Timestamp ts=new Timestamp(dateEntree.getTime());
		 
		 
		 int prime=UnVisiteur.getPrime();
		 String codeUnite=UnVisiteur.getCodeUnite();
		 String nomUnite=UnVisiteur.getNomUnite();
		
		 int ResultatReq=0;
		 
		 try{
			 
			 ResultatReq=ConnexionMySql.execReqMaj("INSERT INTO visiteur VALUES('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+codePostal+"','"+ts+"','"+codeUnite+"','"+nomUnite+"')");
			 ConnexionMySql.fermerConnexionBd();
			 
		 }catch(Exception e){
			 
			 
			 System.out.println("Erreur lors de l'insertion : INSERT INTO visiteur VALUES('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+codePostal+"','"+ts+"','"+codeUnite+"','"+nomUnite+"')");
			 
		 }
		
		return ResultatReq;
	}
	
	
	public static ArrayList<Visiteur> retournerLesVisiteurs(){
		
		ArrayList<Visiteur> LesVisiteurs;
		LesVisiteurs=new ArrayList<Visiteur>();
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM visiteur");
			
			while(ResultatReq.next()){
				
				Date date=new Date(ResultatReq.getTimestamp(8).getTime());
			    Visiteur UnVisiteur=new Visiteur(ResultatReq.getString(1),ResultatReq.getString(2),ResultatReq.getString(3),ResultatReq.getString(4),ResultatReq.getString(5),ResultatReq.getString(6),LocaliteDao.rechercher(ResultatReq.getString(7)),"",date,0,ResultatReq.getString(9),ResultatReq.getString(10));
				LesVisiteurs.add(UnVisiteur);
				
			}
			
		}catch(Exception e){
			
			System.out.println(" Erreur lors de la requête : SELECT * FROM visiteur");
			
			
		}
		
		return LesVisiteurs;
		
	}
	
}
