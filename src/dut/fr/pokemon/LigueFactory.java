package dut.fr.pokemon;

import java.util.Random;

import dut.fr.ligue.BasicLigue;

public class LigueFactory {

	private static Random rand;
	private static Pokedex pokedex;
	
	public LigueFactory(Pokedex pokedex) {
		rand = new Random();
		this.pokedex = pokedex;
	}
	
	private PokemonTeam createRandTeam(int size) {
		if (size >6 || size < 1) {
			throw new IllegalArgumentException("Team's size should be between 1 and 6");
		}
		
		PokemonTeam t = new PokemonTeam();
		
		for(int i=0; i<size; i++) {
			FightingPokemon random = FightingPokemon.createFightingPokemon(rand.nextInt(pokedex.getSize())+1, pokedex);
			t.add(random);
		}
		return t;
		
	}
	
	public BasicLigue createBasicLigue() {
		int size = 5;
		return new BasicLigue(rand.nextInt(), this.createRandTeam(size), this.createRandTeam(size), this.createRandTeam(size), this.createRandTeam(size));
	}
	
}
