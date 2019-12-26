package dut.fr.pokemon;

import java.util.Random;

public class BasicLigue {
	private final PokemonTeam team1;
	private static final Pokedex pokedex = Pokedex.getInstance();

	public BasicLigue(PokemonTeam team1, Pokedex pokedex) {
		this.team1 = team1;
	}
	
	private static PokemonTeam createRandTeam() {
		
		Random r = new Random();
		PokemonTeam t = new PokemonTeam();
		
		for(int i=0; i<5; i++) {
			FightingPokemon random = FightingPokemon.createFightingPokemon(r.nextInt(pokedex.getSize())+1, pokedex);
			t.add(random);
		}
		return t;
		
	}
	
	public void fight() {
		PokemonTeam t2 = BasicLigue.createRandTeam();
		Fight f1 = new Fight(team1, t2);
		f1.fight();
		
		
	}

}