package gsb.modele;

public class Localite {

	protected String codePostal;
	protected String ville;
	
	// test
	public Localite(String UnCodePostal,String UneVille){
		
		this.codePostal=UnCodePostal;
		this.ville=UneVille;
		
		
	}
	
	public String getCodePostal(){
		
		
		
		return this.codePostal;
		
	}
	
	public void setCodePostal(String UnCodePostal){
		
		this.codePostal=UnCodePostal;
		
		
	}
	
	public String getVille(){
		
		
		
		return this.ville;
		
	}
	
	public void setVille(String UneVille){
		
		
		
		this.ville=UneVille;
		
	}
	
	
	
	
}
