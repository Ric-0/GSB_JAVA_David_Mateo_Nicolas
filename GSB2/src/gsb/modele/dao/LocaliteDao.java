package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.dao.ConnexionMySql;
import gsb.modele.Localite;

public class LocaliteDao {
//rico test
	
	public static Localite rechercher(String codeLocalite){
		
		Localite uneLocalite=null;
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM LOCALITE WHERE CODEPOSTAL='"+codeLocalite+"'");
			
			if(ResultatReq.next()){
			
				uneLocalite=new Localite(ResultatReq.getString(1),ResultatReq.getString(2));
			
			}
		}catch(Exception e){
			
			System.out.println("Erreur de requ�te : SELECT * FROM LOCALITE WHERE CODEPOSTAL='"+codeLocalite+"'");
			
		}
		
		
		return uneLocalite;
		
		
	}
	
	public static int creer(Localite uneLocalite){
		
		String codePostal=uneLocalite.getCodePostal();
		String ville=uneLocalite.getVille();
		int ResultatReq=0;
		
		try{
			
		 ResultatReq=ConnexionMySql.execReqMaj("INSERT INTO LOCALITE VALUES('"+codePostal+"','"+ville+"')");
		ConnexionMySql.fermerConnexionBd();	
			
		}catch(Exception e){
			
			
			System.out.println("Erreur lors de l'insertion : INSERT INTO LOCALITE VALUES('"+codePostal+"','"+ville+"')");
			
		}
		
		return ResultatReq;
		
	}
	
	public static ArrayList<Localite> retournerLesLocalites(){
		
		ArrayList<Localite> LesLocalites;
		LesLocalites=new ArrayList<Localite>();
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM LOCALITE");
			
			while(ResultatReq.next()){
				
			Localite UneLocalite=new Localite(ResultatReq.getString(1), ResultatReq.getString(2));
				
			LesLocalites.add(UneLocalite);
				
			}
			
		}catch(Exception e){
			
			
			System.out.println("Erreur lors de l'insertion : SELECT * FROM LOCALITE");
		}
		
		return LesLocalites;
	}
	
	
	
}
