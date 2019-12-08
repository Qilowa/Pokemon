package dut.test;

import java.io.IOException;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;

public class PokedexTest {
	public static void main(String[] args) {
		/*Pokedex p = new Pokedex();
		try {
			p.createPokedex();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		Pokemon a =new Pokemon(2, "pikachu", "img/025.png",10,130, null, null);
		a.showPicture();
		System.out.println(a);
		a.rename("pierre");
		System.out.println(a);
		Capacity p1 = new Capacity("Affutage", "NORMAL", "Status", 0, 0, 30);
		a.addcapacity(p1);
		a.addcapacity(p1);
		a.addcapacity(p1);
		System.out.println(a.showcapacity());
	}
}
