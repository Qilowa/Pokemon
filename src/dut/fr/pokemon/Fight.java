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
	
	public static void printCapacities(Capacity[] c) {
		for (int i=0; i<c.length; i++) {
			System.out.println((i+1)+": "+c[i]);
		}
		System.out.println("Que voulez vous faire ?");
		System.out.println("-1 pour retourner en arrière");
	}
	
	public static void printTeam(PokemonTeam t) {
		for(int i=0; i<t.size(); i++) {
			FightingPokemon tmp = t.get(i);
			System.out.println((i+1)+" : "+tmp);
		}
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
				Fight.printCapacities(pk1.getCapacities());
				if (sc.hasNext()) {
					int attackChoice = sc.nextInt();
					if (attackChoice == -1) {
						continue;
					}
					pk1.attack(attackChoice-1, pk2);
					
					
				}
				break;
			case 2:
				Fight.printTeam(team1);
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
			int choice3 = 0;
			
			while (!pk1.isKO() || choice3 == 3) {
				System.out.println(pk1.getName()+" est KO");
				System.out.println("2 : Envoyer un pokémon");
				System.out.println("3 : Fuir");
				System.out.println("Que voulez vous faire ?");
				if (sc.hasNext()) {
					pk1 = team1.get(choice3);
				}
			}
			
			if (choice3 == 0) {
				System.out.println("Joueur 1 envoie "+ pk1.getName());
			}
			
			System.out.println(pk1.getName()+" a "+pk1.getCurrentHealth());
			System.out.println(pk2.getName()+" a "+pk2.getCurrentHealth());
			
		}
	}
}
