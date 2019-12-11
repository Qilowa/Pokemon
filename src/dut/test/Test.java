package dut.test;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokedex;

public class Test {

	public static void main(String[] args) {
		Pokedex pokedex = Pokedex.getInstance();
		FightingPokemon p = FightingPokemon.createFightingPokemon(1);
		System.out.println(p);
		
	}
}
