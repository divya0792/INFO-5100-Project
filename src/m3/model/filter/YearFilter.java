package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

public class YearFilter extends ValueFilter<Integer> {
	@JsonCreator
	public YearFilter(@JsonProperty("checker") Checker checker) {
		super(checker);
	}
	
	@JsonCreator
	public YearFilter(@JsonProperty("value") Integer value, @JsonProperty("checker") Checker checker) {
        super(value, checker);
    }

    @Override
    public Integer getVehicleValue(Vehicle vehicle) {
        return vehicle.getYear();
    }

	@Override
	public void setValueFromString(String string) throws InputException {

		char[] ch = string.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLetter(ch[i])) {
				throw new InputException("A year number cannot contain any letter.");
			}

		}
		this.setValue(Integer.valueOf(string));
	}

}
