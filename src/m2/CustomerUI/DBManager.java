package m2.CustomerUI;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    public ResultSet data;
    public String dealerId;

    public DBManager(String dealerId) {
        this.dealerId = dealerId;
    }

    /* getting the DB Connection */

    public Connection getDBConnection() throws SQLException {

        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://is-swang01.ischool.uw.edu:1433; DatabaseName=VechileManagementSystem";

        String userid = "INFO6210";
        String passwd = "NEUHusky!";

        Connection conn = null;

        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, userid, passwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /* fetching all the data without filters */

    public ResultSet getAllData() throws SQLException {
        String query = "select * from CarInventory where dealerID = '" + this.dealerId + "'";
        //	String query = "select count(vechileId) from CarInventory where dealerID = '"+this.dealerId+"'";
        System.out.println(query);

        data = queryExecution(query);
        return data;
    }

    /* fetching all the data with filters */

    public ResultSet getAllDataWithFilters(String parameters) throws SQLException {
        String queryWithFilters = "select * from CarInventory where " + parameters + " " + "and" + " " + "dealerID = '" + this.dealerId + "'";
        data = queryExecution(queryWithFilters);
        return data;
    }

    public ResultSet filterValues(String parameter) throws SQLException {
        String queryWithFilters = "select distinct " + parameter + " " + "from CarInventory " + "where" + " " + "dealerID = '" + this.dealerId + "'";
        data = queryExecution(queryWithFilters);
        return data;
    }

    public ResultSet getAllModels(String parameters) throws SQLException {
        String queryWithFilters = "select distinct model from CarInventory where brand = '" + parameters + "'" + "  " + "and" + " " + "dealerID = '" + this.dealerId + "'";
        data = queryExecution(queryWithFilters);
        return data;
    }

    /*
     * executing the query, where query is passed as a parameter to the below
     * function
     */

    public ResultSet queryExecution(String query) throws SQLException {
        Connection con = null;
        con = getDBConnection();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

