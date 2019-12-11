package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public class VehicleIDsFilter extends ListFilter<String> {
    @JsonCreator
    public VehicleIDsFilter(@JsonProperty("checker") Checker<String> checker) {
        super(checker);
    }

    @JsonCreator
    public VehicleIDsFilter(@JsonProperty("list") List<String> list, @JsonProperty("checker") Checker<String> checker) {
        super(list, checker);
    }

    @Override
    public String getVehicleValue(Vehicle vehicle) {
        return vehicle.getId();
    }

    @Override
    public String getValueFromString(String string) throws InputException {
        char[] ch = string.toCharArray();
        for (int j = 0; j < ch.length; j++) {
            if (Character.isLetter(ch[j])) {
                throw new InputException("VehicleIDs cannot contain any letter.");
            }
        }
        return string;
    }
}
