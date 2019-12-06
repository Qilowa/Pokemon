package dut.fr.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Capacity {
	private final String name;
	private final int power;
	private final int precision;
	private final int pp;
	private final String category;
	private final String type;
	public Capacity(String name,String type,String category,int power, int precision,int pp) {
		super();
		this.name=Objects.requireNonNull(name);
		this.type=Objects.requireNonNull(type);
		if (power<15 && power>300 && power%5==1 ) {
			throw new IllegalArgumentException("precision must be between 15 and 300 and also a multiple of 5");
		}
		this.power = power;
		if (precision<0 && precision>100) {
			throw new IllegalArgumentException("precision must be between 0 and 100");
		}
		this.precision = precision;
		this.pp=pp;
		this.category = category;
	}
	
	public int getPower() {
		return power;
	}
	public int getPrecision() {
		return precision;
	}
	public String getCategory() {
		return category;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,power,precision,pp,category);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Capacity)) {return false;};
		Capacity a= (Capacity)o;
		return power==a.power && precision==a.precision && category==a.category  && name==a.name  && pp==a.pp;
	}

	@Override
	public String toString() {
		return name+"[type=" + type + ", category=" + category + ", power=" + power + ", precision=" + precision+ ", pp= "+pp+ "]";
	}


}
