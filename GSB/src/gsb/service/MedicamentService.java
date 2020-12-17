package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {

	public static Medicament rechercher(String depotLeg) {
		Medicament unMedic = null;
		try {
			if (depotLeg == null) {
				throw new Exception("Le champ ne peut �tre vide.");
			}
			if (MedicamentDao.rechercher(depotLeg) == null) {
				throw new Exception("Pas de m�dicament avec ce d�pot l�gal.");
			}
			
			unMedic = MedicamentDao.rechercher(depotLeg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unMedic;
	}
}
