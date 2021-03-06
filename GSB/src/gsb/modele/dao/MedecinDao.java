package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Medecin;

public class MedecinDao {

	public static Medecin rechercher(String codemed){
		
			Medecin unMedecin=null;
		
		try{
				
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM MEDECIN WHERE CODEMED='"+codemed+"'");
			
			if(ResultatReq.next()){
				
				
				unMedecin=new Medecin(ResultatReq.getString(1),ResultatReq.getString(2),ResultatReq.getString(3),ResultatReq.getString(4),ResultatReq.getString(6),ResultatReq.getString(7),ResultatReq.getString(8),LocaliteDao.rechercher(ResultatReq.getString(5)));
				
			}
			
		}catch(Exception e){
			
			System.out.println("Erreur lors de la requ�te :SELECT * FROM MEDECIN WHERE CODEMED='"+codemed+"'");
			
		}
		
		return unMedecin;
		
	}
	
	
	public static int creer(Medecin unMedecin){
		
		 String codeMed=unMedecin.getCodeMed();
		 String nom=unMedecin.getNom();
		 String prenom=unMedecin.getPrenom();
		 String adresse=unMedecin.getAdresse();
		 String telephone=unMedecin.getTelephone();
		 String potentiel=unMedecin.getPotentiel();
		 String specialite=unMedecin.getSpecialite();
		 Localite uneLocalite=unMedecin.getUneLocalite();
		 String unCodePostal=uneLocalite.getCodePostal();
		 int ResultatReq=0;
		 
		 try{
			 
			 ResultatReq=ConnexionMySql.execReqMaj("INSERT INTO MEDECIN VALUES('"+codeMed+"','"+nom+"','"+prenom+"','"+adresse+"','"+unCodePostal+"','"+telephone+"','"+potentiel+"','"+specialite+"')");
			 ConnexionMySql.fermerConnexionBd();
			 
		 }catch(Exception e){
			 
			 System.out.println("Erreur lors de l'insertion : INSERT INTO MEDECIN VALUES('"+codeMed+"','"+nom+"','"+prenom+"','"+adresse+"','"+unCodePostal+"','"+telephone+"','"+potentiel+"','"+specialite+"')");
			 
		 }
		
		
		 return ResultatReq;
		
	} 
	
	public static ArrayList<Medecin> retournerLesMedecins(){
		
		
		ArrayList<Medecin> LesMedecins;
		LesMedecins=new ArrayList<Medecin>();
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM MEDECIN");
			
			while(ResultatReq.next()){
				
				Medecin UnMedecin=new Medecin(ResultatReq.getString(1),ResultatReq.getString(2),ResultatReq.getString(3),ResultatReq.getString(4),ResultatReq.getString(6),ResultatReq.getString(7),ResultatReq.getString(8),LocaliteDao.rechercher(ResultatReq.getString(5)));
				LesMedecins.add(UnMedecin);
			}
			
		}catch(Exception e){
			
			System.out.println("Erreur lors de la requ�te : SELECT * FROM MEDECIN");
			
		}
		
		return LesMedecins;
	}
	
	
}
