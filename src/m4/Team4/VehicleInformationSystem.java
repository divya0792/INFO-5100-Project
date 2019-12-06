package m4.Team4;


import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleInformationSystem implements TableModel {
	Map<String, Vehicle> vehicleManager;
	List<String> keyList;
	
	VehicleInformationSystem(Map<String, Vehicle> vehiclesMap){
		this.vehicleManager = vehiclesMap;
		keyList = getLeadId(vehiclesMap);
	}

	public int getRowCount() {
		return vehicleManager.size();
	}

	public int getColumnCount() {
		return 11;
	}
	
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "      Icon";
		case 1:
			return "LeadId";
		case 2:
			return "VehicleId";
		case 3:
			return "Brand";
		case 4:
			return "Model";
		case 5:
			return "Year";
		case 6:
			return "Type";
		case 7:
			return "Category";
		case 8:
			return "Color";
		case 9:
			return "SalePrice";
		default:
			return "DealerComment";
		}
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		String leadId = keyList.get(rowIndex);
		Vehicle vehicle = vehicleManager.get(leadId);
		switch (columnIndex) {
		case 1:
			return leadId;
		case 2:
			return vehicle.getVehicleId();
		case 3:
			return vehicle.getBrand();
		case 4:
			return vehicle.getModel();
		case 5:
			return String.valueOf(vehicle.getYear());
		case 6:
			return vehicle.getType();
		case 7:
			return vehicle.getCategory();
		case 8:
			return vehicle.getColor();
		case 9:
			return String.valueOf(vehicle.getSalePrice());
		case 10:
			return "";
		default:
			return "Invalid Information";
		}
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}

	public void addTableModelListener(TableModelListener l) {
		
	}

	public void removeTableModelListener(TableModelListener l) {
		
	}
	
	public List<String> getLeadId(Map<String, Vehicle> vehiclesMap){
		return new ArrayList<String>(vehiclesMap.keySet()); 
	}

}
