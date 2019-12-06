package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class PriceFilter extends ValueFilter<Double>{

	public PriceFilter(String value, Checker<Double> checker) {
		super(value, checker);
		
	}

	@Override
	protected void setValue(String string) {
		char[] ch = string.toCharArray();
		for(int i =0; i<ch.length;i++) {
		  try{
			  if(Character.isLetter(ch[i])) {
				  throw new InputException("A price number cannot contain any letter.");
			  }
			   
		  }catch(InputException Ie){
			  System.out.println(Ie);
		  }
	  }
		
	}

	@Override
	public Double getVehicleValue(Vehicle vehicle) {
		
		return vehicle.getPrice();
	}

}
