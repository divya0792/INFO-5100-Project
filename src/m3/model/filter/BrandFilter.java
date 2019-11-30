package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class BrandFilter extends ValueFilter<String> {
    public BrandFilter(String value, Checker<String> checker) {
        super(value, checker);
    }

    @Override
    public String getVehicleValue(Vehicle vehicle) {
        return vehicle.getBrand();
    }
}
