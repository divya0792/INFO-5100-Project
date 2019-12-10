package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public class YearsFilter extends ListFilter<Integer> {
	public YearsFilter(Checker<Integer> checker) {
		super(checker);
	}

	public YearsFilter(List<Integer> list, Checker<Integer> checker) {
        super(list, checker);
    }

    @Override
    public Integer getVehicleValue(Vehicle vehicle) {
        return vehicle.getYear();
    }

	@Override
	public Integer getValueFromString(String string) throws InputException {
		char[] ch = string.toCharArray();
		for (int j = 0; j < ch.length; j++) {
			if (Character.isLetter(ch[j])) {
				throw new InputException("Years cannot contain any letter.");
			}

		}
		return Integer.valueOf(string);
	}

}
