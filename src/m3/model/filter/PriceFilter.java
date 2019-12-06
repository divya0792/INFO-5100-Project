package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class PriceFilter extends ValueFilter<Double> {
	public PriceFilter(Checker<Double> checker) {
		super(checker);
	}

	public PriceFilter(Double value, Checker<Double> checker) {
		super(value, checker);
	}

	@Override
	public Double getVehicleValue(Vehicle vehicle) {
		return vehicle.getPrice();
	}

	@Override
	public void setValueFromString(String string) throws InputException {
		char[] ch = string.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLetter(ch[i])) {
				throw new InputException("A price number cannot contain any letter.");
			}

		}
		this.setValue(Double.valueOf(string));
	}
}
