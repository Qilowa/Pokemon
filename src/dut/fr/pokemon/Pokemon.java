package dut.fr.pokemon;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Objects;

public class Pokemon {
	private final int numPokedex;
	private final ArrayList<Capacity> capacity;
	private final String picture;
	private String name;
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
		this.capacity = new ArrayList<Capacity>();
	}
	
	@Override
	public String toString() {
		return String.format("id: %d, nom: %s, taille: %d, poids: %d", numPokedex, name, height, weight);
	}
	public int rename(String newname) {
		this.name=newname;
		return 1;
	}
	public int addcapacity(Capacity c) {
		capacity.add(c);
		return 1;
	}
	public ArrayList<Capacity> showcapacity() {
		return capacity;
	}
}
