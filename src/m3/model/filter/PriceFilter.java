package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonTypeName;
import m3.mock.Vehicle;
import m3.model.checker.Checker;

@JsonTypeName("PriceFilter")
public class PriceFilter extends ValueFilter<Double> {
	@JsonCreator
	public PriceFilter(@JsonProperty("checker")Checker<Double> checker) {
		super(checker);
	}
	
	@JsonCreator
	public PriceFilter(@JsonProperty("value")Double value, @JsonProperty("checker")Checker<Double> checker) {
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
