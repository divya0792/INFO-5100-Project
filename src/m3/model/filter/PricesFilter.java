package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public class PricesFilter extends ListFilter<Float> {

    @JsonCreator
    public PricesFilter(@JsonProperty("checker") Checker checker) {
        super(checker);
    }

    @JsonCreator
    public PricesFilter(@JsonProperty("list") List<Float> list, @JsonProperty("checker") Checker checker) {
        super(list, checker);
    }

    @Override
    public Float getValueFromString(String string) throws InputException {
        char[] ch = string.toCharArray();
        for (int j = 0; j < ch.length; j++) {
            if (Character.isLetter(ch[j])) {
                throw new InputException("Prices cannot contain any letter.");
            }

        }
        return Float.valueOf(string);
    }

    @Override
    public Float getVehicleValue(Vehicle vehicle) {
        return vehicle.getPrice();
    }

}
