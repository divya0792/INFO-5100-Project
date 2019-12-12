package m2.CustomerUI;

public class Vehicle {
    private String id;
    private String brand;
    private String model;
    private int year;
    private String type;
    private String category;
    private String color;
    private float price;
    private float mileage;
    private float salePrice;

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return this.model;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setCategory(String used){
        this.category = used;
    }

    public String getCategory(){
        return this.category;
    }

    public void setMileage(float mileage){
        this.mileage = mileage;
    }

    public float getMileage(){
        return this.mileage;
    }

    public void setSalePrice(float salePrice){
        this.salePrice = salePrice;
    }

    public float getSalePrice(){
        return this.salePrice;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }



    public Vehicle(String id,String brand, String model, int year, String type, String category, String color,float price, float mileage,float salePrice){
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.model = model;
        this.year = year;
        this.type = type;
        this.category = category;
        this.mileage = mileage;
        this.salePrice = salePrice;

    }
}
