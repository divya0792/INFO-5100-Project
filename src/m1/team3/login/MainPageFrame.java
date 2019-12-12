package m1.team3.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPageFrame extends JFrame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p1,p2;
	
	
	JButton logOut = null;
	private String pageName = "Mage Page" ;

    public MainPageFrame(String pageName)
    {
    	this.pageName = pageName;
        createAndShowGUI();
    }

    private void createAndShowGUI()
    {
        // Set title and default close operation
        setTitle("Vehicle Manage System");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
     // Set a background for JFrame
        JLabel lbl = new JLabel(pageName);
        setContentPane(lbl);
        lbl.setFont(new Font("Roboto", Font.BOLD, 54));
        // Set some layout, say FlowLayout
        setLayout(new FlowLayout());
        
        
        createMainPageDummyPanel();
       
        add(p2);
        
        // Set the size of the JFrame and
        // make it visible
        setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

  
	
	
	private void createMainPageDummyPanel() {
		GridBagLayout p2GBL= new GridBagLayout();
        
		
        // Create another JPanel
        GridBagConstraints pgGBC = new GridBagConstraints();
        pgGBC.anchor = GridBagConstraints.CENTER;
        p2=new JPanel(p2GBL);
        
        // This is more transparent than the previous
        // one
        p2.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.setBackground(new Color(0,0,0,125));
        p2.setPreferredSize(new Dimension(250,150));
        
        logOut = new javax.swing.JButton("Exit");
        logOut.setFont(new Font("Roboto", Font.BOLD, 24));
        logOut.setBounds(250, 280, 100, 30);
		
		p2GBL.setConstraints(logOut, pgGBC);
		logOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(NORMAL);
				
			}
		});
		p2.add(logOut);
	}
    
    
    



}
