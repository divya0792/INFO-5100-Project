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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class VerifyCode {

	JFrame frame = new JFrame("Verification");
	Container c = frame.getContentPane();
	JLabel code = new JLabel("Verification code: ");
	JTextField field = new JTextField(14);
	JButton verify = new JButton("verify");
	
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	
	public VerifyCode(){
		frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        add();
        verifyHandle();
	}

	private void add() {
		
		jp1.add(code);
		jp1.add(field);
		

		jp2.add(verify);
		


		
		GridLayout gl = new GridLayout(3, 1);
		c.setLayout(gl);
		
		c.add(jp3);
		c.add(jp1);
		c.add(jp2);

	}
	private void verifyHandle()
    {
        verify.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	if(codeMatch()) {
            		new ResetPassword();
                    //System.exit(0);
            		frame.setVisible(false);
            	} else {
            		JOptionPane.showMessageDialog(null, "Please enter correct code!");
            	}
            	
            }
        });
    }
	
	private boolean codeMatch() {
		//TODO
//		if() {
//			
//		}
		return false;
	}
	
	public static void main(String[] args) {
        
	       new VerifyCode();

	}
}


