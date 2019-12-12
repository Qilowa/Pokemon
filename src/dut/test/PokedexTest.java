package dut.test;

import java.io.IOException;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;

public class PokedexTest {
	public static void main(String[] args) throws IOException {
		Pokedex p = Pokedex.getInstance();
		Pokemon a =new Pokemon(2, "pikachu", "img/025.png",10,130, null, null);
		System.out.println(Pokedex.getPokemon(15));
		a.showPicture();
		System.out.println(a);

		System.out.println(a);
		Capacity p1 = new Capacity("Affutage", "NORMAL", 0, 30, 0, "Status");

		System.out.println(p.printPokedex());
		
	}
	
}
