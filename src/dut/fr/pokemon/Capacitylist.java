package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Capacitylist {
	private static final String CSV ="./RessourcesPokemon-20191205/Capacity.csv";
	private static Capacity[] capacity = new Capacity[729];
	private static Capacitylist onlyInstance;
	
	public Capacitylist() throws IOException {
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
		        capacity[id]=p;
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
		        capacity[id]=p;
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
		        capacity[id]=p;
			}
	    }
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static ArrayList<Capacity> capacitychoice(Type[] types) {
		ArrayList<Capacity> capacityFinal = new ArrayList<Capacity>();
		for(int i = 1; i < capacity.length; i++){
	      if (capacity[i].getType()[0]==types[0]  || capacity[i].getType()[0]==types[1]) {
	    	 Capacity cap=capacity[i];
	    	 capacityFinal.add(cap);
	      }
	    }
		return capacityFinal;
		
	}
	public static Capacitylist getInstance() throws IOException {
		if (onlyInstance == null) {
			onlyInstance = new Capacitylist();
		}
		return onlyInstance;
	}
	
	
	public Capacity getCapacity(int id) {
		Capacity c = capacity[id];
		return c;
	}
	
	
	@Override
	public String toString() {
		return capacity.toString();
	}
	
	

}
