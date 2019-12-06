package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public abstract class ValueFilter<T> extends Filter<T> {
    private T value;

    public ValueFilter(Checker<T> checker) {
        super(checker);
    }

    public ValueFilter(T value, Checker<T> checker) {
        super(checker);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public abstract void setValueFromString(String string) throws InputException;

    @Override
    public boolean isApplicable(Vehicle vehicle) {
        return this.checker.check(this.getVehicleValue(vehicle), this.value);
    }
}
