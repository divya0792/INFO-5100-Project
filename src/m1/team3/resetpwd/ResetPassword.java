package m1.team3.resetpwd;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ResetPassword {

	JFrame frame = new JFrame("Reset Password");
	Container c = frame.getContentPane();

	JLabel username = new JLabel("Dealer ID:           ");
	JLabel newPassword = new JLabel("New Password:     ");
	JLabel confirmPassword = new JLabel("Confirm Password:");


	JTextField field1 = new JTextField(14);
	JPasswordField field2 = new JPasswordField(14);
	JPasswordField field3 = new JPasswordField(14);


	JButton confirm = new JButton("confirm");
	JButton cancel = new JButton("cancel");


	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp4 = new JPanel();


	public ResetPassword() {


		frame.setVisible(true);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);


		add();
		cancelHandle();
		confirmHandle();

	}

	public void add() {
		jp1.add(username);
		jp1.add(field1);

		jp2.add(newPassword);
		jp2.add(field2);

		jp3.add(confirmPassword);
		jp3.add(field3);

		jp4.add(confirm);
		jp4.add(cancel);

		GridLayout gl = new GridLayout(4, 1);
		c.setLayout(gl);

		c.add(jp1);
		c.add(jp2);
		c.add(jp3);
		c.add(jp4);
	}

	public void cancelHandle()
    {
        cancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                System.exit(0);
            }
        });
    }

	public void confirmHandle() {
		confirm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				char[] password = field2.getPassword();
				char[] comfirmPassword = field3.getPassword();
				String ps = String.valueOf(password);
				String cps = String.valueOf(comfirmPassword);
				if(field1.getText().length()<=0) {
					JOptionPane.showMessageDialog(null, "ID cannot be blank! ");
				} else if(ps.length()<=0 && cps.length()<=0) {
					JOptionPane.showMessageDialog(null, "Please enter your password. ");
				} else if(!ps.equals(cps)) {
					JOptionPane.showMessageDialog(null, "Your password do not MATCH! ");
				} else if(!verifyPasswordLength(ps)) {
					JOptionPane.showMessageDialog(null, "Password length at least 8 digits");
				} else if(!checkCharTypes(ps)) {
					JOptionPane.showMessageDialog(null, "Your password has to include at least 1 uppercase, 1 lowercase and 1 digit");
				} else {
					JOptionPane.showMessageDialog(null, "Reset successfully ");
					//save new password
					saveNewPassword(field1.getText(), ps);
				}
			}
		});
	}

	public boolean verifyPasswordLength(String password) {
        // at least 8 digits

        if (password == null || password.length() < 8) {
            return false;
        }
        return true;
    }

	public boolean checkCharTypes(String password) {

        //at least including 1 uppercase, 1 lowercase, 1 digit.
        int upperCase = 0, lowerCase = 0, digit = 0;

        for (Character ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCase += 1;
            } else if (Character.isLowerCase(ch)) {
                lowerCase += 1;
            } else if (Character.isDigit(ch)) {
                digit += 1;
            }
        }


        if (upperCase >= 1 && lowerCase >=1 && digit >=1) {
            return true;
        }
        return false;
    }

	public void saveNewPassword(String dealerId, String password) {
		//TODO
	}


	public static void main(String[] args) {

				new SendEmail();
	       // new ResetPassword();

	}

}
