package m1.team3.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import m1.team3.login.listners.ForgotPWDListner;
import m1.team3.login.listners.LoginBtnListener;
import m1.team3.login.listners.SignUpListner;


public class VMSLoginFrame extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JPanel loginPanel, signUpPanel;

	JTextField txtUserId = null;
	JPasswordField txtPWD = null;
	Font font = new Font("Roboto", Font.BOLD, 24);

	public VMSLoginFrame() {
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		// Set title and default close operation
		setTitle("Vehicle Management System");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// String iconURL = "/images/dealerLogin.jpg";
		java.net.URL iconURL = null;
		try {
			iconURL = getClass().getResource("../../images/dealerLogin.jpg");
			setContentPane(new JLabel(new ImageIcon(iconURL)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Set a background for JFrame

		// Set some layout, say FlowLayout
		setLayout(new FlowLayout());

		createLoginPanel();

		add(loginPanel);

		createSignUpPanel();
		add(signUpPanel);

		// Set the size of the JFrame and
		// make it visible
		setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private JButton createButton(String buttonName, JPanel panel, GridBagLayout gridbag,
			GridBagConstraints gridConstraint, ActionListener listener) {
		JButton btn = new javax.swing.JButton(buttonName);
		btn.setFont(font);
		btn.setBounds(250, 280, 100, 30);
		gridbag.setConstraints(btn, gridConstraint);
		btn.addActionListener(listener);
		panel.add(btn);
		return btn;
	}

	private JLabel createLabel(String lblName, JPanel panel, GridBagLayout gridbag, GridBagConstraints gridConstraint) {
		JLabel label = new javax.swing.JLabel(lblName);
		label.setFont(font);
		label.setBounds(200, 200, 100, 40);
		gridbag.setConstraints(label, gridConstraint);
		panel.add(label);
		return label;
	}

	private void createLoginPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gridConstraint = new GridBagConstraints();

		// Create a JPanel
		loginPanel = new JPanel(gridbag);

		loginPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		loginPanel.setBackground(new Color(0, 0, 0, 125));
		loginPanel.setPreferredSize(new Dimension(450, 150));

		gridConstraint.fill = GridBagConstraints.BOTH;
		gridConstraint.weightx = 1.0;
		// Add the panels to the JFrame

		// add userName label
		createLabel("Username", loginPanel, gridbag, gridConstraint);

		txtUserId = new UserNameTextField("Email/PhoneNumber");
		txtUserId.setFont(font);
		gridConstraint.gridwidth = GridBagConstraints.REMAINDER; // end row
		gridbag.setConstraints(txtUserId, gridConstraint);
		loginPanel.add(txtUserId);

		// add pwd
		gridConstraint.fill = GridBagConstraints.BOTH;
		gridConstraint.weightx = 1.0;
		gridConstraint.gridwidth = GridBagConstraints.RELATIVE;
		createLabel("Password", loginPanel, gridbag, gridConstraint);

		txtPWD = new javax.swing.JPasswordField();
		txtPWD.setFont(font);
		txtPWD.setBounds(400, 200, 150, 30);
		gridConstraint.gridwidth = GridBagConstraints.REMAINDER; // end row
		gridbag.setConstraints(txtPWD, gridConstraint);
		loginPanel.add(txtPWD);


		gridConstraint.weightx = 1.0;
		gridConstraint.gridwidth = GridBagConstraints.RELATIVE;
		createButton("Login", loginPanel, gridbag, gridConstraint, new LoginBtnListener(txtUserId, txtPWD));

		gridConstraint.gridwidth = GridBagConstraints.REMAINDER; // end row
		createButton("Forgot Password", loginPanel, gridbag, gridConstraint, new ForgotPWDListner());

	}

	private class UserNameTextField extends JTextField {

		private String defaultGrayText = "";

		UserNameTextField(String defaultGrayText) {
			this.defaultGrayText = defaultGrayText;
		}

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (this.getText().equals("")) {
				this.setFont(new Font("Roboto", Font.HANGING_BASELINE, 18));
				g.drawString(this.defaultGrayText, 10, 20);
			}
		}

	}

	private void createSignUpPanel() {
		GridBagLayout p2GBL = new GridBagLayout();

		// Create another JPanel
		GridBagConstraints pgGBC = new GridBagConstraints();
		pgGBC.anchor = GridBagConstraints.CENTER;
		signUpPanel = new JPanel(p2GBL);

		signUpPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		signUpPanel.setBackground(new Color(0, 0, 0, 125));
		signUpPanel.setPreferredSize(new Dimension(250, 150));

		createButton("Signup", signUpPanel, p2GBL, pgGBC, new SignUpListner());
	}
}
