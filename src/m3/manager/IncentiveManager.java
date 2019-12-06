package m3.manager;

import m3.IncentiveManagement;
import m3.mock.Dealer;
import m3.mock.Vehicle;
import m3.model.Incentive;
import m3.model.IncentivesFinalPrice;
import m3.model.checker.EqualChecker;
import m3.model.filter.BrandFilter;
import m3.model.filter.Filter;
import m3.model.offer.DiscountOffer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IncentiveManager implements IncentiveManagement {
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
        if (maxCashBack != null)
            bestIncentives.add(maxCashBack);
        if (maxDiscount != null)
            bestIncentives.add(maxDiscount);
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
            results.add(this.getBestIncentives(vehicles[i], listOfIncentives.get(i)));
        }
        return results;
    }

    //mock
    public List<Incentive> getIncentivesByDealer(Dealer dealer) {
        // get incentive from database
        List<Incentive> r = new ArrayList<>();

        try {
            BrandFilter brandFilter = new BrandFilter("A", new EqualChecker());
            List<Filter> filters = new ArrayList<>();
            filters.add(brandFilter);
            r.add(new Incentive(new SimpleDateFormat("dd/MM/yyyy").parse("31/11/2019"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2019"),
                    "I1", "Test", "123", new DiscountOffer(10),
                    filters));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return r;
    }

    public static void main(String[] args) {
        Dealer dealer = new Dealer("123", "B", "CCC");
        Vehicle[] cars = new Vehicle[]{
                new Vehicle("A", 1, dealer, 5000, "Red", "A", 2000),
                new Vehicle("B", 2, dealer, 6000, "Black", "B", 1990),
                new Vehicle("C", 3, dealer, 5000, "Yellow", "C", 2010),
        };

        IncentiveManagement incentiveManagement = new IncentiveManager();
        List<IncentivesFinalPrice> incentivesFinalPrices = incentiveManagement.getVehicleFinalIncentives(cars);
        System.out.println("hello");
    }
}

