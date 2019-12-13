package m3.view;

import com.toedter.calendar.JDateChooser;
import dataproto.Dealer;
import m3.model.Incentive;
import m3.model.filter.*;
import m3.model.offer.CashBackOffer;
import m3.model.offer.DiscountOffer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncentiveDetailUI {

	JFrame frame;
	JTable table = new JTable();
	DefaultTableModel dm;
	JTextField titleText, disclaimerText, offerText;
	JComboBox offerChoice;
	JButton cancel, create, edit, delete, ok;
	JDateChooser startDateChooser, endDateChooser;
	IncentiveListUI fui;

	int rowIndex;
	JLabel offerLabel;

	FilterDetailUI filterUI;
	private Dealer dealer;
	private Incentive iw;

	private String[] row;
    private Set<String> filterSet;


	IncentiveDetailUI(IncentiveListUI fui, int rowIndex, Dealer dealer) {
		this.fui = fui;
		this.rowIndex = rowIndex;
		this.dealer = dealer;
        filterSet = new HashSet<>();
	}

	//public SecondUI(FirstUI firstUI, String title, String string2, String string3, String disclaimer) {

	//}

	public void start() {
		iw = new Incentive();
		frame = new JFrame();
		frame.setSize(450, 600);
		JPanel panel = new JPanel();
		frame.add(panel);

		placeComponent(panel);
		addListeners();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fui.frame.setEnabled(true);
            }
        });

		frame.setVisible(true);


	}


	public void placeComponent(JPanel panel) {

		Incentive i = rowIndex == -1 ? null : fui.incentives.getIncentiveByIndex(rowIndex);

		if (i != null) {
            iw = i;
            for (Filter f : iw.getConditions()) {
                filterSet.add(filterToString(f)[0]);
            }
        }

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
		if (i != null) {
			String st = i.getOffer().getClass().getSimpleName();
			if (st.equals("CashBackOffer")) {
				offerChoice.setSelectedItem("Cashback");
			} else {
				offerChoice.setSelectedItem("Discount");
			}

		}
		offerText = new JTextField();
		offerText.setBounds(285, 235, 115, 25);

		panel.add(offerText);

		if (i != null) {
			Double doub = i.getOffer().getValue();
			offerText.setText(doub.toString());
		}
		offerLabel = new JLabel();
		offerLabel.setBounds(150, 255, 300, 25);
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
		if (i != null) {
			List<m3.model.filter.Filter> list = i.getConditions();
			for (m3.model.filter.Filter f : list) {

				dm.addRow(filterToString(f));
			}
		}

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
//			filterUI.addWindowStateListener(l -> {
//				addToTableBelow(filterUI.toSecondUIFilter());
//				//filterList.add(filterUI.toSecondUIFilter());
//			});
		});


		edit.addActionListener(e -> {

			row = getRow();
            editFilterUI();
			filterUI.modifyFilter(row);
			filterUI.addWindowStateListener(l -> {

                modifyRow(filterUI.toSecondUIFilter());
                //addToTableBelow(filterUI.toSecondUIFilter());

			});
		});   // Third UI start function here


		delete.addActionListener(e -> deleteSelectedRow());

		//cancel.addActionListener(e -> frame.dispose());
		//cancel.addActionListener(e -> System.exit(0));


		cancel.addActionListener(e -> {
			frame.dispose();
			fui.frame.setEnabled(true);
            fui.refreshTableContents();
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
            try {
			iw.setTitle(titleText.getText());
			iw.setStartDate(startDateChooser.getDate());
			iw.setEndDate(endDateChooser.getDate());
			iw.setDisclaimer(disclaimerText.getText());
			iw.setDealerID(dealer.getId());


			String st = offerChoice.getSelectedItem().toString();
			if (st.equals("Discount")) {
				iw.setOffer(new DiscountOffer(Double.parseDouble(offerText.getText())));
			} else if (st.equals("Cashback")) {
				iw.setOffer(new CashBackOffer(Double.parseDouble(offerText.getText())));
			}
			iw.setDisclaimer(disclaimerText.getText());
                if (iw.getConditions().isEmpty() == true)
                    throw new java.lang.NullPointerException();

                if (iw.getOffer().getClass().equals(DiscountOffer.class) && (iw.getOffer().getValue() > 100 || iw.getOffer().getValue() < 0)) {
                    throw new java.lang.NumberFormatException();
                }


			if (rowIndex == -1) {
				fui.incentives.addIncentive(iw);
			}else {
				fui.incentives.deleteIncentive(rowIndex);
				fui.incentives.addIncentive(iw, rowIndex);
			}
			frame.dispose();
			fui.frame.setEnabled(true);
                fui.refreshTableContents();
            } catch (java.lang.NumberFormatException exce) {
                JOptionPane.showMessageDialog(null, "Please check your input, there's something wrong.");
            } catch (java.lang.NullPointerException NullExce) {
                JOptionPane.showMessageDialog(null, "Please check your input, there's something wrong.");
            }
		});


	}

	private void refreshFilterTable() {


	}


	public void addFiltertoIncentive(m3.model.filter.Filter f) {

        if (filterSet.contains(filterToString(f)[0])) {
            JOptionPane.showMessageDialog(null, "You can't add two same types of filters");
        } else {
            iw.addFilter(f);
            dm.addRow(filterToString(f));
            filterSet.add(filterToString(f)[0]);
        }
	}


	private void openFilterEditUI() {
		filterUI = new FilterDetailUI(this);
	}

    private void editFilterUI() {
        filterUI = new FilterDetailUI(this, 1);
    }

	private void createTable() {

		dm = (DefaultTableModel) table.getModel();
		dm.addColumn("Name");
		dm.addColumn("Type");
		dm.addColumn("Value");
	}


    public void modifyRow(Filter f) {
        dm = (DefaultTableModel) table.getModel();
        try {
            int rowIndex = table.getSelectedRow();
            iw.getConditions().set(rowIndex, f);
            dm.removeRow(rowIndex);
            dm.addRow(filterToString(f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a Row or No rows to delete");
        }
    }
	private void deleteSelectedRow() {
		dm = (DefaultTableModel) table.getModel();
		try {
			int rowIndex = table.getSelectedRow();
			dm.removeRow(rowIndex);
            iw.getConditions().remove(rowIndex);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please select a Row or No rows to delete");
		}
	}

	public String[] getRow() {
		dm = (DefaultTableModel) table.getModel();
		try {
			int rowIndex = table.getSelectedRow();
			//dm.removeRow(rowIndex);
			row = new String[]{(String) dm.getValueAt(rowIndex, 0), (String) dm.getValueAt(rowIndex, 1), (String) dm.getValueAt(rowIndex, 2)};

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please select a Row or No rows to delete");
		}
		return row;
	}

	public void addToTableBelow(m3.model.filter.Filter filter) {
        //dm.addRow(filterToString(filter));
		addFiltertoIncentive(filter);

	}

	private String[] filterToString(m3.model.filter.Filter filter) {
		switch (filter.getClass().getSimpleName()) {
			case ("BrandFilter"): {
				return new String[]{"Brand", ((BrandFilter) filter).checkerToString(), ((BrandFilter) filter).getValue()};
			}
			case ("ColorFilter"): {
				return new String[]{"Color", ((ColorFilter) filter).checkerToString(), ((ColorFilter) filter).getValue()};
			}
			case ("YearFilter"): {
				return new String[]{"Year", ((YearFilter) filter).checkerToString(), ((YearFilter) filter).getValue().toString()};
			}
			case ("VehicleIDsFilter"): {
				return new String[]{"VehicleIDs", ((VehicleIDsFilter) filter).checkerToString(), ((VehicleIDsFilter) filter).getStringfromList()};
			}
			case ("ModelFilter"): {
				return new String[]{"Model", ((ModelFilter) filter).checkerToString(), ((ModelFilter) filter).getValue()};
			}
            case ("PriceFilter"): {
                return new String[]{"Price", ((PriceFilter) filter).checkerToString(), ((PriceFilter) filter).getValue().toString()};
            }
			default:
				throw new IllegalArgumentException("Unexpected value: " + filter.getClass());
		}
	}
}
