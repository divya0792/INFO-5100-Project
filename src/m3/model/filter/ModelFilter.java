package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

public class ModelFilter extends ValueFilter<String> {
	@JsonCreator
	public ModelFilter(@JsonProperty("checker")Checker<String> checker) {
		super(checker);
	}
	@JsonCreator
	public ModelFilter(@JsonProperty("value")String value, @JsonProperty("checker")Checker<String> checker) {
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
