package FinalProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private static PopUp dialog = null;
	public JFrame frame;


	/**
	 * Create the dialog.
	 */
	public PopUp() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblYouHaveSend = new JLabel("Response field is empty");
			lblYouHaveSend.setBounds(15, 78, 380, 25);
			lblYouHaveSend.setHorizontalAlignment(SwingConstants.CENTER);
			lblYouHaveSend.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(lblYouHaveSend);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PopUp.this.dispose();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
public static void main(String[] args) {
		
		PopUp window = new PopUp();
		window.setVisible(true);
		
	}

}
