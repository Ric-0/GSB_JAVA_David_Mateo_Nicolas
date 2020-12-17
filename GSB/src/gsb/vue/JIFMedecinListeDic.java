package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class JIFMedecinListeDic extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	//private ArrayList<Medecin> lesMedecins;
	private ArrayList<Medecin> ArrayMedecin;

	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeMedecin;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;
	
	
	public JIFMedecinListeDic(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// récupération des données Medecin dans la collection
		//lesMedecins = MedecinDao.retournerCollectionDesMedecins();

		//int nbLignes = lesMedecins.size();
		ArrayMedecin = MedecinDao.retournerLesMedecins();
		int nbLignes= ArrayMedecin.size();
		
		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][4] ;
		//for(Medecin unMedecin : lesMedecins){
		
		for (Medecin uneEntree : ArrayMedecin){
			data[i][0] = uneEntree.getCodeMed();
			data[i][1] = uneEntree.getNom();
			data[i][2] = uneEntree.getPrenom();
			data[i][3] = uneEntree.getUneLocalite().getVille() ;
			i++;
			}
		String[] columnNames = {"Code", "Nom","Prenom","Ville"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeMedecin = new JTextField(20);
		JTcodeMedecin.setMaximumSize(JTcodeMedecin.getPreferredSize());

		p.add(pSaisie);
		
		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}