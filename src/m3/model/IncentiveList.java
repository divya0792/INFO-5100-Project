package m3.model;

import dataproto.Dealer;
import m3.db.TableOperations;

import java.util.ArrayList;
import java.util.List;


public class IncentiveList {

	private Dealer d;

	public IncentiveList() {
	}

	;

	public IncentiveList(Dealer d) {
		this.d = d;
	}

	private List<Incentive> allIncentives = new ArrayList<Incentive>();

	public List<Incentive> getAllIncentives() {

		TableOperations database = new TableOperations();


		database.getIncentiveByDealer(d.getName());

		return allIncentives;
	}

	public void addIncentive(Incentive i) {
		allIncentives.add(i);
		TableOperations database = new TableOperations();


		database.Create(i);

	}

	public void addIncentive(Incentive i, int index) {
		allIncentives.add(index, i);
	}

	public Incentive getIncentiveByIndex(int index) {
		if (index > allIncentives.size()) {
			// check
		}
		return allIncentives.get(index);
	}

	public void deleteIncentive(int index) {
		if (index > allIncentives.size()) {
			// check
		}
		allIncentives.remove(index);
	}
}
