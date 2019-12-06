package m3.model.filter;

import java.util.List;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class PricesFilter extends ListFilter<Double>{

	public PricesFilter(List<Double> list, Checker<Double> checker) {
		super(list, checker);

	}

	@Override
	protected void setValue(String string) {
		String[] str = string.split(",");
		for(int i = 0; i < str.length; i++) {
			char[] ch = str[i].toCharArray();
			for(int j =0; j<ch.length;j++) {
				  try{
					  if(Character.isLetter(ch[j])) {
						  throw new InputException("Prices cannot contain any letter.");
					  }
					   
				  }catch(InputException Ie){
					  System.out.println(Ie);
				  }
			  }
		}
		
	}

	@Override
	public Double getVehicleValue(Vehicle vehicle) {
		
		return vehicle.getPrice();
	}

}
