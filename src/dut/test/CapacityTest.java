package dut.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Pokemon;

public class CapacityTest {

	public static void main(String[] args) throws IOException{
		String TXT ="./RessourcesPokemon-20191205/Capacity.txt";
		Capacity[] capacity = new Capacity[6];
		BufferedReader reader = new BufferedReader(new FileReader(TXT));
		String line;
		int c=0;
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
	        capacity[c]=p;
	        //System.out.println(p);
	        c++;
	        
	    	}
	    for(int i = 0; i < capacity.length; i++)
	    {
	      System.out.println("À l'emplacement " + i +" du tableau nous avons = " + capacity[i]);
	    }
	    System.out.println(capacity[1].getName());
	}
}
