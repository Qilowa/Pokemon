package dut.fr.league;

import java.util.ArrayList;
import java.util.Random;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Capacitylist;
import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.PokemonTeam;

public class LeagueFactory {

	private static Random rand;
	private static Pokedex pokedex;
	
	public LeagueFactory(Pokedex pokedex) {
		rand = new Random();
		this.pokedex = pokedex;
	}
	
	private PokemonTeam createRandTeam(int size) {
		if (size >6 || size < 1) {
			throw new IllegalArgumentException("La taille de l'équipe doit être entre 1 et 6");
		}
		
		PokemonTeam t = new PokemonTeam();
		
		int i= 0;
		while (i<size) {
			int r = rand.nextInt(pokedex.getSize());
			
			FightingPokemon random = FightingPokemon.createFightingPokemon(r, pokedex);
			if (random != null) {
				ArrayList<Capacity> available = Capacitylist.capacitychoice(random.getTypes());
				for(int j=0; j<4; j++) {
					int id = rand.nextInt(available.size());
					random.addCapacity(available.get(id));
				}
				t.add(random);
				i++;
			}
		}
		return t;
		
	}
	
	public BasicLeague createBasicLigue() {
		int size = 5;
		return new BasicLeague(rand.nextInt(), this.createRandTeam(size), this.createRandTeam(size), this.createRandTeam(size), this.createRandTeam(size));
	}
	
	public DUT2League createDUT2Ligue() {
		int size=6;
		return new DUT2League(rand.nextInt(), this.createRandTeam(size),this.createRandTeam(size), this.createRandTeam(size)
				, this.createRandTeam(size), this.createRandTeam(size),this.createRandTeam(size), this.createRandTeam(size)
				, this.createRandTeam(size));
	}
	
}
