package dut.fr.menu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class LigueAction extends AbstractAction {
	public LigueAction(String texte){
		super(texte);
	}
 
	public void actionPerformed(ActionEvent e) { 
		System.out.println("Ligue");
	} 
}
