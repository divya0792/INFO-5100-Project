package m3.model.checker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import m3.model.filter.BrandFilter;
import m3.model.filter.BrandsFilter;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LessChecker.class),
        @JsonSubTypes.Type(value = GreaterChecker.class),
        @JsonSubTypes.Type(value = EqualChecker.class),
})
public abstract class Checker<T> {
    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

    public abstract boolean check(T o1, T o2);

    public abstract String ToString();
}
