package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gsb.modele.Visite;
import gsb.service.OffrirService;
import gsb.service.VisiteService;

public class JIFVisiteModif extends JIFVisite implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton annuler;
	private JButton valider;
	private MenuPrincipal fenetreContainer;
	
	public JIFVisiteModif(Visite uneVisite, MenuPrincipal uneFenetreContainer) {
		super();
		fenetreContainer = uneFenetreContainer;
		annuler = new JButton("Annuler");
		valider = new JButton("Valider les modifications");
		pBoutons.add(annuler);
		pBoutons.add(valider);
		
		annuler.addActionListener(this);
		valider.addActionListener(this);
		this.remplirText(uneVisite);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == annuler) {
			fenetreContainer.ouvrirFenetre(new JIFVisiteRecherche(fenetreContainer));
		}
		else if(source == valider) {
			VisiteService.modifierVisite(JTref.getText(),JTdate.getText(),JTcom.getText(),JTcodeMed.getText(),JTmat.getText());
			System.out.println(JTqte1.getText());
			if(JTdl1.getText() != null && JTqte1.getText() != null) {
				if((JTdl1.getText() != dl1 && dl1 != null) || (JTqte1.getText() != qte1 && qte1 != null)) {
					OffrirService.modifierOffre(JTref.getText(),dl1,JTdl1.getText(),Integer.valueOf(JTqte1.getText()));
					System.out.println("modif1");
				}else if(dl1 == null && qte1 == null){
					OffrirService.creerOffre(JTdl1.getText(),JTref.getText(),Integer.valueOf(JTqte1.getText()));
					System.out.println("creer1");
				}
			}
			System.out.println(JTqte2.getText());
			if(JTdl2.getText() != null && JTqte2.getText() != null) {
				if((JTdl2.getText() != dl2 && dl2 != null) || (JTqte2.getText() != qte2 && qte2 != null)) {
					OffrirService.modifierOffre(JTref.getText(),dl2,JTdl2.getText(),Integer.valueOf(JTqte2.getText()));
					System.out.println("modif2");
				}else if(dl2 == null && qte2 == null){
					OffrirService.creerOffre(JTdl2.getText(),JTref.getText(),Integer.valueOf(JTqte2.getText()));
					System.out.println("creer2");
				}
			}
			fenetreContainer.ouvrirFenetre(new JIFVisiteRecherche(fenetreContainer));
		}
		
	}
}
