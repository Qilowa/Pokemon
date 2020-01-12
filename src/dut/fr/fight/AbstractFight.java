package dut.fr.fight;

import java.io.Serializable;
import java.util.Scanner;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.PokemonTeam;
import dut.fr.type.TypeAffinity;

public abstract class AbstractFight implements Fight, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2618372557634190434L;
	
	private final PokemonTeam team1;
	private final PokemonTeam team2;
	public static TypeAffinity table = new TypeAffinity();
	
	AbstractFight(PokemonTeam team1, PokemonTeam team2) {
		this.team1 = team1;
		this.team2 = team2;
	}
	
	@Override
	public int fight() {
		// Return 1 if player1 wins and 2 if player2 wins
				System.out.println("Debut du COMBAT\n");
						
				FightingPokemon pk1 = team1.get(0); // Pokemon on board
				FightingPokemon pk2 = team2.get(0); // Pokemon on board
						
						
				Print.printOnBoard(pk1);
						
				Print.printOnBoard(pk2);
								
				Scanner sc = new Scanner(System.in);
						
				int attackChoice1=-1;
						
				int attackChoice2=-1;
				
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
							//Attack
							attackChoice1 = Print.getAttackChoice(sc, pk1);
							
							if (attackChoice1 == -1) {
								// -1 to go back
								continue;
							}
						if (attackChoice1 != 0 && attackChoice1 != 1 && attackChoice1 != 2 && attackChoice1 != 3) {
							System.out.println("Choisissez une attaque ad�quate !");
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
							return 2;
						default:
							System.out.println("\nChoisir une option adequate");
							continue;
					}
							

					int choicet2 = selectSecondaryChoice(sc);
					switch(choicet2) {
						case 1:
							// Attack
							attackChoice2 = this.getIdAttack(sc, pk2);
							if (attackChoice2 == -1) {
								// -1 to go back
								continue;
							}
						if (attackChoice2 != 0 && attackChoice2 != 1 && attackChoice2 != 2 && attackChoice2 != 3) {
							System.out.println("Choisissez une attaque adéquate !");
							continue;
						}
						break;
						case 2:
							int choice2 = -1;
			                do {
			                    choice2 = Print.getPokemonChoice(sc, team2);
			                    if (choice2 == -1) {
			                    	break;
			                    }
			                    pk2 = team2.get(choice2-1);
			                    
			                } while (pk2==null || pk2.isKO());
			                choice = 2;
			                if (choice2 == -1) {
			                	
			                	continue;
			                }

			                System.out.println(pk2.getName()+" est envoye au combat !");
			                break;
								
						case 3:
							// Give up
							System.out.println("Joueur 2 a perdu !");
							return 1;
						default:
							System.out.println("\nChoisir une option adequate");
							continue;
								
					}
					
					if (choice == 2 && choicet2 == 1) {
						// if the trainer1 decides to change pokemon and trainer2 decides to attack
						pk2.attack(attackChoice2, pk1, table);
					}
					
					if (choice == 1 && choicet2 == 2) {
						// if the trainer1 decides to attack and trainer2 to change pokemon 
						pk1.attack(attackChoice1, pk2, table);
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
							
					
					if (pk1.isKO()) {
						System.out.println(pk1.getName()+" est KO");
						if (team1.haveLost()) {
							System.out.println("Joueur 1 a perdu !");
							return 2;
						}
						Print.printChoiceWhenKO();
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
							System.out.println("Joueur 2 a perdu !");
							return 1;
						}
						int change = -1;
		                do {
		                	change = choiceWhenKO(sc, pk2);
		                        if (change == 1) {
		                            //Switch
		                            do {

		                                int pokemonchoice = getNewPokemon(sc, team2);
		                                if (pokemonchoice==-1) {
		                                    System.out.println("Joueur 1 a perdu !");
		                                    return 2;
		                                }
		                                pk2 = team1.get(pokemonchoice-1);
		                            } while (pk2 == null || pk2.isKO());
		                            
		                            System.out.println(pk2.getName()+" est envoyé au combat !");
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
					
							
					System.out.println(pk1.getName()+" a "+pk1.getCurrentHealth()+"/"+pk1.getMaxHealth()+" PV");
					System.out.println(pk2.getName()+" a "+pk2.getCurrentHealth()+"/"+pk2.getMaxHealth()+" PV");
							
				}
				if (team1.haveLost()) {
					return 2;
				}
				return 1;
				
			
	}
	
	PokemonTeam getTeam1() {
		return team1;
	}
	
	PokemonTeam getTeam2() {
		return team2;
	}
	
	
	
}
