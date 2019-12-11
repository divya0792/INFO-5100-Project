package m3.model.filter;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

public class ColorFilter extends ValueFilter<String> {
    @JsonCreator
    public ColorFilter(@JsonProperty("value") String value, @JsonProperty("checker") Checker<String> checker) {
        super(value, checker);
    }

    public ColorFilter(Checker checker) {
        super(checker);
    }

    @Override
    public String getVehicleValue(Vehicle vehicle) {

        return vehicle.getColor();
    }

    @Override
    public void setValueFromString(String string) throws InputException {
        char[] ch = string.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
				throw new InputException("A color name cannot contain any number.");
			}
			this.setValue(string);
		}

	}
}
