package m4.Team4;

public class Vehicle extends DataObject{
	  private String dealerId;
	  private String brand;//Honda
	  private String model;//Accord
	  private String year;
	  private String type;//SEDAN, SUV, VAN, PICKUP; private VehicleType type;
	  private Category category;//enum Category{ NEW, USED };
	  private String color;
	  private float price;
	  private float mileage;
	  private float salePrice;
	  private int peopleExpressingInterestInThisCar;
	  
	  enum Category{
		  NEW, USED;
	  }

	 public String getVehicleId() {
		 return super.id;
	 }

		
	 public void setVehicleId(String vehicleId) {	
		 super.id = vehicleId;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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

	public float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}

	public int getPeopleExpressingInterestInThisCar() {
		return peopleExpressingInterestInThisCar;
	}

	public void setPeopleExpressingInterestInThisCar(int peopleExpressingInterestInThisCar) {
		this.peopleExpressingInterestInThisCar = peopleExpressingInterestInThisCar;
	}
	  
	  
}
