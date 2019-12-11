package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

public class VehicleIDFilter extends ValueFilter<String> {
    @JsonCreator
    public VehicleIDFilter(@JsonProperty("checker") Checker<String> checker) {
        super(checker);
    }

    @JsonCreator
    public VehicleIDFilter(@JsonProperty("value") String value, @JsonProperty("checker") Checker<String> checker) {
        super(value, checker);
    }

    @Override
    public String getVehicleValue(Vehicle vehicle) {
        return vehicle.getId();
    }

	@Override
	public void setValueFromString(String string) throws InputException {
        char[] ch = string.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetter(ch[i])) {
                throw new InputException("A VehicleID cannot contain any letter.");
            }
        }
        this.setValue(string);
    }
}

