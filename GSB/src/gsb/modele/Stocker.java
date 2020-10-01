package gsb.modele;

public class Stocker {

	protected int qteStock;
	public Visiteur unVisiteur;
	public Medicament unMedicament;

	
	public Stocker(int UneqteStock, Visiteur UnVisiteur, Medicament UnMedicament){
		
		this.qteStock=UneqteStock;
		this.unVisiteur=UnVisiteur;
		this.unMedicament=UnMedicament;
		
		
	}


	public int getQteStock() {
		return qteStock;
	}


	public void setQteStock(int qteStock) {
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
