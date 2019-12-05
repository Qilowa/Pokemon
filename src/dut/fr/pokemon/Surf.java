package dut.fr.pokemon;

public class Surf extends AbstractCapacity{

	public Surf(int power, int precision, Category category) {
		super(power, precision, category);
	}

	@Override
	public String toString() {
		return "Surf "+super.toString();
	}

}
