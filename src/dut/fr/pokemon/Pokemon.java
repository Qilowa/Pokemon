package dut.fr.pokemon;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pokemon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2272093327434807717L;
	
	private final int numPokedex;
	private final String pathImage;
	private final String name;
	private final int height;
	private final int weight;
	private Type[] types;
	
	public Pokemon(int numPokedex, String name, String img, int height, int weight, Type type1, Type type2) {
		this.numPokedex = numPokedex;
		this.pathImage =img;
		this.name = Objects.requireNonNull(name);
		this.height = height;
		this.weight = weight;
		this.types = new Type[] {type1, type2};
	}
	
	public Pokemon(int numPokedex, String name, String img, int height, int weight, Type[] types) {
		this(numPokedex, name, img, height, weight, types[0], types[1]);
	}
	
	@Override
	public String toString() {
		return String.format("id: %d, nom: %s, taille: %d, poids: %d", numPokedex, name, height, weight);
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumPokedex() {
		return numPokedex;
	}
	
	public String getImgPath() {
		return pathImage;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWeight() {
		return weight;
	}
	

	public void showPicture() {
		Image picture;
		try {
			picture = ImageIO.read(new File("RessourcesPokemon-20191205/"+pathImage));
			JLabel label = new JLabel(new ImageIcon(picture));
			JFrame frame=new JFrame();
	        frame.setLayout(new FlowLayout());
	        frame.setSize(300,300);
	        frame.add(label);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pokemon)) {
			return false;
		}
		Pokemon p = (Pokemon) o;
		return p.numPokedex == this.numPokedex && this.name == p.name && this.height == p.height 
				&& this.pathImage == p.pathImage && this.weight == p.weight && this.types == p.types;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numPokedex, pathImage, name, height, weight, types);
	}

	public Type[] getTypes() {
		return types;
	}
	
	
	
	
}
