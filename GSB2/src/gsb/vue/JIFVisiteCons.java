package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

public class JIFVisiteCons extends JIFVisite implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton premier;
    private JButton suivant;
    private JButton precedent; 
    private JButton dernier; 
    private ArrayList<Visite> lesVisites;
	private int indiceEnCours;
	private JButton info;
	private MenuPrincipal fenetreContainer;
	
	public JIFVisiteCons(MenuPrincipal uneFenetreContainer) {
		super();
		fenetreContainer = uneFenetreContainer;
        premier = new JButton("Premier");
        pBoutons.add(premier);
        precedent = new JButton("Precedent");
        pBoutons.add(precedent);
        suivant = new JButton("Suivant");
        pBoutons.add(suivant);
        dernier = new JButton("Dernier");
        pBoutons.add(dernier);
        // déclaration des sources d'évènements
        premier.addActionListener(this);
        suivant.addActionListener(this);
        precedent.addActionListener(this);
        dernier.addActionListener(this);
        
        info = new JButton("Modifier");
        pBoutonInfo.add(info);
        info.addActionListener(this);
        
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Consultation données Visite");
        
        lesVisites = VisiteDao.retournerLesVisites();
        indiceEnCours = 0;
        
        if (lesVisites.size()!=0){ // si collection non vide, affichage des données du premier Medecin
        	Visite laVisite = lesVisites.get(0);
	    	remplirText(laVisite);
	    	}
        
        // ajout d'un écouteur d'évènement pour la fermeture de la fenêtre
        addInternalFrameListener(new InternalFrameAdapter(){
            public void  internalFrameClosing(InternalFrameEvent e) {
                          //le code que tu veux exécuter à la fermeture de la JInternalFrame
            }
        });
	}
	public void actionPerformed(ActionEvent evt) { 
		Object source = evt.getSource();
   		if (source == premier){
			indiceEnCours = 0;
			Visite laVisite = lesVisites.get(indiceEnCours);
	    	remplirText(laVisite);				
	    }
		 else if (source == dernier){
			indiceEnCours = lesVisites.size() - 1;
			Visite laVisite = lesVisites.get(indiceEnCours);
	    	remplirText(laVisite);
		}
		 else if (source == precedent){
			if (indiceEnCours > 0) indiceEnCours = indiceEnCours - 1;
			Visite laVisite = lesVisites.get(indiceEnCours);
	    	remplirText(laVisite);				
	    }
		 else if (source == suivant){
			if (indiceEnCours < (lesVisites.size() - 1)) indiceEnCours = indiceEnCours + 1;
			Visite laVisite = lesVisites.get(indiceEnCours);
	    	remplirText(laVisite);		    	
    	}
		 else if (source == info) {
			System.out.println(JTref.getText());
			System.out.println(lesVisites.get(indiceEnCours).getReference());
			if(lesVisites.get(indiceEnCours).getReference().equals(JTref.getText())) {
				System.out.println("OK");
				Visite laVisite = lesVisites.get(indiceEnCours);
				fenetreContainer.ouvrirFenetre(new JIFVisiteModif(laVisite,fenetreContainer));
			}
		 }
    }
	
}
