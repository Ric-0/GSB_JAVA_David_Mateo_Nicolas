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

import gsb.modele.Stocker;

import gsb.service.StockerService;

public class JIFStockAffi  extends JInternalFrame implements ActionListener {
	
	
	private static final long serialVersionUID = 1L;
	
	//private ArrayList<Medecin> lesMedecins;
		private ArrayList<Stocker> listeStocker;


		protected JPanel p;
		protected JScrollPane scrollPane;
		protected JPanel pSaisie;
		protected JTextField JTcodeVisiteur;
		protected JTable table;
		protected String matricule;
		protected JButton JBrechercher;
		protected String [][] data;
		protected JLabel ref;
		protected JPanel pRechercher;

		public JIFStockAffi() {
				
			
			p = new JPanel(); // panneau principal de la fenêtre	
			
			pSaisie = new JPanel(new GridLayout(1,2));
			pRechercher = new JPanel();
			
			JTcodeVisiteur = new JTextField(20);
			JTcodeVisiteur.setMaximumSize(JTcodeVisiteur.getPreferredSize());
			
			ref = new JLabel("Matricule visiteur");
			
			JBrechercher=new JButton("rechercher");
			
			JBrechercher.addActionListener(this);
			
			pSaisie.add(ref);
			pSaisie.add(JTcodeVisiteur);
			pRechercher.add(JBrechercher);
			p.add(pSaisie);
			p.add(pRechercher);
		
			
			
			// mise en forme de la fenêtre
			Container contentPane = getContentPane();
			contentPane.add(p);
		
			
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Object source=arg0.getSource();
			
			if(source==JBrechercher) {
				
				matricule=JTcodeVisiteur.getText();
				RemplirTab(matricule);
				
				
					
			}
			
		}
			
			public  void RemplirTab(String matricule) {
			
				listeStocker=StockerService.retournerLesStocksSpecifiques(matricule);
				int nbLigne=listeStocker.size();				
				
				int i=0;
				data=new String[nbLigne][3];
				
				
				for (Stocker unStock : listeStocker){
					
					data[i][0] = unStock.getUnMedicament().getDepotLegal();
					data[i][1] = unStock.getUnMedicament().getLibellefamille();
					data[i][2] = String.valueOf(unStock.getQteStock());
						
					i++;
					
					}
				String[] columnNames = {"Code", "Nom","Stock"};
				table = new JTable(data, columnNames);
				scrollPane = new JScrollPane(table);
				scrollPane.setPreferredSize(new Dimension(400, 200));
				p.add(scrollPane);
				setSize(480, 380);
		
			}
		
}

