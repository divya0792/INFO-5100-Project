package utils;

import java.sql.*;

public class JDBC {
    private static final String URL
            = "jdbc:sqlserver://is-swang01.ischool.uw.edu:1433;databaseName=VechileManagementSystem";
    private static final String USERNAME = "INFO6210";
    private static final String PASSWORD = "NEUHusky!";

    private Connection conn;
    private static JDBC _instance;
    private Statement stmt;

    static public JDBC getInstance() throws SQLException {
        if (_instance == null) {
            _instance = new JDBC();
        }
        return _instance;
    }

    private JDBC() throws SQLException {
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				this.stmt = conn.createStatement();
    }

    private PreparedStatement prepareStatement(String sql, String[] params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stmt.setString(i + 1, params[i]);
        }
        return stmt;
    }

    public ResultSet query(String sql, String[] params) throws SQLException {
        return prepareStatement(sql, params).executeQuery();
    }

    public int update(String sql, String[] params) throws SQLException {
        return prepareStatement(sql, params).executeUpdate();
    }
		public ResultSet getResults(String query) {
			ResultSet rs = null;
			try {
				// stmt is the connection statement
				// System.out.println("select sql query: " + query);
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
		public int updateOldversion(String sql) {
			try {
				// System.out.println("update sql query: " + sql);
				return this.stmt.executeUpdate(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
}
