package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class FightingPokemon extends Pokemon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7943795484011533552L;

	private static final String path = "RessourcesPokemon-20191205/stats.csv";

	private String name;
	private int experience;
	private int health;
	private int phyAttack;
	private int speAttack;
	private int phyDefense;
	private int speDefense;
	private int speed;
	private Capacity[] capacities;
	private int numberCapacity;
	
	private FightingPokemon(Pokemon pokemon, String name, int experience, int health, int phyAttack, int speAttack, int phyDefense, int speDefense,
			int speed) {
		super(pokemon.getNumPokedex(), pokemon.getName(), pokemon.getImgPath(), pokemon.getHeight(), pokemon.getWeight(), pokemon.getTypes() );
		this.name = name;
		this.experience = experience;
		this.health = health;
		this.phyAttack = phyAttack;
		this.speAttack = speAttack;
		this.phyDefense = phyDefense;
		this.speDefense = speDefense;
		this.speed = speed;
		this.capacities = new Capacity[4];
		this.numberCapacity = 0;
	}
	
	private FightingPokemon(Pokemon pokemon, int health, int phyAttack, int speAttack, int phyDefense, int speDefense,
			int speed, Capacity[] capacities) {
		this(pokemon, pokemon.getName(), 0, health, phyAttack, speAttack, phyDefense, speDefense, speed);
		
	}
	
	
	@Override
	public String toString() {
		return String.format("%s, EXP:%d, HP:%d, ATT:%d, DEF:%d, SP.ATT:%d, SP.DEF:%d, SPEED:%d", 
				name, experience, health, phyAttack, phyDefense, speAttack, speDefense, speed);
	}
	
	
	public static FightingPokemon createFightingPokemon(int numPokedex, Pokedex pokedex) {
		Pokemon pokemon = pokedex.getPokemon(numPokedex);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			boolean nameField = false;
		     
		    while ((line = reader.readLine()) != null) {
		    	if (nameField == false) {
		    		nameField = true;
		    		continue;
		    	}
		    	String[] array = line.split(",", 13);
		    	Integer id = Integer.parseInt(array[0]);
		    	if (id == numPokedex) {
		    		Integer hp = Integer.parseInt(array[5]);
			    	Integer attack = Integer.parseInt(array[6]);
			    	Integer def = Integer.parseInt(array[7]);
			    	Integer spAttack = Integer.parseInt(array[8]);
			    	Integer spDef = Integer.parseInt(array[9]);
			    	Integer speed = Integer.parseInt(array[10]);
			    	return new FightingPokemon(pokemon, hp, attack, spAttack, def, spDef, speed, null);
		    	}
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	public void addCapacity(Capacity c) {
		if (numberCapacity >= 4) {
			throw new IllegalStateException("cannot add another capacity");
		}
		capacities[numberCapacity] = Objects.requireNonNull(c);
		numberCapacity++;
	}
	
	public void rename(String newname) {
		this.name = Objects.requireNonNull(newname);
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof FightingPokemon)) {
			return false;
		}
		FightingPokemon p = (FightingPokemon) o;
		return super.equals(p) && this.name.equals(p.name) && this.capacities.equals(p.capacities)
				&& p.experience == this.experience && p.health == this.health && p.numberCapacity == this.numberCapacity 
				&& p.phyAttack == this.phyAttack && p.phyDefense == this.phyDefense && p.speAttack == this.speAttack &&
				p.speDefense == this.speDefense && p.speed == this.speed;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), experience, capacities, health, numberCapacity, phyAttack, phyDefense, speAttack, speDefense, speed);
	}
	
	public boolean isKO() {
		if (health <= 0) {
			return true;
		}
		
		return false;
	}
	
	public Capacity[] getCapacities() {
		return capacities;
	}
	
	
}
