package dut.test;

import java.io.IOException;

import dut.fr.menu.Menu;
import dut.fr.pokemon.Capacitylist;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.PokemonTeam;
import dut.fr.pokemon.Save;

public class CapacityTest {

	public static void main(String[] args) throws IOException{
		Capacitylist c = Capacitylist.getInstance();
		Pokedex p = Pokedex.getInstance();
		PokemonTeam team= new PokemonTeam();
	    if (team.createTeam(p)==1) {
	    	PokemonTeam team1 =Save.readPokemonTeam("tmp/team.ser");
	    	Save.save("tmp/team.ser", team1);
	    	System.out.println(team1);
		}
	    else {
	    	Save.save("tmp/team.ser", team);
	    	System.out.println("Team sauvegardé");
	    }
	    
	}

	
}
