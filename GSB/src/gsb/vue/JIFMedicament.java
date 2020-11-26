package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

import gsb.modele.Medicament;
import gsb.modele.Visite;

public class JIFMedicament extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected GridLayout pTexte1;
	protected JPanel pTexte2;
	protected JPanel pBoutons;
	protected JPanel pBoutonInfo;
	
	protected JLabel JLDepotLeg;
	protected JLabel JLNomCommer;
	protected JLabel JLCompo;
	protected JLabel JLEffets;
	protected JLabel JLContrIndi;
	protected JLabel JLdl;
	protected JLabel Jlqo;
	protected JLabel JLPrixEchant;
	protected JLabel JLCodeFam;
	protected JLabel JLLibellFam;
	
	protected JLabel JLvide;
	
	protected JTextField JTDepotLeg;
	protected JTextField JTNomCommer;
	protected JTextField JTCompo;
	protected JTextField JTEffets;
	protected JTextField JTContrIndi;
	protected JTextField JTPrixEchant;
	protected JTextField JTCodeFam;
	protected JTextField JTLibellFam;

	
    public JIFMedicament() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        JPanel pTexte = new JPanel(new GridLayout(9,2));
    	
		JLDepotLeg = new JLabel("Référence");
		JLNomCommer = new JLabel("Nom commercial");
		JLCompo = new JLabel("Composition");
		JLEffets = new JLabel("Les effets");
		JLContrIndi = new JLabel("Contre indication");
		JLPrixEchant = new JLabel("Prix échantillon");
		JLCodeFam = new JLabel("Code famille");
		JLLibellFam =  new JLabel("Libellé famille");
         
     /*    JTcode = new JTextField(20);
         JTcode.setMaximumSize(JTcode.getPreferredSize());
         JTnom = new JTextField();
         JTprenom = new JTextField();
         JTadresse = new JTextField();    
         JTcp = new JTextField();
         JTville = new JTextField();
         JTtelephone = new JTextField();
         JTpotentiel = new JTextField();
         JTspecialite = new JTextField(); */
		
		JTDepotLeg = new JTextField();
		JTNomCommer = new JTextField();
		JTCompo = new JTextField();
		JTEffets = new JTextField();
		JTContrIndi = new JTextField();
		JTPrixEchant = new JTextField();
		JTCodeFam = new JTextField();
		JTLibellFam = new JTextField();
         
		pTexte.add(JLDepotLeg);
		pTexte.add(JTDepotLeg);
		
		pTexte.add(JLNomCommer);
		pTexte.add(JTNomCommer);
		
		pTexte.add(JLCompo);
		pTexte.add(JTCompo);
		
		pTexte.add(JLEffets);
		pTexte.add(JTEffets);
		
		pTexte.add(JLContrIndi);
		pTexte.add(JTContrIndi);
		
		pTexte.add(JLPrixEchant);
		pTexte.add(JTPrixEchant);
		
		pTexte.add(JLCodeFam);
		pTexte.add(JTCodeFam);
		
		pTexte.add(JLLibellFam);
		pTexte.add(JTLibellFam);
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
	/*public JIFMedicament() {
		p = new JPanel();
		pTexte1 = new GridLayout(9,2);
		pTexte2 = new JPanel(new GridLayout(3,3));
		pBoutons = new JPanel();
		pBoutonInfo = new JPanel();
		
		JLDepotLeg = new JLabel("Référence");
		JLNomCommer = new JLabel("Nom commercial");
		JLCompo = new JLabel("Composition");
		JLEffets = new JLabel("Les effets");
		JLContrIndi = new JLabel("Contre indication");
		JLPrixEchant = new JLabel("Prix échantillon");
		JLCodeFam = new JLabel("Code famille");
		JLLibellFam =  new JLabel("Libellé famille");
		
		JLvide = new JLabel(" ");
		
		JTDepotLeg = new JTextField();
		JTNomCommer = new JTextField();
		JTCompo = new JTextField();
		JTEffets = new JTextField();
		JTContrIndi = new JTextField();
		JTPrixEchant = new JTextField();
		JTCodeFam = new JTextField();
		JTLibellFam = new JTextField();
		
		pTexte1.add(JLDepotLeg);
		pTexte1.add(JTDepotLeg);
		
		pTexte1.add(JLNomCommer);
		pTexte1.add(JTNomCommer);
		
		pTexte1.add(JLCompo);
		pTexte1.add(JTCompo);
		
		pTexte1.add(JLEffets);
		pTexte1.add(JTEffets);
		
		pTexte1.add(JLContrIndi);
		pTexte1.add(JTContrIndi);
		
		pTexte1.add(JLPrixEchant);
		pTexte1.add(JTPrixEchant);
		
		pTexte1.add(JLCodeFam);
		pTexte1.add(JTCodeFam);
		
		pTexte1.add(JLLibellFam);
		pTexte1.add(JTLibellFam);
		
		p.add(pTexte1);	
		
		p.add(pTexte2);
		
		p.add(pBoutons);
		
		p.add(pBoutonInfo);
		
		Container contentPane = getContentPane();
        contentPane.add(p);
	}*/
	
	public void remplirText(Medicament unMedic) {
		JTDepotLeg.setText(unMedic.getDepotLegal());
		JTNomCommer.setText(unMedic.getNomCommercial());
		JTCompo.setText(unMedic.getComposition());
		JTEffets.setText(unMedic.getEffets());
		JTContrIndi.setText(unMedic.getContreIndication());
		JTPrixEchant.setText(unMedic.getPrixEchantillonString());
		JTCodeFam.setText(unMedic.getCodeFamille());
		JTLibellFam.setText(unMedic.getLibellefamille());
		
	}
	
	public void viderText() {
		JTDepotLeg.setText("");
		JTNomCommer.setText("");
		JTCompo.setText("");
		JTEffets.setText("");
		JTContrIndi.setText("");
		JTPrixEchant.setText("");
		JTCodeFam.setText("");
		JTLibellFam.setText("");
	}
}
