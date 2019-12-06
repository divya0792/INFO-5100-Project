package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class BrandFilter extends ValueFilter<String> {
    public BrandFilter(Checker<String> checker) {
        super(checker);
    }

    public BrandFilter(String value, Checker<String> checker) {
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
