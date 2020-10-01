package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medicament;

public class MedicamentDao {

	
	public static Medicament  rechercher(String medDepotLegal){
		
		Medicament UnMedicament=null; 
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM medicament WHERE MED_DEPOTLEGAL='"+medDepotLegal+"'");
			
			if(ResultatReq.next()){
				
				UnMedicament=new Medicament(ResultatReq.getString(1),ResultatReq.getString(2),ResultatReq.getString(3),ResultatReq.getString(4),ResultatReq.getString(5),ResultatReq.getFloat(6),ResultatReq.getString(7),ResultatReq.getString(8));
				
			}
			
			
		}catch(Exception e){
			
			
			System.out.println("Erreur lors de la requête : SELECT * FROM medicament WHERE MED_DEPOTLEGAL='"+medDepotLegal+"'");
			
		}
		
		return UnMedicament;
	}
	
	
	
	public static int creer (Medicament UnMedicament){
		
		String depotLegal=UnMedicament.getDepotLegal();
		String nomCommercial=UnMedicament.getNomCommercial();
	    String composition=UnMedicament.getComposition();
		String effets=UnMedicament.getEffets();
		String contreIndication=UnMedicament.getContreIndication();
	    float prixEchantillon=UnMedicament.getPrixEchantillon();
		String codeFamille=UnMedicament.getCodeFamille();
		String libellefamille=UnMedicament.getLibellefamille();
		
		int ResultatReq=0;
		
		
		try{
			
			ResultatReq=ConnexionMySql.execReqMaj("INSERT INTO medicament VALUES('"+depotLegal+"','"+nomCommercial+"','"+composition+"','"+effets+"','"+contreIndication+"',"+prixEchantillon+",'"+codeFamille+"','"+libellefamille+"')");
			ConnexionMySql.fermerConnexionBd();
			
		}catch(Exception e){
			
			System.out.println("Erreur lors de l'insertion : INSERT INTO medicament VALUES('"+depotLegal+"','"+nomCommercial+"','"+composition+"','"+effets+"','"+contreIndication+"',"+prixEchantillon+",'"+codeFamille+"','"+libellefamille+"')");
			
		}
		
		return ResultatReq;
	}
	
	
	
	public static ArrayList<Medicament> retournerLesMedicaments(){
		
		ArrayList<Medicament> LesMedicaments;
		LesMedicaments=new ArrayList<Medicament>();
		
		try{
			
			ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM medicament");
			
			while(ResultatReq.next()){
				
			Medicament	UnMedicament=new Medicament(ResultatReq.getString(1),ResultatReq.getString(2),ResultatReq.getString(3),ResultatReq.getString(4),ResultatReq.getString(5),ResultatReq.getFloat(6),ResultatReq.getString(7),ResultatReq.getString(8));
			
			LesMedicaments.add(UnMedicament);
			
			}
			
		}catch(Exception e){
			
			System.out.println("Erreur lors de la requête : SELECT * FROM medicament ");
			
		}
		
		return LesMedicaments;
		
	}

	
	
}
