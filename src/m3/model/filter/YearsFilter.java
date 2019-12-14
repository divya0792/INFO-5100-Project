package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public class YearsFilter extends ListFilter<Integer> {
    @JsonCreator
    public YearsFilter(@JsonProperty("checker") Checker checker) {
        super(checker);
    }

    @JsonCreator
    public YearsFilter(@JsonProperty("list") List<Integer> list, @JsonProperty("checker") Checker checker) {
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
