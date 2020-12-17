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

import gsb.service.StockerService;

public class JIFStocker extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;

	public JButton ajout;

	protected JLabel JLqte;
	protected JLabel JLVisiteur;
	protected JLabel JLMedicament;

	protected JTextField JTqte;
	protected JTextField JTVisiteur;
	protected JTextField JTMedicament;

	public JIFStocker() {
		p = new JPanel();
		pBoutons = new JPanel(new GridLayout(1, 1));
		pTexte = new JPanel(new GridLayout(4, 2));

		ajout = new JButton("Ajout stock");
		pBoutons.add(ajout);

		ajout.addActionListener((ActionListener) this);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Ajout stock médicament");

		JLqte = new JLabel("Quantité : ");
		JLVisiteur = new JLabel("Visiteur : ");
		JLMedicament = new JLabel("Médicament : ");

		JTqte = new JTextField();
		JTVisiteur = new JTextField();
		JTMedicament = new JTextField();

		pTexte.add(JLVisiteur);
		pTexte.add(JTVisiteur);

		pTexte.add(JLMedicament);
		pTexte.add(JTMedicament);

		pTexte.add(JLqte);
		pTexte.add(JTqte);


		p.add(pTexte);
		p.add(pBoutons);
		Container contentPane = getContentPane();
		contentPane.add(p);

	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == ajout) {
			try {
				if (StockerService.ajoutEchant(JTqte.getText(), JTVisiteur.getText(), JTMedicament.getText()) == 0) {
					throw new Exception("Erreur.");
				}
			} catch (Exception e) {

			}
		}

	}
}
