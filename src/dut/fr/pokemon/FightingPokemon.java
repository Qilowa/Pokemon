package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import dut.fr.type.Type;

import dut.fr.type.TypeAffinity;

public class FightingPokemon extends Pokemon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7943795484011533552L;

	private static final String path = "RessourcesPokemon-20191205/newstats.txt";

	private String name;
	private final int experience;
	private final int health;
	private final int phyAttack;
	private final int speAttack;
	private final int phyDefense;
	private final int speDefense;
	private final int speed;
	private final Capacity[] capacities;
	private int numberCapacity;
	private int currentHealth;
	
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
		this.currentHealth = health;
	}
	
	private FightingPokemon(Pokemon pokemon, int health, int phyAttack, int speAttack, int phyDefense, int speDefense,
			int speed, Capacity[] capacities) {
		this(pokemon, pokemon.getName(), 0, health, phyAttack, speAttack, phyDefense, speDefense, speed);
		
	}
	
	
	@Override
	public String toString() {
		return String.format("%s, EXP:%d, HP:%d/%d, ATT:%d, DEF:%d, SP.ATT:%d, SP.DEF:%d, SPEED:%d", 
				name, experience, currentHealth, health, phyAttack, phyDefense, speAttack, speDefense, speed);
	}
	
	
	public static FightingPokemon createFightingPokemon(int numPokedex) {
		/**
		 * Creates a new FightingPokemon
		 * @param numPokedex id of the pokemon in the pokedex
		 * @return a new FightingPokemon
		 */
		Pokemon pokemon = Pokedex.getPokemon(numPokedex);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
		     
		    while ((line = reader.readLine()) != null) {
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
		/**
		 * Add a capacity to the Pokemon
		 * @param c the capacity added
		 */
		if (numberCapacity > 4 || numberCapacity < 0) {
			throw new IllegalStateException("cannot add another capacity");
		}
		capacities[numberCapacity] = Objects.requireNonNull(c);
		numberCapacity++;
	}
	
	public void rename(String newname) {
		/**
		 * Rename the pokemon
		 * @param newname The new name of the pokemon
		 */
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
		/**
		 * Return if the pokemon is KO
		 * @return true if the pokemon is KO, false otherwise
		 */
		if (currentHealth <= 0) {
			return true;
		}
		
		return false;
	}
	
	public Capacity[] getCapacities() {
		/**
		 * Return the capacities of the Pokemon
		 * @return An array containing the capacities
		 */
		return capacities;
	}
	
	public int getDefense() {
		/**
		 * Return the defense of the pokemon
		 */
		return phyDefense;
	}
	
	public int getSpeDefense() {
		/**
		 * Return the special defense of the pokemon
		 */
		return speDefense;
	}
	
	@Override
	public String getName() {
		/**
		 * Return the name of the pokemon
		 */
		return name;
	}
	
	public int getCurrentHealth() {
		/**
		 * Return the Current Health of the pokemon
		 */
		return currentHealth;
	}
	
	public void attack(int capacityID, FightingPokemon pk, TypeAffinity table) {
		/**
		 * Attack another pokemon
		 * @param capacityID the ID of the capacity chosen
		 * @param pk is the Pokemon you want to attack
		 * @param table is the Affinity of type
		 */
		int lostHealth = 0;
		
		Capacity cap = capacities[capacityID];
		
		if (cap.getPP() <= 0) {
			System.out.println("Pas assez de pp");
			return;
		}
		
		Type[] types = pk.getTypes();
		
		double aff = table.getAffinity(types).get(cap.getType());
		
		if (cap.getCategory() == Category.physical) {
			lostHealth = (int) (((((50*0.4+2)*this.phyAttack*1*cap.getPower())/(pk.getDefense()*1*50))+2)*aff);
		}
		if (cap.getCategory() == Category.special) {
			lostHealth = (int) (((((50*0.4+2)*this.speAttack*1*cap.getPower())/(pk.getSpeDefense()*1*50))+2)*aff);
		}
		pk.getDamaged(lostHealth);
		cap.reducePP();
		
		System.out.println(this.name+" lance " + cap.getName());
		
		System.out.println(pk.getName()+": -"+lostHealth+"PV");
	}
	
	
	private void getDamaged(int lostHP) {
		this.currentHealth -= lostHP;
	}
	
	public int getSpeed() {
		/**
		 * Return the speed of the Pokemon
		 * @return An int that specifies the pokemon's speed
		 */
		return speed;
	}
	
	public int getMaxHealth() {
		/** Return the pokemon's Max Health
		 * @return Pokemon's Max Health
		 */
		return health;
	}
	
	public int getNumCapacity() {
		/**
		 *  Return the number of capacity that the Pokemon has
		 *  @return Number of capacity of the Pokemon
		 */
		return numberCapacity;
	}
	
}
