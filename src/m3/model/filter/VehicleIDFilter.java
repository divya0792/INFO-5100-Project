package m3.model.filter;


import m3.mock.Vehicle;
import m3.model.checker.Checker;

public class VehicleIDFilter extends ValueFilter<Integer>{
	 public VehicleIDFilter(String value, Checker<Integer> checker) {
	        super(value, checker);
	    }

	    @Override
	    public Integer getVehicleValue(Vehicle vehicle) {
	        return vehicle.getId();
	    }

		@Override
		protected void setValue(String string) {
			// TODO Auto-generated method stub
			char[] ch = string.toCharArray();
			for(int i =0; i<ch.length;i++) {
			  try{
				  if(Character.isLetter(ch[i])) {
					  throw new InputException();
				  }
				   
			  }catch(InputException Ie){
				  System.out.println("A VehicleID cannot contain letters.");
			  }
		  }
		}
	}

