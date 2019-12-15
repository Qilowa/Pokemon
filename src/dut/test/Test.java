package dut.test;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.PokemonTeam;
import dut.fr.pokemon.Save;

public class Test {

	public static void main(String[] args) {
		Pokedex pokedex = Pokedex.getInstance();
		System.out.println(pokedex.getPokemon(1));
		FightingPokemon p = FightingPokemon.createFightingPokemon(1, pokedex);
		System.out.println(p);
		
		PokemonTeam team = new PokemonTeam();
		System.out.println(team);
		
		Save.save("tmp/team.ser", team);
		PokemonTeam s =Save.readPokemonTeam("tmp/team.ser");
		System.out.println(s);
		System.out.println(s.equals(p));
		
	}
}
