package dut.test;

import java.io.IOException;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;
import dut.fr.pokemon.Type;

public class PokedexTest {
	public static void main(String[] args) throws IOException {
		Pokedex p = Pokedex.getInstance();
		Pokemon a =p.getPokemon(3);
		System.out.println(p.getPokemon(15));
		a.showPicture();
		System.out.println(a);

		System.out.println(a);
		// Capacity p1 = new Capacity("Affutage", Type.NORMAL, 0, 30, 0, "Status");

		System.out.println(p);
		
	}
	
}
