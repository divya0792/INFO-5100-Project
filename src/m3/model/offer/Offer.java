package m3.model.offer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;


@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CashBackOffer.class),
        @JsonSubTypes.Type(value = DiscountOffer.class),
})
public abstract class Offer {
    private double value;

    public Offer(){}
    @JsonCreator
    public Offer(@JsonProperty("value") double value) {
        this.value = value;
    }

    public double getValue() {

        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Double.compare(offer.value, value) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}
