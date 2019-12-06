package m1.team3.signup;

import dataproto.*;

import java.awt.FlowLayout;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import m1.team3.Dealers;

public class RegisterPage1 {

	private JFrame frame;
	private JFormattedTextField formattedTextField,formattedTextField_1,formattedTextField_2,
	formattedTextField_3,formattedTextField_4;
	private JPasswordField formattedTextField_5,formattedTextField_6;
	private JLabel lblname,lblDea,lblEmailAddress,Address,
	lblContact,lblCreatePassword,lblRewritePassword,lbIMsg;



	public static void main(String[] args) {
		new RegisterPage1();
	}


	public RegisterPage1() {
		initialize();
	}

	private void NameText(JPanel panel) {
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(260, 40, 282, 43);
		panel.add(formattedTextField);

	}
	private void DealerIdText(JPanel panel) {
		formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(260, 120, 282, 43);
		panel.add(formattedTextField_1);
	}
	private void EmailText(JPanel panel) {
		formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(260, 200, 282, 43);
		panel.add(formattedTextField_2);
	}
	private void contactText(JPanel panel) {
		formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setBounds(260, 280, 282, 43);
		panel.add(formattedTextField_3);
	}
	private void AddressText(JPanel panel) {
		formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setBounds(260, 360, 282, 43);
		panel.add(formattedTextField_4);
	}

	private void createPasswordText(JPanel panel) {
		formattedTextField_5 = new JPasswordField();
		formattedTextField_5.setBounds(260, 440, 282, 43);
		panel.add(formattedTextField_5);
	}
	private void confirmPasswordText(JPanel panel) {
		formattedTextField_6 = new JPasswordField();
		formattedTextField_6.setBounds(260,520, 282, 43);
		panel.add(formattedTextField_6);
	}
	private void addName(JPanel panel) {
		lblname = new JLabel("Name:");
		lblname.setBounds(53, 40, 97, 43);
		panel.add(lblname);
	}
	private void addDealer(JPanel panel) {
		lblDea = new JLabel("Dealer ID:");
		lblDea.setBounds(53, 120, 97, 43);
		panel.add(lblDea);
	}

	private void addEmailAddress(JPanel panel) {
		lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setBounds(53, 200, 151, 43);
		panel.add(lblEmailAddress);
	}
	private void addContact(JPanel panel) {
		lblContact = new JLabel("Contact");
		lblContact.setBounds(53, 280, 97, 43);
		panel.add(lblContact);
	}
	private void addAddress(JPanel panel) {
		Address = new JLabel("Address:");
		Address.setBounds(53, 360, 97, 43);
		panel.add(Address);
	}
	private void createPassword(JPanel panel) {
		lblCreatePassword = new JLabel("Create Password");
		lblCreatePassword.setBounds(53,440, 151, 43);
		panel.add(lblCreatePassword);
	}
	private void rewritePassword(JPanel panel) {
		lblRewritePassword = new JLabel("Rewrite Password");
		lblRewritePassword.setBounds(53,520, 151, 43);
		panel.add(lblRewritePassword);
	}
	private void addlbIMsg(JPanel panel) {
		lbIMsg = new JLabel("Warning message");
		lbIMsg.setBounds(53,600, 400, 43);
		 lbIMsg.setForeground(Color.RED);
		panel.add(lbIMsg);
	}
	private void button1(JPanel panel) {
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(103, 700, 193, 62);
		panel.add(btnSave);
		btnSave.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
                      //设置信息标签为空 清楚原来的历史信息
				       lbIMsg.setText("");
				       //获取用户输入的用户名
				       String strName = lblname.getText();
				       if (strName==null||strName.equals("")) {

				    	   Address.setText("Name cannot be emp");
				    	   return;
					}
				       //获取用户名密码
				       String strPwd = new String(formattedTextField_5.getPassword());
				       if (strPwd==null||strPwd.equals("")) {

				    	   lbIMsg.setText("PassWord cannot be empty");
				    	   return;
					}
				       String strRePwd = new String(formattedTextField_6.getPassword());
				       if (strRePwd==null||strRePwd.equals("")) {

				    	   lbIMsg.setText("confirm password cannot be empty");
				    	   return;
				       }

				       //判断确认密码是否跟密码相同
				       if (!strRePwd.equals(strPwd)) {

				    	   lbIMsg.setText("the confirm password different from origin password");
				    	   return;
					}
//

				     Dealer dealer = new Dealer();
				     dealer.setName(formattedTextField.getText());
				     dealer.setId(formattedTextField_1.getText());
				     dealer.setEmailId(formattedTextField_2.getText());
				     dealer.setAddress(formattedTextField_4.getText());
				     dealer.setPhone(formattedTextField_3.getText());
				     dealer.setPassword(formattedTextField_5.getText());
             Dealers.getInstance().add(dealer);
//				     这里不知道密码的怎么加
//

			}
		}
			);
		}
	//取消/返回按钮
	private void button2(JPanel panel) {
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnCancel.setBounds(476, 700, 193, 62);
		panel.add(btnCancel);
	}
	private void add(JPanel panel) {
		NameText(panel);

		DealerIdText(panel);
		EmailText(panel);
		contactText(panel);
		AddressText(panel);
		createPasswordText(panel);
		confirmPasswordText(panel);
		addName(panel);
		addEmailAddress(panel);
		addDealer(panel);
		addContact(panel);
		createPassword(panel);
		rewritePassword(panel);
		button1(panel);
		button2(panel);
		addAddress(panel);
		addlbIMsg(panel);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 771, 876);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Register Page");
        frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		add(panel);

        panel.setBackground(Color.LIGHT_GRAY);    //background color
	}

}
