package m3.model.filter;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import dataproto.Vehicle;
import m3.model.checker.Checker;

import java.util.Objects;


@JsonTypeInfo(use = Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = BrandFilter.class, name = "BrandFilter"),
        @Type(value = BrandsFilter.class),
        @Type(value = ColorFilter.class, name = "ColorFilter"),
        @Type(value = ColorsFilter.class),
        @Type(value = ModelFilter.class),
        @Type(value = ModelsFilter.class),
        @Type(value = PriceFilter.class, name = "PriceFilter"),
        @Type(value = PricesFilter.class),
        @Type(value = VehicleIDFilter.class),
        @Type(value = VehicleIDsFilter.class),
        @Type(value = YearFilter.class),
        @Type(value = YearsFilter.class)
})

public abstract class Filter<T> {
    protected Checker<T> checker;

    @JsonCreator
    public Filter(@JsonProperty("checker") Checker<T> checker) {
        this.checker = checker;
    }

    abstract public T getVehicleValue(Vehicle vehicle);

    public String checkerToString() {
        return checker.ToString();
    }

    abstract public boolean isApplicable(Vehicle vehicle);

    abstract public boolean isApplicable(T value);

    @JsonProperty("cheker")
    public Checker<T> getChecker() {
        return checker;
    }

    @JsonProperty("cheker")
    public void setChecker(Checker<T> checker) {
        this.checker = checker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filter<?> filter = (Filter<?>) o;
        return Objects.equals(checker, filter.checker);
    }

    @Override
    public int hashCode() {

        return Objects.hash(checker);
    }
}
