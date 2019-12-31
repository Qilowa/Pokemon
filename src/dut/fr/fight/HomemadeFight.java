package dut.fr.fight;

import java.util.Random;
import java.util.Scanner;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.PokemonTeam;

public class HomemadeFight extends AbstractFight{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6543156436059906943L;

	HomemadeFight(PokemonTeam team1, PokemonTeam team2) {
		super(team1, team2);
	}
	
	@Override
	public int fight() {
		/* Regles speciales */
		PokemonTeam team1 = super.getTeam1();
		PokemonTeam team2 = super.getTeam2();
		
		System.out.println("Debut du COMBAT\n");
		
		FightingPokemon pk1 = team1.get(0); // Pokemon sur le board
		FightingPokemon pk2 = team2.get(0); // Pokemon sur le board
		
		
		AbstractFight.printOnBoard(pk1);
		
		AbstractFight.printOnBoard(pk2);
				
		Scanner sc = new Scanner(System.in);
		
		int attackChoice1=-1;
		
		int attackChoice2=-1;
		
		while (!team1.haveLost() || !team2.haveLost()) {
			Random rand = new Random();
			
			System.out.println("\nJoueur 1");
			AbstractFight.printPanel();
					
			int choice = sc.nextInt();
					
			switch(choice) {
				case 1:
					//Attaque
					attackChoice1 = getAttackChoice(sc, pk1);
					
					if (attackChoice1 == -1) {
						// -1 pour retourner en arriere
						continue;
					}
					break;
				case 2:
					//Changer de pokemon
					do {	
						int choice2 = rand.nextInt(6);
						pk1 = team1.get(choice2);
					} while (pk1.isKO());
					System.out.println(pk1.getName()+" est envoyé au combat !");
					break;
						
				case 3:
					// Abandonner
					System.out.println("Joueur 1 a perdu !");
					return 2;
			}
					
			System.out.println("\nJoueur 2");
			AbstractFight.printPanel();
			int choicet2 = sc.nextInt();
			switch(choicet2) {
				case 1:
					//Attaque
					attackChoice2 = getAttackChoice(sc, pk2);
					if (attackChoice2 == -1) {
						// -1 pour retourner en arriere
						continue;
					}
					break;
				case 2:
					//Changer de pokemon
					do {
						int choice2 = rand.nextInt(6);
						if (choice2 == -1) {
							continue;
						}
						pk2 = team2.get(choice2);
					} while (pk2.isKO());
					break;
						
				case 3:
					// Abandonner
					System.out.println("Joueur 2 a perdu !");
					return 1;
			}
					
					
			if (pk1.isKO()) {
				do {
					AbstractFight.printChoiceWhenKO(pk1);
					int change;
					if (sc.hasNext()) {
						change = sc.nextInt();
						if (change == 1) {
							//Switch
							pk1 = team1.get(change);
							continue;
						} else {
							// Abandon
							System.out.println("Joueur 1 a perdu !");
							return 2;
							
						}
						
					}
				} while (pk1.isKO());
				
			}
					
			if (pk2.isKO()) {
				do {
				AbstractFight.printChoiceWhenKO(pk2);
				int change;
					if (sc.hasNext()) {
					change = sc.nextInt();
					if (change == 1) {
						//Switch
						pk2 = team2.get(change);
						continue;
					} else {
						// Abandon
						System.out.println("Joueur 2 a perdu !");
						return 1;
					}
					
				}
			} while (pk2.isKO());
			}
					
			if (choice == 1 && choicet2 == 1) {
				if (pk1.getSpeed() >= pk2.getSpeed()) {
					pk1.attack(attackChoice1, pk2, table);
					if (!pk2.isKO()) {
						pk2.attack(attackChoice2, pk1, table);
					}
				} else {
					pk2.attack(attackChoice2, pk1, table);
					if (!pk1.isKO()) {
						pk1.attack(attackChoice1, pk2, table);
					}
				}
			}
					
					
			if (choice==1 && choicet2 != 1) {
				pk1.attack(attackChoice1, pk2, table);
			}
			if (choicet2 == 2 && choice!=1) {
				pk2.attack(attackChoice2, pk1, table);
			} 
					
			System.out.println(pk1.getName()+" a "+pk1.getCurrentHealth()+"/"+pk1.getMaxHealth()+" PV");
			System.out.println(pk2.getName()+" a "+pk2.getCurrentHealth()+"/"+pk2.getMaxHealth()+" PV");
					
		}
		if (team1.haveLost()) {
			return 2;
		}
		return 1;
				
			
	}

}
