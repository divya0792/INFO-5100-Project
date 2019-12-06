package m3;

import m3.mock.Vehicle;
import m3.model.Incentive;
import m3.model.IncentivesFinalPrice;

import java.util.List;

public interface IncentiveManagement {

    public List<List<Incentive>> getVehicleIncentives(Vehicle[] vehicles);

    public List<IncentivesFinalPrice> getVehicleFinalIncentives(Vehicle[] vehicles);

    IncentivesFinalPrice getBestIncentives(Vehicle vehicle, List<Incentive> incentives);
}
