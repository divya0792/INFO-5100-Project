package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public class VehicleIDsFilter extends ListFilter<Integer> {
    public VehicleIDsFilter(List<Integer> list, Checker<Integer> checker) {
        super(list, checker);
    }

    @Override
    public Integer getVehicleValue(Vehicle vehicle) {
        return vehicle.getId();
    }
}
