package dut.fr.fight;

import java.io.Serializable;
import java.util.Scanner;

import dut.fr.pokemon.Capacity;
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
	

	public int fight() {
		// Renvoie 1 ou 2 si respectivement le joueur 1 gagne ou le joueur 2 gagne
				System.out.println("Debut du COMBAT\n");
						
				FightingPokemon pk1 = team1.get(0); // Pokemon sur le board
				FightingPokemon pk2 = team2.get(0); // Pokemon sur le board
						
						
				Print.printOnBoard(pk1);
						
				Print.printOnBoard(pk2);
								
				Scanner sc = new Scanner(System.in);
						
				int attackChoice1=-1;
						
				int attackChoice2=-1;
						
				while (!team1.haveLost() || !team2.haveLost()) {
					System.out.println("\nJoueur 1");
					Print.printPanel();
							
					int choice = sc.nextInt();
							
					switch(choice) {
						case 1:
							//Attaque
							attackChoice1 = Print.getAttackChoice(sc, pk1);
							if (attackChoice1 == -1) {
								// -1 pour retourner en arriere
								continue;
							}
						if (attackChoice1 != 0 && attackChoice1 != 1 && attackChoice1 != 2 && attackChoice1 != 3) {
							System.out.println("Choisissez une attaque adÈquate !");
							continue;
						}
						
						break;
						case 2:
							int choice2 = -1;
			                do {
			                    choice2 = Print.getPokemonChoice(sc, team1);
			                    if (choice2 == -1) {
			                    	continue;
			                    }
			                    pk1 = team1.get(choice2-1);
			                    
			                } while (pk1==null || pk1.isKO());

			                System.out.println(pk1.getName()+" est envoye au combat !");
			                break;
								
						case 3:
							// Abandonner
							System.out.println("Joueur 1 a perdu !");
							return 0;
						default:
							System.out.println("\nChoisir une option adequate");
							continue;
					}
							
					System.out.println("\nJoueur 2");
					Print.printPanel();
					int choicet2 = sc.nextInt();
					switch(choicet2) {
						case 1:
							//Attaque
							attackChoice2 = Print.getAttackChoice(sc, pk2);
							if (attackChoice2 == -1) {
								// -1 pour retourner en arriere
								continue;
							}
						if (attackChoice2 != 0 && attackChoice2 != 1 && attackChoice2 != 2 && attackChoice2 != 3) {
							System.out.println("Choisissez une attaque adÈquate !");
							continue;
						}
						case 2:
							int choice2 = -1;
			                do {
			                    choice2 = Print.getPokemonChoice(sc, team1);
			                    if (choice2 == -1) {
			                    	continue;
			                    }
			                    pk1 = team1.get(choice2-1);
			                    
			                } while (pk1==null || pk1.isKO());

			                System.out.println(pk1.getName()+" est envoye au combat !");
			                break;
								
						case 3:
							// Abandonner
							System.out.println("Joueur 2 a perdu !");
							return 1;
								
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
					
					if (pk1.isKO()) {
						System.out.println(pk1.getName()+" est KO");
						if (team1.haveLost()) {
							System.out.println("Joueur 1 a perdu !");
							return 0;
						}
						Print.printChoiceWhenKO(pk1);
							int change;
							if (sc.hasNext()) {
								change = sc.nextInt();
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
									} while (pk1.isKO());
									
									System.out.println(pk1.getName()+" est envoy√© au combat !");
									continue;
								} else {
									// Abandon
									System.out.println("Joueur 1 a perdu !");
									return 2;
									
								}
								
							}
					
				}
							
					if (pk2.isKO()) {
						System.out.println(pk2.getName()+" est KO");
						if (team2.haveLost()) {
							System.out.println("Joueur 2 a perdu !");
							return 0;
						}
						int change;
						if (sc.hasNext()) {
							change = sc.nextInt();
							if (change == 1) {
								//Switch
								do {
									Print.printTeam(team2);
									System.out.println("-1 pour abandonner");
									int pokemonchoice = sc.nextInt();
									if (pokemonchoice==-1) {
										System.out.println("Joueur 2 a perdu !");
										return 1;
									}
									pk2 = team2.get(pokemonchoice-1);
								} while (pk2.isKO());
								
								System.out.println(pk2.getName()+" est envoy√© au combat !");
								continue;
							} else {
								// Abandon
								System.out.println("Joueur 2 a perdu !");
								return 1;
								
							}
							
						}
					
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
