package dut.test;

import java.io.IOException;

import dut.fr.pokemon.Pokedex;

public class PokedexTest {
	public static void main(String[] args) {
		Pokedex p = new Pokedex();
		try {
			p.createPokedex();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
