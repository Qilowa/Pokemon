package dut.fr.fight;

import java.io.Serializable;
import java.util.Scanner;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokemon;
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
	
	
	static void printPanel() {
		
		System.out.println("1 : attaquer");
		System.out.println("2 : Changer de pokemon");
		System.out.println("3 : Fuir");
		System.out.println("Que voulez vous faire ?");
	}
	
	static void printCapacities(Capacity[] c) {
		for (int i=0; i<c.length; i++) {
			System.out.println((i)+": "+c[i]);
		}
		System.out.println("Que voulez vous faire ?");
		System.out.println("-1 pour retourner en arriere");
	}
	
	static void printTeam(PokemonTeam t) {
		for(int i=0; i<t.size(); i++) {
			FightingPokemon tmp = t.get(i);
			System.out.println((i+1)+" : "+tmp);
		}
	}
	
	static void printOnBoard(FightingPokemon p) {
		p.showPicture();
		System.out.println("on Board : "+p.getName());
	}
	
	private static <T> int getLength(T[] array) {
		int count = 0;
	    for(T el : array)
	        if (el != null)
	            ++count;
	    return count;
	}
	
	static int getAttackChoice(Scanner sc, FightingPokemon pk) {
		int attackChoice= -1 ;
		
		AbstractFight.printCapacities(pk.getCapacities());
		if (sc.hasNextInt()) {
			attackChoice = sc.nextInt();
			if (AbstractFight.getLength(pk.getCapacities()) <= attackChoice) {
				return 5;
			}
		} else {
			return 5;
		}
		
		return attackChoice;
	}
	
	static int getPokemonChoice(Scanner sc, PokemonTeam team) {
		int choice2=0;
		
		AbstractFight.printTeam(team);
		System.out.println("Choisissez un pokemon (-1 pour retourner en arriere)");
		if (sc.hasNext()) {
			choice2 = sc.nextInt();
		}
		return choice2;
	}
	
	static void printChoiceWhenKO(Pokemon pk) {
		System.out.println(pk.getName()+" est KO");
		System.out.println("1 : Envoyer un pokemon");
		System.out.println("2 : Fuir");
		System.out.println("Que voulez vous faire ?");
	}
	

	public int fight() {
		// Renvoie 1 ou 2 si respectivement le joueur 1 gagne ou le joueur 2 gagne
		System.out.println("Debut du COMBAT\n");
				
		FightingPokemon pk1 = team1.get(0); // Pokemon sur le board
		FightingPokemon pk2 = team2.get(0); // Pokemon sur le board
				
				
		AbstractFight.printOnBoard(pk1);
				
		AbstractFight.printOnBoard(pk2);
						
		Scanner sc = new Scanner(System.in);
				
		int attackChoice1=-1;
				
		int attackChoice2=-1;
				
		while (!team1.haveLost() || !team2.haveLost()) {
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
						
						if (attackChoice1 != 1 && attackChoice1 != 2 && attackChoice2 != 3) {
							System.out.println("Choisissez une attaque ad�quate !");
							continue;
						}
					break;
				case 2:
					//Changer de pokemon
					do {
						int choice2 = AbstractFight.getPokemonChoice(sc, team1);
						if (choice2 == -1) {
							continue;
						}
						pk1 = team1.get(choice2-1);
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
						if (attackChoice1 != 1 && attackChoice1 != 2 && attackChoice2 != 3) {
							System.out.println("Choisissez une attaque ad�quate !");
							continue;
						}
					break;
				case 2:
					//Changer de pokemon
					
					do {int choice2 = AbstractFight.getPokemonChoice(sc, team2);
					if (choice2 == -1) {
						continue;
					}
					pk2 = team1.get(choice2-1);
					} while (pk2.isKO());
					System.out.println(pk2.getName()+" est envoyé au combat !");
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
				AbstractFight.printChoiceWhenKO(pk1);
				int change;
				if (sc.hasNext()) {
					change = sc.nextInt();
					if (change == 1) {
						//Switch
						do {
							AbstractFight.printTeam(team1);
							System.out.println("-1 pour abandonner");
							int pokemonchoice = sc.nextInt();
							if (pokemonchoice==-1) {
								System.out.println("Joueur 1 a perdu !");
								return 2;
							}
							pk1 = team1.get(pokemonchoice-1);
						} while (pk1.isKO());
						
						System.out.println(pk1.getName()+" est envoyé au combat !");
						pk1.showPicture();
						continue;
					} else {
						// Abandon
						System.out.println("Joueur 1 a perdu !");
						return 2;
						
					}
					
				}
			
		}
					
			if (pk2.isKO()) {
				AbstractFight.printChoiceWhenKO(pk2);
				int change;
				if (sc.hasNext()) {
					change = sc.nextInt();
					if (change == 1) {
						//Switch
						do {
							AbstractFight.printTeam(team2);
							System.out.println("-1 pour abandonner");
							int pokemonchoice = sc.nextInt();
							if (pokemonchoice==-1) {
								System.out.println("Joueur 2 a perdu !");
								return 1;
							}
							pk2 = team2.get(pokemonchoice-1);
						} while (pk2.isKO());
						
						System.out.println(pk2.getName()+" est envoyé au combat !");
						pk2.showPicture();
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
