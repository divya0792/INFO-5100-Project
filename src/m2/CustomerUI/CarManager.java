package m2.CustomerUI;
//package FinalProject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class CarManager {
//    ArrayList<CarInformation> carList = new ArrayList<CarInformation>();
//
//    public void addcars(CarInformation car){
//        boolean hasCar = carList.contains(car);
//        if(!hasCar)
//            carList.add(car);
//        else
//            System.out.println("the car with id " + car.getId() + "has already exist");
//
//    }
//
//    public CarInformation findcars(String brand, double price, String color, String state){
//        for(CarInformation cars : carList){
//            if(cars.getBrand().equals(brand)){
//                if(cars.getPrice() <= price){
//                    if(cars.getColor().equals(color)){
//
//                        return cars;
//                    }
//
//                }
//            }
//        }
//        return null;
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<CarInformation> getCars() {
//        return (ArrayList<CarInformation>)carList.clone();
//    }
//
//
//
//}
