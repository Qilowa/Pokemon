package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FightingPokemon {
	private static final String path = "RessourcesPokemon-20191205/stats.csv";
	
	private final Pokemon pokemon;
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
		this.pokemon = pokemon;
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
	
	
	public static FightingPokemon createFightingPokemon(int numPokedex) {
		Pokemon pokemon = Pokedex.getPokemon(numPokedex);
		
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
	
	
}
