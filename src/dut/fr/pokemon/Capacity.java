package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Capacity {
	private final String name;
	private final int power;
	private final int accuracy;
	private final int pp;
	private final String category;
	private final Type[] type;
	public Capacity(String name,Type type,int power,int pp, int accuracy,String category) {
		this.name=Objects.requireNonNull(name);
		this.type=new Type[] {type};;
		/*if (type == type.FIGHTING &&(power<15 || power>300 || power%5==1 )) {
			throw new IllegalArgumentException("precision must be between 15 and 300 and also a multiple of 5");
		}*/
		this.power = power;
		if (accuracy<0 || accuracy>100) {
			throw new IllegalArgumentException("precision must be between 0 and 100");
		}
		this.accuracy = accuracy;
		this.pp=pp;
		this.category = category;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,type,category,power,accuracy,pp);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Capacity)) {return false;};
		Capacity a= (Capacity)o;
		return name==a.name && type==a.type && category==a.category && power==a.power && accuracy==a.accuracy && pp==a.pp;
	}

	@Override
	public String toString() {
		return name+"[type=" + type + ", power=" + power +", pp= "+pp+ ", accuracy=" + accuracy+ ", category=" + category+"]";
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public int getPp() {
		return pp;
	}

	public String getCategory() {
		return category;
	}

	public Type[] getType() {
		return type;
	}


}
