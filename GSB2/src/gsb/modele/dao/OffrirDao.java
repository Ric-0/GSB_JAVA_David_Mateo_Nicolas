package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;

public class OffrirDao {
	public static int creer(Offrir uneOffre) {
		String refVisite = uneOffre.getUneVisite().getReference();
		String medDepotLegal = uneOffre.getUnMedicament().getDepotLegal();
		int qte = uneOffre.getQteOfferte();
		int ResultatReq = 0;
		try {
			ResultatReq = ConnexionMySql.execReqMaj("INSERT INTO OFFRIR VALUES("+qte+",'"+medDepotLegal+"','"+refVisite+"')");
			ConnexionMySql.fermerConnexionBd();
		}catch(Exception e) {
			System.out.println("Erreur lors de l'insertion : INSERT INTO OFFRIR VALUES("+qte+",'"+medDepotLegal+"','"+refVisite+"')");
		}
		return ResultatReq;
	}
	public static ArrayList<Offrir> rechercherViaVisite(String refVisite) {
		ArrayList<Offrir> lesDons = new ArrayList<Offrir>();
		try {
			ResultSet ResultatReq = ConnexionMySql.execReqSelection("SELECT * FROM OFFRIR WHERE REFERENCE = '"+refVisite+"';");
			while(ResultatReq.next()) {
				Medicament uneMed = MedicamentDao.rechercher(ResultatReq.getString(2));
				Visite uneVisite = VisiteDao.rechercher(ResultatReq.getString(3));
				Offrir uneOffre = new Offrir(uneMed,uneVisite,ResultatReq.getInt(1));
				lesDons.add(uneOffre);
			}
		}catch(Exception e) {
			System.out.println("Erreur lors de la requête : SELECT * FROM OFFRIR WHERE REFERENCE = '"+refVisite+"';");
		}
		return lesDons;
	}
	public static Offrir rechercher(String depLeg,String ref) {
		Offrir uneOffre = null;
		try {
			ResultSet ResultatReq = ConnexionMySql.execReqSelection("SELECT * FROM OFFRIR WHERE REFERENCE = '"+ref+"' AND '"+depLeg+"'");
			if(ResultatReq.next()) {
				uneOffre = new Offrir(MedicamentDao.rechercher(ResultatReq.getString(1)),VisiteDao.rechercher(ResultatReq.getString(2)),ResultatReq.getInt(3));
			}
			ConnexionMySql.fermerConnexionBd();
		}
		catch(Exception e) {
			System.out.println("Erreur lors de la requête : SELECT * FROM OFFRIR WHERE REFERENCE = '"+ref+"' AND '"+depLeg+"';");
		}
		return uneOffre;
	}
	public static void modifier(String refB,String dlB,String depLeg, int qte) {
		System.out.println("dao : "+qte);
		try {
			if(dlB == depLeg) {
				ConnexionMySql.execReqMaj("UPDATE OFFRIR SET QTEOFFERTE = "+qte+" WHERE REFERENCE = '"+refB+"' AND DEPOTLEGAL = '"+dlB+"'");
				ConnexionMySql.fermerConnexionBd();
			}
			else {
				ConnexionMySql.execReqMaj("DELETE FROM OFFRIR WHERE REFERENCE = '"+refB+"' AND DEPOTLEGAL = '"+dlB+"'");
				Offrir uneOffre = new Offrir(MedicamentDao.rechercher(depLeg),VisiteDao.rechercher(refB),qte);
				creer(uneOffre);
			}
		}
		catch(Exception e) {
			System.out.println("Erreur lors de la requete : UPDATE OFFRIR SET QTEOFFERTE = "+qte+" AND DEPOTLEGAL = '"+depLeg+"' WHERE REFERENCE = '"+refB+"' AND DEPOTLEGAL = '"+dlB+"'");
		}
	}
}
