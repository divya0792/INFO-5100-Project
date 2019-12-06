import m3.manager.IncentiveManager;
import m3.mock.Dealer;
import m3.mock.Vehicle;
import m3.model.Incentive;
import m3.model.IncentivesFinalPrice;
import m3.model.offer.CashBackOffer;
import m3.model.offer.DiscountOffer;
import m3.model.offer.Offer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class IncentiveManagerTest {
    IncentiveManager incentiveManager = new IncentiveManager();

    Dealer bmwDealer = new Dealer("Bob", "123456");

    Vehicle vehicle1 = new Vehicle("BMW",001, bmwDealer, 50000, "black",
            "X5", 2019);
    Vehicle vehicle2 = new Vehicle("BMW", 020, bmwDealer, 35000, "red",
            "X1", 2013);
    Vehicle[] vehicles = {vehicle1, vehicle2};

    Offer discountOffer1 = new DiscountOffer(10);
    Offer discountOffer2 = new DiscountOffer(20);
    Offer discountOffer3 = new DiscountOffer(30);

    Incentive incentive1 = new Incentive(discountOffer1);
    Incentive incentive2 = new Incentive(discountOffer2);
    Incentive incentive3 = new Incentive(discountOffer3);

    Offer cashBackOffer1 = new CashBackOffer(1000);
    Offer cashBackOffer2 = new CashBackOffer(2000);

    Incentive incentiveCashBack1 = new Incentive(cashBackOffer1);
    Incentive incentiveCashBack2 = new Incentive(cashBackOffer2);


    @Before
    public void setUp(){

    }

    @Test
    public void testGetVehicleFinalIncentivesWithInputOnlyDiscountOffer(){

        List<Incentive> listOfBestIncentive = new ArrayList<>();
        listOfBestIncentive.add(incentive3);
        IncentivesFinalPrice incentiveFinalPrice1 = new IncentivesFinalPrice(listOfBestIncentive, 35000);
        IncentivesFinalPrice incentiveFinalPrice2 = new IncentivesFinalPrice(listOfBestIncentive, 24500);

        List<IncentivesFinalPrice> result = new ArrayList<>();
        result.add(incentiveFinalPrice1);
        result.add(incentiveFinalPrice2);

        assertEquals(incentiveManager.getVehicleFinalIncentives(vehicles), result);
    }

    @Test
    public void testGetVehicleFinalIncentivesWithInputBothOffer() {
        List<Incentive> listOfBestIncentive = new ArrayList<>();
        listOfBestIncentive.add(incentive3);
        listOfBestIncentive.add(incentiveCashBack2);

        IncentivesFinalPrice incentiveFinalPrice1 = new IncentivesFinalPrice(listOfBestIncentive, 33000);
        IncentivesFinalPrice incentiveFinalPrice2 = new IncentivesFinalPrice(listOfBestIncentive, 22500);

    }


}
