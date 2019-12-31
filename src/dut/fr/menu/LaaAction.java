package dut.fr.menu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class LaaAction extends AbstractAction {
	public LaaAction(String texte){
		super(texte);
	}
 
	public void actionPerformed(ActionEvent e) { 
		System.out.println("Voalà");
	} 
}
