package m4.Team4;


import m4.Team4.Vehicle.Category;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleManageFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Map<String, Vehicle> vehiclesMap = new HashMap<String, Vehicle>();
	private Map<String, Lead> leadMap;
	private Font font;
	private JFrame jFrame;
	private JLabel jLable;
	private JLabel iconLable;
	private JTable vehiclesTable;
	private VehicleInformationSystem model;
	private JScrollPane jscrollPane;
	private LeadSearchImp leadManager;
	private JLabel jNameLable;
	private JLabel jPhoneNumLable;
	private JLabel jLeadNumLable;
	private Vehicle vehicle;

	public VehicleManageFrame(String phoneNumber) {
		font = new Font("PLAIN", Font.PLAIN, 20);
		create(phoneNumber);
		create();
		addListeners();
		makeItVisible();
	}

	public void create(String phoneNumber) {
		leadManager = new LeadSearchImp();
		leadManager.getLead(phoneNumber);
		leadMap = new HashMap<String, Lead>();
		leadMap = leadManager.getLeadMap();
		List<String> leadId = new ArrayList<String>(leadMap.keySet());
		feakDate();

		try {
			vehiclesMap = new HashMap<String, Vehicle>();
			for (String l : leadId) {
				vehiclesMap.put(l, vehicle);
			}
			model = new VehicleInformationSystem(vehiclesMap);
		} catch (Exception e) {
		}
		vehiclesTable = new JTable(model);

		jNameLable = new JLabel("Name: " + leadMap.get(leadId.get(0)).getFirstName() + " " + leadMap.get(leadId.get(0)).getLastName());
		jNameLable.setBounds(300, 30, 350, 50);
		jNameLable.setFont(font);

		jPhoneNumLable = new JLabel("Phone Number: " + leadMap.get(leadId.get(0)).getContactNo());
		jPhoneNumLable.setBounds(300, 80, 350, 50);
		jPhoneNumLable.setFont(font);

		jLeadNumLable = new JLabel("Numbers of Lead: " + leadMap.size());
		jLeadNumLable.setBounds(300, 130, 350, 50);
		jLeadNumLable.setFont(font);

	}

	private void create() {
		jFrame = new JFrame("Interested Vehicles");
		jLable = new JLabel();

		ImageIcon background = new ImageIcon(VehicleManageFrame.class.getResource("user.PNG"));
		iconLable = new JLabel(background);
		iconLable.setBounds(60, 10, background.getIconWidth(), background.getIconHeight());

		vehiclesTable.getColumnModel().getColumn(0).setCellRenderer(new MyRender(0));
		vehiclesTable.getColumnModel().getColumn(10).setCellRenderer(new MyRender(12));

		vehiclesTable.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int r = vehiclesTable.getSelectedRow();
				int c = vehiclesTable.getSelectedColumn();
				Component leadId = vehiclesTable.getComponentAt(r, c);
				Object value = vehiclesTable.getValueAt(r, c);
				DetailInfo frame = new DetailInfo(value.toString(), leadMap.get(value.toString()));

			}

		});

		jscrollPane = new JScrollPane(vehiclesTable);
		jscrollPane.setBounds(0, 220, 800, 350);
		jLable.add(iconLable);
		jLable.add(jscrollPane);
		jLable.add(jNameLable);
		jLable.add(jPhoneNumLable);
		jLable.add(jLeadNumLable);

		jFrame.add(jLable);

	}

	public void add(Container con) {
		BorderLayout b = new BorderLayout();
		con.setLayout(b);
		con.add(new JScrollPane(vehiclesTable), "South");
		con.add(jLable);
	}

	public void feakDate() {
		vehicle = new Vehicle();
		vehicle.setVehicleId("011");
		vehicle.setDealerId("001");
		vehicle.setBrand("Honda");
		vehicle.setModel("Accord");
		vehicle.setYear(2019);
		vehicle.setType("SUV");
		vehicle.setCategory(Category.NEW);
		vehicle.setColor("Black");
		vehicle.setPrice(20000.0f);
		vehicle.setMileage(100.0f);
		vehicle.setSalePrice(18000.0f);
		vehicle.setPeopleExpressingInterestInThisCar(10);
	}

	public void addListeners() {

	}

	public void makeItVisible() {
		jFrame.setSize(800, 600);
		jFrame.setVisible(true);
	}

	class MyRender extends AbstractCellEditor implements TableCellRenderer, ActionListener, TableCellEditor {

		private JLabel iconLable;

		public MyRender(int index) {
			ImageIcon background;
			if (index == 0)
				background = new ImageIcon(VehicleManageFrame.class.getResource("car.PNG"));
			else
				background = new ImageIcon(VehicleManageFrame.class.getResource("comment.PNG"));
			iconLable = new JLabel(background);
			iconLable.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			return iconLable;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return iconLable;
		}
	}

	public static void main(String[] args) {
		VehicleManageFrame vmf = new VehicleManageFrame("206-890-5085");
	}

}
