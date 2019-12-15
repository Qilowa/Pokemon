package dut.fr.pokemon;

import java.util.Scanner;

public class Fight {
	
	private static void printPanel() {
		System.out.println("\nJoueur 1");
		System.out.println("1 : Attaquer");
		System.out.println("2 : Changer de pokémon");
		System.out.println("3 : Fuir");
		System.out.println("Que voulez vous faire ?");
	}
	

	public static void fight(PokemonTeam team1, PokemonTeam team2) {
		System.out.println("Début du COMBAT\n");
		
		FightingPokemon pk1 = team1.get(0); // Pokemon sur le board
		FightingPokemon pk2 = team2.get(0); // Pokemon sur le board
		
		
		System.out.println("Joueur 1 envoie "+ pk1.getName());
		
		System.out.println("Joueur 2 envoie "+ pk2.getName());
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while (!team1.haveLost() || !team2.haveLost()) {
			Fight.printPanel();
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println(pk1.getCapacities().toString());
				break;
			case 2:
				for(int i=0; i<team1.size(); i++) {
					FightingPokemon tmp = team1.get(i);
					System.out.println((i+1)+" : "+tmp);
				}
				System.out.println("Choisissez un pokémon (-1 pour retourner en arrière)");
				if (sc.hasNext()) {
					int choice2 = sc.nextInt();
					if (choice2 == -1) {
						continue;
					}
					pk1 = team1.get(choice2);
					
					
				}
				break;
				
			case 3:
				System.out.println("Joueur 1 a perdu !");
				return;
				
			}
			
		}
	}
}
