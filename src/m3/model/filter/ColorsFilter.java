package m3.model.filter;

import java.util.List;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class ColorsFilter extends ListFilter <String>{
	public ColorsFilter(List<String> list, Checker<String> checker) {
		super(list, checker);
	}

	@Override
	public String getVehicleValue(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return vehicle.getColor();
	}

	@Override
	protected void setValue(String string) {
		// TODO Auto-generated method stub
		String[] str = string.split(",");
		for(int i = 0; i < str.length; i++) {
			char[] ch = str[i].toCharArray();
			for(int j =0; j<ch.length;j++) {
				  try{
					  if(Character.isDigit(ch[j])) {
						  throw new InputException();
					  }
					   
				  }catch(InputException Ie){
					  System.out.println("Color names cannot contain any number.");
				  }
			  }
		}
		
	}
}
