package dut.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;

public class PokedexTest {
	public static void main(String[] args) throws IOException {
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
		/*Pokedex p = new Pokedex();
		try {
			p.createPokedex();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		Pokemon a =new Pokemon(2, "pikachu", "img/025.png",10,130, null, null);
		a.showPicture();
		System.out.println(a);
		a.rename("pierre");
		System.out.println(a);
		Capacity p1 = new Capacity("Affutage", "NORMAL", "Status", 0, 0, 30);
		a.addcapacity(capacity[0]);
		System.out.println(a.showcapacity());
		//test
		
	}
	
}
