package gsb.modele;

import java.util.Date;

public class Visite {

	protected String reference;
	protected Date date;
	protected String commentaire;
	protected Medecin unMedecin;
	protected Visiteur unVisiteur;

	
	public Visite(String UneReference,Date UneDate,String UnCommentaire, Medecin UnMedecin, Visiteur UnVisiteur){
		
		this.reference = UneReference;
		this.date =UneDate;
		this.commentaire = UnCommentaire;
		this.unMedecin = UnMedecin;
		this.unVisiteur = UnVisiteur;
		
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Medecin getUnMedecin() {
		return unMedecin;
	}


	public void setUnMedecin(Medecin unMedecin) {
		this.unMedecin = unMedecin;
	}


	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}


	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}
	
	

	
}
