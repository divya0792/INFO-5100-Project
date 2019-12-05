package m3.model.filter;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class ModelFilter extends ValueFilter<String>{
	public ModelFilter(String value, Checker<String> checker) {
		super(value, checker);
	}

	@Override
	public String getVehicleValue(Vehicle vehicle) {

		return vehicle.getModel();
	}

	@Override
	protected void setValue(String string) {
		char[] ch = string.toCharArray();
		for(int i =0; i<ch.length;i++) {
		  try{
			  if(!Character.isLetterOrDigit(ch[i])) {
				  throw new InputException("A model name can only contain number or letter or both.");
			  }
			   
		  }catch(InputException Ie){
			  System.out.println(Ie);
		  }
	  }
	}
}
