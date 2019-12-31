package dut.test;

import java.util.ArrayList;

import dut.fr.fight.AbstractFight;
import dut.fr.fight.SoloFight;
import dut.fr.ligue.BasicLigue;
import dut.fr.ligue.LigueFactory;
import dut.fr.pokemon.Capacity;
import dut.fr.pokemon.Capacitylist;
import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.PokemonTeam;

public class Test2 {

	public static void main(String[] args) {
		Pokedex pokedex = Pokedex.getInstance();
		Capacitylist list = Capacitylist.getInstance();
		FightingPokemon pk1 = FightingPokemon.createFightingPokemon(226);
		Capacity p = list.getCapacity(0);
		pk1.addCapacity(p);
		FightingPokemon pk2 = FightingPokemon.createFightingPokemon(1);
		pk2.addCapacity(p);
		PokemonTeam team1 = new PokemonTeam();
		PokemonTeam team2 = new PokemonTeam();
		team1.add(pk1);
		team2.add(pk2);
		
		/* ArrayList<Capacity> c = Capacitylist.capacitychoice(pk1.getTypes());
		for (Capacity f : c) {
			System.out.println(f.getType());
		} 
		
		
		System.out.println(team1); */
		LigueFactory f = new LigueFactory(pokedex);
		BasicLigue b = f.createBasicLigue();
		b.fightLigue(team1);
		
	}

}
