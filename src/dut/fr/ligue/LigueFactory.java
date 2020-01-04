package dut.fr.ligue;

import java.util.ArrayList;
import java.util.Random;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Capacitylist;
import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.PokemonTeam;

/**
 *Class that represents a Factory of League
 */
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
		
		int i= 0;
		while (i<size) {
			int r = rand.nextInt(pokedex.getSize());
			
			FightingPokemon random = FightingPokemon.createFightingPokemon(r);
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
	
	/**
	 * Create a BasicLigue
	 * @return BasicLigue
	 */
	public BasicLigue createBasicLigue() {
		int size = 5;
		return new BasicLigue(rand.nextInt(), this.createRandTeam(size), this.createRandTeam(size), this.createRandTeam(size), this.createRandTeam(size));
	}
	
	/**
	 * Create a DUT2Ligue
	 * @return DUT2Ligue
	 */
	public DUT2Ligue createDUT2Ligue() {
		int size=6;
		return new DUT2Ligue(rand.nextInt(), this.createRandTeam(size),this.createRandTeam(size), this.createRandTeam(size)
				, this.createRandTeam(size), this.createRandTeam(size),this.createRandTeam(size), this.createRandTeam(size)
				, this.createRandTeam(size));
	}
	
}
