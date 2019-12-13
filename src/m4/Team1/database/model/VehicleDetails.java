package m4.Team1.database.model;

import java.sql.Date;

public class VehicleDetails {
    private String id;
    private int interestedPeopleCount;
    private String dealerId;
    private String brand;
    private String model;
    private Date dateOfManufacturing;
    private String type;
    private String category;
    private String color;
    private double price;
    private double mileage;

    public String getDetails() {
        return String.format("brand: %s \nmodel: %s \ndate-of-manufacturing: %s \ntype: %s \ncategory: %s \ncolor: %s \nprice: %.3f \nmileage: %.3f",
                brand, model, dateOfManufacturing, type, category, color, price, mileage);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInterestedPeopleCount() {
        return interestedPeopleCount;
    }

    public void setInterestedPeopleCount(int interestedPeopleCount) {
        this.interestedPeopleCount = interestedPeopleCount;
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

    public Date getDateOfManufacturing() {
        return dateOfManufacturing;
    }

    public void setDateOfManufacturing(Date dateOfManufacturing) {
        this.dateOfManufacturing = dateOfManufacturing;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
}
