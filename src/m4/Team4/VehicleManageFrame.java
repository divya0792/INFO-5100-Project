package m4.Team4;

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
	private JLabel jNameLable;
	private JLabel jPhoneNumLable;
	private JLabel jLeadNumLable;
	private Vehicle vehicle;

	public VehicleManageFrame(Map<String, Lead> leadMap) {
		font = new Font("PLAIN", Font.PLAIN, 20);
		create(leadMap);
		create();
		addListeners();
		makeItVisible();
	}

	public void create(Map<String, Lead> leadMap) {
		this.leadMap = leadMap;
		List<String> leadId = new ArrayList<String>(leadMap.keySet());
		VehicleSearchImp vehicleManager = new VehicleSearchImp();
		
		try {
			vehiclesMap = new HashMap<String, Vehicle>();
			for (String l : leadId) {						
				vehicleManager.getVehicle(leadMap.get(l).getVehicleId());
				if (vehicleManager.getVehicle() == null)
					continue;				
				vehiclesMap.put(l, vehicleManager.getVehicle());
			}
			model = new VehicleInformationSystem(leadMap, vehiclesMap);
		} catch (Exception e) {
		}
		vehiclesTable = new JTable(model);

		jNameLable = new JLabel("Name: " + leadMap.get(leadId.get(0)).getFirstName() + " " + leadMap.get(leadId.get(0)).getLastName());
		jNameLable.setBounds(250, 30, 350, 50);
		jNameLable.setFont(font);

		jPhoneNumLable = new JLabel("Phone Number: " + leadMap.get(leadId.get(0)).getContactNo());
		jPhoneNumLable.setBounds(250, 80, 350, 50);
		jPhoneNumLable.setFont(font);

		jLeadNumLable = new JLabel("Numbers of Lead: " + leadMap.size());
		jLeadNumLable.setBounds(250, 130, 350, 50);
		jLeadNumLable.setFont(font);

	}

	private void create() {
		jFrame = new JFrame("Interested Vehicles");
		jLable = new JLabel();

		ImageIcon background = new ImageIcon(VehicleManageFrame.class.getResource("user.PNG"));
		iconLable = new JLabel(background);
		iconLable.setBounds(30, 10, background.getIconWidth(), background.getIconHeight());

		vehiclesTable.getColumnModel().getColumn(0).setCellRenderer(new MyRender(0));
		
		vehiclesTable.getColumnModel().getColumn(6).setCellRenderer(new MyRender(6));
		
		

		vehiclesTable.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int r = vehiclesTable.getSelectedRow();
				Object value = vehiclesTable.getValueAt(r, 1);				
				LeadInformation frame = new LeadInformation(leadMap.get(value.toString()), vehiclesMap.get(value.toString()));
			}

		});

		jscrollPane = new JScrollPane(vehiclesTable);
		jscrollPane.setBounds(5, 220, 595, 350);
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

	public void addListeners() {

	}

	public void makeItVisible() {
		jFrame.setSize(600, 600);
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
			Object object = vehiclesTable.getValueAt(row, column);
			if ( object == null) {
				return null;
			}
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

}
