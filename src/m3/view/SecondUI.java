package m3.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import m3.model.Incentive;
import m3.model.offer.CashBackOffer;
import m3.model.offer.DiscountOffer;

public class SecondUI {
	
	JFrame frame = new JFrame();
	JTable table = new JTable();
	DefaultTableModel dm;
	JTextField titleText, disclaimerText,offerText;
	JComboBox offerChoice;
	JButton cancel,create,edit,delete,ok;
	JDateChooser startDateChooser,endDateChooser;	
	Incentive iw = new Incentive();
	FirstUI fui;
	
	SecondUI(FirstUI fui){
		this.fui = fui;
	}
	
	public void start(){
        JFrame frame = new JFrame();
        frame.setSize(450, 600);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponent(panel);
        addListeners();
        frame.setVisible(true);
    }


	public void placeComponent(JPanel panel){
        panel.setLayout(null);
        JLabel title = new JLabel("Title");
        title.setBounds(50, 25, 200, 25);
        panel.add(title);
        titleText = new JTextField();
        titleText.setBounds(150, 25, 250, 25);
        panel.add(titleText);
        panel.setLayout(null);
        JLabel startDate = new JLabel("Start Date");
        startDate.setBounds(50, 65, 200, 25);
        panel.add(startDate);   
        startDateChooser = new JDateChooser();
        startDateChooser.setBounds(150, 65, 250, 25);
        panel.add(startDateChooser);
        
        JLabel endDate = new JLabel("End Date");
        endDate.setBounds(50, 105, 200, 25);
        panel.add(endDate);
        
        endDateChooser = new JDateChooser();
        endDateChooser.setSelectableDateRange(startDateChooser.getDate(), null);
        endDateChooser.setBounds(150, 105, 250, 25);
        panel.add(endDateChooser);
        JLabel disclaimer = new JLabel("Disclaimer");
        disclaimer.setBounds(50, 145, 200, 25);
        panel.add(disclaimer);
        disclaimerText = new JTextField();
        disclaimerText.setBounds(150, 145, 250, 75);
        panel.add(disclaimerText);
        JLabel offer = new JLabel("Offer");
        offer.setBounds(50, 235, 200, 25);
        panel.add(offer);
        offerChoice = new JComboBox();
        offerChoice.setBounds(150, 235, 115, 25);
        offerChoice.addItem("");
        offerChoice.addItem("Discount");
        offerChoice.addItem("Cashback");
        panel.add(offerChoice);
        offerText = new JTextField();
        offerText.setBounds(285, 235, 115, 25);
        panel.add(offerText);
        JLabel conditions = new JLabel("Conditions");
        conditions.setBounds(50, 295, 200, 25);
        panel.add(conditions);
        create = new JButton("Create");
        create.setBounds(150, 295, 80, 25);
        panel.add(create);
        edit = new JButton("Edit");
        edit.setBounds(235, 295, 80, 25);
        panel.add(edit);
        delete = new JButton("Delete");
        delete.setBounds(320, 295, 80, 25);
        panel.add(delete);
        createTable();
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(50, 350, 350, 150);
        panel.add(pane);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(90, 520, 120, 25);
        panel.add(cancel);
        ok = new JButton("OK");
        ok.setBounds(240, 520, 120, 25);
        panel.add(ok);
        
        
    }
    
	private void addListeners() {
		create.addActionListener(e -> {addToTableBelow();
		openFilterEditUI();
		} );   // Third UI start function here
        
		
        
    	// edit.addActionListener(e -> );   // Third UI start function here
        
        
    	delete.addActionListener(e -> deleteSelectedRow());
    	
    	
    	cancel.addActionListener(e -> System.exit(0));
    	
    	offerChoice.addActionListener(e -> {
    		String st = offerChoice.getSelectedItem().toString();
	    	if(st.equals("Discount")){
	    		JOptionPane.showMessageDialog(null, "Enter percentage of discount and press Enter");
	    	}else if(st.equals("Cashback")) {
	    		JOptionPane.showMessageDialog(null, "Enter amount of cashback in $ and press Enter");
	    	}
    	});
    	
    	offerText.addKeyListener(
    			new KeyListener(){
					@Override
					public void keyPressed(KeyEvent e) {
						String st = offerChoice.getSelectedItem().toString();
						String offerValue = offerText.getText();
						if(e.getKeyCode() == KeyEvent.VK_ENTER && st.equals("Cashback")){
							char[] offerArray = offerValue.toCharArray();
							for(char c : offerArray){
								if(Character.isAlphabetic(c)){
									offerText.setText("");
									JOptionPane.showMessageDialog(null, "Enter a valid Cashback");
								}
							}
						}
						if(e.getKeyCode() == KeyEvent.VK_ENTER && st.equals("Discount")){
							if(Integer.parseInt(offerValue) < 0 || Integer.parseInt(offerValue) > 100){
								offerText.setText("");
								JOptionPane.showMessageDialog(null, "Enter a Discount value between 1 & 100!");
							}
						}
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
    			}
    			); 
    	
    	ok.addActionListener(e -> {
    		iw.setTitle(titleText.getText());
    		iw.setStartDate(startDateChooser.getDate());
    		iw.setEndDate(endDateChooser.getDate());
    		iw.setDisclaimer(disclaimerText.getText());
    		String st = offerChoice.getSelectedItem().toString();
    		if(st.equals("Discount")){
    			iw.setOffer(new DiscountOffer(Double.parseDouble(offerText.getText())));
    		}else if(st.equals("Cashback")){
    			iw.setOffer(new CashBackOffer(Double.parseDouble(offerText.getText())));
    		}
    		iw.setDisclaimer(disclaimerText.getText());
    		fui.addToTable(iw);
    		//frame.setVisible(false);
    	});		
	}
	
	private void openFilterEditUI() {
		FilterEditUI filterUI = new FilterEditUI();
	}
    
    private void createTable(){
		dm = (DefaultTableModel) table.getModel();
		dm.addColumn("Name");
		dm.addColumn("Type");
		dm.addColumn("Value");       
	}
    
    
	
    
    private void deleteSelectedRow(){
    	dm = (DefaultTableModel) table.getModel();
		try{
			int rowIndex = table.getSelectedRow();
			dm.removeRow(rowIndex);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Please select a Row or No rows to delete");
		}
    }
    
    private void addToTableBelow() {
		String[] s1 = { "Brand", "Hyundai", "500"};
		String[] s2 = {"Colour", "Red", "40"};
		String[] s3 = {"Price", "Nissan", "3000"};
		dm.addRow(s1);
		dm.addRow(s2);
		dm.addRow(s3);
	}
}
