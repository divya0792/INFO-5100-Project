package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class ModelFilter extends ValueFilter<String> {
	public ModelFilter(Checker<String> checker) {
		super(checker);
	}

	public ModelFilter(String value, Checker<String> checker) {
		super(value, checker);
	}

	@Override
	public String getVehicleValue(Vehicle vehicle) {

		return vehicle.getModel();
	}

	@Override
	public void setValueFromString(String string) throws InputException {
		char[] ch = string.toCharArray();
		for (char c : ch) {
			if (!Character.isLetterOrDigit(c)) {
				throw new InputException("A model name can only contain number or letter or both.");
			}
		}
		this.setValue(string);
	}
}
