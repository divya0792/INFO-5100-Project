package m3.model.filter;

import java.util.List;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class ModelsFilter extends ListFilter <String>{
	public ModelsFilter(List<String> list, Checker<String> checker) {
		super(list, checker);
	}

	@Override
	public String getVehicleValue(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return vehicle.getModel();
	}

	@Override
	protected void setValue(String string) {
		// TODO Auto-generated method stub
		String[] str = string.split(",");
		for(int i = 0; i < str.length; i++) {
			char[] ch = str[i].toCharArray();
			for(int j =0; j<ch.length;j++) {
				  try{
					  if(Character.isLetterOrDigit(ch[j])) {
						  throw new InputException();
					  }
					   
				  }catch(InputException Ie){
					  System.out.println("Model names can only contain number, letter or both.");
				  }
			  }
		}
		
	}
}
