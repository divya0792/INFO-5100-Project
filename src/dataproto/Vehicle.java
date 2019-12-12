package dataproto;

import java.util.Collection;

public class Vehicle extends DataObject {
    private String dealerId;
    private String brand;//Honda
    private String model;//Accord
    private int year;
    private String type;//SEDAN, SUV, VAN, PICKUP; private VehicleType type;
    private String category;//enum Category{ NEW, USED };
    private String color;
    private float price;
    private float mileage;
    private Collection<Incentive> matchedIncentives;
    private float salePrice;
    private int peopleExpressingInterestInThisCar;


    public Vehicle(String model, String ID, String dealerId, float price, String color, String type, int year) {
        this.setId(ID);
        this.dealerId = dealerId;
        this.model = model;
        this.year = year;
        this.type = type;
        this.color = color;
        this.price = price;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public Collection<Incentive> getMatchedIncentives() {
        return matchedIncentives;
    }

    public void setMatchedIncentives(Collection<Incentive> matchedIncentives) {
        this.matchedIncentives = matchedIncentives;
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
