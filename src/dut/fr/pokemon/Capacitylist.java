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
		String line;
		boolean nameField = false;
		try {
		BufferedReader reader = new BufferedReader(new FileReader(CSV));
	    while ((line = reader.readLine()) != null) {
	    	if (nameField == false) {
	    		nameField = true;
	    		continue;
	    	}
	    	String[] array = line.split(",");
	    	if (array.length==7) {
	    		Integer id = Integer.parseInt(array[0]);
		    	String name = array[1];
		    	Type type = Type.valueOf(array[2].toUpperCase());
		    	Integer power = Integer.parseInt(array[3]);
		    	Integer pp = Integer.parseInt(array[4]);
		    	Integer precision = Integer.parseInt(array[5]);
		    	String category = array[6];
		        Capacity p = new Capacity(name, type, power,pp, precision,category);
		        capacity.add(p);
			}
	    	if (array.length==6) {
	    		Integer id = Integer.parseInt(array[0]);
		    	String name = array[1];
		    	Type type = Type.valueOf(array[2].toUpperCase());
		    	Integer power = 0;
		    	Integer pp = Integer.parseInt(array[3]);
		    	Integer precision = Integer.parseInt(array[4]);
		    	String category = array[5];
		        Capacity p = new Capacity(name, type, power,pp, precision,category);
		        capacity.add(p);
			}
	    	if (array.length==5) {
	    		Integer id = Integer.parseInt(array[0]);
		    	String name = array[1];
		    	Type type = Type.valueOf(array[2].toUpperCase());
		    	Integer power = 0;
		    	Integer pp = Integer.parseInt(array[3]);
		    	Integer precision = 0;
		    	String category = array[4];
		        Capacity p = new Capacity(name, type, power,pp, precision,category);
		        capacity.add(p);
			}
	    }
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Return the capacities that has the same type as types
	 * @param types Array of type
	 * @return ArrayList<Capacity>
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
		if (onlyInstance == null) {
			onlyInstance = new Capacitylist();
		}
		return onlyInstance;
	}
	
	/**
	 * Return a capacity according to the id
	 * @param id Integer representing the id of a capacity
	 * @return Capacity
	 */
	public static Capacity getCapacity(int id) {
		Capacity c = capacity.get(id);
		return c;
	}
	
	
	@Override
	public String toString() {
		return capacity.toString();
	}
	
	

}
