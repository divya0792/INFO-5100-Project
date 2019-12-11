package m4.Team4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VehicleSearchImp {
	private Vehicle vehicle;
    private String driverName;
    private String dbURL;
    private String userid;
    private String passwd;


    public VehicleSearchImp(){
        this.driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.dbURL = "jdbc:sqlserver://128.95.157.76:1433; DatabaseName=VechileManagementSystem";
        this.userid = "INFO6210";
        this.passwd = "NEUHusky!";

    }

    public void getVehicle(String vehicleId){
    	System.out.println(vehicleId);
        try{
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(dbURL,userid,passwd);            String.format("select * from dbo.CarInventory where vechileId = '%s'", vehicleId);
            String sql = "SELECT  * FROM dbo.CarInventory WHERE vechileId=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, vehicleId);
            ResultSet rs = stmt.executeQuery();
            VehicleHelper(rs);

            stmt.close();
            conn.close();
        }
        catch(Exception sqle){
            System.out.println("Exception:" + sqle);
        }
    }
    public void VehicleHelper(ResultSet rs) {
        try {
            while (rs.next()) {
            	vehicle = new Vehicle();
            	vehicle.setVehicleId(rs.getString("vechileId"));
            	vehicle.setBrand(rs.getString("brand"));
            	vehicle.setType(rs.getString("type"));
            	vehicle.setDealerId(rs.getString("dealerId"));
            	vehicle.setYear(rs.getString("dateofmanufacturing"));
            	vehicle.setModel(rs.getString("model"));
            	vehicle.setPrice((Float.valueOf(rs.getString("price"))));
            	vehicle.setPeopleExpressingInterestInThisCar(Integer.valueOf(rs.getString("InterestedPeople")));
            	
            }
        }
        catch(Exception sqle){
            System.out.println("Exception:" + sqle);
        }
    }
    
    public Vehicle getVehicle() {
    	return vehicle;
    }

}
