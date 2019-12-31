package dut.test;

import java.util.HashMap;

import dut.fr.pokemon.FightingPokemon;
import dut.fr.pokemon.Pokedex;
import dut.fr.type.Type;
import dut.fr.type.TypeAffinity;

public class AffinityTest {
	public static void main(String[] args) {
		TypeAffinity affinity = new TypeAffinity();
		Pokedex pokedex = Pokedex.getInstance();
		
		// System.out.println(affinity);
		
		Type[] types = {Type.STEEL, Type.FIGHTING};
		
		HashMap<Type, Double> p =affinity.getAffinity(types);
		
		FightingPokemon pk1 = FightingPokemon.createFightingPokemon(305);
		FightingPokemon pk2 = FightingPokemon.createFightingPokemon(1);
		
		// System.out.println(p);
	}
}
