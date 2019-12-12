package m3.test;

import dataproto.Dealer;
import dataproto.Vehicle;
import m3.model.Incentive;
import m3.model.IncentivesFinalPrice;
import m3.model.checker.EqualChecker;
import m3.model.checker.GreaterChecker;
import m3.model.filter.BrandFilter;
import m3.model.filter.Filter;
import m3.model.filter.PriceFilter;
import m3.model.offer.CashBackOffer;
import m3.model.offer.DiscountOffer;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class IncentiveManagerTest {
    TestIncentiveManager testIncentiveManager;

    Dealer bmwDealer = new Dealer("001", "Bob", "rtyui");

    Vehicle vehicle1 = new Vehicle("001", bmwDealer.getId(), "BMW", "X5", "2019-01-01", "VAN", "NEW", "black", 50000.0f, 0.0f);
    Vehicle vehicle2 = new Vehicle("002", bmwDealer.getId(), "BMW", "X1", "2013-01-01", "VAN", "NEW", "red", 35000.0f, 0.0f);
    Vehicle vehicle3 = new Vehicle("003", bmwDealer.getId(), "BMW", "X11", "2023-01-01", "VAN", "NEW", "red", 30000.0f, 0.0f);
    Vehicle[] vehicles = {vehicle1, vehicle2, vehicle3};

    Filter brandFilter = new BrandFilter("BMW", new EqualChecker<>());
    Filter priceFilter = new PriceFilter(30000.0f, new GreaterChecker());

    List<Filter> conditions = new ArrayList<>();
    List<Filter> conditions2 = new ArrayList<>();

    Incentive discountIncentive1;
    Incentive discountIncentive2;
    Incentive cashBackIncentive1;
    Incentive cashBackIncentive2;

    List<Incentive> incentives = new ArrayList<>();

    @Before
    public void setUp() {

        conditions2.add(brandFilter);
        conditions2.add(priceFilter);
        conditions.add(brandFilter);

        try {
            discountIncentive1 = new Incentive(new SimpleDateFormat("dd/MM/yyyy").parse("1/12/2019"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("25/12/2019"),
                    "X", "Test", "001", new DiscountOffer(10),
                    conditions);

            discountIncentive2 = new Incentive(new SimpleDateFormat("dd/MM/yyyy").parse("1/12/2019"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("25/12/2019"),
                    "X", "Test", "001", new DiscountOffer(20),
                    conditions);

            cashBackIncentive1 = new Incentive(new SimpleDateFormat("dd/MM/yyyy").parse("1/12/2019"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("25/12/2019"),
                    "X", "Test", "001", new CashBackOffer(1000),
                    conditions2);

            cashBackIncentive2 = new Incentive(new SimpleDateFormat("dd/MM/yyyy").parse("1/12/2019"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("25/12/2019"),
                    "X", "Test", "001", new CashBackOffer(5000),
                    conditions2);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        incentives.add(discountIncentive1);
        incentives.add(discountIncentive2);
        incentives.add(cashBackIncentive1);
        incentives.add(cashBackIncentive2);

        testIncentiveManager = new TestIncentiveManager(incentives);
    }

    @Test
    public void testGetVehicleFinalIncentivesWithInputBothOffer() {
        List<Incentive> vehicle1listOfBestIncentive = new ArrayList<>();
        vehicle1listOfBestIncentive.add(discountIncentive2);
        vehicle1listOfBestIncentive.add(cashBackIncentive2);
        IncentivesFinalPrice incentiveFinalPrice1 = new IncentivesFinalPrice(vehicle1listOfBestIncentive,
                                                                    35000);

        List<Incentive> vehicle2listOfBestIncentive = new ArrayList<>();
        vehicle2listOfBestIncentive.add(discountIncentive1);
        vehicle2listOfBestIncentive.add(cashBackIncentive2);
        IncentivesFinalPrice incentiveFinalPrice2 = new IncentivesFinalPrice(vehicle2listOfBestIncentive,
                                               26500);

        List<Incentive> vehicle3listOfBestIncentive = new ArrayList<>();
        vehicle3listOfBestIncentive.add(discountIncentive2);
        IncentivesFinalPrice incentiveFinalPrice3 = new IncentivesFinalPrice(vehicle3listOfBestIncentive,
                                            24000);

        List<IncentivesFinalPrice> expectedResult = new ArrayList<>();
        expectedResult.add(incentiveFinalPrice1);
        expectedResult.add(incentiveFinalPrice2);
        expectedResult.add(incentiveFinalPrice3);

        assertEquals(expectedResult, testIncentiveManager.getVehicleFinalIncentives(vehicles));
    }
}
