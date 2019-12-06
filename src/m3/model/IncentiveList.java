package m3.model;

import java.util.*;

public class IncentiveList {
	
	private static List<Incentive> allIncentives = new ArrayList<Incentive>();
	
	public static List<Incentive> getAllIncentives(){
		return allIncentives;
	}
	
	public static void addIncentive(Incentive i){
		allIncentives.add(i);
	}
	
	public static void addIncentive(Incentive i, int index){
		allIncentives.add(index, i);
	}
	
	public static Incentive getIncentiveByIndex(int index){
		if(index > allIncentives.size()){
			// check
		}
		return allIncentives.get(index);
	}
	
	public static void deleteIncentive(int index){
		if(index > allIncentives.size()){
			// check
		}
		allIncentives.remove(index);
	}
}
