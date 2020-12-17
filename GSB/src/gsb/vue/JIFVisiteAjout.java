package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.service.VisiteService;

public class JIFVisiteAjout extends JInternalFrame implements ActionListener {

	
	
	
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
	
	private JButton Ajouter;
	
	
	public JIFVisiteAjout() {   
		
		
		p = new JPanel(new GridLayout(2,1));
		pTexte1 = new JPanel(new GridLayout(6,2));
		pTexte2 = new JPanel(new GridLayout(2,1));
		pBoutons = new JPanel();
		Ajouter=new JButton("Ajouter");		
	
		
		JLref = new JLabel("Référence");
		JLdate = new JLabel("Date visite");
		JLcom = new JLabel("Commentaire");
		JLmat = new JLabel("Matricule visiteur");
		JLcodeMed = new JLabel("Code Médecin");
		
		
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
		
		pTexte1.add(JLcom);
		pTexte1.add(JTcom);
		
		pTexte1.add(JLmat);
		pTexte1.add(JTmat);
		
		pTexte1.add(JLcodeMed);
		pTexte1.add(JTcodeMed);
	
		
		pBoutons.add(Ajouter);
		
		pTexte2.add(JLvide);
		pTexte2.add(pBoutons);
		
		p.add(pTexte1);
			
		p.add(pTexte2);
		
		
		
		
		

		
		Container contentPane = getContentPane();
        contentPane.add(p);
        
        
        // déclaration des sources d'évènements
        Ajouter.addActionListener(this);
        
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Ajout d'une Visite");
        
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
   		if (source == Ajouter){
			
   			VisiteService.creerVisite(JTref.getText(),JTdate.getText(),JTcom.getText(),JTcodeMed.getText(),JTmat.getText());
	    
   		}
	}
}
