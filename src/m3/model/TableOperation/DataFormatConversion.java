package m3.model.TableOperation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import m3.model.Incentive;

public class DataFormatConversion {

    public static String FilterToString(Incentive I) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String filterList = mapper.writeValueAsString(I.getConditions()); //convert filter list to string
        return filterList;
    }

    public static String OfferToString(Incentive I) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String Offer = mapper.writeValueAsString(I.getOffer()); //convert offer to string
        return Offer;
    }

}
