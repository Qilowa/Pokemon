package dut.test;

import java.io.IOException;

import dut.fr.pokemon.Capacitylist;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.PokemonTeam;

public class CapacityTest {

	public static void main(String[] args) throws IOException{
		Capacitylist c = Capacitylist.getInstance();
		Pokedex p = Pokedex.getInstance();
		PokemonTeam team= new PokemonTeam();
	    team.createTeam(p);
	}
}
