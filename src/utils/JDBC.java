package utils;

import java.sql.*;

public class JDBC {
    private static final String URL
            = "jdbc:sqlserver://is-swang01.ischool.uw.edu:1433;databaseName=VechileManagementSystem";
    private static final String USERNAME = "INFO6210";
    private static final String PASSWORD = "NEUHusky!";

    private Connection conn;
    private static JDBC _instance;

    static public JDBC getInstance() throws SQLException {
        if (_instance == null) {
            _instance = new JDBC();
        }
        return _instance;
    }

    private JDBC() throws SQLException {
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
}
