package m3.model.filter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class YearsFilter extends ListFilter<Integer> {
	@JsonCreator
	public YearsFilter(@JsonProperty("checker")Checker<Integer> checker) {
		super(checker);
	}
	
	@JsonCreator
	public YearsFilter(@JsonProperty("list")List<Integer> list, @JsonProperty("checker")Checker<Integer> checker) {
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
