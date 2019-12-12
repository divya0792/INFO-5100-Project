package m4.Team1;

import m4.Team1.controller.RequestFormController;
import m4.Team1.database.dao.DealerTableDao;
import m4.Team1.database.dao.CustomerRequestTableDao;
import m4.Team1.database.dao.VehicleTableDao;
import m4.Team1.database.model.CustomerInfo;
import m4.Team1.database.model.DealerDetails;
import m4.Team1.database.model.VehicleDetails;
import m4.Team1.database.utils.Constants;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Optional;

public class RequestForm extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String BLUE_CODE = "#CDE7FB";
	private static final String BLACK_CODE = "#000000";
	private static final String RED_CODE = "#F08080";

	private JLabel firstNameLabel, lastNameLabel, emailLabel, phoneNumLabel, carsDetailLabel, messageLabel,
			dealerInfoLabel, interestedPeopleLabel;
	private JTextField firstNameField, lastNameField, emailField, phoneNumField;
	private JButton submitButton;
	private JTextArea messageArea, dealerDetailsField, carDetailsField;

	private RequestFormController requestFormController;
	private VehicleDetails carDetails;
	private DealerDetails dealerDetails;
	private int interestedPeopleCount;

	private RequestForm(RequestFormController requestFormController, VehicleDetails carDetails,
			DealerDetails dealerDetails, int interestedPeopleCount) {

		this.requestFormController = requestFormController;
		this.carDetails = carDetails;
		this.dealerDetails = dealerDetails;
		this.interestedPeopleCount = interestedPeopleCount;
		InitializeUI();
	}

	private void InitializeUI() {
		createUI();
		addPanel();
		addActionListener();
	}

	private void createUI() {
		firstNameLabel = createJLabel("First Name  ", BLACK_CODE);
		lastNameLabel = createJLabel("   Last Name   ", BLACK_CODE);
		emailLabel = createJLabel("     Email       ", BLACK_CODE);
		phoneNumLabel = createJLabel("Phone Number", BLACK_CODE);
		carsDetailLabel = createJLabel(
				"Car Detail                                                                                       ",
				BLACK_CODE);
		dealerInfoLabel = createJLabel(
				"Dealer Information                                                                           ",
				BLACK_CODE);
		messageLabel = createJLabel("Write any message to the dealer in below box                               ",
				BLACK_CODE);
		interestedPeopleLabel = createJLabel(String
				.format("%d people interested in this Car                                     ", interestedPeopleCount),
				RED_CODE);

		carDetailsField = new JTextArea(3, 36);
		carDetailsField.setText(carDetails.getDetails());
		carDetailsField.setEditable(false);

		dealerDetailsField = new JTextArea(3, 36);
		dealerDetailsField.setText(dealerDetails.getDetails());
		dealerDetailsField.setEditable(false);

		firstNameField = new JTextField(10);
		lastNameField = new JTextField(10);
		emailField = new JTextField(10);
		phoneNumField = new JTextField(10);

		messageArea = new JTextArea(6, 36);

		submitButton = new JButton("Submit");
		submitButton.setAlignmentX(RIGHT_ALIGNMENT);

	}

	private void addPanel() {
		Container con = getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.setBackground(Color.decode(BLUE_CODE));

		addInformationPanel(con);
		addCarDealerPanel(con);
		addMessagePanel(con);
		addSubmitPanel(con);
	}

	private void addInformationPanel(Container con) {
		JPanel customerInfoPanel = new JPanel();
		customerInfoPanel.setLayout(new BoxLayout(customerInfoPanel, BoxLayout.Y_AXIS));
		setBackGround(customerInfoPanel);

		JPanel phoneEmailPanel = new JPanel();
		addPanel(phoneEmailPanel, phoneNumLabel, phoneNumField, emailLabel, emailField);
		setBackGround(phoneEmailPanel);
		customerInfoPanel.add(phoneEmailPanel);

		JPanel customerNamePanel = new JPanel();
		setBackGround(customerNamePanel);
		addPanel(customerNamePanel, firstNameLabel, firstNameField, lastNameLabel, lastNameField);
		customerInfoPanel.add(customerNamePanel);

		con.add(customerInfoPanel);
		con.add(Box.createVerticalGlue());
	}

	/**
	 * Function to add car and dealer panel
	 *
	 * @param con
	 */
	private void addCarDealerPanel(Container con) {
		JPanel informationPanel = new JPanel();
		informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));
		setBackGround(informationPanel);

		JPanel carDetailsTitle = new JPanel();
		addPanel(carDetailsTitle, carsDetailLabel);
		informationPanel.add(carDetailsTitle);

		JPanel carDetailsFieldPanel = new JPanel();
		addPanel(carDetailsFieldPanel, carDetailsField);
		informationPanel.add(carDetailsFieldPanel);

		JPanel dealerInfoLabelPanel = new JPanel();
		addPanel(dealerInfoLabelPanel, dealerInfoLabel);
		informationPanel.add(dealerInfoLabelPanel);

		JPanel dealerDetailsFieldPanel = new JPanel();
		addPanel(dealerDetailsFieldPanel, dealerDetailsField);
		informationPanel.add(dealerDetailsFieldPanel);

		con.add(informationPanel);
		con.add(Box.createVerticalGlue());
	}

	private void addMessagePanel(Container con) {
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
		setBackGround(messagePanel);

		JPanel messageLabelPanel = new JPanel();
		setBackGround(messageLabelPanel);
		messageLabelPanel.add(messageLabel);
		messagePanel.add(messageLabelPanel);

		JPanel messageAreaPanel = new JPanel();
		setBackGround(messageAreaPanel);
		messageAreaPanel.add(messageArea);
		messagePanel.add(messageAreaPanel);

		con.add(messagePanel);
		con.add(Box.createVerticalGlue());
	}

	/**
	 * Function to add Submit button Panel
	 *
	 * @param con
	 */
	private void addSubmitPanel(Container con) {
		addPanel(con, interestedPeopleLabel, submitButton);
	}

	private void addPanel(JPanel panel, Component a) {
		setBackGround(panel);
		panel.add(a);
	}

	private void addPanel(Container con, Component a, Component b) {
		JPanel panel = new JPanel();
		setBackGround(panel);
		panel.add(a);
		panel.add(b);
		con.add(panel);
	}

	private void addPanel(JPanel panel, Component a, Component b, Component c, Component d) {
		panel.add(a);
		panel.add(b);
		panel.add(c);
		panel.add(d);
	}

	private JLabel createJLabel(String text, String colorCode) {
		JLabel label = new JLabel(text);
		label.setForeground(Color.decode(colorCode));
		label.setFont(new Font("Aerial", Font.BOLD, 12));
		label.setHorizontalTextPosition(JLabel.LEFT);
		return label;
	}

	private void setBackGround(JPanel panel) {
		panel.setBackground(Color.decode(BLUE_CODE));
	}

	public void addActionListener() {

		submitButton.addActionListener((ActionEvent ae) -> {
			writeToTable();
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		});

		phoneNumField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				searchAndFillCustomerInfo();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchAndFillCustomerInfo();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				searchAndFillCustomerInfo();
			}
		});

	}

	private void searchAndFillCustomerInfo() {
		String phoneNumber = checkContactNo(phoneNumField.getText());
		Optional<CustomerInfo> customerInfo = requestFormController.getCustomerInfo(phoneNumber);
		if (customerInfo.isPresent()) {
			emailField.setText(customerInfo.get().getEmail());
			firstNameField.setText(customerInfo.get().getFirstName());
			lastNameField.setText(customerInfo.get().getLastName());
		}
	}

	private String checkContactNo(String contactNum) {
		String phoneNumber = "";
		for (int i = 0; i < contactNum.length(); i++) {
			char c = contactNum.charAt(i);
			if (c >= '0' && c <= '9')
				phoneNumber += c;
		}
		if (phoneNumber.length() > 10) {
			JOptionPane.showMessageDialog(this, "Invalid Phone Number!!! Enter ten digits number");
			return null;
		} else {
			return phoneNumber;
		}
	}

	public VehicleDetails getCarDetails() {
		return carDetails;
	}

	public DealerDetails getDealerDetails() {
		return dealerDetails;
	}

	public JTextField getFirstNameField() {
		return firstNameField;
	}

	public JTextField getLastNameField() {
		return lastNameField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public JTextField getPhoneNumField() {
		return phoneNumField;
	}

	public JTextArea getMessageArea() {
		return messageArea;
	}

	private void writeToTable() {
		requestFormController.writeCustomerRequest(this);
		requestFormController.updateInterestedPeopleCount();
	}

	public static class RequestFormBuilder {
		private VehicleDetails carDetails;
		private DealerDetails dealerDetails;
		private int interestedPeopleCount;
		private RequestFormController requestFormController;

		public RequestFormBuilder withCarDetails(VehicleDetails carDetails) {
			this.carDetails = carDetails;
			return this;
		}

		public RequestFormBuilder withDealerDetails(DealerDetails dealerDetails) {
			this.dealerDetails = dealerDetails;
			return this;
		}

		public RequestFormBuilder withInterestedPeopleCount(int interestedPeopleCount) {
			this.interestedPeopleCount = interestedPeopleCount;
			return this;
		}

		public RequestFormBuilder withRequestFormController(RequestFormController requestFormController) {
			this.requestFormController = requestFormController;
			return this;
		}

		public RequestForm build() {
			return new RequestForm(requestFormController, carDetails, dealerDetails, interestedPeopleCount);
		}
	}
}
