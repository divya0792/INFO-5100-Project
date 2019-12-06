package m4.Team1.database.dao;

import m4.Team1.database.model.DealerDetails;

public class DealerTableDao {

    public DealerDetails getDealerDetails(String dealerId) {
        //TODO
        DealerDetails item = new DealerDetails();
        item.setId(dealerId);
        item.setDetails("Dealer name: XXXX, store location: XXXXXX");
        return item;
    }
}
