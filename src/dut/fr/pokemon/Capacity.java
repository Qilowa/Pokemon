package dut.fr.pokemon;

import java.io.Serializable;
import java.util.Objects;

import dut.fr.type.Type;

/**
 * Class that represents a Pokemon's Capacity
 *
 */
public class Capacity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4350881480069526109L;
	
	private final String name;
	private final int power;
	private final int accuracy;
	private final int pp;
	private final Category category;
	private final Type type;
	private int currentPP;
	
	Capacity(String name,Type type,int power,int pp, int accuracy,String category) {
		this.name=Objects.requireNonNull(name);
		this.type=type;
		/*if (type == type.FIGHTING &&(power<15 || power>300 || power%5==1 )) {
			throw new IllegalArgumentException("precision must be between 15 and 300 and also a multiple of 5");
		}*/
		this.power = power;
		if (accuracy<0 || accuracy>100) {
			throw new IllegalArgumentException("precision must be between 0 and 100");
		}
		this.accuracy = accuracy;
		this.pp=pp;
		this.category = Category.valueOf(category);
		this.currentPP = pp;
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
		return name+"[type=" + type + ", power=" + power +", pp= "+currentPP+"/"+pp+ ", accuracy=" + accuracy+ ", category=" + category+"]";
	}

	/**
	 * Return the name of the capacity
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the Power of the capacity
	 * @return Integer
	 */
	public int getPower() {
		return power;
	}

	/**
	 * Return the Accuracy of the capacity
	 * @return Integer
	 */
	public int getAccuracy() {
		return accuracy;
	}

	/**
	 * Return the Current PP of a Capacity
	 * @return Integer
	 */
	public int getPP() {
		return currentPP;
	}
	
	/**
	 * Return the Max PP of the capacity
	 * @return Integer
	 */
	public int getMaxPP() {
		return pp;
	}

	/**
	 * Return the Category of the capacity
	 * @return Category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Return the Type of the capacity
	 * @return Type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Reduce the PP of the capacity
	 */
	public void reducePP() {
		currentPP--;
	}


}
