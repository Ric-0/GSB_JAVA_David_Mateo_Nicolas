
package gsb.service;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;


public class MedecinService {
	
	public static Medecin rechercherMedecin(String unCodeMedecin){
		Medecin unMedecin = null;
		try{
		if (unCodeMedecin==null) {
            throw new Exception("Donnée obligatoire : code");
        }
		unMedecin = MedecinDao.rechercher(unCodeMedecin);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedecin;
	}
	public int creerMedecin(String UnCodeMed, String UnNom, String UnPrenom, String UneAdresse, String telephone, String UnPotentiel, String UneSpecialite, Localite UneLocalite) {
		Medecin unMedecin;
		int result = 0;
		try {
			if(UnCodeMed == null || UnNom == null || UnPrenom == null || UneAdresse == null || telephone == null || UnPotentiel == null || UneSpecialite == null || UneLocalite == null) {
				throw new Exception("Données obligatoire : code, nom, prenom, adresse, tel, potentiel, spe, localite");
			}
			if(MedecinDao.rechercher(UnCodeMed) != null) {
				throw new Exception("Un medecin avec le code : "+UnCodeMed+" existe deja");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
}
