package m1.team3.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import m1.team3.login.listners.ForgotPWDListner;
import m1.team3.login.listners.LoginBtnListener;
import m1.team3.login.listners.RememberMeListner;
import m1.team3.login.listners.SignUpListner;

public class VMSLoginFrame extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JPanel p1,p2;

	JTextField txtUserId = null;
    JPasswordField txtPWD = null;
    JCheckBox rememberMe = null;
    JButton loginBtn = null;
	JButton forgotPWDBtn = null;
	JButton signUpBtn = null;

    public VMSLoginFrame()
    {
        createAndShowGUI();
    }

    private void createAndShowGUI()
    {
        // Set title and default close operation
        setTitle("Vehicle Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // String iconURL = "/images/dealerLogin.jpg";
        java.net.URL iconURL = null;
        try {
          iconURL = getClass().getResource("../../images/dealerLogin.jpg");
          setContentPane(new JLabel(new ImageIcon(iconURL)));
        } catch(Exception e) {
          e.printStackTrace();
        }
        // Set a background for JFrame

        // Set some layout, say FlowLayout
        setLayout(new FlowLayout());


        createLoginPanel();

        add(p1);

        createSignUpPanel();
        add(p2);

        // Set the size of the JFrame and
        // make it visible
        setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }


	private void createLoginPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gridConstraint = new GridBagConstraints();

		// Create a JPanel
        p1=new JPanel(gridbag);

        p1.setBorder(BorderFactory.createLineBorder(Color.black));
        p1.setBackground(new Color(0,0,0,125));
        p1.setPreferredSize(new Dimension(450,150));


        gridConstraint.fill = GridBagConstraints.BOTH;
        gridConstraint.weightx = 1.0;
        // Add the panels to the JFrame
        JLabel label1 = new javax.swing.JLabel("Username");
		label1.setFont(new Font("Roboto", Font.BOLD, 24));
		//label1.setBounds(200, 80, 50, 40);
		//p1.add(label1);
		gridbag.setConstraints(label1, gridConstraint);
		p1.add(label1);


		 txtUserId = new MyTextField();
		txtUserId.setFont(new Font("Roboto", Font.BOLD, 24));
		//textfield1.setBounds(400, 80, 150, 30);

		gridConstraint.gridwidth = GridBagConstraints.REMAINDER; //end row
		gridbag.setConstraints(txtUserId, gridConstraint);
		p1.add(txtUserId);



		//gridConstraint.weightx = 0.0;  //reset to the default
		JLabel label2 = new javax.swing.JLabel("Password");
		label2.setFont(new Font("Roboto", Font.BOLD, 24));
		label2.setBounds(200, 200, 100, 40);
		gridConstraint.fill = GridBagConstraints.BOTH;
        gridConstraint.weightx = 1.0;
        gridConstraint.gridwidth = GridBagConstraints.RELATIVE;
		gridbag.setConstraints(label2, gridConstraint);
		p1.add(label2);

		txtPWD = new javax.swing.JPasswordField();
		txtPWD.setFont(new Font("Roboto", Font.BOLD, 24));
		txtPWD.setBounds(400, 200, 150, 30);
		gridConstraint.gridwidth = GridBagConstraints.REMAINDER; //end row
		gridbag.setConstraints(txtPWD, gridConstraint);
		p1.add(txtPWD);

		rememberMe = new JCheckBox("RememberMe", true);
		rememberMe.setFont(new Font("Roboto", Font.BOLD, 24));
		rememberMe.setBounds(250, 280, 100, 30);
		//gridConstraint.fill =  GridBagConstraints.HORIZONTAL;
		gridbag.setConstraints(rememberMe, gridConstraint);
		rememberMe.addActionListener(new RememberMeListner());
		p1.add(rememberMe);

		loginBtn = new javax.swing.JButton("Login");
		loginBtn.setFont(new Font("Roboto", Font.BOLD, 24));
		loginBtn.setBounds(250, 280, 100, 30);
		gridConstraint.weightx = 1.0;
	    gridConstraint.gridwidth = GridBagConstraints.RELATIVE;
		gridbag.setConstraints(loginBtn, gridConstraint);
		loginBtn.addActionListener(new LoginBtnListener(txtUserId,txtPWD,rememberMe));
		p1.add(loginBtn);

		forgotPWDBtn = new javax.swing.JButton("Forgot Password");
		forgotPWDBtn.setFont(new Font("Roboto", Font.BOLD, 24));
		forgotPWDBtn.setBounds(250, 280, 100, 30);
		gridConstraint.gridwidth = GridBagConstraints.REMAINDER; //end row
		gridbag.setConstraints(forgotPWDBtn, gridConstraint);
		forgotPWDBtn.addActionListener(new ForgotPWDListner());
		p1.add(forgotPWDBtn);


	}

	private class MyTextField extends JTextField {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  if (this.getText().equals("")){
			  this.setFont(new Font("Roboto", Font.HANGING_BASELINE, 18));
		     g.drawString("User Id/email/phoneNumber", 10, 20);
		  }
		}

		}


	private void createSignUpPanel() {
		GridBagLayout p2GBL= new GridBagLayout();


        // Create another JPanel
        GridBagConstraints pgGBC = new GridBagConstraints();
        pgGBC.anchor = GridBagConstraints.CENTER;
        p2=new JPanel(p2GBL);

        // This is more transparent than the previous
        // one
        p2.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.setBackground(new Color(0,0,0,125));
        p2.setPreferredSize(new Dimension(250,150));

        signUpBtn = new javax.swing.JButton("Signup");
        signUpBtn.setFont(new Font("Roboto", Font.BOLD, 24));
        signUpBtn.setBounds(250, 280, 100, 30);

		p2GBL.setConstraints(signUpBtn, pgGBC);
		signUpBtn.addActionListener(new SignUpListner());
		p2.add(signUpBtn);
	}




}
