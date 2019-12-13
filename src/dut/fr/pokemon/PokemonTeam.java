package dut.fr.pokemon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class PokemonTeam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1698139518706136991L;
	
	private final ArrayList<FightingPokemon> array;
	private static final int MAX_SIZE=6;
	private int size;
	
	public PokemonTeam() {
		this.array = new ArrayList<FightingPokemon>();
		size = 0;
	}
	
	public void add(FightingPokemon p) {
		if (this.size >= MAX_SIZE) {
			throw new IllegalStateException("Your team is already full");
		}
		array.add(p);
		size++;
	}
	
	@Override
	public String toString() {
		return array.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PokemonTeam)) {
			return false;
		}
		PokemonTeam team = (PokemonTeam) o;
		return team.size == this.size && this.array.equals(team.array);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(array, size);
	}
	
}
