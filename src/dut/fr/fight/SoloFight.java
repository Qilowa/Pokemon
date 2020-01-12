package dut.fr.fight;

import java.util.Random;
import java.util.Scanner;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.PokemonTeam;

public class SoloFight extends AbstractFight{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5476983139756810573L;
	private static final Random random= new Random();
	private int botPokemonIndex; //The index of the next pokemon that will be fighting

	public SoloFight(PokemonTeam team1, PokemonTeam team2) {
		super(team1, team2);
		this.botPokemonIndex = 0;
	}
	
	
	@Override
	public int selectSecondaryChoice(Scanner c) {
		// The bot always attacks
		return 1;
	}

	@Override
	public int getIdAttack(Scanner sc, FightingPokemon pk) {
		// The bot attacks randomly
		int v = random.nextInt(pk.getNumCapacity());
		return v;
	}

	@Override
	public int getNewPokemon(Scanner sc, PokemonTeam team) {
		botPokemonIndex++;
		return botPokemonIndex;
	}

	@Override
	public int choiceWhenKO(Scanner sc, FightingPokemon pk) {
		return 1;
	}

	

}
