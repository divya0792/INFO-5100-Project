package m3.model.filter;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

import java.util.Objects;

public abstract class ValueFilter<T> extends Filter<T> {
    protected T value;
    @JsonCreator
    public ValueFilter(@JsonProperty("checker")Checker<T> checker) {
        super(checker);
    }
    
    @JsonCreator
    public ValueFilter(@JsonProperty("value")T value, @JsonProperty("checker")Checker<T> checker) {
        super(checker);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ValueFilter<?> that = (ValueFilter<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), value);
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
        return this.isApplicable(this.getVehicleValue(vehicle));
    }

    @Override
    public boolean isApplicable(T value) {
        return this.checker.check(value, this.value);
    }
}
