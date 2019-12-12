package m2.DealerUI;


import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;

import javax.swing.JOptionPane;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.util.ArrayList;
	
public class ConnectToDatabase {
	 private static Connection conn;
	public void getConnections() throws SQLException
	{
		Connection conn;
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://is-swang01.ischool.uw.edu:1433; DatabaseName=VechileManagementSystem";
	
		String userid = "INFO6210";
		String passwd = "NEUHusky!";
	
		try {
			
			Class.forName(driverName);		
			conn = DriverManager.getConnection(dbURL, userid, passwd);
			if(conn == null)
				System.out.print("Null in Database");
			else
				setConn(conn);
				System.out.print(" Not Null in Database"+conn);
		}
		catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}

}

