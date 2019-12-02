package FinalProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmNew extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public JFrame frame;

	/**
	 * Create the dialog.
	 */
	public ConfirmNew() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			
//			Icon blueIcon = new ImageIcon("yourFile.gif");
//		    Object stringArray[] = { "Yes", "No" };
//		    JOptionPane.showOptionDialog(frame, "are you sure you want to send response?", "Select an Option",
//		        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, blueIcon, stringArray,
//		        stringArray[0]);
		    
		    
			
			int reply = JOptionPane.showConfirmDialog(null,"are you sure you want to send response?", "select option", JOptionPane.YES_NO_OPTION);
	        if (reply == JOptionPane.YES_OPTION) {
	        	
	          frame = new JFrame();
	          JOptionPane.showMessageDialog(frame, "Response has been sent to customer");
	          //email response to customer - christine
	          //if customer has account, send response to customer page by saving response text in database - shuguo
	          System.exit(0);
	        }else {  
	        	   frame.setVisible(false);
	        	
	        }
		}
	}
	
	
public static void main(String[] args) {	
		ConfirmNew window = new ConfirmNew();
		window.setVisible(true);		
	}
}
