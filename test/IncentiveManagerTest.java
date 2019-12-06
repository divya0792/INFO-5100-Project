import m3.manager.IncentiveManager;
import m3.mock.Dealer;
import m3.mock.Vehicle;
import m3.model.Incentive;
import m3.model.IncentivesFinalPrice;
import m3.model.checker.EqualChecker;
import m3.model.checker.GreaterChecker;
import m3.model.filter.BrandFilter;
import m3.model.filter.Filter;
import m3.model.filter.PriceFilter;
import m3.model.offer.CashBackOffer;
import m3.model.offer.DiscountOffer;
import m3.model.offer.Offer;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class IncentiveManagerTest {
    IncentiveManager incentiveManager = new IncentiveManager();

    Dealer bmwDealer = new Dealer("Bob", "123456");

    Vehicle vehicle1 = new Vehicle("BMW", 001, bmwDealer, 50000, "black",
            "X5", 2019);
    Vehicle vehicle2 = new Vehicle("BMW", 020, bmwDealer, 35000, "red",
            "X1", 2013);
    Vehicle[] vehicles = {vehicle1, vehicle2};

    Filter brandFilter = new BrandFilter("BMW", new EqualChecker<String>());
    Filter priceFilter = new PriceFilter(30000, new GreaterChecker<Double>());

    List<Filter> conditions = new ArrayList<>();
    conditions.add(brandFilter);

    List<Filter> conditions2 = new ArrayList<>();
    conditions2.add(brandFilter);
    conditions2.add(priceFilter);

    Incentive discountIncentive1;
    Incentive discountIncentive2;
    Incentive cashBackIncentive1;
    Incentive cashBackIncentive2;

    {
        try {
            discountIncentive1 = new Incentive(new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2019"),
                                               new SimpleDateFormat("dd/MM/yyyy").parse("25/12/2019"),
                                          "X", "Test", bmwDealer, new DiscountOffer(10),
                                               conditions);

            discountIncentive2 = new Incentive(new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2019"),
                                               new SimpleDateFormat("dd/MM/yyyy").parse("25/12/2019"),
                                          "X", "Test", bmwDealer, new DiscountOffer(20),
                                               conditions);


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {

    }

    @Test
    public void testGetVehicleFinalIncentivesWithInputOnlyDiscountOffer() {

        List<Incentive> listOfBestIncentive = new ArrayList<>();
        listOfBestIncentive.add(discountIncentive2);
        IncentivesFinalPrice incentiveFinalPrice1 = new IncentivesFinalPrice(listOfBestIncentive, 40000);
        IncentivesFinalPrice incentiveFinalPrice2 = new IncentivesFinalPrice(listOfBestIncentive, 28000);

        List<IncentivesFinalPrice> result = new ArrayList<>();
        result.add(incentiveFinalPrice1);
        result.add(incentiveFinalPrice2);

        assertEquals(incentiveManager.getVehicleFinalIncentives(vehicles), result);
    }

    @Test
    public void testGetVehicleFinalIncentivesWithInputBothOffer() {

        try {
            cashBackIncentive1 = new Incentive(new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2019"),
                                               new SimpleDateFormat("dd/MM/yyyy").parse("25/12/2019"),
                                          "X", "Test", bmwDealer, new CashBackOffer(1000),
                                               conditions2);

            cashBackIncentive2 = new Incentive(new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2019"),
                                               new SimpleDateFormat("dd/MM/yyyy").parse("25/12/2019"),
                                          "X", "Test", bmwDealer, new CashBackOffer(5000),
                                                conditions2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Incentive> vehicle1listOfBestIncentive = new ArrayList<>();
        vehicle1listOfBestIncentive.add(discountIncentive2);
        vehicle1listOfBestIncentive.add(cashBackIncentive2);
        IncentivesFinalPrice incentiveFinalPrice1 = new IncentivesFinalPrice(vehicle1listOfBestIncentive,
                                                                    35000);

        List<Incentive> vehicle2listOfBestIncentive = new ArrayList<>();
        vehicle2listOfBestIncentive.add(discountIncentive2);
        IncentivesFinalPrice incentiveFinalPrice2 = new IncentivesFinalPrice(vehicle2listOfBestIncentive,
                                               28000);

        List<IncentivesFinalPrice> result = new ArrayList<>();
        result.add(incentiveFinalPrice1);
        result.add(incentiveFinalPrice2);

        assertEquals(incentiveManager.getVehicleFinalIncentives(vehicles), result);



    }


}
