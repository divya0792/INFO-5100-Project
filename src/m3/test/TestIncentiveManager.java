package m3.test;

import m3.manager.IncentiveManager;
import m3.model.Incentive;

import java.util.List;

public class TestIncentiveManager extends IncentiveManager {
    List<Incentive> incentives;

    public TestIncentiveManager(List<Incentive> incentives) {
        this.incentives = incentives;
    }

    public List<Incentive> getIncentivesByDealer(String dealerID) {
        return incentives;
    }
}
