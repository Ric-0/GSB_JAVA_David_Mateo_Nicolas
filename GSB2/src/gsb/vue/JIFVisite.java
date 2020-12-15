package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

import gsb.modele.Visite;

public class JIFVisite extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte1;
	protected JPanel pTexte2;
	protected JPanel pBoutons;
	protected JPanel pBoutonInfo;
	
	protected JLabel JLref;
	protected JLabel JLdate;
	protected JLabel JLmat;
	protected JLabel JLcodeMed;
	protected JLabel JLcom;
	protected JLabel JLdl;
	protected JLabel Jlqo;
	
	protected JLabel JLvide;
	
	protected JTextField JTref;
	protected JTextField JTdate;
	protected JTextField JTmat;
	protected JTextField JTcodeMed;
	protected JTextField JTcom;
	
	public JIFVisite() {
		p = new JPanel();
		pTexte1 = new JPanel(new GridLayout(7,2));
		pTexte2 = new JPanel(new GridLayout(3,3));
		pBoutons = new JPanel();
		pBoutonInfo = new JPanel();
		
		JLref = new JLabel("Référence");
		JLdate = new JLabel("Date visite");
		JLmat = new JLabel("Matricule visiteur");
		JLcodeMed = new JLabel("Code Médecin");
		JLcom = new JLabel("Commentaire");
		
		JLvide = new JLabel(" ");
		
		JTref = new JTextField();
		JTdate = new JTextField();
		JTmat = new JTextField();
		JTcodeMed = new JTextField();
		JTcom = new JTextField();
		
		pTexte1.add(JLref);
		pTexte1.add(JTref);
		
		pTexte1.add(JLdate);
		pTexte1.add(JTdate);
		
		pTexte1.add(JLmat);
		pTexte1.add(JTmat);
		
		pTexte1.add(JLcodeMed);
		pTexte1.add(JTcodeMed);
		
		pTexte1.add(JLcom);
		pTexte1.add(JTcom);
		
		p.add(pTexte1);
		
		
		
		p.add(pTexte2);
		
		p.add(pBoutons);
		
		p.add(pBoutonInfo);
		
		Container contentPane = getContentPane();
        contentPane.add(p);
	}
	
	public void remplirText(Visite uneVisite) {
		JTref.setText(uneVisite.getReference());
		JTdate.setText(uneVisite.getDate());
		JTmat.setText(uneVisite.getUnVisiteur().getMatricule());
		JTcodeMed.setText(uneVisite.getUnMedecin().getCodeMed());
		JTcom.setText(uneVisite.getCommentaire());
		
	}
	
	public void viderText() {
		JTref.setText("");
		JTdate.setText("");
		JTmat.setText("");
		JTcodeMed.setText("");
		JTcom.setText("");
	}
}
