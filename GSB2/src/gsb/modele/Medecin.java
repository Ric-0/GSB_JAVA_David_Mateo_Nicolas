package gsb.modele;

public class Medecin {

	@Override
	public String toString() {
		return "Medecin [codeMed=" + codeMed + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", potentiel=" + potentiel + ", specialite=" + specialite
				+ ", uneLocalite=" + uneLocalite + "]";
	}


	protected String codeMed;
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String telephone;
	protected String potentiel;
	protected String specialite;
	protected Localite uneLocalite;


	public Medecin(String UnCodeMed, String UnNom, String UnPrenom, String UneAdresse, String telephone, String UnPotentiel, String UneSpecialite, Localite UneLocalite  ){
		
		this.codeMed=UnCodeMed;
		this.nom=UnNom;
		this.prenom=UnPrenom;
		this.adresse=UneAdresse;
		this.telephone=telephone;
		this.potentiel=UnPotentiel;
		this.specialite=UneSpecialite;
		this.uneLocalite=UneLocalite;
		
		
	}


	public String getCodeMed() {
		return codeMed;
	}


	public void setCodeMed(String codeMed) {
		this.codeMed = codeMed;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getPotentiel() {
		return potentiel;
	}


	public void setPotentiel(String potentiel) {
		this.potentiel = potentiel;
	}


	public String getSpecialite() {
		return specialite;
	}


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}


	public Localite getUneLocalite() {
		return uneLocalite;
	}


	public void setUneLocalite(Localite uneLocalite) {
		this.uneLocalite = uneLocalite;
	}
	
	
	
	
}
