package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import dut.fr.type.Type;

public class Pokedex implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 414282765508690974L;
	
	private static final String CSV ="RessourcesPokemon-20191205/pokedex.csv";
	private static ArrayList<Pokemon> pokedex;
	private static Pokedex onlyInstance;
	
	private Pokedex() {
		Pokedex.pokedex = new ArrayList<Pokemon>();
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
				String[] array = line.split(",", 7);
				Integer id = Integer.parseInt(array[0]);
				String name = array[1].toUpperCase();
				String picture = array[2];
				Integer height = Integer.parseInt(array[3]);
				Integer weight = Integer.parseInt(array[4]);
				Type type1 = Type.valueOf(array[5].toUpperCase());
				
				String s = array[6].toUpperCase();
				Type type2;
				if (s.isEmpty()) {
					type2 = null;
				} else {
					type2 = Type.valueOf(s);
				}
				
			    Pokemon p = new Pokemon(id, name, picture, height, weight, type1, type2);
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
	
	public static Pokemon getPokemon(int numPokedex) {
		Pokemon p = pokedex.get(numPokedex-1);
		return p;
	}
	
	@Override
	public String toString() {
		return pokedex.toString();
	}
	
	public int getSize() {
		return pokedex.size();
	}
	
}
