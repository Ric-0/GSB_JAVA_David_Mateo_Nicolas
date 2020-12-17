package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.service.OffrirService;

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
	
	protected JPanel pOffre;
	
	protected JLabel JLdepLeg;
	protected JLabel JLqte;
	protected JLabel JLmed1;
	protected JLabel JLmed2;
	protected JTextField JTdl1;
	protected JTextField JTqte1;
	protected JTextField JTdl2;
	protected JTextField JTqte2;
	
	protected String dl1;
	protected String qte1;
	protected String dl2;
	protected String qte2;
	
	public JIFVisite() {
		dl1 = null;
		qte1 = null;
		dl2 = null;
		qte2 = null;
		
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
		
		pOffre = new JPanel(new GridLayout(3,3));
		
		pOffre.add(JLvide);
		JLdepLeg = new JLabel("Depot legal");
		pOffre.add(JLdepLeg);
		JLqte = new JLabel("Quantité offerte");
		pOffre.add(JLqte);
		
		JLmed1 = new JLabel("Medicament 1");
		pOffre.add(JLmed1);
		JTdl1 = new JTextField();
		pOffre.add(JTdl1);
		JTqte1 = new JTextField();
		pOffre.add(JTqte1);
		
		JLmed2 = new JLabel("Medicament 2");
		pOffre.add(JLmed2);
		JTdl2 = new JTextField();
		pOffre.add(JTdl2);
		JTqte2 = new JTextField();
		pOffre.add(JTqte2);
		
		p.add(pOffre);
		
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
		ArrayList<Offrir> listeOffres = OffrirService.rechercherOffreViaVisite(JTref.getText());
		System.out.println(listeOffres.size());
		if(listeOffres.size() != 0) {
			JTdl1.setText(listeOffres.get(0).getUnMedicament().getDepotLegal());
			dl1 = JTdl1.getText();
			JTqte1.setText(String.valueOf(listeOffres.get(0).getQteOfferte()));
			qte1 = ""+JTqte1.getText()+"";
		}
		if(listeOffres.size() == 2) {
			JTdl2.setText(listeOffres.get(1).getUnMedicament().getDepotLegal());
			dl2 = JTdl2.getText();
			JTqte2.setText(String.valueOf(listeOffres.get(1).getQteOfferte()));
			qte2 = ""+JTqte2.getText()+"";
		}
		
	}
	
	public void viderText() {
		JTref.setText("");
		JTdate.setText("");
		JTmat.setText("");
		JTcodeMed.setText("");
		JTcom.setText("");
	}
}
