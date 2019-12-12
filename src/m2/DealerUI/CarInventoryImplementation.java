package m2.DealerUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dataproto.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CarInventoryImplementation implements CarInventoryInterface {
	
	public String addvehicle(Vehicle vehicle,DefaultTableModel tableModel) throws ParseException  {
		// TODO Auto-generated method stub	
		
		try {
			
			 ConnectToDatabase connectToSql = new ConnectToDatabase();
			  Connection connection = connectToSql.getConn();
			 String query = "select *  FROM dbo.CarInventory WHERE vechileId  = ? "
		             + "AND dealerId = ?";
		            PreparedStatement pst = connection.prepareStatement(query);
		            pst.setString(1, vehicle.getId());
		            pst.setString(2, vehicle.getDealerId());
		            ResultSet rs = pst.executeQuery();

	         if (!rs.next()) {
	        	 
	        	 String record ="INSERT INTO dbo.CarInventory(vechileId,dealerId,brand,model,dateofmanufacturing,type,category,color,price,mileage)"
	        	          +"VALUES(?,?,?,?,?,?,?,?,?,?)";
	        	 PreparedStatement stmt = connection.prepareStatement(record);
	        	 stmt.setString(1, vehicle.getId());
	             stmt.setString(2, vehicle.getDealerId());
	             stmt.setString(3, vehicle.getBrand());
	             stmt.setString(4, vehicle.getModel());
                 String manufacturingDate = vehicle.getDateofmanufacturing();
	             Date utilDate = new SimpleDateFormat("yyyy-mm-dd").parse(manufacturingDate);
	             java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	             stmt.setDate(5,sqlDate);
	             stmt.setString(6,vehicle.getType());
	             stmt.setString(7, vehicle.getCategory());
	             stmt.setString(8, vehicle.getColor());
	             stmt.setFloat(9, vehicle.getPrice());
	             stmt.setFloat(10, vehicle.getMileage());
	             int affectedRows = stmt.executeUpdate();
	        	 stmt.close();
	             if (affectedRows > 0) {
	            	 String message = "Details are succesfully entered";
	            	 tableModel.addRow(new Object[]{vehicle.getId(),vehicle.getBrand(),vehicle.getModel(),vehicle.getDateofmanufacturing(),vehicle.getType(),vehicle.getCategory(),vehicle.getColor(),vehicle.getPrice(),vehicle.getMileage()});            	 
	                  	 return message;
	             }
	             
	        }
	         else
	         {  String message = " Dealer and Vehicle already exists";
        	     return message;
	        }
	         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error occured while registering";
		
	}

	

	public int getRowCount(Connection conn) throws SQLException {
		 ConnectToDatabase connectToSql = new ConnectToDatabase();
		 Connection connection = connectToSql.getConn();
		 Statement st = connection.createStatement();
    	 ResultSet rset = st.executeQuery("SELECT COUNT(*) FROM dbo.CarInventory");
    	 rset.next();
    	 int rowCount = rset.getInt(1);
    	 rset.close();
    	 st.close();
		return rowCount;
	}

	@Override
	public   String  deleteVehicle(Vehicle vehicle,DefaultTableModel tableModel,JTable jTable1) throws SQLException {
		// TODO Auto-generated method stub
		  ConnectToDatabase connectToSql = new ConnectToDatabase();
		  Connection connection = connectToSql.getConn();
		 String query = "select *  FROM dbo.CarInventory WHERE vechileId  = ? "
	             + "AND dealerId = ?";
	            PreparedStatement pst = connection.prepareStatement(query);
	            pst.setString(1,  vehicle.getId());
	            pst.setString(2, vehicle.getDealerId());
	            ResultSet rs = pst.executeQuery();
	          

         if (rs.next()) {
		String sql = "DELETE FROM dbo.CarInventory WHERE vechileId  = ? "
	             + "AND dealerId = ?";
	            PreparedStatement pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, vehicle.getId());
	            pstmt.setString(2, vehicle.getDealerId());
	            int affectedRows  = pstmt.executeUpdate();
	         
	             if (affectedRows > 0) {
	            	 tableModel.removeRow(jTable1.getSelectedRow());         	 
	            	 String message = " Car Details successfully deleted";
	            	 return message;
	             }	             
	        
	         else
	         {  String message = "Error occured while deleting";
       	          return message;
	        }
         }
         else
         {
        	 return "No entries exist for the dealer and car";
         }
       
	            
	}

	@Override
	public String modifyVehicle(Vehicle vehicle, DefaultTableModel tableModel,JTable jTable1) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		  ConnectToDatabase connectToSql = new ConnectToDatabase();
		  Connection connection = connectToSql.getConn();
		  String query = "select *  FROM dbo.CarInventory WHERE vechileId  = ? "
	             + "AND dealerId = ?";
	            PreparedStatement pst = connection.prepareStatement(query);
	            pst.setString(1, vehicle.getId());
	            pst.setString(2, vehicle.getDealerId());
	            ResultSet rs = pst.executeQuery();
	          

        if (rs.next()) {
        		String sql = "UPDATE dbo.CarInventory"
                 + " SET  brand = ?,"
                 + "  model  = ?,"
                 + " dateofmanufacturing = ?,"
                 + " type  = ?,"
                 + " category = ?,"
                 + " color = ?,"
                 + " price = ?,"
                 + " mileage = ?"
                 + " where vechileId  = ?"
	             + " AND dealerId = ?";
                 
	            PreparedStatement stmt = connection.prepareStatement(sql);
	             stmt.setString(1, vehicle.getBrand());
	             stmt.setString(2, vehicle.getModel());
                 String manufacturingDate = vehicle.getDateofmanufacturing();
                 Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(manufacturingDate);
	             java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	             stmt.setDate(3,sqlDate);
	             stmt.setString(4,vehicle.getType());
	             stmt.setString(5, vehicle.getCategory());
	             stmt.setString(6, vehicle.getColor());
	             stmt.setFloat(7, vehicle.getPrice());
	             stmt.setFloat(8, vehicle.getMileage());  
	             stmt.setString(9, vehicle.getId());
	             stmt.setString(10, vehicle.getDealerId());
	             int affectedRows  = stmt.executeUpdate();
	         
	             if (affectedRows > 0) {
	            	 
	                 int selectedRowIndex = jTable1.getSelectedRow();
	                 tableModel.setValueAt(vehicle.getId(), selectedRowIndex, 0);
	                 tableModel.setValueAt(vehicle.getBrand(), selectedRowIndex, 1);
	                 tableModel.setValueAt(vehicle.getModel(), selectedRowIndex, 2);
	                 String manufacturingDate1 = vehicle.getDateofmanufacturing();
	                 Date utilDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(manufacturingDate1);
	                 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	                 String date = formatter.format(utilDate1);
	                 tableModel.setValueAt(date, selectedRowIndex, 3);
	                 tableModel.setValueAt(vehicle.getType(), selectedRowIndex, 4);
	                 tableModel.setValueAt(vehicle.getCategory(), selectedRowIndex, 5);
	                 tableModel.setValueAt(vehicle.getColor(), selectedRowIndex, 6);
	                 tableModel.setValueAt(vehicle.getPrice(), selectedRowIndex, 7);
	                 tableModel.setValueAt(vehicle.getMileage(), selectedRowIndex, 8);
	            	 
	            	 String message = " Car Details successfully updated";
	            	 return message;
	             }	             
	        
	         else
	         {  String message = "Error occured while updating";
      	          return message;
	        }
        }
        else
        {
       	 return "No entries exist for the dealer and car";
        }
	            
		
	}
	// Convert data into 2D Data for displaying
	public Object[][] convert2Data(ArrayList<Vehicle> list) {
	       Object[][] data = new Object[list.size()][10];
	       for (int i = 0; i < list.size(); i++) {
	          data[i][0] = list.get(i).getId();
	          data[i][1] = list.get(i).getBrand();
	          data[i][2] = list.get(i).getModel();
	          data[i][3] = list.get(i).getDateofmanufacturing();
	          data[i][4] = list.get(i).getType();
	          data[i][5] = list.get(i).getCategory();
	          data[i][6] = list.get(i).getColor();
	          data[i][7] = list.get(i).getPrice();
	          data[i][8] = list.get(i).getMileage();
	       }
	       return data;
}
// Method returns the list of all Dealers
	public ArrayList<Vehicle> getListForAllDealers() throws SQLException {
		// TODO Auto-generated method stub
		 ConnectToDatabase connectToSql = new ConnectToDatabase();
		  Connection connection = connectToSql.getConn();
		Statement stmt = connection.createStatement();
		String SQL = "SELECT * FROM dbo.CarInventory";
        ResultSet rs = stmt.executeQuery(SQL);
        ArrayList<Vehicle> list = new ArrayList<Vehicle>(); 

            
        // Iterate through the data in the result set and display it.
       while (rs.next()) {
       	Vehicle vehicle = new Vehicle(); 
       	
       	vehicle.setId(rs.getString("vechileId"));
       	
       	vehicle.setDealerId(rs.getString("dealerId"));
       	
       	vehicle.setBrand(rs.getString("brand"));
       	vehicle.setModel(rs.getString("model"));
       	
       	vehicle.setDateofmanufacturing(rs.getString("dateofmanufacturing"));
       	vehicle.setType(rs.getString("type"));
       	
       	vehicle.setCategory(rs.getString("category"));
       	vehicle.setColor(rs.getString("color"));
       	
       	vehicle.setPrice(rs.getFloat("price"));
       	vehicle.setMileage(rs.getFloat("mileage"));
           
           list.add(vehicle);
       }
       return list;
	}

	public ArrayList<Vehicle> getListOflDealersCar(String dealerIDString) throws SQLException {
		// TODO Auto-generated method stub
		  ArrayList<Vehicle> listOfCarsForDealers = new ArrayList<Vehicle>();
		  String query = "select *  FROM dbo.CarInventory WHERE dealerId  = ? ";	
		
		  ConnectToDatabase connectToSql = new ConnectToDatabase();
		  Connection connection = connectToSql.getConn();
		  if  (connection == null)
			  System.out.println ("Null value");
		  PreparedStatement pst = connection.prepareStatement(query);
          pst.setString(1, dealerIDString);
          ResultSet rs = pst.executeQuery();
   
		// Iterate through the data in the result set and display it.
	       while (rs.next()) {
	    	   
		       	Vehicle vehicle = new Vehicle(); 
		     	
		       	vehicle.setId(rs.getString("vechileId"));
		       	
		       	vehicle.setDealerId(rs.getString("dealerId"));
		       	
		       	vehicle.setBrand(rs.getString("brand"));
		       	vehicle.setModel(rs.getString("model"));
		       	
		       	vehicle.setDateofmanufacturing(rs.getString("dateofmanufacturing"));
		       	vehicle.setType(rs.getString("type"));
		       	
		       	vehicle.setCategory(rs.getString("category"));
		       	vehicle.setColor(rs.getString("color"));
		       	
		       	vehicle.setPrice(rs.getFloat("price"));
		       	vehicle.setMileage(rs.getFloat("mileage"));
		           
		       	listOfCarsForDealers.add(vehicle);
	       }		
		return listOfCarsForDealers;
		
	}
}
