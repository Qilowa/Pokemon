package dut.fr.menu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class LaAction extends AbstractAction {
	public LaAction(String texte){
		super(texte);
	}
 
	public void actionPerformed(ActionEvent e) { 
		System.out.println("Vous avez cliqué là");
	} 
}
