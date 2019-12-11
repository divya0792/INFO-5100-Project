package m3.test;

import m3.db.TableOperations;
import m3.model.Incentive;
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

import static junit.framework.TestCase.assertEquals;

public class DBTest {

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
    }


    @Test
    public void testDBOperation() {
        TableOperations tb = new TableOperations();
        for (Incentive incentive : incentives) {
            tb.Create(incentive);
        }

        List<Incentive> returnedIncentives = tb.getIncentiveByDealer("001");
        assertEquals(incentives, returnedIncentives);

    }

}
