package dut.fr.type;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

public class TypeAffinity {
	private final EnumMap<Type, HashMap<Type, Double>> affinitymap;
	private static final String path = "RessourcesPokemon-20191205/grid_types.csv";
	
	public TypeAffinity() {
		affinitymap = new EnumMap<>(Type.class);
		load();
	}
	
	@Override
	public String toString() {
		return affinitymap.toString();
	}
	
	public HashMap<Type, Double> getAffinity(Type t) {
		return affinitymap.get(t);
	}
	
	private void load() {
		BufferedReader reader;
		String line;
		boolean nameField = false;
	    ArrayList<Type> types = new ArrayList<Type>();
		
	    try {
	    	reader = new BufferedReader(new FileReader(path));
	    	
			while ((line = reader.readLine()) != null) {
				if (nameField == false) {
					String[] array = line.split(",", 20);
					int i=0;
					for(String s: array) {
						if (i>2) {
							types.add(Type.valueOf(s.strip().toUpperCase()));
						}
						i++;
					}
					
					nameField = true;
					continue;
				}
				String[] array = line.split(",", 20);
				Type type1 = Type.valueOf((array[0].toUpperCase()));
				
				for(int i=2; i<19; i++) {
					if (affinitymap.get(type1) == null) {
						affinitymap.put(type1, new HashMap<Type, Double>());
					}
					affinitymap.get(type1).put(types.get(i-2), Double.parseDouble(array[i]));
				}
			    
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
