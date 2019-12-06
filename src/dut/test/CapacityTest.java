package dut.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Pokemon;

public class CapacityTest {

	public static void main(String[] args) throws IOException{
		String CSV ="./RessourcesPokemon-20191205/Capacity.txt";
		ArrayList<String> capacity;
		BufferedReader reader = new BufferedReader(new FileReader(CSV));
		String line;
		boolean nameField = false;
	     
	    while ((line = reader.readLine()) != null) {
	    	if (nameField == false) {
	    		nameField = true;
	    		continue;
	    	}
	    	String[] array = line.split(",", 6);
	    	String name = array[0];
	    	String type = array[1];
	    	String category = array[2];
	    	Integer power = Integer.parseInt(array[3]);
	    	Integer precision = Integer.parseInt(array[4]);
	    	Integer pp = Integer.parseInt(array[5]);
	    	
	        Capacity p = new Capacity(name, type, category, power, precision, pp);        
	        System.out.println(p);

	    	}
	}
}
