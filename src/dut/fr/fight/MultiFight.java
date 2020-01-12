package dut.fr.fight;

import java.util.Scanner;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.PokemonTeam;

public class MultiFight extends AbstractFight{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1698786338164088890L;

	public MultiFight(PokemonTeam team1, PokemonTeam team2) {
		super(team1, team2);
	}
	
	@Override
	public int selectSecondaryChoice(Scanner c) {
		// Gets the command of the second player
		System.out.println("\nJoueur 2");
		Print.printPanel();
		try {
			return Integer.parseInt(c.nextLine());
		} catch(Exception e) {
			return -1;
		}
	}

	@Override
	public int getIdAttack(Scanner sc, FightingPokemon pk) {
		return Print.getAttackChoice(sc, pk);
	}

	@Override
	public int getNewPokemon(Scanner sc, PokemonTeam team) {
		Print.printTeam(team);
        System.out.println("-1 pour abandonner");
        return sc.nextInt();
	}

	@Override
	public int choiceWhenKO(Scanner sc, FightingPokemon pk) {
		Print.printChoiceWhenKO();
		System.out.println("-1 pour abandonner");
        return sc.nextInt();
	}
}
