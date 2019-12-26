package dut.test;

import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Capacitylist;
import dut.fr.pokemon.Fight;
import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.PokemonTeam;

public class Test2 {

	public static void main(String[] args) {
		Pokedex pokedex = Pokedex.getInstance();
		Capacitylist list = Capacitylist.getInstance();
		FightingPokemon pk1 = FightingPokemon.createFightingPokemon(25, pokedex);
		Capacity p = list.getCapacity(0);
		pk1.addCapacity(p);
		FightingPokemon pk2 = FightingPokemon.createFightingPokemon(1, pokedex);
		pk2.addCapacity(p);
		PokemonTeam team1 = new PokemonTeam();
		PokemonTeam team2 = new PokemonTeam();
		team1.add(pk1);
		team2.add(pk2);
		
		Fight f = new Fight(team1, team2);
		f.fight();
	}

}
