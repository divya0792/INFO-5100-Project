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
    try{
       //STEP 2: Register JDBC driver
       Class.forName("com.mysql.jdbc.Driver");

       //STEP 3: Open a connection
       System.out.println("Connecting to a selected database...");
       conn = DriverManager.getConnection(DB_URL, USER, PASS);
       System.out.println("Connected database successfully...");

       //STEP 4: Execute a query
       System.out.println("Creating statement...");
       this.stmt = conn.createStatement();
      } catch(Exception e) {

    }
  }
  public ResultSet getResults(String query) {
    ResultSet rs = null;
    try {
        //stmt is the connection statement
        rs = this.stmt.executeQuery(sql);
    } catch(Exception e) {
    }
    return rs;
  }
}
