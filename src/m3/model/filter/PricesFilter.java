package m3.model.filter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class PricesFilter extends ListFilter<Double> {

	@JsonCreator
	public PricesFilter(@JsonProperty("checker")Checker<Double> checker) {
		super(checker);
	}
	@JsonCreator
	public PricesFilter(@JsonProperty("list")List<Double> list, @JsonProperty("checker")Checker<Double> checker) {
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
