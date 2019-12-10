package dut.test;

import java.io.IOException;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokedex;

public class Test {

	public static void main(String[] args) {
		try {
			Pokedex pokedex = new Pokedex();
			pokedex.createPokedex();
			FightingPokemon p = FightingPokemon.createFightinPokemong(1);
			System.out.println(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
