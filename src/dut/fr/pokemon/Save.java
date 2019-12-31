package dut.fr.pokemon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dut.fr.fight.AbstractFight;

public class Save {
	
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
	
	public static AbstractFight readFight(String path) {
		try {
			File f = new File(path);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			AbstractFight p;
			try {
				p = (AbstractFight) ois.readObject();
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
