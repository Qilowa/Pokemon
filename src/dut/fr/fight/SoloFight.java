package dut.fr.fight;

import java.util.Random;
import java.util.Scanner;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.PokemonTeam;

/**
 * Class that represents a fight with a bot
 * 
 *
 */
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
		// Renvoie true si le joueur 1 gagne et 0 sinon
		Random r = new Random();
		PokemonTeam team1 = super.getTeam1();
		PokemonTeam team2 = super.getTeam2();
		
		System.out.println("Debut du COMBAT\n");
		
		FightingPokemon pk1 = team1.get(0); // Pokemon sur le board
		FightingPokemon pk2 = team2.get(0); // Pokemon sur le board
		
		
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
				
			
			// Choice of Player 1
			switch(choice) {
			
			case 1:
				//Attack
					attackChoice1 = Print.getAttackChoice(sc, pk1);
					if (attackChoice1 == -1) {
						// -1 return back
						continue;
					}
					
				if (attackChoice1 != 0 && attackChoice1 != 1 && attackChoice1 != 2 && attackChoice1 != 3) {
					System.out.println("Choisissez une attaque ad�quate !");
					continue;
				}
				
				break;
			case 2:
				// Change pokemon
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
                pk1.showPicture();
                break;
			case 3:
				// Give up
				System.out.println("Joueur 1 a perdu !");
				return 0;
			default:
				System.out.println("\nChoisir une option adequate");
				continue;
			
			}
			
			// Choice of BOT
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
			
			// User 1 : Pokemon is KO
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
                            
                            System.out.println(pk1.getName()+" est envoyé au combat !");
                            pk1.showPicture();
                            choice=-1;
                            continue;
                        } 
                        if (change == 2){
                            // Abandon
                            System.out.println("Joueur 1 a perdu !");
                            return 2;
                        }
                        else {
                        	System.out.println(change);
                            System.out.println("Choisissez une option ad�quate");
                        }
                	
                        
                } while (change != 1 && change != 2);
				
			}
			
			if (pk2.isKO()) {
				System.out.println(pk2.getName()+" est KO");
				if (team2.haveLost()) {
					System.out.println("Vous avez gagn� !");
					return 1;
				}
				pk2 = team2.get(i);
				pk2.showPicture();
				System.out.println(pk2.getName()+" est envoyé au combat !");
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
