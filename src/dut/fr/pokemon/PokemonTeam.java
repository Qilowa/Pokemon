package dut.fr.pokemon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
	
	public void createTeam(Pokedex p) {
		for (int i = 0; i < 6; i++) {
	    	Scanner sc = new Scanner(System.in);
			System.out.println(p);
		    System.out.println("Choissisez un Pokémon (id) : ");
		    int pk = sc.nextInt();
		    System.out.println("Vous avez saisi le Pokémon : " + p.getPokemon(pk));
		    FightingPokemon pokemon = FightingPokemon.createFightingPokemon(pk, p);
		    System.out.println(pokemon);
		    ArrayList<Capacity> capacitylist=Capacitylist.capacitychoice(p.getPokemon(pk).getTypes());//pk.gettype()
			for(int y = 0; y < capacitylist.size(); y++)
		    {
		      System.out.println("id: " + y +" " + capacitylist.get(y));
		    }
		    System.out.println("Choissisez votre 1ère capacité (id) : ");
		    int cp1 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist.get(cp1));
		    pokemon.addCapacity(capacitylist.get(cp1));
		    //pokemon.addpacity(capacity[cp1]);
		    
		    
		    System.out.println("Choissisez votre 2ème capacité (id) : ");
		    int cp2 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist.get(cp2));
		    pokemon.addCapacity(capacitylist.get(cp2));
		    //pokemon.addpacity(capacity[cp2]);
		    
		    
		    System.out.println("Choissisez votre 3ème capacité (id) : ");
		    int cp3 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist.get(cp3));
		    pokemon.addCapacity(capacitylist.get(cp3));
		    //pokemon.addpacity(capacity[cp3]);
		    
		    
		    System.out.println("Choissisez votre 4ème capacité (id) : ");
		    int cp4 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist.get(cp4));
		    pokemon.addCapacity(capacitylist.get(cp4));
		    //pokemon.addpacity(capacity[cp4]);
		    
		    
		    this.add(pokemon);
		    
	    }
	    System.out.println("Voici vos pokémons : ");
	    System.out.println(this.toString());
	}
	
	private boolean isEmpty() {
		if (array.size() <= 0) {
			return true;
		}
		return false;
	}
	
	public boolean haveLost() {
		if (this.isEmpty()) {
			throw new IllegalStateException("Please add pokemon to your team");
		}
		
		for (int i=0; i<array.size(); i++) {
			FightingPokemon p = array.get(i);
			if (!p.isKO()) {
				return false;
			}
		}
		return true;
		
	}
	
	public FightingPokemon get(int index) {
		return array.get(index);
	}
	
	public int size() {
		return array.size();
	}

}
