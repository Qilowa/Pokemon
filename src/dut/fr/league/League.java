package dut.fr.league;

import dut.fr.pokemon.PokemonTeam;

public interface League {
	/**
	 * Fight the league
	 * @param t1 PokemonTeam
	 */
	 void fightLigue(PokemonTeam t1);
	 
	 /**
	  * Return the Type of the League (DUT2 or Basic)
	  * @return String representing the Type of the League
	  */
	 String getType();
}
