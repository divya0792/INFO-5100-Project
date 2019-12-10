package m2.dealerUI;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionURL {

	static ArrayList<String> data;
	
	/*getting the DB Connection*/

	public static Connection getDBConnection() throws SQLException {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://is-swang01.ischool.uw.edu:1433; DatabaseName=VechileManagementSystem";

		String userid = "INFO6210";
		String passwd = "NEUHusky!";

		Connection conn = null;

		try {
			System.out.println("123");
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, userid, passwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/*fetching all the data without filters*/

	public static ArrayList<String> getAllData() throws SQLException {
		String query = "select brand,model,Datepart(year,dateofmanufacturing) as year,type,category,color,price,mileage from CarInventory";

		data = executeQuery(query);
		return data;
	}
	
	/*fetching all the data with filters*/
	
	public static ArrayList<String> getAllDataWithFilters(String parameters) throws SQLException {
		String queryWithFilters = "select brand,model,Datepart(year,dateofmanufacturing) as year,type,category,color,price,mileage from CarInventory where "
				+ parameters;
		data = executeQuery(queryWithFilters);
		return data;
	}

	/*executing the query, where query is passed as a parameter to the below function */
	
	public static ArrayList<String> executeQuery(String query) throws SQLException {
		ArrayList<String> columnValues = new ArrayList<String>();
		Connection con = null;
		con = getDBConnection();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					columnValues.add(rs.getString(i));

				}

			}
			System.out.println(columnValues);
			return columnValues;
		}

		catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			con.close();

		}
		return null;
	}

	public static void main(String[] args) throws SQLException {

		ArrayList<String> arr = getAllData();
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}

		/*ArrayList<String> arr1 = getAllDataWithFilters("brand='TESLA'");
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}*/

	}
}
