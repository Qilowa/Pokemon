package dut.fr.fight;

import java.util.Scanner;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.PokemonTeam;

public interface Fight {
	/**
	 * Method that start a fight between team1 and team2
	 * @return 1 if the User 1 wins, 0 otherwise
	 */
	int fight();
	
	/**
	 * Takes the input of the second pokemon trainer (BOT or multi)
	 * @param c the scanner
	 * @return choice of the secondary player
	 */
	int selectSecondaryChoice(Scanner c);
	
	/**
	 * Method that get the ID of the attack
	 * @param sc
	 * @param pk
	 * @return
	 */
	int getIdAttack(Scanner sc, FightingPokemon pk);
	
	/**
	 * Method that get the ID of the next Pokemon
	 * @param sc
	 * @param team the pokemonteam 
	 * @return
	 */
	int getNewPokemon(Scanner sc, PokemonTeam team);
	
	/**
	 *Method that get the choice when the pokemon is KO
	 * @param sc
	 * @param pk
	 * @return
	 */
	int choiceWhenKO(Scanner sc, FightingPokemon pk);
}
