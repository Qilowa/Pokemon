package dut.fr.fight;

import java.util.Scanner;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokemon;
import dut.fr.pokemon.PokemonTeam;

public class Print {
static void printPanel() {
		
		System.out.println("1 : attaquer");
		System.out.println("2 : Changer de pokemon");
		System.out.println("3 : Fuir");
		System.out.println("Que voulez vous faire ?");
	}
	
	static void printCapacities(Capacity[] c) {
		for (int i=0; i<c.length; i++) {
			System.out.println((i)+": "+c[i]);
		}
		System.out.println("Que voulez vous faire ?");
		System.out.println("-1 pour retourner en arriere");
	}
	
	static void printTeam(PokemonTeam t) {
		for(int i=0; i<t.size(); i++) {
			FightingPokemon tmp = t.get(i);
			System.out.println((i+1)+" : "+tmp);
		}
	}
	
	static void printOnBoard(FightingPokemon p) {
		p.showPicture();
		System.out.println("on Board : "+p.getName());
	}
	
	private static <T> int getLength(T[] array) {
		int count = 0;
	    for(T el : array)
	        if (el != null)
	            ++count;
	    return count;
	}
	
	static int getAttackChoice(Scanner sc, FightingPokemon pk) {
		int attackChoice= -1 ;
		
		Print.printCapacities(pk.getCapacities());
		if (sc.hasNextInt()) {
			attackChoice = sc.nextInt();
			String s = sc.nextLine(); // Consummer la ligne
			if (Print.getLength(pk.getCapacities()) <= attackChoice) {
				return 5;
			}
		} else {
			return 5;
		}
		
		return attackChoice;
	}
	
	static int getPokemonChoice(Scanner sc, PokemonTeam team) {
		int choice2=0;
		
		Print.printTeam(team);
		System.out.println("Choisissez un pokemon (-1 pour retourner en arriere)");
		if (sc.hasNext()) {
			choice2 = sc.nextInt();
		}
		return choice2;
	}
	
	static void printChoiceWhenKO(Pokemon pk) {
		System.out.println(pk.getName()+" est KO");
		System.out.println("1 : Envoyer un pokemon");
		System.out.println("2 : Fuir");
		System.out.println("Que voulez vous faire ?");
	}
}
