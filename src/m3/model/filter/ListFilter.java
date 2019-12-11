package m3.model.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dataproto.Vehicle;
import m3.model.checker.Checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ListFilter<T> extends Filter<T> {
    private List<T> list;

    @JsonCreator
    public ListFilter(@JsonProperty("checker") Checker<T> checker) {
        super(checker);
    }

    @JsonCreator
    public ListFilter(@JsonProperty("list") List<T> list, @JsonProperty("checker") Checker<T> checker) {
        super(checker);
        this.list = list;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ListFilter<?> that = (ListFilter<?>) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), list);
    }


    @JsonProperty("list")
    public List<T> getList() {
        return list;
    }


    @JsonProperty("list")
    public void setList(List<T> list) {
        this.list = list;
    }

    public abstract T getValueFromString(String string) throws InputException;

    public void setListFromString(String string) throws InputException {
        String[] strings = string.split(",");
        List<T> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(this.getValueFromString(strings[i]));
        }
        this.setList(list);
    }

    @Override
    public boolean isApplicable(T value) {
        for (T t : list) {
            if (this.checker.check(value, t))
                return true;
        }
        return false;
    }

    @Override
    public boolean isApplicable(Vehicle vehicle) {
        return this.isApplicable(this.getVehicleValue(vehicle));
    }


    @JsonIgnore
    public String getStringfromList() {
        String s = "";
        for (T str : list) {
            s = s.concat(str.toString());
            s = s.concat(",");
        }
        return s.substring(0, s.length() - 1);

    }
}
