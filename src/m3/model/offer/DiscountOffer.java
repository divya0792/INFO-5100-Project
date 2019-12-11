package m3.model.offer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscountOffer extends Offer {
    @JsonCreator
    public DiscountOffer(@JsonProperty("value") double value) {
        super(value);
    }
}
