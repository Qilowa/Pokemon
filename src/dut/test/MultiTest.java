package dut.test;

import java.io.IOException;

import dut.fr.fight.MultiFight;
import dut.fr.pokemon.Capacitylist;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.PokemonTeam;
import dut.fr.pokemon.Save;

public class MultiTest {
	public static void main(String[] args) throws IOException{
		Capacitylist c = Capacitylist.getInstance();
		Pokedex p = Pokedex.getInstance();
		PokemonTeam team= new PokemonTeam();
		System.out.println("Joueur 1");
	    if (team.createTeam(p)==1) {
	    	PokemonTeam team1 =Save.readPokemonTeam("tmp/team1.ser");
	    	Save.save("tmp/team1.ser", team1);
	    	System.out.println(team1);
	    	team=team1;
		}
	    else {
	    	Save.save("tmp/team1.ser", team);
	    	System.out.println("Team sauvegardé");
	    }
	    
	    PokemonTeam teambis= new PokemonTeam();
	    System.out.println("Joueur 2");
	    if (teambis.createTeam(p)==1) {
	    	PokemonTeam teambis1 =Save.readPokemonTeam("tmp/team2.ser");
	    	Save.save("tmp/team2.ser", teambis1);
	    	System.out.println(teambis1);
	    	teambis=teambis1;
		}
	    else {
	    	Save.save("tmp/team2.ser", teambis);
	    	System.out.println("Team sauvegardé");
	    }
	    MultiFight f1=new MultiFight(team, teambis);
	    f1.fight();
	   
	    
	}
}
