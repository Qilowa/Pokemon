package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pokedex {
	private static final String CSV ="./RessourcesPokemon-20191205/pokedex.csv";
	private final ArrayList<Pokemon> pokedex;
	
	public Pokedex() {
		this.pokedex = new ArrayList<Pokemon>();
	}
	
	public void createPokedex() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(CSV));
		String line;
		boolean nameField = false;
	     
	    while ((line = reader.readLine()) != null) {
	    	if (nameField == false) {
	    		nameField = true;
	    		continue;
	    	}
	    	String[] array = line.split(",", 7);
	    	Integer id = Integer.parseInt(array[0]);
	    	String name = array[1];
	    	String picture = array[2];
	    	Integer height = Integer.parseInt(array[3]);
	    	Integer weight = Integer.parseInt(array[4]);
	    	String type1 = array[5];
	    	String type2 = array[6];
	    	
	        Pokemon p = new Pokemon(id, name, picture, height, weight, null, null);
	        System.out.println(p);
	        
	    }
		
	}
	
}
