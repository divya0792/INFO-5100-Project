package dataproto;

import java.util.Collection;
import java.util.List;

public class Vehicle extends DataObject{
    private String id;
    private String dealerId;
	private String brand;
	private String model;
	private int year;
	private String dateofmanufacturing;
	private String type;
	private String category;
	private String color;
	private float price;
	private float mileage;
	private String flag;
	private List<m3.model.Incentive> matchedIncentives;
	private double salePrice;
	private int peopleExpressingInterestInThisCar;

	public String getId() {
		return id;
	}

	public int getYear() {
		int ret = 0;
		try {
			ret = Integer.parseInt(dateofmanufacturing.split("-")[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setId(String id) {
	this.id = id;
}

public String getDealerId() {
	return dealerId;
}

public void setDealerId(String dealerId) {
	this.dealerId = dealerId;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public String getDateofmanufacturing() {
	return dateofmanufacturing;
}

public void setDateofmanufacturing(String dateofmanufacturing) {
	this.dateofmanufacturing = dateofmanufacturing;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public float getMileage() {
	return mileage;
}

public void setMileage(float mileage) {
	this.mileage = mileage;
}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<m3.model.Incentive> getMatchedIncentives() {
		return matchedIncentives;
	}

	public void setMatchedIncentives(List<m3.model.Incentive> matchedIncentives) {
		this.matchedIncentives = matchedIncentives;
	}

	public int getPeopleExpressingInterestInThisCar() {
		return peopleExpressingInterestInThisCar;
	}

	public void setPeopleExpressingInterestInThisCar(int peopleExpressingInterestInThisCar) {
		this.peopleExpressingInterestInThisCar = peopleExpressingInterestInThisCar;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public Vehicle() {

	}

	public Vehicle(String carIDString, String dealerIDString, String brandString, String modelString,
				   String dateofmanufacturingString, String typeString, String categoryString,
				   String colorString, float price, float mileage) {
		// TODO Auto-generated constructor stub
		  id = carIDString;
          dealerId = dealerIDString;
          brand = brandString;
          model = modelString;        
          dateofmanufacturing = dateofmanufacturingString;
          type = typeString;
          category = categoryString;
          color = colorString;     
          this.price = price;
          this.mileage = mileage;

	}
	

}
