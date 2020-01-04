package dut.fr.fight;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.PokemonTeam;

public class SoloFight extends AbstractFight{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5476983139756810573L;

	public SoloFight(PokemonTeam team1, PokemonTeam team2) {
		super(team1, team2);
	}
	
	@Override
	public int fight() {
		// Return 1 if player 1 wins and 0 if player 2 wins
		Random r = new Random();
		PokemonTeam team1 = super.getTeam1();
		PokemonTeam team2 = super.getTeam2();
		
		System.out.println("Debut du COMBAT\n");
		
		FightingPokemon pk1 = team1.get(0); // Pokemon that is currently fighting
		FightingPokemon pk2 = team2.get(0); // Pokemon that is currently fighting
		
		
		Print.printOnBoard(pk1);
		
		Print.printOnBoard(pk2);
				
		Scanner sc = new Scanner(System.in);
		
		int attackChoice1=-1;
		
		int attackChoice2=-1;
		
		int i=1;
		
		int choice = -1;
		
		while (!team1.haveLost() || !team2.haveLost()) {
			System.out.println("\nJoueur 1");
			Print.printPanel();
			
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch(Exception e) {
				
			}
				
			
			switch(choice) {
			
			case 1:
				//Attaque
					attackChoice1 = Print.getAttackChoice(sc, pk1);
					if (attackChoice1 == -1) {
						// -1 to got back
						continue;
					}
					
				if (attackChoice1 != 0 && attackChoice1 != 1 && attackChoice1 != 2 && attackChoice1 != 3) {
					System.out.println("Choisissez une attaque adéquate !");
					continue;
				}
				
				break;
			case 2:
				int choice2 = -1;
                do {
                    choice2 = Print.getPokemonChoice(sc, team1);
                    if (choice2 == -1) {
                    	break;
                    }
                    pk1 = team1.get(choice2-1);
                    
                } while (pk1==null || pk1.isKO());
                choice = 2;
                if (choice2 == -1) {
                	
                	continue;
                }

                System.out.println(pk1.getName()+" est envoye au combat !");
                break;
			case 3:
				// Give up
				System.out.println("Joueur 1 a perdu !");
				return 0;
			default:
				System.out.println("\nChoisir une option adequate");
				continue;
			
			}
			int v = r.nextInt(pk2.getNumCapacity());
			attackChoice2 = v;
			
			if (choice == 2 ) {
				pk2.attack(attackChoice2, pk1, table);
			}
			
			if (choice == 1) {
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
			
			if (pk1.isKO()) {
				System.out.println(pk1.getName()+" est KO");
				if (team1.haveLost()) {
					System.out.println("Vous avez perdu !");
					return 0;
				}
				Print.printChoiceWhenKO(pk1);
				int change = -1;
                do {
                	if (sc.hasNextInt()) {
                        change = sc.nextInt();
                	}
                	System.out.println(change);
                        if (change == 1) {
                            //Switch
                            do {
                                Print.printTeam(team1);
                                System.out.println("-1 pour abandonner");
                                int pokemonchoice = sc.nextInt();
                                if (pokemonchoice==-1) {
                                    System.out.println("Joueur 1 a perdu !");
                                    return 2;
                                }
                                pk1 = team1.get(pokemonchoice-1);
                            } while (pk1 == null || pk1.isKO());
                            
                            System.out.println(pk1.getName()+" est envoyÃ© au combat !");
                            choice=-1;
                            continue;
                        } 
                        if (change == 2){
                            // Give up
                            System.out.println("Joueur 1 a perdu !");
                            return 2;
                        }
                        else {
                        	System.out.println(change);
                            System.out.println("Choisissez une option adéquate");
                        }
                	
                        
                } while (change != 1 && change != 2);
				
			}
			
			if (pk2.isKO()) {
				System.out.println(pk2.getName()+" est KO");
				if (team2.haveLost()) {
					System.out.println("Vous avez gagné !");
					return 1;
				}
				pk2 = team2.get(i);
				System.out.println(pk2.getName()+" est envoyÃ© au combat !");
				i++;
			}
			
			
			System.out.println(pk1.getName()+" a "+pk1.getCurrentHealth()+"/"+pk1.getMaxHealth()+" PV");
			System.out.println(pk2.getName()+" a "+pk2.getCurrentHealth()+"/"+pk2.getMaxHealth()+" PV");
			
		}
		
		if (team1.haveLost()) {
			return 1;
		}
		
		return 0;				
	}

}
