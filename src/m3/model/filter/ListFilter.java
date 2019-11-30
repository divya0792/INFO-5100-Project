package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public abstract class ListFilter<T> extends Filter<T> {
    private List<T> list;

    public ListFilter(List<T> list, Checker<T> checker) {
        super(checker);
        this.list = list;
    }

    @Override
    public boolean isApplicable(Vehicle vehicle) {
        for (T t : list) {
            if (this.checker.check(this.getVehicleValue(vehicle), t))
                return true;
        }
        return false;
    }
}
