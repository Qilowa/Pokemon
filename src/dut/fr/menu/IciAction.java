package dut.fr.menu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class IciAction extends AbstractAction {
	public IciAction(String texte){
		super(texte);
	}
 
	public void actionPerformed(ActionEvent e) { 
		System.out.println("Vous avez cliqué ici");
	} 
}
