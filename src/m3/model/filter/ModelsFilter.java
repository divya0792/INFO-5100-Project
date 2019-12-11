package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public class ModelsFilter extends ListFilter<String> {
    @JsonCreator
    public ModelsFilter(@JsonProperty("checker") Checker<String> checker) {
        super(checker);
    }

    @JsonCreator
    public ModelsFilter(@JsonProperty("list") List<String> list, @JsonProperty("checker") Checker<String> checker) {
        super(list, checker);
    }

	@Override
	public String getVehicleValue(Vehicle vehicle) {

		return vehicle.getModel();
	}

	@Override
	public String getValueFromString(String string) throws InputException {
		char[] ch = string.toCharArray();
		for (int j = 0; j < ch.length; j++) {
			if (!Character.isLetterOrDigit(ch[j])) {
				throw new InputException("Model names can only contain number, letter or both.");
			}
		}
		return string;
	}

}
