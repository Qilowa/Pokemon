package dut.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;

public class CapacityTest {

	public static void main(String[] args) throws IOException{
		String TXT ="./RessourcesPokemon-20191205/Capacity.txt";
		Capacity[] capacity = new Capacity[4];
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
	    Pokedex p = new Pokedex();
		try {
			p.createPokedex();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    for(int i = 0; i < capacity.length; i++)
	    {
	      System.out.println("id: " + i +" " + capacity[i]);
	    }
	    for (int i = 0; i < 6; i++) {
	    	Scanner sc = new Scanner(System.in);
		    System.out.println("Choissisez un Pokémon (id) : ");
		    int pk1 = sc.nextInt();
		    System.out.println("Vous avez saisi le Pokémon : " + pk1);
		    //new Pokémon
		    //Pokémon.addlist
		    System.out.println("Choissisez une capacités (id) : ");
		    int cp1 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité 1 : " + cp1);
		    int cp2 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité 2 : " + cp2);
		    int cp3 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité 3 : " + cp3);
		    int cp4 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité 4 : " + cp4);
	    }
	}
}
