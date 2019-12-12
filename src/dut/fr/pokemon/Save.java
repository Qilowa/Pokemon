package dut.fr.pokemon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save {
	
	public static void savePokedex(String path, Pokedex p) {
		try {
			File f = new File(path);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(p);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void savePokemonTeam(String path, PokemonTeam team) {
		try {
			File f = new File(path);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(team);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
