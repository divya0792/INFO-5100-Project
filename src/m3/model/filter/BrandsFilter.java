package m3.model.filter;

import java.util.List;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class BrandsFilter extends ListFilter<String>{
	public BrandsFilter(List<String> list, Checker<String> checker) {
        super(list, checker);
    }
	
    @Override
    public String getVehicleValue(Vehicle vehicle) {
        return vehicle.getBrand();
    }

	@Override
	protected void setValue(String string) {
		String[] str = string.split(",");
		for(int i = 0; i < str.length; i++) {
			char[] ch = str[i].toCharArray();
			for(int j =0; j<ch.length;j++) {
				  try{
					  if(Character.isDigit(ch[j])) {
						  throw new InputException();
					  }
					   
				  }catch(InputException Ie){
					  System.out.println("Brand names cannot contain any number.");
				  }
			  }
		}
		
	}
}
