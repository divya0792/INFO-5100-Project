package m3.model.filter;

import java.util.List;

import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class YearsFilter extends ListFilter <Integer>{
	public YearsFilter(List<Integer> list, Checker<Integer> checker) {
        super(list, checker);
    }

    @Override
    public Integer getVehicleValue(Vehicle vehicle) {
        return vehicle.getYear();
    }

	@Override
	protected void setValue(String string) {
		// TODO Auto-generated method stub
		String[] str = string.split(",");
		for(int i = 0; i < str.length; i++) {
			char[] ch = str[i].toCharArray();
			for(int j =0; j<ch.length;j++) {
				  try{
					  if(Character.isLetter(ch[j])) {
						  throw new InputException();
					  }
					   
				  }catch(InputException Ie){
					  System.out.println("Years cannot contain any letter.");
				  }
			  }
		}
		
	}
	
}
