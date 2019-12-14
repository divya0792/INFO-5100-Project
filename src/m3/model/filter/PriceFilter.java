package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import dataproto.Vehicle;
import m3.model.checker.Checker;

@JsonTypeName("PriceFilter")
public class PriceFilter extends ValueFilter<Float> {
	@JsonCreator
	public PriceFilter(@JsonProperty("checker") Checker checker) {
		super(checker);
	}

	@JsonCreator
	public PriceFilter(@JsonProperty("value") Float value, @JsonProperty("checker") Checker checker) {
		super(value, checker);
	}

	@Override
	public Float getVehicleValue(Vehicle vehicle) {
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
		this.setValue(Float.valueOf(string));
	}
}
