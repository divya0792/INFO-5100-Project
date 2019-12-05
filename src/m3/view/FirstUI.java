package m3.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import m3.model.Incentive;


public class FirstUI {
	
	JTable table = new JTable();
	DefaultTableModel tableModel;
	JButton create,delete,edit;
	SecondUI sui ;
	
	public FirstUI(){
		 
	}
	
	    public void start(){
	        JFrame frame = new JFrame();
	        frame.setTitle("Incentive List");
	        frame.setSize(450, 500);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JPanel panel = new JPanel();
	        frame.add(panel);
	        placeComponent(panel);
	        addListeners();
	        frame.setVisible(true);
	    }

	    private void addListeners() {
	    	create.addActionListener(e -> {
	    		sui= new SecondUI(this);
	        	sui.start();
	        	//addToTable(iw);
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
	        
	        
	        createIncentiveTable();
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(50, 65, 350, 400);
	        panel.add(pane);
	    
	    }
	    
	    
	    public void addToTable(Incentive iw) {
    		tableModel = (DefaultTableModel) table.getModel();   		
			String[] s = {iw.getTitle(),iw.getStartDate().toString(),iw.getEndDate().toString(),iw.getDisclaimer()};
			tableModel.addRow(s);   		
		}

		private void createIncentiveTable() {
	        tableModel = (DefaultTableModel) table.getModel();
	        tableModel.addColumn("Title");
	        tableModel.addColumn("Start Date");
	        tableModel.addColumn("End Date");
	        tableModel.addColumn("Disclaimer");
		}
	    
	    
	    	
	    private void editSelectedRow() {
	    	tableModel = (DefaultTableModel) table.getModel();
			try{
				int rowIndex = table.getSelectedRow();     // need to update the existing row
				sui.start();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Please select a Row or No rows to delete");
			}
		}

		private void deleteSelectedRow(){
	    	tableModel = (DefaultTableModel) table.getModel();
			try{
				int rowIndex = table.getSelectedRow();
				tableModel.removeRow(rowIndex);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Please select a Row or No rows to delete");
			}
	    }

}
