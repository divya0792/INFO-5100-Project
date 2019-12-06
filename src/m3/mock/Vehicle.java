package m3.mock;

public class Vehicle {
    private String brand;
    private int id;
    private Dealer dealer;
    private double price;
    private String color;
    private String model;
    private Integer year;


    public Vehicle(String brand, int id, Dealer dealer, double price, String color, String model, Integer year) {
        this.brand = brand;
        this.id = id;
        this.dealer = dealer;
        this.price = price;
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
