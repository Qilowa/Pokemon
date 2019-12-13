package dut.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Capacitylist;
import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;

public class CapacityTest {

	public static void main(String[] args) throws IOException{
		Capacitylist c = Capacitylist.getInstance();
		Pokedex p = Pokedex.getInstance();
	    for (int i = 0; i < 6; i++) {
	    	Scanner sc = new Scanner(System.in);
			System.out.println(p.printPokedex());
		    System.out.println("Choissisez un Pokémon (id) : ");
		    int pk = sc.nextInt();
		    System.out.println("Vous avez saisi le Pokémon : " + pk);
		    FightingPokemon pokemon = FightingPokemon.createFightingPokemon(pk);
		    System.out.println(p.getPokemon(pk-1));
		    Capacity[] capacity=c.capacitychoice(p.getPokemon(pk).getTypes());//pk.gettype()
			/*System.out.println(capacity);
			for(int y = 1; y < capacity.length; y++)
		    {
		      System.out.println("id: " + y +" " + capacity[y]);
		    }*/
		    System.out.println("Choissisez une capacités (id) : ");
		    int cp1 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + cp1);
		    //pokemon.addpacity(capacity[cp1]);
		    int cp2 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + cp2);
		    //pokemon.addpacity(capacity[cp2]);
		    int cp3 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + cp3);
		    //pokemon.addpacity(capacity[cp3]);
		    int cp4 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + cp4);
		    //pokemon.addpacity(capacity[cp4]);
		    //Pokémon.addlist
	    }
	}
}
