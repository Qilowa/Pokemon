package dut.fr.pokemon;

import java.util.HashMap;

public enum Type {
	STEEL(new HashMap<Type, Integer>()),
	FIGHTING(new HashMap<Type, Integer>()),
	DRAGON(new HashMap<Type, Integer>()),
	WATER(new HashMap<Type, Integer>()),
	ELECTRIC(new HashMap<Type, Integer>()),
	FAIRY(new HashMap<Type, Integer>()),
	FIRE(new HashMap<Type, Integer>()),
	ICE(new HashMap<Type, Integer>()),
	BUG(new HashMap<Type, Integer>()),
	NORMAL(new HashMap<Type, Integer>()),
	GRASS(new HashMap<Type, Integer>()),
	POISON(new HashMap<Type, Integer>()),
	PSYCHIC(new HashMap<Type, Integer>()),
	ROCK(new HashMap<Type, Integer>()),
	GROUND(new HashMap<Type, Integer>()),
	GHOST(new HashMap<Type, Integer>()),
	DARK(new HashMap<Type, Integer>()),
	FLYING(new HashMap<Type, Integer>());
	
	 private final HashMap<Type, Integer> hash;
	 private static final String path = "/RessourcesPokemon-20191205/grid_types.csv";
	
	Type(HashMap<Type, Integer> a) {
		hash = a;
	}
	
	public static void load() {
		
	}

}
