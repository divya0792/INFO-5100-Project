package utils;

import java.sql.*;

public class JDBC {
	private Statement stmt;
	private static JDBC _instance;

	static public JDBC getInstance() {
		if (_instance == null) {
			_instance = new JDBC();
		}
		return _instance;
	}

	private JDBC() {
		Connection conn = null;
		stmt = null;
		try {
			// STEP 2: Register JDBC driver
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://is-swang01.ischool.uw.edu:1433;databaseName=VechileManagementSystem", "INFO6210",
					"NEUHusky!");
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			this.stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getResults(String query) {
		ResultSet rs = null;
		try {
			// stmt is the connection statement
			System.out.println("select sql query: " + query);
			rs = this.stmt.executeQuery(query);
			/**
			 * 
			 * rs = this.stmt.executeQuery("select * from dbo.CustomerRequest"); while
			 * (rs.next()) { System.out.println(rs.getString("leadId") +
			 * rs.getString("firstName")); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int update(String sql) {
		try {
			System.out.println("update sql query: " + sql);
			return this.stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
