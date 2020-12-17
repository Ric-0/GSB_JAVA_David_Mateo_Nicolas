package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;
import gsb.service.VisiteService;

public class JIFVisiteRecherche extends JInternalFrame implements ActionListener{
	
	private JButton rechercher;
	private JPanel p;
	private JPanel pTexte;
	private JPanel pBoutons;
	private JPanel pTab;
	
	private JLabel JLmat;
	private JLabel JLdate;
	
	private JTextField JTmat;
	private JTextField JTdate;
	
	private String[][] data;
	
	private JLabel JLref;
	private JTextField JTref;
	private JButton visite;
	
	private JPanel pRecherche;
	
	private MenuPrincipal fenetreContainer;
	
	public JIFVisiteRecherche(MenuPrincipal uneFenetreContainer) {
		fenetreContainer = uneFenetreContainer;
		p = new JPanel();
		pTexte = new JPanel(new GridLayout(2,2));
		pBoutons = new JPanel(new GridLayout(1,1));
		pTab = new JPanel();
		rechercher = new JButton("Rechercher");
		
		JLmat = new JLabel("Matricule visiteur : ");
		JLdate = new JLabel("Date (jj/mm/aaaa) : ");
		
		JTmat = new JTextField();
		JTdate = new JTextField();
		
		pTexte.add(JLmat);
		pTexte.add(JTmat);
		
		pTexte.add(JLdate);
		pTexte.add(JTdate);
		
		p.add(pTexte);
		
		pBoutons.add(rechercher);
		
		p.add(pBoutons);
		
		rechercher.addActionListener(this);
		
		creerTab();
		
		String[] entetes = {"Référence","Code médecin","Commentaire"};
		JTable table = new JTable(data, entetes);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(400,180));
		pTab.add(scroll);
		
		p.add(pTab);
		
		pRecherche = new JPanel(new GridLayout(1,3));
		
		JLref = new JLabel("Référence : ");
		JTref = new JTextField();
		visite = new JButton("Visite détaillée");
		
		visite.addActionListener(this);
		
		pRecherche.add(JLref);
		pRecherche.add(JTref);
		pRecherche.add(visite);
		
		p.add(pRecherche);
		
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == rechercher) {
			remplirTab(JTmat.getText(),JTdate.getText());
		}
		else if(source == visite) {
			Visite uneVisite = VisiteService.rechercherVisite(JTref.getText());
			System.out.println(JTref.getText());
			fenetreContainer.ouvrirFenetre(new JIFVisiteModif(uneVisite,fenetreContainer));
		}
	}
	public void remplirTab(String mat, String date) {
		int i = 0;
		ArrayList<Visite> listeVisite = VisiteService.rechercherListeVisite(mat,date);
		for(Visite uneVisite : listeVisite) {
			data[i][0] = uneVisite.getReference();
			data[i][1] = uneVisite.getUnMedecin().getCodeMed();
			data[i][2] = uneVisite.getCommentaire();
			i++;
		}
	}
	public void creerTab() {
		ArrayList<Visite> listeVisite = VisiteDao.retournerLesVisites();
		int j = listeVisite.size();
		data = new String[j][3];
		int i = 0;
		while(i < 5) {
			data[i][0] = " ";
			data[i][1] = " ";
			data[i][2] = " ";
			i++;
		}
	}
	

}
