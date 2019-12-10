package m1.DAO;

import java.sql.*;

public class DBConnector {

    private Connection conn;
    private Statement stmt;
    private static final DBConnector INSTANCE = new DBConnector();

    private DBConnector () {
        try {
            this.conn = DriverManager.getConnection(
                    "jdbc:sqlserver://is-swang01.ischool.uw.edu:1433;databaseName=VechileManagementSystem", "INFO6210",
                    "NEUHusky!");
            this.stmt = this.conn.createStatement();
        } catch (Exception e) {
            System.out.println("Conntect DB error");
            e.printStackTrace();
            System.exit(1);
        }

    }

    private void test() {
        try {
            ResultSet r = stmt.executeQuery("select * from Dealer where DealerId = 100");
            System.out.println(r);
            while (r.next()) {
                System.out.println(r.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        DBConnector.INSTANCE.test();
    }
}
