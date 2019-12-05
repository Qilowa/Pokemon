package dut.fr.pokemon;

import java.util.Objects;

public abstract class AbstractCapacity implements Capacity {
	private final int power;
	private final int precision;
	private final Category category;
	public AbstractCapacity(int power, int precision, Category category) {
		super();
		if (power<15 && power>300 && power%5==1 ) {
			throw new IllegalArgumentException("precision must be between 15 and 300 and also a multiple of 5");
		}
		this.power = power;
		if (precision<0 && precision>100) {
			throw new IllegalArgumentException("precision must be between 0 and 100");
		}
		this.precision = precision;
		this.category = category;
	}
	
	public int getPower() {
		return power;
	}
	public int getPrecision() {
		return precision;
	}
	public Category getCategory() {
		return category;
	}
	@Override
	public int hashCode() {
		return Objects.hash(power,precision,category);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof AbstractCapacity)) {return false;};
		AbstractCapacity a= (AbstractCapacity)o;
		return power==a.power && precision==a.precision && category==a.category;
	}

	@Override
	public String toString() {
		return "[power=" + power + ", precision=" + precision + ", category=" + category + "]";
	}


}
