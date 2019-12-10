package m3.model.filter;


import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class VehicleIDFilter extends ValueFilter<Integer> {
	public VehicleIDFilter(Checker<Integer> checker) {
		super(checker);
	}

	public VehicleIDFilter(Integer value, Checker<Integer> checker) {
		super(value, checker);
	}

	@Override
	public Integer getVehicleValue(Vehicle vehicle) {
		return vehicle.getId();
	}

	@Override
	public void setValueFromString(String string) throws InputException {
		char[] ch = string.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLetter(ch[i])) {
				throw new InputException("A VehicleID cannot contain any letter.");
			}
		}
		this.setValue(Integer.valueOf(string));
	}
}

