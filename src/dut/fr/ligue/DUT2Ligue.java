package dut.fr.ligue;

import java.util.Objects;

import dut.fr.pokemon.Fight;
import dut.fr.pokemon.PokemonTeam;

public class DUT2Ligue extends BasicLigue{
	private final PokemonTeam team5;
	private final PokemonTeam team6;
	private final PokemonTeam team7;
	private final PokemonTeam team8;

	public DUT2Ligue(int identifier, PokemonTeam team1, PokemonTeam team2, PokemonTeam team3, PokemonTeam team4, PokemonTeam team5, PokemonTeam team6, PokemonTeam team7, PokemonTeam team8) {
		super(identifier, team1, team2, team3, team4);
		this.team5 = Objects.requireNonNull(team5);
		this.team6 = Objects.requireNonNull(team6);
		this.team7 = Objects.requireNonNull(team7);
		this.team8 = Objects.requireNonNull(team8);
	}
	
	@Override
	public void fightLigue(PokemonTeam t1) {
		super.fightLigue(t1);
		Fight f1 = new Fight(t1, team5);
		if (!f1.fightRandom()) {
			System.out.println("Vous avez perdu la ligue !");
			addWins();
			return;
		}
		Fight f2 = new Fight(t1, team6);
		if (!f2.fightRandom()) {
			System.out.println("Vous avez perdu la ligue !");
			addWins();
			return;
		}
		
		Fight f3 = new Fight(t1, team7);
		if (!f3.fightRandom()) {
			System.out.println("Vous avez perdu la ligue !");
			addWins();
			return;
		}
		
		Fight f4 = new Fight(t1, team8);
		if (!f4.fightRandom()) {
			System.out.println("Vous avez perdu la ligue !");
			addWins();
			return;
		}
		
	}
	
	@Override
	public String getType() {
		return "Made by DUT2";
	}
	
}
