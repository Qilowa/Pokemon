package dut.fr.pokemon;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dut.fr.type.Type;


/**
 * A class representing a Pokemon of the Pokedex
 */
public class PokedexPokemon implements Serializable{

	private static final long serialVersionUID = -2272093327434807717L;
	
	private final int numPokedex;
	private final String pathImage;
	private final String name;
	private final int height;
	private final int weight;
	private Type[] types;
	
	PokedexPokemon(int numPokedex, String name, String img, int height, int weight, Type type1, Type type2) {
		this.numPokedex = numPokedex;
		this.pathImage =img;
		this.name = Objects.requireNonNull(name);
		this.height = height;
		this.weight = weight;
		this.types = new Type[] {type1, type2};
	}
	
	public PokedexPokemon(int numPokedex, String name, String img, int height, int weight, Type[] types) {
		this(numPokedex, name, img, height, weight, types[0], types[1]);
	}
	
	@Override
	public String toString() {
		return String.format("id: %d, nom: %s, taille: %d, poids: %d", numPokedex, name, height, weight);
	}
	
	/**
	 * Return the Original name of the pokemon
	 * @return The name of the Pokemon
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the Index in the Pokedex of the pokemon
	 * @return An Integer representing the index of the Pokedex in the Pokedex
	 */
	public int getNumPokedex() {
		return numPokedex;
	}
	
	/**
	 * Return the Path for the image of the pokemon
	 * @return A String representing the pokemon image path
	 */
	public String getImgPath() {
		return pathImage;
	}
	
	/**
	 * Return the Height of the pokemon
	 * @return An Integer representing the pokemon's height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Return the Weight of the pokemon
	 * @return An Integer representing the pokemon's weight
	 */
	public int getWeight() {
		return weight;
	}
	
<<<<<<< HEAD

=======
>>>>>>> master
	/**
	 * Return the image of the pokemon
	 * 
	 */
	public void showPicture() {
		Image picture;
		/* try {
			picture = ImageIO.read(new File("RessourcesPokemon-20191205/img/"+pathImage));
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
		*/
	}
<<<<<<< HEAD

=======
	
>>>>>>> master
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PokedexPokemon)) {
			return false;
		}
		PokedexPokemon p = (PokedexPokemon) o;
		return p.numPokedex == this.numPokedex && this.name == p.name && this.height == p.height 
				&& this.pathImage == p.pathImage && this.weight == p.weight && this.types == p.types;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numPokedex, pathImage, name, height, weight, types);
	}

	/**
	 * Return the types of the pokemon in an array
	 * @return An array of the type of the Pokemon
	 */
	public Type[] getTypes() {
		return types;
	}
	
	
	
	
}
