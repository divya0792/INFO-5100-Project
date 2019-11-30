package m3.model;

import java.util.List;

public class IncentivesFinalPrice {
    private List<Incentive> incentives;
    private double finalPrice;

    public IncentivesFinalPrice(List<Incentive> incentives, double finalPrice) {
        this.incentives = incentives;
        this.finalPrice = finalPrice;
    }
}
