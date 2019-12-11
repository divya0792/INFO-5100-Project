package m3.model.filter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class VehicleIDsFilter extends ListFilter<Integer> {
	@JsonCreator
	public VehicleIDsFilter(@JsonProperty("checker")Checker<Integer> checker) {
		super(checker);
	}
	
	@JsonCreator
    public VehicleIDsFilter(@JsonProperty("list")List<Integer> list, @JsonProperty("checker")Checker<Integer> checker) {
        super(list, checker);
    }

    @Override
    public Integer getVehicleValue(Vehicle vehicle) {
        return vehicle.getId();
    }

	@Override
	public Integer getValueFromString(String string) throws InputException {
		char[] ch = string.toCharArray();
		for (int j = 0; j < ch.length; j++) {
			if (Character.isLetter(ch[j])) {
				throw new InputException("VehicleIDs cannot contain any letter.");
			}
		}
		return Integer.valueOf(string);
	}
}
