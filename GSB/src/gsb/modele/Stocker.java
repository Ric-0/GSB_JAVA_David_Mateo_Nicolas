package gsb.modele;

public class Stocker {

	@Override
	public String toString() {
		return "Stocker [qteStock=" + qteStock + ", unVisiteur=" + unVisiteur + ", unMedicament=" + unMedicament + "]";
	}


	protected String qteStock;
	public Visiteur unVisiteur;
	public Medicament unMedicament;

	
	public Stocker(String UneqteStock, Visiteur UnVisiteur, Medicament UnMedicament){
		
		this.qteStock=UneqteStock;
		this.unVisiteur=UnVisiteur;
		this.unMedicament=UnMedicament;
		
		
	}


	public String getQteStock() {
		return qteStock;
	}


	public void setQteStock(String qteStock) {
		this.qteStock = qteStock;
	}


	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}


	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}


	public Medicament getUnMedicament() {
		return unMedicament;
	}


	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}
	
	
	
}
