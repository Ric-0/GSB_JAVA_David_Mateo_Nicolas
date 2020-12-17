package gsb.modele;

public class Medicament {
	  
	protected String depotLegal;
	protected String nomCommercial;
	protected String composition;
	protected String effets;
	protected String contreIndication;
	protected float prixEchantillon;
	protected String codeFamille;
	protected String libellefamille;
	
	
	
	public Medicament(String UnDepotLegal,String UnNomCommercial, String UneComposition, String LesEffets, String UneContreIndication, float LePrixEchantillon, String UnCodeFamille, String UnLibellefamille  ){
		
		this.depotLegal=UnDepotLegal;
		this.nomCommercial=UnNomCommercial;
		this.composition=UneComposition;
		this.effets=LesEffets;
		this.contreIndication=UneContreIndication;
		this.prixEchantillon=LePrixEchantillon;
		this.codeFamille=UnCodeFamille;
		this.libellefamille=UnLibellefamille;
		
	}



	public String getDepotLegal() {
		return depotLegal;
	}



	public void setDepotLegal(String depotLegal) {
		this.depotLegal = depotLegal;
	}



	public String getNomCommercial() {
		return nomCommercial;
	}



	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}



	public String getComposition() {
		return composition;
	}



	public void setComposition(String composition) {
		this.composition = composition;
	}



	public String getEffets() {
		return effets;
	}



	public void setEffets(String effets) {
		this.effets = effets;
	}



	public String getContreIndication() {
		return contreIndication;
	}



	public void setContreIndication(String contreIndication) {
		this.contreIndication = contreIndication;
	}



	public float getPrixEchantillon() {
		return prixEchantillon;
	}
	
	public String getPrixEchantillonString() {
		return String.valueOf(prixEchantillon);
	}



	public void setPrixEchantillon(float prixEchantillon) {
		this.prixEchantillon = prixEchantillon;
	}



	public String getCodeFamille() {
		return codeFamille;
	}



	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}



	public String getLibellefamille() {
		return libellefamille;
	}



	public void setLibellefamille(String libellefamille) {
		this.libellefamille = libellefamille;
	}
	
	
	
}
