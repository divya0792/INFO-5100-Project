package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public class BrandsFilter extends ListFilter<String> {
	public BrandsFilter(Checker<String> checker) {
		super(checker);
	}

	public BrandsFilter(List<String> list, Checker<String> checker) {
        super(list, checker);
    }

    @Override
	public String getValueFromString(String string) throws InputException {
		char[] ch = string.toCharArray();
		for (int j = 0; j < ch.length; j++) {
			if (Character.isDigit(ch[j])) {
				throw new InputException("Brand names cannot contain any number.");
			}
		}
		return string;
	}

	@Override
	public String getVehicleValue(Vehicle vehicle) {
		return vehicle.getBrand();
	}
}
