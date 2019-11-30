package m3.manager;

import m3.IncentiveManagement;
import m3.mock.Dealer;
import m3.mock.Vehicle;
import m3.model.Incentive;
import m3.model.IncentivesFinalPrice;
import m3.model.filter.Filter;
import m3.model.offer.DiscountOffer;

import java.util.ArrayList;
import java.util.List;

public class IncentiveManager implements IncentiveManagement {

    public IncentivesFinalPrice getBestIncentives(Vehicle vehicle, List<Incentive> incentives) {
        // split by offer and sort offer in descending (90%, 10%) (-300, -100) // one function
        List<List<Incentive>> list = this.splitAndSortIncentivesByOfferType(incentives);
        double minPrice = Double.MAX_VALUE;
        Incentive cashOff, discount;


        // discount first then check if cash off still apply
        // find the lowest final price combination

        return new IncentivesFinalPrice(new ArrayList<>(), minPrice);
    }

    private List<List<Incentive>> splitAndSortIncentivesByOfferType(List<Incentive> incentives) {
        //discount first then cash off (sorted)
        Incentive incentive = new Incentive();
        boolean test = incentive.getOffer().getClass() == DiscountOffer.class;
        return null;
    }

    public boolean checkVehicleIncentive(Vehicle vehicle, Incentive incentive) {
        for (Filter condition : incentive.getConditions()) {
            if (!condition.isApplicable(vehicle))
                return false;
        }
        return true;
    }


    @Override
    public List<List<Incentive>> getVehicleIncentives(Vehicle[] vehicles) {
        ArrayList<List<Incentive>> results = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            ArrayList<Incentive> incentives = new ArrayList<>();
            for (Incentive incentive : this.getIncentivesByDealer(vehicle.getDealer())) {
                if (this.checkVehicleIncentive(vehicle, incentive))
                    incentives.add(incentive);
            }
            results.add(incentives);
        }
        return results;
    }

    @Override
    public List<IncentivesFinalPrice> getVehicleFinalIncentives(Vehicle[] vehicles) {
        List<IncentivesFinalPrice> results = new ArrayList<>();
        List<List<Incentive>> listOfIncentives = this.getVehicleIncentives(vehicles);

        for (int i = 0; i < vehicles.length; i++) {
            //this.getBestIncentives
        }
        return results;
    }

    public List<Incentive> getIncentivesByDealer(Dealer dealer) {
        // get incentive from database
        return new ArrayList<>();
    }

    public Incentive getIncentiveById(int id) {
        return null;
    }

    public void save(Incentive incentive) {
        //save incentive to database
    }

}
