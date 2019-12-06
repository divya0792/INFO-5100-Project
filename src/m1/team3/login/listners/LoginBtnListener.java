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

public class LoginBtnListener implements ActionListener{
	private LoginService loginService = new LoginServiceImpl();

	JTextField txtUserId = null;
    JPasswordField txtPWD = null;
    JCheckBox rememberMe = null;

    public LoginBtnListener(JTextField txtUserId,JPasswordField txtPWD,JCheckBox rememberMe ){
    	this.txtUserId = txtUserId;
    	this.txtPWD = txtPWD;
    	this.rememberMe = rememberMe;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(loginService.validateLogin(txtUserId.getText(), String.valueOf(txtPWD.getPassword()))) {
        Dealer dealer = new Dealer();
        dealer.setId(txtUserId.getText());
        ContentEditor.INSTANCE.openEditor(dealer);
		}
		else {
			JOptionPane.showMessageDialog(null, "Login Failed ");
		}

	}

}
