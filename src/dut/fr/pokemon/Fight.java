package dut.fr.pokemon;

import java.util.Scanner;

public class Fight {

	public static void fight(PokemonTeam team1, PokemonTeam team2) {
		System.out.println("Début du COMBAT\n");
		
		FightingPokemon pk1 = team1.get(0); // Pokemon sur le board
		FightingPokemon pk2 = team2.get(0); // Pokemon sur le board
		
		
		System.out.println("Joueur 1 envoie "+ pk1.getName());
		
		System.out.println("Joueur 2 envoie "+ pk2.getName());
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while (!team1.haveLost() || !team2.haveLost()) {
			System.out.println("\nJoueur 1");
			System.out.println("1 : Attaquer");
			System.out.println("2 : Changer de pokémon");
			System.out.println("3 : Fuir");
			System.out.println("Que voulez vous faire ?");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println();
				break;
			case 2:
				
				
			case 3:
				break;
				
			}
			
		}
	}
}
