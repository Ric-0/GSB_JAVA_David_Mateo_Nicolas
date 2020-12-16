package gsb.modele.dao;
import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.ConnexionMySql;

public class stockerDao {


	public static int ajoutEchant(Stocker unStock) {
		String matricule=unStock.getUnVisiteur().getMatricule();
		String medDepotLegal=unStock.getUnMedicament().getDepotLegal();
		int qte= unStock.getQteStock();
		int ResultatReq=0;
		try{
			ResultatReq=ConnexionMySql.execReqMaj("INSERT INTO STOCKER VALUES('"+qte+"','"+matricule+"','"+medDepotLegal+"')");
			ConnexionMySql.fermerConnexionBd();
		}catch(Exception e){
			
			System.out.println("Erreur lors de l'insertion : INSERT INTO STOCKER VALUES('"+qte+"','"+matricule+"','"+medDepotLegal+")");
		}
		return ResultatReq;
	}


public static ArrayList<Stocker> retournerLesStocks(){
	
	ArrayList<Stocker> LesStocks;
	LesStocks=new ArrayList<Stocker>();
	int cpt =0;
	
	try{
		
		ResultSet ResultatReq=ConnexionMySql.execReqSelection("SELECT * FROM STOCKER");
		
		while(ResultatReq.next()){
			
			
			String unMatricule = ResultatReq.getString(2);
			String unDepotLegal = ResultatReq.getString(3);
		    Stocker UnStock=new Stocker(ResultatReq.getInt(1), VisiteurDao.rechercher(unMatricule), MedicamentDao.rechercher(unDepotLegal));
			LesStocks.add(UnStock);

		}
		
	}catch(Exception e){
		System.out.println(" Erreur lors de la requête : SELECT * FROM STOCKER");	
	}
	
	return LesStocks;
	
}

}


