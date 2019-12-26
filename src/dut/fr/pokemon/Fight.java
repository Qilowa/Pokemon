package dut.fr.pokemon;

import java.util.Scanner;

public class Fight {
	private final PokemonTeam team1;
	private final PokemonTeam team2;
	
	public Fight(PokemonTeam team1, PokemonTeam team2) {
		this.team1 = team1;
		this.team2 = team2;
	}
	
	
	private static void printPanel() {
		
		System.out.println("1 : attaquer");
		System.out.println("2 : Changer de pok�mon");
		System.out.println("3 : Fuir");
		System.out.println("Que voulez vous faire ?");
	}
	
	public static void printCapacities(Capacity[] c) {
		for (int i=0; i<c.length; i++) {
			System.out.println((i)+": "+c[i]);
		}
		System.out.println("Que voulez vous faire ?");
		System.out.println("-1 pour retourner en arri�re");
	}
	
	public static void printTeam(PokemonTeam t) {
		for(int i=0; i<t.size(); i++) {
			FightingPokemon tmp = t.get(i);
			System.out.println((i+1)+" : "+tmp);
		}
	}
	
	private static void printOnBoard(FightingPokemon p) {
		p.showPicture();
		System.out.println("on Board : "+p.getName());
	}
	
	private static int getAttackChoice(Scanner sc, FightingPokemon pk) {
		int attackChoice= 0 ;
		
		Fight.printCapacities(pk.getCapacities());
		if (sc.hasNext()) {
			attackChoice = sc.nextInt();
		}
		return attackChoice;
	}
	
	private static int getPokemonChoice(Scanner sc, PokemonTeam team) {
		int choice2=0;
		
		Fight.printTeam(team);
		System.out.println("Choisissez un pok�mon (-1 pour retourner en arri�re)");
		if (sc.hasNext()) {
			choice2 = sc.nextInt();
		}
		return choice2;
	}
	

	public void fight() {
		System.out.println("D�but du COMBAT\n");
		
		FightingPokemon pk1 = team1.get(0); // Pokemon sur le board
		FightingPokemon pk2 = team2.get(0); // Pokemon sur le board
		
		
		Fight.printOnBoard(pk1);
		
		Fight.printOnBoard(pk2);
				
		Scanner sc = new Scanner(System.in);
		
		int attackChoice1=-1;
		
		int attackChoice2=-1;
		
		while (!team1.haveLost() || !team2.haveLost()) {
			System.out.println("\nJoueur 1");
			Fight.printPanel();
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				//Attaque
				attackChoice1 = getAttackChoice(sc, pk1);
				if (attackChoice1 == -1) {
					// -1 pour retourner en arri�re
					continue;
				}
				break;
			case 2:
				//Changer de pok�mon
				
				int choice2 = Fight.getPokemonChoice(sc, team1);
				if (choice2 == -1) {
					continue;
				}
				pk1 = team1.get(choice2);
				break;
				
			case 3:
				// Abandonner
				System.out.println("Joueur 1 a perdu !");
				return;
				
			}
			
			int choicet2 = sc.nextInt();
			System.out.println("\nJoueur 2");
			switch(choicet2) {
			case 1:
				//Attaque
				attackChoice2 = getAttackChoice(sc, pk1);
				if (attackChoice2 == -1) {
					// -1 pour retourner en arri�re
					continue;
				}
				break;
			case 2:
				//Changer de pok�mon
				
				int choice2 = Fight.getPokemonChoice(sc, team1);
				if (choice2 == -1) {
					continue;
				}
				pk1 = team1.get(choice2);
				break;
				
			case 3:
				// Abandonner
				System.out.println("Joueur 2 a perdu !");
				return;
				
			}
			
			if (pk1.isKO()) {
				System.out.println(pk1.getName()+" est KO");
				System.out.println("2 : Envoyer un pok�mon");
				System.out.println("3 : Fuir");
				System.out.println("Que voulez vous faire ?");
				int change;
				if (sc.hasNext()) {
					change = sc.nextInt();
					pk1 = team1.get(change);
					continue;
				}
			}
			
			if (pk2.isKO()) {
				System.out.println(pk2.getName()+" est KO");
				System.out.println("2 : Envoyer un pok�mon");
				System.out.println("3 : Fuir");
				System.out.println("Que voulez vous faire ?");
				int change;
				if (sc.hasNext()) {
					change = sc.nextInt();
					pk2 = team1.get(change);
					continue;
				}
			}
			
			// Si pok�mon KO
			/* int choice3 = 0;
			choice = sc.nextInt();
			
			while (!pk1.isKO() || choice3 == 3) {
				System.out.println(pk1.getName()+" est KO");
				System.out.println("2 : Envoyer un pok�mon");
				System.out.println("3 : Fuir");
				System.out.println("Que voulez vous faire ?");
				if (sc.hasNext()) {
					choice = sc.nextInt();
					pk1 = team1.get(choice3);
				}
			}
			
			if (choice3 == 0) {
				System.out.println("Joueur 1 envoie "+ pk1.getName());
			} */
			
			if (choice == 1) {
				if (pk1.getSpeed() >= pk2.getSpeed()) {
					pk1.attack(attackChoice1, pk2);
				} else {
					pk2.attack(attackChoice2, pk1);
				}
			}
			
			System.out.println(pk1.getName()+" a "+pk1.getCurrentHealth()+"/"+pk1.getMaxHealth()+" PV");
			System.out.println(pk2.getName()+" a "+pk2.getCurrentHealth()+"/"+pk2.getMaxHealth()+" PV");
			
		}
	}
}
