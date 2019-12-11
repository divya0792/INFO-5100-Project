package m3.view;

import dataproto.Dealer;
import m3.model.Incentive;
import m3.model.IncentiveList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class IncentiveListUI {

	JFrame frame;
	JTable table = new JTable() {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	JButton create, delete, edit;
	IncentiveDetailUI sui;
	private Dealer d;

	public IncentiveList incentives;

	public IncentiveListUI(Dealer d) {
		this.d = d;
		start();
	}


	public void start() {

		frame = new JFrame();
		frame.setTitle("Incentive List");
		frame.setSize(450, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponent(panel);
		addListeners();
		frame.setVisible(true);
		incentives = new IncentiveList(d);
		refreshTableContents();

	}

    private void addListeners() {
    	create.addActionListener(e -> {
			frame.setEnabled(false);
			sui = new IncentiveDetailUI(this, -1, d);
			sui.start();
		});
    	  // need to store to an incentive object
    	edit.addActionListener(e -> editSelectedRow());
    	delete.addActionListener(e -> deleteSelectedRow());
	}

	private void placeComponent(JPanel panel) {
        panel.setLayout(null);
        create = new JButton("Create");
        create.setBounds(50, 25, 80, 25);
        panel.add(create);
        edit = new JButton("Edit");
        edit.setBounds(180, 25, 80, 25);
        panel.add(edit);
        delete = new JButton("Delete");
        delete.setBounds(310, 25, 80, 25);
        panel.add(delete);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(50, 65, 350, 400);
        panel.add(pane);
    }


    public void refreshTableContents() {
    	DefaultTableModel tableModel = new DefaultTableModel();
    	tableModel.addColumn("Title");
        tableModel.addColumn("Start Date");
        tableModel.addColumn("End Date");
        tableModel.addColumn("Disclaimer");

		for (Incentive i : incentives.getAllIncentives()) {
			tableModel.addRow(new String[]{i.getTitle(), i.getStartDate().toString(), i.getEndDate().toString(), i.getDisclaimer()});
		}

    	table.setModel(tableModel);
	}


    private void editSelectedRow() {
		try {
			int rowIndex = table.getSelectedRow();
			if (rowIndex == -1) {
				throw new Exception();
			}
			frame.setEnabled(false);
			sui = new IncentiveDetailUI(this, rowIndex, d);
			sui.start();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Please select a Row or No rows to Edit");
		}
	}

	private void deleteSelectedRow(){

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		try {
			int rowIndex = table.getSelectedRow();
			tableModel.removeRow(rowIndex);
			incentives.deleteFromDatabase(rowIndex);
			incentives.deleteIncentive(rowIndex);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Please select a Row or No rows to delete");
		}
    }

}
