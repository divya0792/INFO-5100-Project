package m1.team3.mycollege.login.listners;

import m1.team3.mycollege.signup.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import m1.team3.mycollege.login.MainPageFrame;

public class SignUpListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new RegisterPage1();
	}

}
