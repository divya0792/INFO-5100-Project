package m1.team3.resetpwd;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SendEmail {

	JFrame frame = new JFrame("Retrieve Password");

	Container c = frame.getContentPane();


	JLabel email = new JLabel("Email Address: ");


	JTextField field2 = new JTextField(14);

	JButton send = new JButton("send");

	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();



	public SendEmail() {



		frame.setVisible(true);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);



		add();
		sendHandle();


	}

	public void add() {


		jp2.add(email);
		jp2.add(field2);


		jp3.add(send);


		GridLayout gl = new GridLayout(3, 1);
		c.setLayout(gl);

		c.add(jp1);
		c.add(jp2);
		c.add(jp3);
	}


	public void sendHandle()
    {
        send.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	sendEmail();
            	frame.setVisible(false); 
            	new VerifyCode();

            }
        });
    }
	public void sendEmail() {

		//TODO

	}

	public static void main(String[] args) {

	       new SendEmail();

	}
}
