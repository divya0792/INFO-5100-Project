package m1.team3.mycollege.login.listners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import m1.team3.mycollege.login.MainPageFrame;

public class ForgotPWDListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO here you need to integrate with actual forgot page page
		new MainPageFrame("Forgot Password screen");
		
	}

}
