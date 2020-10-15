package gsb.modele.dao;
import gsb.modele.Stocker;
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
}
