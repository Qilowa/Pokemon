package dut.fr.pokemon;

import java.awt.Image;
import java.util.Objects;

public class Pokemon {
	private final int numPokedex;
	private final String picture;
	private final String name;
	private final int height;
	private final int weight;
	private Type[] types;
	
	public Pokemon(int numPokedex, String name, String img, int height, int weight, Type type1, Type type2) {
		this.numPokedex = numPokedex;
		this.picture = Objects.requireNonNull(img);
		this.name = Objects.requireNonNull(name);
		this.height = height;
		this.weight = weight;
		this.types = new Type[] {type1, type2};
	}
	
	@Override
	public String toString() {
		return String.format("id: %d, nom: %s, taille: %d, poids: %d", numPokedex, name, height, weight);
	}
}
