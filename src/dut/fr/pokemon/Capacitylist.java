package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Capacitylist {
	private final String TXT ="./RessourcesPokemon-20191205/Capacity.csv";
	private Capacity[] capacity = new Capacity[729];
	private static Capacitylist onlyInstance;
	public Capacitylist() throws IOException {
		String line;
		boolean nameField = false;
		try {
		BufferedReader reader = new BufferedReader(new FileReader(TXT));
	    while ((line = reader.readLine()) != null) {
	    	if (nameField == false) {
	    		nameField = true;
	    		continue;
	    	}
	    	String[] array = line.split(",");
	    	if (array.length==7) {
	    		Integer id = Integer.parseInt(array[0]);
		    	String name = array[1];
		    	String type = array[2];
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
		    	String type = array[2];
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
		    	String type = array[2];
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
	public Capacity[] capacitychoice(String typechoice) {
		Capacity[] capacityfinal = new Capacity[50];
		int c=1;
		if ((capacity[1].getType())==typechoice) {
			System.out.println("ouii");
		}
		System.out.println(capacity[1].getType());
		System.out.println(typechoice);
		for(int i = 1; i < capacity.length; i++){
	      if (capacity[i].getType()==typechoice || capacity[i].getType()=="normal") {
	    	  System.out.println("test");
	    	  System.out.println(capacity[i]);
	    	 capacityfinal[c]=capacity[i];
	    	 System.out.println(capacityfinal[i]);
	    	 c++;
	      }
	    }
		return capacityfinal;
		
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
	

}