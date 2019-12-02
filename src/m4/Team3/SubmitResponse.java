package FinalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class SubmitResponse {

	public JFrame frame;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;

	

	/**
	 * Create the application.
	 */
	public SubmitResponse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(70, 70, 782, 778);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea txtrHiIdLike = new JTextArea();
		txtrHiIdLike.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrHiIdLike.setForeground(Color.GRAY);
		txtrHiIdLike.setBackground(Color.WHITE);
		txtrHiIdLike.setEnabled(false);
		txtrHiIdLike.setEditable(false);
		txtrHiIdLike.setText("Hi, I'd like to ****");
		

		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		
		JLabel lblCarInformation = new JLabel("Car Information");
		Font defaultFont = new Font("Tahoma", Font.PLAIN, 20);
		lblCarInformation.setFont(defaultFont);
		lblCarInformation.setBounds(10, 11, 219, 20);
		panel.add(lblCarInformation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		JLabel lblCustomerInformation = new JLabel("Customer Information");
		lblCustomerInformation.setFont(defaultFont);
		lblCustomerInformation.setBounds(15, 16, 242, 20);
		panel_1.add(lblCustomerInformation);
		
		JLabel lblMessagesFromCustomer = new JLabel("Messages from customer:");
		lblMessagesFromCustomer.setFont(defaultFont);
		
		JLabel lblReplyToCustomer = new JLabel("Reply to customer:");
		lblReplyToCustomer.setFont(defaultFont);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("");
			}
		});
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ViewCar frame = new ViewCar(txtrHiIdLike.getText());
				//frame.setVisible(true);
				if(textArea_1.getText().isEmpty()) {
					PopUp popup = new PopUp();
					popup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					popup.setLocationRelativeTo(frame);
					popup.setVisible(true);
				}else {
				ConfirmNew dialog = new ConfirmNew();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(frame);
				dialog.setVisible(true);
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(130)
					.addComponent(btnSubmit)
					.addPreferredGap(ComponentPlacement.RELATED, 381, Short.MAX_VALUE)
					.addComponent(btnReset)
					.addGap(103))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblReplyToCustomer, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(469, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMessagesFromCustomer, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(491, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrHiIdLike, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblMessagesFromCustomer)
					.addGap(18)
					.addComponent(txtrHiIdLike, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblReplyToCustomer)
					.addGap(18)
					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReset)
						.addComponent(btnSubmit))
					.addGap(87))
		);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(25, 52, 69, 20);
		panel_1.add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(25, 83, 69, 20);
		panel_1.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(25, 119, 69, 20);
		panel_1.add(lblPhone);
		
		JLabel lblSecondName = new JLabel("Last Name");
		lblSecondName.setBounds(311, 52, 69, 20);
		panel_1.add(lblSecondName);
		
		textField_16 = new JTextField();
		textField_16.setBounds(133, 52, 96, 20);
		panel_1.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(399, 52, 96, 20);
		panel_1.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(133, 83, 169, 20);
		panel_1.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(133, 119, 169, 20);
		panel_1.add(textField_19);
		textField_19.setColumns(10);

		JLabel lblCarBand = new JLabel("Car Brand");
		lblCarBand.setBounds(25, 53, 69, 20);
		panel.add(lblCarBand);
		
		JLabel lblYears = new JLabel("Year");
		lblYears.setBounds(25, 81, 69, 20);
		panel.add(lblYears);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(311, 81, 69, 20);
		panel.add(lblModel);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(311, 52, 69, 20);
		panel.add(lblType);
		
		textField_12 = new JTextField();
		textField_12.setBounds(133, 53, 96, 20);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(399, 53, 96, 20);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(133, 81, 96, 20);
		panel.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(399, 81, 96, 20);
		panel.add(textField_15);
		textField_15.setColumns(10);
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
