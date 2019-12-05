package dut.fr.pokemon;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pokemon {
	private final int numPokedex;
	private final Image img;
	private final String name;
	private final List<Type> types;
	private final int height;
	private final int weight;
	
	public Pokemon(int numPokedex, Image img, String name, List<Type> types, int height, int weight) {
		this.numPokedex = numPokedex;
		this.img = Objects.requireNonNull(img);
		this.name = Objects.requireNonNull(name);
		this.types = Objects.requireNonNull(types);
		this.height = height;
		this.weight = weight;
	}
}
