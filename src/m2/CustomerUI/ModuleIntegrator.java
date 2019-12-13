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
import java.util.HashMap;
import java.util.List;

public class ModuleIntegrator {
    DBManager db;

    public ModuleIntegrator(String dealerID) {
        db = new DBManager(dealerID);
    }

    public ArrayList<Vehicle> integratorGetAllVehicles() {

        ResultSet rs;

        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

        try {
            rs = db.getAllData();

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();

                vehicle.setId(rs.getString(1));
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
        } catch (SQLException se) {
            se.printStackTrace();
        }

        //get incentives for vehicles

        Vehicle[] arrayOfVehicles = new Vehicle[vehicleList.size()];

        for (int i = 0; i < vehicleList.size(); i++) {
            arrayOfVehicles[i] = vehicleList.get(i);
        }

        IncentiveManagement incentiveManagement = new IncentiveManager();
        List<IncentivesFinalPrice> finalIncentiveList = incentiveManagement.getVehicleFinalIncentives(arrayOfVehicles);

        for (int i = 0; i < vehicleList.size(); i++) {
            IncentivesFinalPrice ifp = finalIncentiveList.get(i);
            Vehicle vehicle = vehicleList.get(i);

            vehicle.setSalePrice(ifp.getFinalPrice());
            vehicle.setMatchedIncentives(ifp.getIncentives());
        }

        return vehicleList;
    }

    public ArrayList<Vehicle> integratorGetFilteredVehiclesFor(String searchString) {
        ResultSet rs;

        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

        try {
            rs = db.getAllDataWithFilters(searchString);

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();

                vehicle.setId(rs.getString(1));
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
        } catch (SQLException se) {
            se.printStackTrace();
        }

        //get incentives for vehicles

        Vehicle[] arrayOfVehicles = new Vehicle[vehicleList.size()];

        for (int i = 0; i < vehicleList.size(); i++) {
            arrayOfVehicles[i] = vehicleList.get(i);
        }

        IncentiveManagement incentiveManagement = new IncentiveManager();
        List<IncentivesFinalPrice> finalIncentiveList = incentiveManagement.getVehicleFinalIncentives(arrayOfVehicles);

        for (int i = 0; i < vehicleList.size(); i++) {
            IncentivesFinalPrice ifp = finalIncentiveList.get(i);
            Vehicle vehicle = vehicleList.get(i);

            vehicle.setSalePrice(ifp.getFinalPrice());
            vehicle.setMatchedIncentives(ifp.getIncentives());
        }

        return vehicleList;
    }


    public String getIncentiveForVehicle(Vehicle selectedVehicle) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < selectedVehicle.getMatchedIncentives().size(); i++) {
            Incentive inc = selectedVehicle.getMatchedIncentives().get(i);

            if(i == selectedVehicle.getMatchedIncentives().size()-1) {
                sb.append(inc.getTitle() + " (" + inc.getDisclaimer() + ")");
            }
            else {
                sb.append(inc.getTitle() + " (" + inc.getDisclaimer() + "), ");
            }
        }

        return sb.toString();
    }

}
