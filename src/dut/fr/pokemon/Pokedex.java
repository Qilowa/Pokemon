package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import dut.fr.type.Type;

/**
 * A class that contains all the Pokemon of the Pokedex
 * 
 *
 */
public class Pokedex implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 414282765508690974L;
	
	private static final String CSV ="RessourcesPokemon-20191205/pokedex.csv";
	private static ArrayList<PokedexPokemon> pokedex;
	private static Pokedex onlyInstance;
	
	private Pokedex() {
		Pokedex.pokedex = new ArrayList<PokedexPokemon>();
		BufferedReader reader;
		String line;
		boolean nameField = false;
	     
	    try {
	    	reader = new BufferedReader(new FileReader(CSV));
	    	
			while ((line = reader.readLine()) != null) {
				if (nameField == false) {
					nameField = true;
					continue;
				}
			    PokedexPokemon p = PokedexPokemon.createPokemon(line);
			    pokedex.add(p);
			    // System.out.println(p);
			    
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Pokedex getInstance() {
		if (onlyInstance == null) {
			onlyInstance = new Pokedex();
		}
		return onlyInstance;
	}
	
	/**
	 * Return the Pokedex that has the numPokedex ID
	 * @param numPokedex the ID of the Pokedex you want
	 * @return A Pokedex of the Pokedex
	 */
	public static PokedexPokemon getPokemon(int numPokedex) {
		PokedexPokemon p = pokedex.get(numPokedex-1);
		return p;
	}
	
	@Override
	public String toString() {
		return pokedex.toString();
	}
	
	/**
	 * Return the size of the Pokedex
	 * @return An integer representing the number of pokemon
	 */
	public int getSize() {
		return pokedex.size();
	}
	
}
