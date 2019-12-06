package m1.team3.login.listners;

import m1.team3.resetpwd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import m1.team3.login.MainPageFrame;

public class ForgotPWDListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// new ResetPassword();
		new SendEmail();
		//TODO here you need to integrate with actual forgot page page
		// new MainPageFrame("Forgot Password screen");

	}

}
