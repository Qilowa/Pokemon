package dut.fr.pokemon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Save {
	private static String pathPokemonTeam;
	private static String pathPokedex;
	private static String pathCapacityList;
	
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
	
	
}
