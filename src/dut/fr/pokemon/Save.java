package dut.fr.pokemon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dut.fr.fight.Fight;
/**
 * A class that contains all the methods for saving the information
 *
 *
 */
public class Save {
	
	/**
	 * Save an object within the file given in the path variable
	 * @param path the path of the file you want to store the information
	 * @param o the object saved
	 */
	public static void save(String path, Object o) {
		try {
			File f = new File(path);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(o);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Return the PokemonTeam contained in the file
	 * @param path the path where the information is stored
	 * @return A PokemonTeam stored in the file
	 */
	public static PokemonTeam readPokemonTeam(String path) {
		try {
			File f = new File(path);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			PokemonTeam p;
			try {
				p = (PokemonTeam) ois.readObject();
				return p;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Return the pokedex stored in the file specified by the path
	 * @param path the path where the file is
	 * @return A Pokedex
	 */
	public static Pokedex readPokedex(String path) {
		try {
			File f = new File(path);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			Pokedex p;
			try {
				p = (Pokedex) ois.readObject();
				return p;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Return the Capacitylist stored in the file specified by the path
	 * @param path the path where the file is
	 * @return The Capacitylist
	 */
	public static Capacitylist readCapacityList(String path) {
		try {
			File f = new File(path);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			Capacitylist p;
			try {
				p = (Capacitylist) ois.readObject();
				return p;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Return the fight contained in the file specified by the path
	 * @param path the path where the file is
	 * @return The fight contained in the file specified by the path
	 */
	public static Fight readFight(String path) {
		try {
			File f = new File(path);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			Fight p;
			try {
				p = (Fight) ois.readObject();
				return p;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
