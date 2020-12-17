package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {

	public static Medicament rechercher(String depotLeg) {
		Medicament unMedic = null;
		try {
			if (depotLeg == null) {
				throw new Exception("Le champ ne peut être vide.");
			}
			if (MedicamentDao.rechercher(depotLeg) == null) {
				throw new Exception("Pas de médicament avec ce dépot légal.");
			}
			
			unMedic = MedicamentDao.rechercher(depotLeg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unMedic;
	}
}
