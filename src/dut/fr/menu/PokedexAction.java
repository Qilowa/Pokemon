package dut.fr.menu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;

public class PokedexAction extends AbstractAction {
	public PokedexAction(String texte){
		super(texte);
	}
 
	public void actionPerformed(ActionEvent e) { 
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(640, 480));
        panel.setLayout(new FlowLayout());
 
		JButton bouton = new JButton(new PokedexAction("Pokedex"));
		panel.add(bouton);
 
		JButton bouton2 = new JButton(new CombatAction("Combat"));
		panel.add(bouton2);
		Pokedex p = Pokedex.getInstance();
		Pokemon a =Pokedex.getPokemon(3);
		System.out.println(Pokedex.getPokemon(15));
		a.showPicture();
		System.out.println(a);
		System.out.println("Pokedex");
	} 
}
