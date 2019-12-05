package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class YearFilter extends ValueFilter<Integer>{
	public YearFilter(String value, Checker<Integer> checker) {
        super(value, checker);
    }

    @Override
    public Integer getVehicleValue(Vehicle vehicle) {
        return vehicle.getYear();
    }

	@Override
	protected void setValue(String string) {
		
		char[] ch = string.toCharArray();
		for(int i =0; i<ch.length;i++) {
		  try{
			  if(Character.isLetter(ch[i])) {
				  throw new InputException("A year number cannot contain any letter.");
			  }
			   
		  }catch(InputException Ie){
			  System.out.println(Ie);
		  }
	  }
	}
	
}
