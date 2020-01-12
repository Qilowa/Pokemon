package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dut.fr.type.Type;

/**
 * 
 * Class containing the Capacity
 */
public class Capacitylist {
	private static final String CSV ="./RessourcesPokemon-20191205/Capacity.csv";
	private static ArrayList<Capacity> capacity;
	private static Capacitylist onlyInstance;
	
	private Capacitylist()  {
		capacity = new ArrayList<Capacity>();
	}
	
	private static void createCapacitylist() {
		String line;
		boolean nameField = false;
		try {
		BufferedReader reader = new BufferedReader(new FileReader(CSV));
	    while ((line = reader.readLine()) != null) {
	    	if (nameField == false) {
	    		nameField = true;
	    		continue;
	    	}
	    	Capacity c = Capacity.createCapacity(line);
	    	capacity.add(c);
	    }
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Return the capacities that has the same type as types
	 * @param types Array of type
	 * @return ArrayList
	 */
	public static ArrayList<Capacity> capacitychoice(Type[] types) {
		ArrayList<Capacity> capacityFinal = new ArrayList<Capacity>();
		for(int i = 0; i < capacity.size(); i++){
	      if (capacity.get(i).getType()==types[0]  || capacity.get(i).getType()==types[1] || capacity.get(i).getType()==Type.NORMAL) {
	    	 Capacity cap=capacity.get(i);
	    	 capacityFinal.add(cap);
	      }
	    }
		return capacityFinal;
		
	}
	
	public static Capacitylist getInstance() {
		if (capacity == null) {
			onlyInstance = new Capacitylist();
			Capacitylist.createCapacitylist();
		}
		return onlyInstance;
	}
	
	/**
	 * Return a capacity according to the id
	 * @param id Integer representing the id of a capacity
	 * @return Capacity
	 */
	public Capacity getCapacity(int id) {
		Capacity c = capacity.get(id);
		return c;
	}
	
	
	@Override
	public String toString() {
		return capacity.toString();
	}
	
	

}
