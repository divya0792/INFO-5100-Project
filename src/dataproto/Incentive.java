package dataproto;

import java.util.Collection;
import java.util.Date;

class Incentive extends DataObject {
  private Date startDate;
  private Date endDate;
  private float discount;
  private String title;
  private String disclaimer;
  private VehicleCategory vehicleCategory;
  private Collection<String> vehicleIds;
}
