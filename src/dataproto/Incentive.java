package dataproto;

import java.util.Collection;
import java.util.Date;

class Incentive extends DataObject {
    public Incentive(String id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    private Date startDate;
    private Date endDate;
    private float discount;
    private String title;
    private String disclaimer;
    private Category Category;
    private Collection<String> vehicleIds;
}
