package gsb.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;
import gsb.modele.dao.StockerDao;

public class StockerService {

	public static int ajoutEchant(String uneqteStock, String matricule, String depotLeg) {
		int verif = 0;
		try {
			if (matricule == null) {
				throw new Exception("Tous les champs doivent être remplis.");
			}
			if (uneqteStock == null) {
				throw new Exception("Tous les champs doivent être remplis.");
			}
			if (depotLeg == null) {
				throw new Exception("Tous les champs doivent être remplis.");
			}
			if (uneqteStock == "0") {
				throw new Exception("La quantité ne peut être nulle.");
			}

			if (Integer.parseInt(uneqteStock) < 0) {

				throw new Exception("La quantité doit être > à 0");
			}

			if (VisiteurDao.rechercher(matricule) == null) {

				throw new Exception("Pas de visiteur avec ce matricule.");
			}

			if (MedicamentDao.rechercher(depotLeg) == null) {

				throw new Exception("Pas de médicament avec ce dépot légal.");
			}

			if (StockerDao.retournerUnStock(matricule, depotLeg) != null) {

				ResultSet ResultatReq = ConnexionMySql.execReqSelection(
						"SELECT * FROM STOCKER WHERE MATRICULE='" + matricule + "' AND DEPOTLEGAL ='" + depotLeg + "'");

				while (ResultatReq.next()) {

					int x = (ResultatReq.getInt(1));

					uneqteStock = String.valueOf(Integer.parseInt(uneqteStock) + x);

					ConnexionMySql.execReqMaj("UPDATE STOCKER SET QTESTOCK = '"+ uneqteStock+"' WHERE MATRICULE= '" + matricule
							+ "' AND DEPOTLEGAL = '" + depotLeg + "'");

				}
			} else {

				Visiteur visiteur = VisiteurDao.rechercher(matricule);
				Medicament medicament = MedicamentDao.rechercher(depotLeg);
				Stocker UnStock = new Stocker(uneqteStock, visiteur, medicament);
				StockerDao.ajoutEchant(UnStock);
				verif = 1;

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return verif;
	}

	public static ArrayList<Stocker> retournerLesStocksSpecifiques(String matricule) {
		ArrayList<Stocker> lesStocks = new ArrayList<Stocker>();
		lesStocks = null;
		try {
			if (VisiteService.rechercherVisiteur(matricule) == null) {
				throw new Exception("Le visiteur n'existe pas.");
			}
			lesStocks = StockerDao.retournerLesStocksSpecifiques(matricule);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lesStocks;
	}
}