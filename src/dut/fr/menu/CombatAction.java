package dut.fr.menu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class CombatAction extends AbstractAction {
	public CombatAction(String texte){
		super(texte);
	}
 
	public void actionPerformed(ActionEvent e) { 
		System.out.println("Combat");
	} 
}
