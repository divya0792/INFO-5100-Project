package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public class ColorsFilter extends ListFilter<String> {
	@JsonCreator
	public ColorsFilter(@JsonProperty("list") List<String> list, @JsonProperty("checker") Checker<String> checker) {
		super(list, checker);
	}

	@Override
	public String getValueFromString(String string) throws InputException {
		char[] ch = string.toCharArray();
		for (int j = 0; j < ch.length; j++) {
			if (Character.isDigit(ch[j])) {
				throw new InputException("Color names cannot contain any number.");
			}
		}
		return string;
	}

	@Override
	public String getVehicleValue(Vehicle vehicle) {
		return vehicle.getColor();
	}

}
