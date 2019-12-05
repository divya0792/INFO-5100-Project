package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

import java.util.List;

public class VehicleIDsFilter extends ListFilter<Integer> {
    public VehicleIDsFilter(List<Integer> list, Checker<Integer> checker) {
        super(list, checker);
    }

    @Override
    public Integer getVehicleValue(Vehicle vehicle) {
        return vehicle.getId();
    }

	@Override
	protected void setValue(String string) {
	
		String[] str = string.split(",");
		for(int i = 0; i < str.length; i++) {
			char[] ch = str[i].toCharArray();
			for(int j =0; j<ch.length;j++) {
				  try{
					  if(Character.isLetter(ch[j])) {
						  throw new InputException("VehicleIDs cannot contain any letter.");
					  }
					   
				  }catch(InputException Ie){
					  System.out.println(Ie);
				  }
			  }
		}
		
	}
}
