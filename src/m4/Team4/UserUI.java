package m4.Team4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Map;

public class UserUI extends JFrame{
	private Map<String, Lead> leadMap;
	private LeadSearchImp leadManager;
	private int count=0;
	private JButton button1;
	private JButton button2;
	private JLabel jLable;
	private JFrame jFrame;
    private JTextField jtext1;
    private JLabel jAdmin;
    public UserUI(){
    	create();
    	addListeners();
	}

    public void create() {
    	Font font =new Font("PLAIN", Font.PLAIN, 20);
    	jFrame=new JFrame("Sign In");
    	jFrame.setSize(450, 280);

		jLable=new JLabel();
		jAdmin=new JLabel("Phone Number");
		jAdmin.setBounds(40, 50, 250, 50);
		jAdmin.setFont(font);

		button1=new JButton("Login");
		button1.setBounds(90, 150, 100, 50);
		button1.setFont(font);

		button2=new JButton("Exit");
		button2.setBounds(250, 150, 100, 50);
		button2.setFont(font);
		jLable.add(jAdmin);
		jLable.add(button1);
		jLable.add(button2);

		jtext1=new JTextField();
		jtext1.setBounds(200, 50, 200, 50);
		jtext1.setFont(font);


		jLable.add(jtext1);

		jFrame.add(jLable);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jFrame.setLocation(300,400);
    }

    public void addListeners() {
    	ActionListener actionListerner=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String phoneNumber=jtext1.getText();
				leadManager = new LeadSearchImp();
				leadManager.getLead(phoneNumber);
				leadMap = leadManager.getLeadMap();
				if(leadMap.size() != 0)
				{
					VehicleManageFrame ml=new VehicleManageFrame(leadMap);
					jFrame.dispose();
				}
				else {
					count++;
					JOptionPane.showMessageDialog(jFrame, "Phone Number does not exist!");
					if(count==3){
						jFrame.dispose();
					}
				}
			}
		};
		button1.addActionListener(actionListerner);
		ActionListener bt2_ls=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
        jFrame.dispose();
			}
		};
		button2.addActionListener(bt2_ls);
    }


	public static void main(String[] args) {
		UserUI userUI =new UserUI();
	}
}
