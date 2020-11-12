package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;


public class JIFMedicamentCons extends JIFMedicament implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton premier;
    private JButton suivant;
    private JButton precedent; 
    private JButton dernier; 
    private ArrayList<Medicament> lesMedic;
	private int indiceEnCours;
	private JButton info;
	
	public JIFMedicamentCons() {
		super();
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
        
        info = new JButton("Fiche détaillée");
        pBoutonInfo.add(info);
        info.addActionListener(this);
        
        
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Consultation données Médicament");
        
        lesMedic = MedicamentDao.retournerLesMedicaments();
        indiceEnCours = 0;
        
        if (lesMedic.size()!=0){ // si collection non vide, affichage des données du premier Medecin
        	Medicament leMedic = lesMedic.get(0);
	    	remplirText(leMedic);
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
			Medicament unMedic = lesMedic.get(indiceEnCours);
	    	remplirText(unMedic);				
	    }
		 else if (source == dernier){
			indiceEnCours = lesMedic.size() - 1;
			Medicament unMedic = lesMedic.get(indiceEnCours);
	    	remplirText(unMedic);
		}
		 else if (source == precedent){
			if (indiceEnCours > 0) indiceEnCours = indiceEnCours - 1;
			Medicament unMedic = lesMedic.get(indiceEnCours);
	    	remplirText(unMedic);				
	    }
		 else if (source == suivant){
			if (indiceEnCours < (lesMedic.size() - 1)) indiceEnCours = indiceEnCours + 1;
			Medicament unMedic = lesMedic.get(indiceEnCours);
	    	remplirText(unMedic);		    	
    	}
		 else if (source == info) {
			 
		 }
    }
	
}
