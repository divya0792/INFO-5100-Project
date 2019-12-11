package dataproto;

import java.util.Collection;

public class Dealer extends DataObject {
    public Dealer(String id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    private String name;
    // private Address address;
    private String address;
    private String phone;
    private Collection<Vehicle> vehicles;
    private String emailId;
    private Collection<Incentive> incentives;
    private Collection<Lead> leads;
}
