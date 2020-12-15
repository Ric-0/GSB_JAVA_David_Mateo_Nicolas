package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medecin;
import gsb.modele.Stocker;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.StockerDao;
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

		public JIFStockAffi() {
				
			
			p = new JPanel(); // panneau principal de la fenêtre	
			
			pSaisie = new JPanel();
			JTcodeVisiteur = new JTextField(20);
			JTcodeVisiteur.setMaximumSize(JTcodeVisiteur.getPreferredSize());
			pSaisie.add(JTcodeVisiteur);
			JBrechercher=new JButton("rechercher");
			JBrechercher.addActionListener(this);
			pSaisie.add(JBrechercher);
			p.add(pSaisie);
		
			
			
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
					System.out.println(unStock.getUnMedicament().getCodeFamille());
					
					data[i][0] = unStock.getUnMedicament().getCodeFamille();
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

