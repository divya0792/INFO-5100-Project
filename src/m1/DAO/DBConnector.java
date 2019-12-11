package m1.DAO;

import java.sql.*;

public class DBConnector {

    private Connection conn;
    private Statement stmt;
    public static final DBConnector INSTANCE = new DBConnector();

    public Statement getStmt() {
        return this.stmt;
    }

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

    private PreparedStatement prepareStatement(String sql, String[] params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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

    public String updateReturnKey(String sql, String[] params) throws SQLException {
        PreparedStatement statement = prepareStatement(sql, params);
        int affRows = statement.executeUpdate();
        System.out.println("affRows " + affRows);
        ResultSet resultSet = statement.getGeneratedKeys();
        System.out.println(resultSet.next());
        return resultSet.getString(1);
    }


    public static void main(String[] args) {
        DBConnector.INSTANCE.test();
    }
}
