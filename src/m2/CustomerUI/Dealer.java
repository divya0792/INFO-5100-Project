package m2.CustomerUI;

import java.util.Collection;

public class Dealer extends DataObject {
  private String name;
  // private Address address;
  private String address;
  private String phone;
  private Collection<VehicleObj> vehicles;
  private String emailId;
  private Collection<Incentive> incentives;
  private Collection<Lead> leads;
}
