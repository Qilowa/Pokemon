package dut.fr.ligue;

import java.util.Objects;

import dut.fr.pokemon.Fight;
import dut.fr.pokemon.PokemonTeam;

public class AbstractLigue implements Ligue{
	private final int identifier;
	private final PokemonTeam team1;
	private final PokemonTeam team2;
	private final PokemonTeam team3;
	private final PokemonTeam team4;
	private int nbWins;
	private int nbFights;

	public AbstractLigue(int identifier, PokemonTeam team1, PokemonTeam team2, PokemonTeam team3, PokemonTeam team4) {
		this.identifier = identifier;
		this.team1 = Objects.requireNonNull(team1);
		this.team2 = Objects.requireNonNull(team2);
		this.team3 = Objects.requireNonNull(team3);
		this.team4 = Objects.requireNonNull(team4);
		this.nbWins = 0;
		this.nbFights = 0;
	}

	@Override
	public void fightLigue(PokemonTeam t1) {
		nbFights++;
		
		Fight f1 = new Fight(t1, team1);
		if (!f1.fightRandom()) {
			System.out.println("Vous avez perdu la ligue !");
			nbWins++;
			return;
		}
		Fight f2 = new Fight(t1, team2);
		if (!f2.fightRandom()) {
			System.out.println("Vous avez perdu la ligue !");
			nbWins++;
			return;
		}
		
		Fight f3 = new Fight(t1, team3);
		if (!f3.fightRandom()) {
			System.out.println("Vous avez perdu la ligue !");
			nbWins++;
			return;
		}
		
		Fight f4 = new Fight(t1, team4);
		if (!f4.fightRandom()) {
			System.out.println("Vous avez perdu la ligue !");
			nbWins++;
			return;
		}
		
		System.out.println("Bravo, vous avez gagné la ligue Pokémon !");
	}

	@Override
	public String getType() {
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("Ligue %s numero %d, %d victoires pour %d combats" , getType(), identifier, nbWins, nbFights);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(identifier, team1, team2, team3, team4, nbWins, nbFights);
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof AbstractLigue)) {
			return false;
		}
		AbstractLigue b = (BasicLigue) o;
		return b.identifier==this.identifier && team1.equals(b.team1) && team2.equals(b.team2) && team3.equals(b.team3) && team4.equals(b.team4) && b.nbFights==this.nbFights && nbWins == this.nbWins;
	}
	
	void addWins() {
		nbWins++;
	}
	
}
