package dut.fr.ligue;

import dut.fr.pokemon.PokemonTeam;

/**
 * Class representing a basic League : 4 Pokemon's trainers with 5 pokemons each
 *
 */
public class BasicLigue extends AbstractLigue{

	BasicLigue(int identifier, PokemonTeam team1, PokemonTeam team2, PokemonTeam team3, PokemonTeam team4) {
		super(identifier, team1, team2, team3, team4);
	}
	
	@Override
	public String getType() {
		return "Normale";
	}
}