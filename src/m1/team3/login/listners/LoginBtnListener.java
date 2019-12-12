package m1.team3.login.listners;
import dataproto.*;
import m1.team2.ContentEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import m1.team3.login.LoginService;
import m1.team3.login.LoginServiceImpl;
import m1.team3.login.MainPageFrame;
import m3.view.MenuPage;

public class LoginBtnListener implements ActionListener{
	private LoginService loginService = new LoginServiceImpl();

	JTextField txtUserId = null;
    JPasswordField txtPWD = null;

    public LoginBtnListener(JTextField txtUserId,JPasswordField txtPWD ){
    	this.txtUserId = txtUserId;
    	this.txtPWD = txtPWD;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
    Dealer dealer = loginService.validateLogin(txtUserId.getText(), String.valueOf(txtPWD.getPassword()));
		if(dealer != null) {
			new MenuPage(dealer);
		}
		else {
			JOptionPane.showMessageDialog(null, "Login Failed ");
		}

	}

}
