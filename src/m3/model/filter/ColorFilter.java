package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class ColorFilter extends ValueFilter<String>{
	public ColorFilter(String value, Checker<String> checker) {
		super(value, checker);
	}

	@Override
	public String getVehicleValue(Vehicle vehicle) {

		return vehicle.getColor();
	}

	@Override
	protected void setValue(String string) {
		char[] ch = string.toCharArray();
		for(int i =0; i<ch.length;i++) {
		  try{
			  if(Character.isDigit(ch[i])) {
				  throw new InputException("A color name cannot contain any number.");
			  }
			   
		  }catch(InputException Ie){
			  System.out.println(Ie);
		  }
	  }
	
	}
}
