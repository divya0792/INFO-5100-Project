package m4.Team1.database.dao;

import m4.Team1.database.model.VehicleDetails;
import m4.Team1.database.utils.SQLUtil;
import java.sql.*;

public class VehicleTableDao {
	private static final String VEHICLE_ID = "vechileId";
	private static final String PRICE = "price";
	private static final String BRAND = "brand";
	private static final String DEALER_ID = "dealerId";
	private static final String MODEL = "model";
	private static final String DATE_OF_MANUFAC = "dateofmanufacturing";
	private static final String TYPE = "type";
	private static final String CATEGORY = "category";
	private static final String COLOR = "color";
	private static final String MILEAGE = "mileage";
	private static final String INTERESTEDPEOPLE = "InterestedPeople";

	private final String url;
	private final String carTableName;

	private Connection connection;

	public VehicleTableDao(String url, String carTableName) {
		this.url = url;
		this.carTableName = carTableName;
		connection = SQLUtil.getConnection(url);
	}

	public VehicleDetails getVehicleDetails(String carId) {
		try {
			if (connection.isClosed()) {
				connection = SQLUtil.getConnection(url);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		try (Statement statement = connection.createStatement()) {
			String querySyntax = String.format("SELECT * FROM dbo.%s WHERE %s = '%s'", carTableName, VEHICLE_ID, carId);
			ResultSet result = statement.executeQuery(querySyntax);

			if (result.next()) {
				VehicleDetails vehicleDetails = new VehicleDetails();
				vehicleDetails.setId(result.getString(VEHICLE_ID));
				vehicleDetails.setDealerId(result.getString(DEALER_ID));
				vehicleDetails.setInterestedPeopleCount(result.getInt(INTERESTEDPEOPLE));
				vehicleDetails.setPrice(result.getDouble(PRICE));
				vehicleDetails.setBrand(result.getString(BRAND));
				vehicleDetails.setModel(result.getString(MODEL));
				vehicleDetails.setDateOfManufacturing(result.getDate(DATE_OF_MANUFAC));
				vehicleDetails.setType(result.getString(TYPE));
				vehicleDetails.setCategory(result.getString(CATEGORY));
				vehicleDetails.setColor(result.getString(COLOR));
				vehicleDetails.setMileage(result.getDouble(MILEAGE));

				return vehicleDetails;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateInterestedPeopleCount(String carId, int interestedPeoplecount) {
		try {
			if (connection.isClosed()) {
				connection = SQLUtil.getConnection(url);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		try (Statement statement = connection.createStatement()) {
			String querySyntax = String.format("UPDATE  dbo.%s SET InterestedPeople = %s WHERE %s = '%s'", carTableName,
					interestedPeoplecount + 1, VEHICLE_ID, carId);
			statement.execute(querySyntax);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
