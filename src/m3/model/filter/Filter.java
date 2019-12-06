package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public abstract class Filter<T> {
    protected Checker<T> checker;

    public Filter(Checker<T> checker) {
        this.checker = checker;
    }

    abstract public T getVehicleValue(Vehicle vehicle);

    abstract public boolean isApplicable(Vehicle vehicle);
}
