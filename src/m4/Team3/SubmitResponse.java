
import java.awt.Color;
import java.awt.EventQueue;
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

public class SubmitResponse {

	public JFrame frame;

	

	/**
	 * Create the application.
	 */
	public SubmitResponse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 782, 778);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea txtrHiIdLike = new JTextArea();
		txtrHiIdLike.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrHiIdLike.setForeground(Color.GRAY);
		txtrHiIdLike.setBackground(Color.WHITE);
		txtrHiIdLike.setEnabled(false);
		txtrHiIdLike.setEditable(false);
		txtrHiIdLike.setText("Hi, I'd like to ****");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ViewCar frame = new ViewCar(txtrHiIdLike.getText());
				//frame.setVisible(true);
				
				Confirm dialog = new Confirm();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(frame);
				dialog.setVisible(true);
			}
		});
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		
		JLabel lblCarInformation = new JLabel("Car Information");
		Font defaultFont = new Font("Tahoma", Font.PLAIN, 20);
		lblCarInformation.setFont(defaultFont);
		lblCarInformation.setBounds(15, 16, 219, 20);
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
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(130)
					.addComponent(btnSubmit)
					.addPreferredGap(ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
					.addComponent(btnReset)
					.addGap(103))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMessagesFromCustomer, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(478, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrHiIdLike, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblReplyToCustomer, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(456, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(lblMessagesFromCustomer)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtrHiIdLike, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
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
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(25, 52, 69, 20);
		panel_1.add(lblName);
		
		JLabel lblAilsa = new JLabel("Ailsa");
		Font font = new Font("Tahoma", Font.BOLD, 16);
		lblAilsa.setFont(font);
		lblAilsa.setBounds(123, 52, 69, 20);
		panel_1.add(lblAilsa);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(25, 88, 69, 20);
		panel_1.add(lblEmail);
		
		JLabel lblAilsagmailcom = new JLabel("info5100finaltestr@gmail.com");
		lblAilsagmailcom.setFont(font);
		lblAilsagmailcom.setBounds(123, 88, 288, 20);
		panel_1.add(lblAilsagmailcom);
		
		JLabel lblCarBand = new JLabel("Car Band");
		lblCarBand.setBounds(25, 53, 69, 20);
		panel.add(lblCarBand);
		
		JLabel lblBenz = new JLabel("Benz");
		lblBenz.setFont(font);
		lblBenz.setBounds(122, 53, 69, 20);
		panel.add(lblBenz);
		
		JLabel lblYears = new JLabel("Years");
		lblYears.setBounds(25, 81, 69, 20);
		panel.add(lblYears);
		
		JLabel label = new JLabel("2019");
		label.setFont(font);
		label.setBounds(122, 81, 69, 20);
		panel.add(label);
		frame.getContentPane().setLayout(groupLayout);
	}
}
