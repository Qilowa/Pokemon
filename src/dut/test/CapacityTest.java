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
			System.out.println(p);
		    System.out.println("Choissisez un Pokémon (id) : ");
		    int pk = sc.nextInt();
		    System.out.println("Vous avez saisi le Pokémon : " + p.getPokemon(pk-1));
		    FightingPokemon pokemon = FightingPokemon.createFightingPokemon(pk);
		    System.out.println(pokemon);
		    Capacity[] capacitylist=c.capacitychoice(p.getPokemon(pk).getTypes());//pk.gettype()
			for(int y = 1; y < capacitylist.length; y++)
		    {
		      System.out.println("id: " + y +" " + capacitylist[y]);
		    }
		    System.out.println("Choissisez votre 1ère capacité (id) : ");
		    int cp1 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist[cp1]);
		    pokemon.addCapacity(capacitylist[cp1]);
		    //pokemon.addpacity(capacity[cp1]);
		    System.out.println("Choissisez votre 2ème capacité (id) : ");
		    int cp2 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist[cp2]);
		    pokemon.addCapacity(capacitylist[cp2]);
		    //pokemon.addpacity(capacity[cp2]);
		    System.out.println("Choissisez votre 3ème capacité (id) : ");
		    int cp3 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist[cp3]);
		    pokemon.addCapacity(capacitylist[cp3]);
		    //pokemon.addpacity(capacity[cp3]);
		    System.out.println("Choissisez votre 4ème capacité (id) : ");
		    int cp4 = sc.nextInt();
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist[cp4]);
		    pokemon.addCapacity(capacitylist[cp4]);
		    //pokemon.addpacity(capacity[cp4]);
		    //Pokémon.addlist
	    }
	}
}
