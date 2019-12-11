package dut.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;

public class PokedexTest {
	public static void main(String[] args) throws IOException {
		Pokedex p = new Pokedex();
		try {
			p.createPokedex();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Pokemon a =new Pokemon(2, "pikachu", "img/025.png",10,130, null, null);
		a.showPicture();
		System.out.println(a);

		System.out.println(a);
		Capacity p1 = new Capacity("Affutage", "NORMAL", 0, 30, 0, "Status");

		
	}
	
}
