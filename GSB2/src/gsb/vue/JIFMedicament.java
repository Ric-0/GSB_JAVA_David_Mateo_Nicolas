/*
 * Cr�� le 22 mars 2012
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;

import gsb.modele.Medicament;

import java.awt.Container;
import java.awt.GridLayout;

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
	
    public JIFMedicament() {
    	p = new JPanel(new GridLayout(2,1));  // panneau principal de la fen�tre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(10,4));
    	
    	 JLdepotLegal = new JLabel("D�p�t l�gal : ");
         JLnomCommercial = new JLabel("Nom commercial : ");
         JLcomposition = new JLabel("Composition : ");
         JLeffets = new JLabel("Effets : ");
         JLcontreIndication = new JLabel("Contre indication : ");
         JLprixEchantillon = new JLabel("Prix �chantillon : ");
         JLcodeFamille = new JLabel("Code famille : ");
         JLlibelleFamille = new JLabel("Libell� famille : ");
         
         
         
         JTdepotLegal = new JTextField(20);
         JTnomCommercial = new JTextField(20);
         JTcomposition = new JTextField(20);            
         JTeffets = new JTextField(20);               
         JTcontreIndication = new JTextField(20); 
         JTprixEchantillon = new JTextField(20);         
         JTcodeFamille = new JTextField(20);         
         JTlibelleFamille = new JTextField(20);  
         
         
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
		
        // mise en forme de la fen�tre
         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);
	}
   
    public void remplirText(Medicament unMedic) 	
    {  // m�thode qui permet de remplir les zones de texte � partir des valeurs pass�es en param�tres
    	JTdepotLegal.setText(unMedic.getDepotLegal());
    	JTnomCommercial.setText(unMedic.getNomCommercial());
    	JTcomposition.setText(unMedic.getComposition());
    	JTeffets.setText(unMedic.getEffets());
    	JTcontreIndication.setText(unMedic.getContreIndication());
    	JTprixEchantillon.setText(unMedic.getPrixEchantillonString());
    	JTcodeFamille.setText(unMedic.getCodeFamille());
    	JTlibelleFamille.setText(unMedic.getLibellefamille());
    
    	
     }
     
      public void viderText() 	
    {  // m�thode qui permet de vider les zones de texte 
      	JTdepotLegal.setText("");
      	JTnomCommercial.setText("");
      	JTcomposition.setText("");
      	JTeffets.setText("");
      	JTcontreIndication.setText("");
      	JTprixEchantillon.setText("");
      	JTcodeFamille.setText("");
      	JTlibelleFamille.setText("");
     }


    
}
