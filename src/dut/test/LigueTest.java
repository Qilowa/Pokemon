package dut.test;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dut.fr.league.BasicLeague;
import dut.fr.league.DUT2League;
import dut.fr.league.LeagueFactory;
import dut.fr.pokemon.Capacitylist;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.PokemonTeam;
import dut.fr.pokemon.Save;

public class LigueTest {

	public static void main(String[] args) throws IOException{
		Capacitylist c = Capacitylist.getInstance();
		Pokedex p = Pokedex.getInstance();
		PokemonTeam team= new PokemonTeam();
	    if (team.createTeam(p)==1) {
	    	PokemonTeam team1 =Save.readPokemonTeam("tmp/team.ser");
	    	Save.save("tmp/team.ser", team1);
	    	System.out.println(team1);
	    	team=team1;
		}
	    else {
	    	Save.save("tmp/team.ser", team);
	    	System.out.println("Team sauvegardé");
	    }
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Choisir votre ligue('défaut'=0 , 'made in DUT 2'=1)");
	    int choix = sc.nextInt();
	    
	    LeagueFactory f = new LeagueFactory(p);
	    switch (choix) {
		case 0:
			BasicLeague basicligue = f.createBasicLigue();
			basicligue.fightLigue(team);
			break;
		case 1:
			DUT2League dutligue = f.createDUT2Ligue();
			dutligue.fightLigue(team);
			break;

		default:
			break;
		}
	    
	}

}
