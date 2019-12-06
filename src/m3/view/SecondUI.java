package m3.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.imageio.spi.ServiceRegistry.Filter;
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
import m3.model.filter.BrandFilter;
import m3.model.filter.ColorFilter;
import m3.model.offer.CashBackOffer;
import m3.model.offer.DiscountOffer;

public class SecondUI {
	
	JFrame frame;
	JTable table = new JTable();
	DefaultTableModel dm;
	JTextField titleText, disclaimerText,offerText;
	JComboBox offerChoice;
	JButton cancel,create,edit,delete,ok;
	JDateChooser startDateChooser,endDateChooser;
	FirstUI fui;

	int rowIndex;
	JLabel offerLabel;

	FilterEditUI filterUI;

	
	SecondUI(FirstUI fui, int rowIndex){
		this.fui = fui;
		this.rowIndex = rowIndex;
	}
	
	//public SecondUI(FirstUI firstUI, String title, String string2, String string3, String disclaimer) {
		
	//}

	public void start(){
        frame = new JFrame();
        frame.setSize(450, 600);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponent(panel);
        //addListeners();
        frame.setVisible(true);
    }


	public void placeComponent(JPanel panel){
		Incentive i = rowIndex == -1 ? null : IncentiveList.getIncentiveByIndex(rowIndex);
        panel.setLayout(null);
        JLabel title = new JLabel("Title");
        title.setBounds(50, 25, 200, 25);
        panel.add(title);
        titleText = new JTextField();
        String s = i == null ? "" : i.getTitle(); 
        titleText.setText(s);
        titleText.setBounds(150, 25, 250, 25);
        panel.add(titleText);
        panel.setLayout(null);
        JLabel startDate = new JLabel("Start Date");
        startDate.setBounds(50, 65, 200, 25);
        panel.add(startDate);  
        startDateChooser = new JDateChooser();
        Date d = i == null ? null : i.getStartDate();
        startDateChooser.setDate(d);
        startDateChooser.setBounds(150, 65, 250, 25);
        panel.add(startDateChooser);
        
        JLabel endDate = new JLabel("End Date");
        endDate.setBounds(50, 105, 200, 25);
        panel.add(endDate);
        
        endDateChooser = new JDateChooser();
        d = i == null ? null : i.getEndDate();
        endDateChooser.setDate(d);
        
        endDateChooser.setBounds(150, 105, 250, 25);
        panel.add(endDateChooser);
        JLabel disclaimer = new JLabel("Disclaimer");
        disclaimer.setBounds(50, 145, 200, 25);
        panel.add(disclaimer);
        disclaimerText = new JTextField();
        s = i == null ? "" : i.getDisclaimer();
        disclaimerText.setText(s);
        disclaimerText.setBounds(150, 145, 250, 75);
        panel.add(disclaimerText);
        JLabel offer = new JLabel("Offer");
        offer.setBounds(50, 235, 200, 25);
        panel.add(offer);
        offerChoice = new JComboBox();
        offerChoice.setBounds(150, 235, 115, 25);
        offerChoice.addItem("Discount");
        offerChoice.addItem("Cashback");
        panel.add(offerChoice);
        offerText = new JTextField();
        offerText.setBounds(285, 235, 115, 25);
        panel.add(offerText);
        offerLabel = new JLabel();
        offerLabel.setBounds(150,255,300,25);
        panel.add(offerLabel);
        
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
		create.addActionListener(e -> {
		openFilterEditUI();
		filterUI.addWindowStateListener(l -> {addToTableBelow(filterUI.toSecondUIFilter());});

		//addToTableBelow(filterUI.toSecondUIFilter())
		}
				);
		
		  // Third UI start function here
        
		
    	// edit.addActionListener(e -> );   // Third UI start function here
        
        
    	delete.addActionListener(e -> deleteSelectedRow());
    	
    	
    	cancel.addActionListener(e -> {
    		frame.dispose();
    		fui.frame.setEnabled(true);
    	});
    	
    	
    	offerChoice.addActionListener(e -> {
    		String st = offerChoice.getSelectedItem().toString();
	    	if(st.equals("Discount")){
	    		offerLabel.setText("Enter percentage of discount and press Enter");
	    	}else if(st.equals("Cashback")) {
	    		offerLabel.setText("Enter amount of cashback in $ and press Enter");
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
    		Incentive iw = new Incentive();
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

    		if(rowIndex == -1){
    			IncentiveList.addIncentive(iw);
    		}else{
    			IncentiveList.deleteIncentive(rowIndex);
    			IncentiveList.addIncentive(iw, rowIndex);
    		}
    		frame.dispose();
    		fui.frame.setEnabled(true);
    		fui.refreshTableContents();
    	});
        
        
    }
	

	private void createTable(){

    		fui.addToTable(iw);
    		//frame.setVisible(false);
    	});		
	}
	
	private void openFilterEditUI() {
		filterUI = new FilterEditUI(this);
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
    
    public void addToTableBelow(m3.model.filter.Filter filter) {
		dm.addRow(filterToString(filter));

	}
    
    private String[] filterToString(m3.model.filter.Filter filter) {
    	switch (filter.getClass().getSimpleName()) {
		case ("BrandFilter"):
		{	
			return new String[] {"Brand",((BrandFilter)filter).checkerToString(),((BrandFilter)filter).getValue()};
			}
		case("ColorFilter"):{
			return new String[] {"Color", ((ColorFilter)filter).checkerToString(),((ColorFilter)filter).getValue()};
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + filter.getClass());
		}
    }
}
