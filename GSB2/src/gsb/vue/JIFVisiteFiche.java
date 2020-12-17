package gsb.vue;

import gsb.modele.Visite;

public class JIFVisiteFiche extends JIFVisite{

	private static final long serialVersionUID = 1L;
	
	public JIFVisiteFiche(Visite uneVisite) {
		super();
		this.remplirText(uneVisite);
	}
}
