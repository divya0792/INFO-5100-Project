package m3.manager;

import dataproto.Vehicle;
import m3.IncentiveManagement;
import m3.db.TableOperations;
import m3.model.Incentive;
import m3.model.IncentivesFinalPrice;
import m3.model.filter.Filter;
import m3.model.offer.DiscountOffer;

import java.util.*;

public class IncentiveManager implements IncentiveManagement {
    TableOperations client = new TableOperations();
    Map<String, List<Incentive>> cache = new HashMap<>();

    private double calculatePrice(double price, Incentive incentive) {
        if (incentive.getOffer().getClass() == DiscountOffer.class) {
            price = price * (1 - incentive.getOffer().getValue() / 100.0);
        } else {
            price = price - incentive.getOffer().getValue();
        }
        return price < 0 ? 0 : price;
    }

    private boolean checkPriceAvailability(double price, Incentive incentive) {
        for (Filter condition : incentive.getConditions()) {
            if (condition.getClass().getName().contains("Price")) {
                if (!condition.isApplicable(price))
                    return false;
            }
        }
        return true;
    }


    private IncentivesFinalPrice getBestIncentives(Vehicle vehicle, List<Incentive> incentives) {
        // split by offer and sort offer in descending (90%, 10%) (-300, -100) // one function
        List<List<Incentive>> list = this.splitAndSortIncentivesByOfferType(incentives);
        double minPrice = Double.MAX_VALUE;
        Incentive maxCashBack = null, maxDiscount = null;

        // discount first then check if cash off still apply
        // find the lowest final price combination
        for (int i = 0; i < list.get(0).size(); i++) {
            Incentive discount = list.get(0).get(i);
            for (int j = 0; j < list.get(1).size(); j++) {
                Incentive cashBack = list.get(1).get(j);
                double finalPrice = vehicle.getPrice();
                boolean cashBackApplyFlag = false;
                if (discount != null) {
                    finalPrice = this.calculatePrice(finalPrice, discount);
                }
                if (cashBack != null) {
                    if (this.checkPriceAvailability(finalPrice, cashBack)) {
                        finalPrice = this.calculatePrice(finalPrice, cashBack);
                        cashBackApplyFlag = true;
                    }
                }
                if (finalPrice < minPrice) {
                    minPrice = finalPrice;
                    maxCashBack = cashBack;
                    maxDiscount = discount;
                } else if (cashBackApplyFlag) {
                    break;
                }
            }
        }

        List<Incentive> bestIncentives = new ArrayList<>();
        if (maxDiscount != null)
            bestIncentives.add(maxDiscount);
        if (maxCashBack != null)
            bestIncentives.add(maxCashBack);
        return new IncentivesFinalPrice(bestIncentives, minPrice);
    }

    private List<List<Incentive>> splitAndSortIncentivesByOfferType(List<Incentive> incentives) {
        //discount first then cash off (sorted)

        List<Incentive> discountIncentives = new ArrayList<>();
        List<Incentive> cashBackIncentives = new ArrayList<>();

        //split
        for (Incentive incentive : incentives) {
            boolean isDiscount = incentive.getOffer().getClass() == DiscountOffer.class;
            if (isDiscount) {
                discountIncentives.add(incentive);
            } else {
                cashBackIncentives.add(incentive);

            }
        }

        //sort
        discountIncentives.sort((Incentive o1, Incentive o2) ->
                (int) (o2.getOffer().getValue() - o1.getOffer().getValue()));

        cashBackIncentives.sort((Incentive o1, Incentive o2) ->
                (int) (o2.getOffer().getValue() - o1.getOffer().getValue()));


        discountIncentives.add(null);
        cashBackIncentives.add(null);

        List<List<Incentive>> result = new ArrayList<>();
        result.add(discountIncentives);
        result.add(cashBackIncentives);
        return result;
    }

    private boolean checkVehicleIncentive(Vehicle vehicle, Incentive incentive) {
        Date now = new Date();
        if (now.after(incentive.getEndDate()) || now.before(incentive.getStartDate()))
            return false;
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
            for (Incentive incentive : this.getIncentivesByDealer(vehicle.getDealerId())) {
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
            results.add(this.getBestIncentives(vehicles[i], listOfIncentives.get(i)));
        }
        return results;
    }


    public List<Incentive> getIncentivesByDealer(String dealerID) {
        // get incentive from database
        if (this.cache.containsKey(dealerID))
            return this.cache.get(dealerID);

        List<Incentive> list = client.getIncentiveByDealer(dealerID);
        this.cache.put(dealerID, list);
        return list;
    }
}

