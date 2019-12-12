package m3.model;

import java.util.List;
import java.util.Objects;

public class IncentivesFinalPrice {
    private List<Incentive> incentives;
    private double finalPrice;

    public List<Incentive> getIncentives() {
        return incentives;
    }

    public void setIncentives(List<Incentive> incentives) {
        this.incentives = incentives;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public IncentivesFinalPrice(List<Incentive> incentives, double finalPrice) {
        this.incentives = incentives;
        this.finalPrice = finalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncentivesFinalPrice that = (IncentivesFinalPrice) o;
        return Double.compare(that.finalPrice, finalPrice) == 0 &&
                Objects.equals(incentives, that.incentives);
    }

    @Override
    public int hashCode() {
        return Objects.hash(incentives, finalPrice);
    }
}
