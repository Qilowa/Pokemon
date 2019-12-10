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
	        System.out.println(p);
	        
	    }
		
	}
	
}
