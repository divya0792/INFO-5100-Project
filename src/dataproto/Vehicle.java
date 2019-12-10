package dataproto;

import java.util.Collection;

public class Vehicle extends DataObject{
  private String dealerId;
  private String brand;//Honda
  private String model;//Accord
  private int year;
  private String type;//SEDAN, SUV, VAN, PICKUP; private VehicleType type;
  private VehicleCategory category;//enum Category{ NEW, USED };
  private String color;
  private float price;
  private float mileage;
  private Collection<Incentive> matchedIncentives;
  private float salePrice;
  private int peopleExpressingInterestInThisCar;
}
