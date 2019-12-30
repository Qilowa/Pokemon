package dut.fr.type;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

public class TypeAffinity {
	private final HashMap<List<Type>, HashMap<Type, Double>> affinitymap;
	private static final String path = "RessourcesPokemon-20191205/grid_types.csv";
	
	public TypeAffinity() {
		affinitymap = new HashMap<List<Type>, HashMap<Type, Double>>();
		load();
	}
	
	@Override
	public String toString() {
		/* StringBuilder s = new StringBuilder();
		for (Type[] table : affinitymap.keySet()) {
			s.append(table[0]);
			s.append(table[1]);
			s.append(" ");
		}
		return s.toString(); */
		return affinitymap.toString();
		
	}
	
	public HashMap<Type, Double> getAffinity(Type[] types) {
		List<Type> l = Collections.unmodifiableList(Arrays.asList(types));
		return affinitymap.get(l);
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
				String s = array[1].toUpperCase();
				Type type2;
				if (s.isBlank()) {
					type2 = null;
				} else {
					type2 = Type.valueOf(s.strip());
				}
				
				Type[] table = {type1, type2};
				List<Type> l = Collections.unmodifiableList(Arrays.asList(table));
				
				for(int i=2; i<19; i++) {
					if (affinitymap.get(l) == null) {
						
						affinitymap.put(l, new HashMap<Type, Double>());
					}
					affinitymap.get(l).put(types.get(i-2), Double.parseDouble(array[i]));
				}
			    
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
