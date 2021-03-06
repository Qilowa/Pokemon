package dut.fr.fight;

import java.util.Arrays;
import java.util.Scanner;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.PokedexPokemon;
import dut.fr.pokemon.PokemonTeam;

/**
 * A class that contains the view
 */
public class Print {
	
	/**
	 * Print the menu of Fight
	 */
	static void printPanel() {
		System.out.println("----------MENU---------");
		System.out.println("1 : Attaquer");
		System.out.println("2 : Changer de pokemon");
		System.out.println("3 : Fuir");
		System.out.println("Que voulez vous faire ?");
		System.out.println("-----------------------");
	}
	
	/**
	 * Print the capacities in c
	 * @param c An array containing capacities
	 */
	static void printCapacities(Capacity[] c) {
		for (int i=0; i<c.length; i++) {
			System.out.println((i)+": "+c[i]);
		}
		System.out.println("----------------------------");
		System.out.println("Que voulez vous faire ?");
		System.out.println("-1 pour retourner en arriere");
		System.out.println("----------------------------");
	}
	
	/**
	 * Print a PokemonTeam
	 * @param t A PokemonTeam + an index
	 */
	static void printTeam(PokemonTeam t) {
		for(int i=0; i<t.size(); i++) {
			FightingPokemon tmp = t.get(i);
			System.out.println((i+1)+" : "+tmp);
		}
	}
	
	/**
	 * Print the Pokemon that is currently fighting
	 * @param p The Pokemon that is currently fighting
	 */
	static void printOnBoard(FightingPokemon p) {
		System.out.println("---------On board----------");
		System.out.println(p.getName());
	}
	
	private static int getLength(Capacity[] array) {
		return (int) Arrays.stream(array).filter(s->s != null).count();
	}
	
	/**
	 * Return the choice of attack that the user made
	 * @param sc Scanner 
	 * @param pk FightingPokemon currently fighting
	 * @return An Integer representing the index of the attack that the user chose
	 */
	static int getAttackChoice(Scanner sc, FightingPokemon pk) {
		System.out.println("--------Attack Choice--------");
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
	
	/**
	 * Return the choice of pokemon that the user made
	 * @param sc Scanner
	 * @param team PokemonTeam 
	 * @return An Integer representing the index of the Pokemon that the user chose
	 */
	static int getPokemonChoice(Scanner sc, PokemonTeam team) {
		 int choice2=0;
	        
	        Print.printTeam(team);
	        System.out.println("Choisissez un pokemon (-1 pour retourner en arriere)");
	        try {
	            choice2 = Integer.parseInt(sc.nextLine());
	        } catch (Exception e) {
	            
	        }
	        return choice2;
	}
	
	/**
	 * Print the choices left when the pokemon is KO
	 * @param pk the KO Pokemon
	 */
	static void printChoiceWhenKO() {
		System.out.println("----------MENU---------");
		System.out.println("1 : Envoyer un pokemon");
		System.out.println("2 : Fuir");
		System.out.println("Que voulez vous faire ?");
		System.out.println("-----------------------");
	}
}
