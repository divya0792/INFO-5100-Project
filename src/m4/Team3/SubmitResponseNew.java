package FinalProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class SubmitResponseNew extends JFrame {

	public JFrame frame;
	private JTextField carBrandTextField, carTypeTextField, carYearTextField, carModelTextField, customerFirstNameTextField, customerLastNameTextField, customerEmailTextField, customerPhoneNumberTextField;
	private JTextArea customerQueryTextArea, dealerResponseTextArea ;
	private JLabel carInfoLabel, customerInfoLabel, customerQueryLabel, dealerResponseLabel, carBrand, carType, carYear, carModel, customerFirstName, customerLastName, customerEmailId, customerPhoneNo;
	private JButton submitButton, resetButton;
	private JPanel panel, panel_1;
	JTextArea textAreas[] = {customerQueryTextArea, dealerResponseTextArea};
	JPanel panels[] = {panel, panel_1};
	JTextField textFields[] = {carBrandTextField, carTypeTextField, carYearTextField, carModelTextField, customerFirstNameTextField, customerLastNameTextField, customerEmailTextField, customerPhoneNumberTextField};
	JLabel labels[] = {carInfoLabel, carBrand, carModel, carYear, carType, customerInfoLabel, customerFirstName, customerLastName, customerEmailId, customerPhoneNo, customerQueryLabel, dealerResponseLabel};
	String str[] = {"Car Information","Car Brand", "Car Model", "Car Year", "Car Type", "Customer Information", "First Name", "Last Name","Email ID", "Phone No", "Query from customer:", "Reply to customer:"};   

	public SubmitResponseNew() {
		initializeAndAddComponents();
		setLayout();
	}

	public void initializeAndAddComponents() {
		frame = new JFrame();
		frame.setBounds(70, 70, 782, 778);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font defaultFont = new Font("Tahoma", Font.PLAIN, 20);

		//initializing text areas
		for(int i = 0; i < textAreas.length; i++) {
			textAreas[i] = new JTextArea();
			textAreas[i].setFont(new Font("Monospaced", Font.PLAIN, 16));
			if(i == 0) {
				textAreas[i].setEditable(false);
				textAreas[i].setText("Hi, I'd like to ****");
			}
		}

		//initializing panels
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			panels[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			panels[i].setLayout(null);
		}

		//initializing text fields
		for (int i = 0; i < textFields.length; i++) {
			textFields[i] = new JTextField(10);
			if( i < 4) {
				if( i == 0) {
					textFields[i].setBounds(133, 53, 96, 20);
				} else if( i == 1) {
					textFields[i].setBounds(399, 53, 96, 20);
				} else if( i == 2) {
					textFields[i].setBounds(133, 81, 96, 20);
				} else if( i == 3) {
					textFields[i].setBounds(399, 81, 96, 20);
				} 
				panels[0].add(textFields[i]);
			} else {			
				if( i == 4) {
					textFields[i].setBounds(133, 52, 96, 20);
				} else if( i == 5) {
					textFields[i].setBounds(399, 52, 96, 20);
				} else if( i == 6) {
					textFields[i].setBounds(133, 83, 169, 20);
				}else {
					textFields[i].setBounds(133, 119, 169, 20);
				}
				panels[1].add(textFields[i]);
			}
		}

		//initializing labels
		for(int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(str[i]);
			if( i < 5) {
				if( i == 0) {
					labels[i].setFont(defaultFont);
					labels[i].setBounds(10, 11, 219, 20);
				} else if( i == 1) {
					labels[i].setBounds(25, 53, 69, 20);
				} else if( i == 2) {
					labels[i].setBounds(311, 81, 69, 20);
				}else if( i == 3){
					labels[i].setBounds(25, 81, 69, 20);
				}else {
					labels[i].setBounds(311, 52, 69, 20);
				}		
				panels[0].add(labels[i]);
			} else if( i > 4 & i < 10) {
				if( i == 5) {
					labels[i].setFont(defaultFont);
					labels[i].setBounds(15, 16, 242, 20);
				} else if( i == 6) {
					labels[i].setBounds(25, 52, 69, 20);
				} else if( i == 7) {
					labels[i].setBounds(311, 52, 69, 20);
				}else if( i == 8){
					labels[i].setBounds(25, 83, 69, 20);
				}else {
					labels[i].setBounds(25, 119, 69, 20);
				}					
				panels[1].add(labels[i]);
			}else {
				labels[i].setFont(defaultFont);
			}
		}

		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textAreas[1].getText().isEmpty()) {					
					JOptionPane.showMessageDialog(frame, "Response field is empty");
				}else {
					int result = JOptionPane.showConfirmDialog((Component) null, "are you sure you want to send response?",
							"alert", JOptionPane.OK_CANCEL_OPTION);
					if (result == 0) {
						JOptionPane.showMessageDialog(null, "Response has been sent to customer");
					}
				}
			}
		});
		

		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dealerResponseTextArea.setText("");
			}
		});

	}
	
	private void setLayout() {
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(130).addComponent(submitButton).addPreferredGap(ComponentPlacement.RELATED, 381, Short.MAX_VALUE).addComponent(resetButton)
						.addGap(103)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(textAreas[1], GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE).addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(labels[10], GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE).addContainerGap(469, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(16).addComponent(panels[0], GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE).addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addGap(16).addComponent(panels[1], GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE).addContainerGap()).addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addContainerGap().addComponent(labels[11], GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE).addContainerGap(491, Short.MAX_VALUE)).addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addContainerGap().addComponent(textAreas[0], GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(panels[0], GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE).addGap(33)
						.addComponent(panels[1], GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE).addGap(18).addComponent(labels[10]).addGap(18)
						.addComponent(textAreas[0], GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(32).addComponent(labels[11]).addGap(18)
						.addComponent(textAreas[1], GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE).addGap(29).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(resetButton).addComponent(submitButton)).addGap(87)));
		frame.getContentPane().setLayout(groupLayout);
	}

}