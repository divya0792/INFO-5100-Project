package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import dataproto.Vehicle;
import m3.model.checker.Checker;

@JsonTypeName("BrandFilter")
public class BrandFilter extends ValueFilter<String> {
	@JsonCreator
	public BrandFilter(@JsonProperty("checker")Checker<String> checker) {
        super(checker);
    }
    @JsonCreator
    public BrandFilter(@JsonProperty("value")String value, @JsonProperty("checker")Checker<String> checker) {
        super(value, checker);
    }

    @Override
    public void setValueFromString(String string) throws InputException {
        char[] ch = string.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                throw new InputException("A brand name cannot contain any number.");
            }
            this.setValue(string);
        }
    }

    @Override
    public String getVehicleValue(Vehicle vehicle) {
        return vehicle.getBrand();
    }
}
