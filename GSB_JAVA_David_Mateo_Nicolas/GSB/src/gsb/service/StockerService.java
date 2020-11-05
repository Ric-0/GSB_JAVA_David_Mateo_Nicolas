package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;
import gsb.modele.dao.stockerDao;

public class StockerService {

	public static int ajoutEchant(int uneqteStock, String matricule, String depotLeg) {
		int verif = 0;
		try {
			if (matricule == null || depotLeg == null || uneqteStock == 0) {
			throw new Exception ("Tous les champs doivent être remplis.");
			}
			
			if (uneqteStock > 0) {
			throw new Exception ("La quantité doit être > à 0");
			}
			
			if (VisiteurDao.rechercher(matricule) != null) {
			throw new Exception ("Pas de visiteur avec ce matricule.");
			}
			
			if (MedicamentDao.rechercher(depotLeg) != null) {
			throw new Exception ("Pas de médicament avec ce dépot légal.");
			}
			
			// TODO vérifier que le stock n'existe pas déjà (liaison dépotlégal et matricule)

				Visiteur visiteur = VisiteurDao.rechercher(matricule);
				Medicament medicament = MedicamentDao.rechercher(depotLeg);
				Stocker UnStock = new Stocker(uneqteStock, visiteur, medicament);
				stockerDao.ajoutEchant(UnStock);
				verif =1;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return verif;

	}
}