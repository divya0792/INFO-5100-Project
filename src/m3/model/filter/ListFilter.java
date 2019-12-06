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

    protected abstract void setValue(String string);
    
    @Override
    public boolean isApplicable(Vehicle vehicle) {
        return this.isApplicable(this.getVehicleValue(vehicle));
    }

    @Override
    public boolean isApplicable(T value) {
        for (T t : list) {
            if (this.checker.check(value, t))
                return true;
        }
        return false;
    }
}
