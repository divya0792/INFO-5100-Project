package m4.Team4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class LeadSearchImp{
    private Map<String, Lead> leadMap;
    private String driverName;
    private String dbURL;
    private String userid;
    private String passwd;


    public LeadSearchImp(){
    	Map<String, Lead> leadMap = new HashMap<>();
        this.leadMap=leadMap;
        this.driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.dbURL = "jdbc:sqlserver://128.95.157.76:1433; DatabaseName=VechileManagementSystem";
        this.userid = "INFO6210";
        this.passwd = "NEUHusky!";

    }

    public void getLead(String phoneNo){

        try{
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(dbURL,userid,passwd);
            String sql = "SELECT  * FROM dbo.CustomerRequest WHERE contactNo=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phoneNo);
            ResultSet rs = stmt.executeQuery();
            leadHelper(rs);

            stmt.close();
            conn.close();
        }
        catch(Exception sqle){
            System.out.println("Exception:" + sqle);
        }
    }
    public  void leadHelper(ResultSet rs) {
        try {
            while (rs.next()) {
            	Lead lead = new Lead();
            	lead.setLeadId(rs.getString("leadId"));
            	lead.setVehicleId(rs.getString("vehicleId"));
            	lead.setDealerId(rs.getString("dealerId"));
            	lead.setFirstName(rs.getString("firstName"));
            	lead.setLastName(rs.getString("LastName"));
            	lead.setEmail(rs.getString("email"));
            	lead.setContactNo(rs.getString("contactNo"));
            	lead.setComment(rs.getString("comment"));
            	lead.setDealerComment(rs.getString("dealerComment"));
            	leadMap.put(rs.getString("leadId"),lead);
            }
        }
        catch(Exception sqle){
            System.out.println("Exception:" + sqle);
        }
    }

    public Map<String, Lead> getLeadMap() {
        return leadMap;
    }

    public static void main(String[] args) {
    	 LeadSearchImp ds = new LeadSearchImp();
         ds.getLead("206-890-5085");
         Map<String, Lead> leadMap = ds.getLeadMap();
         System.out.println();
    }

}

