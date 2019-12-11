package m3.model;

import dataproto.Dealer;
import m3.db.TableOperations;

import java.util.ArrayList;
import java.util.List;


public class IncentiveList {

    private Dealer d;

    public IncentiveList() {
    }

    public IncentiveList(Dealer d) {
        this.d = d;
    }

    private List<Incentive> allIncentives = new ArrayList<Incentive>();

    public List<Incentive> getAllIncentives() {

        TableOperations database = new TableOperations();


        allIncentives = database.getIncentiveByDealer(d.getId());

        return allIncentives;
    }

    public void addIncentive(Incentive i) {
        allIncentives.add(i);
        TableOperations database = new TableOperations();


        database.Create(i);

    }

    public void addIncentive(Incentive i, int index) {
        allIncentives.add(index, i);
        TableOperations database = new TableOperations();

        database.EditItem(i);


    }

    public Incentive getIncentiveByIndex(int index) {
        return allIncentives.get(index);
    }

    public void deleteIncentive(int index) {
        allIncentives.remove(index);
    }

    public void deleteFromDatabase(int index) {
        TableOperations database = new TableOperations();
        database.DeleteItem(getIncentiveByIndex(index));
    }
}
