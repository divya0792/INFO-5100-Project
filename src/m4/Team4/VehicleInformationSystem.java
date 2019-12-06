package m4.Team4;


import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleInformationSystem implements TableModel {
	private Map<String, Lead> leadMap;
	private Map<String, Vehicle> vehicleManager;
	private List<String> keyList;
	
	VehicleInformationSystem(Map<String, Lead> leadMap, Map<String, Vehicle> vehiclesMap){
		this.leadMap = leadMap;
		this.vehicleManager = vehiclesMap;
		keyList = getLeadId(vehiclesMap);
	}

	public int getRowCount() {
		return vehicleManager.size();
	}

	public int getColumnCount() {
		return 7;
	}
	
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "       Icon";
		case 1:
			return "LeadId";
		case 2:
			return "VehicleId";
		case 3:
			return "Brand";
		case 4:
			return "SalePrice";
		case 5:
			return "InterestedPeople";
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
		Lead lead = leadMap.get(leadId);
		switch (columnIndex) {
		case 1:
			return leadId;
		case 2:
			return vehicle.getVehicleId();
		case 3:
			return vehicle.getBrand();
		case 4:
			return String.valueOf(vehicle.getPrice());
		case 5:
			return String.valueOf(vehicle.getPeopleExpressingInterestInThisCar());
		case 6:
			return (lead.getDealerComment() == null) ? null : "";
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
