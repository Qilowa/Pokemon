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
		String TXT ="./RessourcesPokemon-20191205/Capacity.csv";
		Capacity[] capacity = new Capacity[729];
		BufferedReader reader = new BufferedReader(new FileReader(TXT));
		String line;
		boolean nameField = false;
	     
	    while ((line = reader.readLine()) != null) {
	    	if (nameField == false) {
	    		nameField = true;
	    		continue;
	    	}
	    	String[] array = line.split(",");
	    	if (array.length==7) {
	    		Integer id = Integer.parseInt(array[0]);
		    	String name = array[1];
		    	String type = array[2];
		    	Integer power = Integer.parseInt(array[3]);
		    	Integer pp = Integer.parseInt(array[4]);
		    	Integer precision = Integer.parseInt(array[5]);
		    	String category = array[6];
		        Capacity p = new Capacity(name, type, power,pp, precision,category);
		        capacity[id]=p;
			}
	    	if (array.length==6) {
	    		Integer id = Integer.parseInt(array[0]);
		    	String name = array[1];
		    	String type = array[2];
		    	Integer power = 0;
		    	Integer pp = Integer.parseInt(array[3]);
		    	Integer precision = Integer.parseInt(array[4]);
		    	String category = array[5];
		        Capacity p = new Capacity(name, type, power,pp, precision,category);
		        capacity[id]=p;
			}
	    	if (array.length==5) {
	    		Integer id = Integer.parseInt(array[0]);
		    	String name = array[1];
		    	String type = array[2];
		    	Integer power = 0;
		    	Integer pp = Integer.parseInt(array[3]);
		    	Integer precision = 0;
		    	String category = array[4];
		        Capacity p = new Capacity(name, type, power,pp, precision,category);
		        capacity[id]=p;
			}
	        
	    	}
	    /*Pokedex p = new Pokedex();
		try {
			p.createPokedex();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
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
		    System.out.println("Choissisez une capacités (id) : ");
		    int cp1 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité 1 : " + cp1);
		    //pokemon.addpacity(capacity[cp1]);
		    int cp2 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité 2 : " + cp2);
		    //pokemon.addpacity(capacity[cp2]);
		    int cp3 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité 3 : " + cp3);
		    //pokemon.addpacity(capacity[cp3]);
		    int cp4 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité 4 : " + cp4);
		    //pokemon.addpacity(capacity[cp4]);
		    //Pokémon.addlist
	    }
	}
}
