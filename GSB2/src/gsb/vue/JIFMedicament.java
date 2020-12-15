/*
 * Créé le 22 mars 2012
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Medecin;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedicament extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	protected JLabel JLdepotLegal;
	protected JLabel JLnomCommercial;
	protected JLabel JLcomposition;
	protected JLabel JLeffets;
	protected JLabel JLcontreIndication;
    protected JLabel JLprixEchantillon;
    protected JLabel JLcodeFamille;
    protected JLabel JLlibelleFamille;
    
	protected JTextField JTdepotLegal;
	protected JTextField JTnomCommercial;
	protected JTextField JTcomposition;
	protected JTextField JTeffets;
	protected JTextField JTcontreIndication;
    protected JTextField JTprixEchantillon;
    protected JTextField JTcodeFamille;
    protected JTextField JTlibelleFamille;

	
    public JIFMedecin() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(8,2));
    	
    	 JLdepotLegal = new JLabel("Code");
         JLnomCommercial = new JLabel("Nom");
         JLcomposition = new JLabel("Prénom");
         JLeffets = new JLabel("Adresse rue");
         JLcontreIndication = new JLabel("Code postal");
         JLprixEchantillon = new JLabel("Ville");
         JLcodeFamille = new JLabel("Téléphone");
         JLlibelleFamille = new JLabel("potentiel");
         
         JTdepotLegal = new JTextField(20);
         JTnomCommercial = new JTextField();
         JTcomposition = new JTextField();
         JTeffets = new JTextField();
         JTcontreIndication = new JTextField();    
         JTprixEchantillon = new JTextField();
         JTcodeFamille = new JTextField();
         JTlibelleFamille = new JTextField();


         
         pTexte.add(JLdepotLegal);
         pTexte.add(JTdepotLegal);
         pTexte.add(JLnomCommercial);
         pTexte.add(JTnomCommercial);
         pTexte.add(JLcomposition);
         pTexte.add(JTcomposition);
         pTexte.add(JLeffets);
         pTexte.add(JTeffets);
         pTexte.add(JLcontreIndication);
         pTexte.add(JTcontreIndication);
         pTexte.add(JLprixEchantillon);
         pTexte.add(JTprixEchantillon);
         pTexte.add(JLcodeFamille);
         pTexte.add(JTcodeFamille);
         pTexte.add(JLlibelleFamille);
         pTexte.add(JTlibelleFamille);
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Medecin unMedecin) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
        JTcode.setText(unMedecin.getCodeMed());        
        JTnom.setText(unMedecin.getNom());
        JTprenom.setText(unMedecin.getPrenom());
        JTadresse.setText(unMedecin.getAdresse());    
        JTcp.setText(unMedecin.getUneLocalite().getCodePostal());
        JTville.setText(unMedecin.getUneLocalite().getVille());
        JTtelephone.setText(unMedecin.getTelephone());
        JTpotentiel.setText(unMedecin.getPotentiel());
        JTspecialite.setText(unMedecin.getSpecialite());
     }
     
      public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
        JTcode.setText("");        
        JTnom.setText("");
        JTprenom.setText("");
        JTadresse.setText("");    
        JTcp.setText("");
        JTville.setText("");
        JTtelephone.setText("");
        JTpotentiel.setText("");
        JTspecialite.setText("");
     }


    
}
