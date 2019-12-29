package dut.fr.ligue;

import dut.fr.pokemon.PokemonTeam;

public class BasicLigue extends AbstractLigue{

	public BasicLigue(int identifier, PokemonTeam team1, PokemonTeam team2, PokemonTeam team3, PokemonTeam team4) {
		super(identifier, team1, team2, team3, team4);
	}
	
	@Override
	public String getType() {
		return "Normale";
	}
}