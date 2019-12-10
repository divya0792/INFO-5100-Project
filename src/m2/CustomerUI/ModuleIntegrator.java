package m2.CustomerUI;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModuleIntegrator {
    DBManager db = new DBManager();

    public ArrayList<VehicleObj> integratorGetAllVehicles() {

        ResultSet rs;

        ArrayList<VehicleObj> vehicleList = new ArrayList<VehicleObj>();

        try {
            rs = db.getAllData();

            while (rs.next()) {
                VehicleObj vehicle = new VehicleObj();

                vehicle.setDealerId(rs.getString(2));
                vehicle.setBrand(rs.getString(3));
                vehicle.setModel(rs.getString(4));

                String[] year = rs.getString(5).split("-");
                vehicle.setYear(Integer.parseInt(year[0]));
                vehicle.setType(rs.getString(6));

                String category = rs.getString(7);

                if (category == "NEW") {
                    vehicle.setCategory(Category.NEW);
                } else {
                    vehicle.setCategory(Category.USED);
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

    public ArrayList<VehicleObj> integratorGetFilteredVehiclesFor(String searchString) {
        ResultSet rs;

        ArrayList<VehicleObj> vehicleList = new ArrayList<VehicleObj>();

        try {
            rs = db.getAllDataWithFilters(searchString);

            while (rs.next()) {
                VehicleObj vehicle = new VehicleObj();

                vehicle.setDealerId(rs.getString(2));
                vehicle.setBrand(rs.getString(3));
                vehicle.setModel(rs.getString(4));

                String[] year = rs.getString(5).split("-");
                vehicle.setYear(Integer.parseInt(year[0]));
                vehicle.setType(rs.getString(6));

                String category = rs.getString(7);

                if (category == "NEW") {
                    vehicle.setCategory(Category.NEW);
                } else {
                    vehicle.setCategory(Category.USED);
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
