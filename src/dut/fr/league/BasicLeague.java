package dut.fr.league;

import dut.fr.pokemon.PokemonTeam;

/**
 * Class representing a basic League : 4 Pokemon's trainers with 5 pokemons each
 *
 */
public class BasicLeague extends AbstractLeague{

	BasicLeague(int identifier, PokemonTeam team1, PokemonTeam team2, PokemonTeam team3, PokemonTeam team4) {
		super(identifier, team1, team2, team3, team4);
	}
	
	@Override
	public String getType() {
		return "Normale";
	}
}