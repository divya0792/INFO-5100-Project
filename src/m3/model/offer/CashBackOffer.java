package m3.model.offer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

public class CashBackOffer extends Offer {

    @JsonCreator
    public CashBackOffer(@JsonProperty("value") double value) {
        super(value);
    }
}
