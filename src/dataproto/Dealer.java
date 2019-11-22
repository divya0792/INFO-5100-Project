package dataproto;

import java.util.Collection;

public class Dealer extends DataObject {
  private String name;
  // private Address address;
  private String address;
  private String phone;
  private Collection<Vehicle> vehicles;
  private String emailId;
  private Collection<Incentive> incentives;
  private Collection<Leads> leads;

  private String headInfoId;
  private String footInfoId;
  private String leftInfoId;
  private String rightInfoId;

}
