package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public class PricesFilter extends ListFilter<Double> {
	public PricesFilter(Checker<Double> checker) {
		super(checker);
	}

	public PricesFilter(List<Double> list, Checker<Double> checker) {
		super(list, checker);
	}

	@Override
	public Double getValueFromString(String string) throws InputException {
		char[] ch = string.toCharArray();
		for (int j = 0; j < ch.length; j++) {
			if (Character.isLetter(ch[j])) {
				throw new InputException("Prices cannot contain any letter.");
			}

		}
		return Double.valueOf(string);
	}

	@Override
	public Double getVehicleValue(Vehicle vehicle) {
		return vehicle.getPrice();
	}

}
