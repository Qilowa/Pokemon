package dut.fr.pokemon;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pokemon {
	private final int numPokedex;
	private final ArrayList<Capacity> capacity;
	private final Image picture;
	private String name;
	private final int height;
	private final int weight;
	private Type[] types;
	
	public Pokemon(int numPokedex, String name, String img, int height, int weight, Type type1, Type type2) {
		this.numPokedex = numPokedex;
		try {
			this.picture = ImageIO.read(new File("RessourcesPokemon-20191205/"+img));
		} catch (IOException e) {
			throw new IllegalArgumentException("Image cannot be loaded");
		}
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
	public void rename(String newname) {
		this.name= Objects.requireNonNull(newname);
	}
	public int addcapacity(Capacity c) {
		capacity.add(c);
		return 1;
	}
	public ArrayList<Capacity> showcapacity() {
		return capacity;
	}
	
	public void showPicture() {
		JLabel label = new JLabel(new ImageIcon(picture));
		JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(300,300);
        frame.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pokemon)) {
			return false;
		}
		Pokemon p = (Pokemon) o;
		return p.numPokedex == this.numPokedex && this.name == p.name && this.height == p.height 
				&& this.picture == p.picture && this.weight == p.weight && this.types == p.types;
	
	}
}
