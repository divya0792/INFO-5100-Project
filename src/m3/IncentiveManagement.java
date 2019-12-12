package m3;

import dataproto.Vehicle;
import m3.model.Incentive;
import m3.model.IncentivesFinalPrice;

import java.util.List;

public interface IncentiveManagement {

    public List<List<Incentive>> getVehicleIncentives(Vehicle[] vehicles);

    public List<IncentivesFinalPrice> getVehicleFinalIncentives(Vehicle[] vehicles);
}
