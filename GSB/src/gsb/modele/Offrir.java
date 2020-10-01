package gsb.modele;

public class Offrir {

	protected Medicament unMedicament;
	protected Visite uneVisite;
	protected int qteOfferte;
	
	
	public Offrir(Medicament UnMedicament, Visite UneVisite, int UneqteOfferte){
		
		this.unMedicament=UnMedicament;
		this.uneVisite=UneVisite;
		this.qteOfferte=UneqteOfferte;
		
	}


	public Medicament getUnMedicament() {
		return unMedicament;
	}


	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}


	public Visite getUneVisite() {
		return uneVisite;
	}


	public void setUneVisite(Visite uneVisite) {
		this.uneVisite = uneVisite;
	}


	public int getQteOfferte() {
		return qteOfferte;
	}


	public void setQteOfferte(int qteOfferte) {
		this.qteOfferte = qteOfferte;
	}
	
	
}
