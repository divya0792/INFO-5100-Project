package m2.CustomerUI;

import dataproto.Vehicle;
import m3.IncentiveManagement;
import m3.manager.IncentiveManager;
import m3.model.Incentive;
import m3.model.IncentivesFinalPrice;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModuleIntegrator {
    DBManager db = new DBManager("DEA0001");

    public ArrayList<Vehicle> integratorGetAllVehicles() {

        ResultSet rs;

        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

        try {
            rs = db.getAllData();

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();

                vehicle.setDealerId(rs.getString(2));
                vehicle.setBrand(rs.getString(3));
                vehicle.setModel(rs.getString(4));

                vehicle.setDateofmanufacturing(rs.getString(5));

                vehicle.setType(rs.getString(6));

                String category = rs.getString(7);

                if (category.equals("NEW")) {
                    vehicle.setCategory("NEW");
                } else {
                    vehicle.setCategory("USED");
                }

                vehicle.setColor(rs.getString(8));

                float price = Float.parseFloat(rs.getString(9));
                vehicle.setPrice(price);

                float mileage = Float.parseFloat(rs.getString(10));
                vehicle.setMileage(mileage);

                vehicleList.add(vehicle);
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

        //get incentives for vehicles

        IncentiveManagement incentiveManagement = new IncentiveManager();
        List<IncentivesFinalPrice> finalIncentiveList = incentiveManagement.getVehicleFinalIncentives((Vehicle[]) vehicleList.toArray());



        return vehicleList;



    }

    public ArrayList<Vehicle> integratorGetFilteredVehiclesFor(String searchString) {
        ResultSet rs;

        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

        try {
            rs = db.getAllDataWithFilters(searchString);

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();

                vehicle.setDealerId(rs.getString(2));
                vehicle.setBrand(rs.getString(3));
                vehicle.setModel(rs.getString(4));

                String[] year = rs.getString(5).split("-");
                vehicle.setYear(Integer.parseInt(year[0]));
                vehicle.setType(rs.getString(6));

                String category = rs.getString(7);

                if (category.equals("NEW")) {
                    vehicle.setCategory("NEW");
                } else {
                    vehicle.setCategory("USED");
                }

                vehicle.setColor(rs.getString(8));

                float price = Float.parseFloat(rs.getString(9));
                vehicle.setPrice(price);

                float mileage = Float.parseFloat(rs.getString(10));
                vehicle.setMileage(mileage);

                vehicleList.add(vehicle);
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }


        return vehicleList;
    }
}
