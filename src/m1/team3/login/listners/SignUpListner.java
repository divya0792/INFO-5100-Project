package m1.team3.login.listners;

import m1.team3.signup.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import m1.team3.login.MainPageFrame;

public class SignUpListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new RegisterPage1();
	}

}
