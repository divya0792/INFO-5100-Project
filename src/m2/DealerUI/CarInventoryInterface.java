package m2.DealerUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import dataproto.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public interface CarInventoryInterface {
	
	public String addvehicle(Vehicle vehicle,DefaultTableModel tableModel) throws ParseException;

	public   String  deleteVehicle(Vehicle vehicle,DefaultTableModel tableModel,JTable jTable1) throws SQLException;

	public String modifyVehicle(Vehicle vehicle, DefaultTableModel tableModel,JTable jTable1) throws SQLException, ParseException;

}

