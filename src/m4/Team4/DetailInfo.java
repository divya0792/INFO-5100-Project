package m4.Team4;


import javax.swing.*;
import java.awt.*;

public class DetailInfo extends JFrame {
	private static final long serialVersionUID = 8256394807443698879L;
	private String leadId;
	private Lead lead;
	private Font font;
	private JFrame jFrame;
	private JLabel jLable;
	private JLabel jEmailLable;
	private JTable vehiclesTable;
	private JLabel jLeadIdLable;
	private JLabel jDealerIdLable;
	private JLabel jVehicleIdLable;
	private JLabel userLable;
	private JLabel dealerLable;
	private JTextField userComment;
	private JTextField dealerComment;


    public DetailInfo(String leadId, Lead lead) {
    	font = new Font("PLAIN", Font.PLAIN, 20);
    	this.leadId = leadId;
    	this.lead = lead;
        init();
        makeItVisible();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
    	jFrame = new JFrame("Lead Information");
    	jLable = new JLabel();
    	jLeadIdLable = new JLabel("Lead Id: " + leadId);
    	jLeadIdLable.setBounds(80, 30, 350, 50);
    	jLeadIdLable.setFont(font);

		jDealerIdLable = new JLabel("Dealer Id: " + lead.getDealerId());
		jDealerIdLable.setBounds(280, 30, 350, 50);
		jDealerIdLable.setFont(font);

		jVehicleIdLable = new JLabel("Vehicle Id: " + lead.getVehicleId());
		jVehicleIdLable.setBounds(80, 80, 350, 50);
		jVehicleIdLable.setFont(font);

		jEmailLable = new JLabel("Email: " + lead.getEmail());
		jEmailLable.setBounds(280, 80, 350, 50);
		jEmailLable.setFont(font);

		ImageIcon background = new ImageIcon(VehicleManageFrame.class.getResource("user1.PNG"));
		userLable = new JLabel(background);
		userLable.setBounds(20, 150, background.getIconWidth(), background.getIconHeight());
		userComment = new JTextField("User comment: " + lead.getComment());
		userComment.setBounds(150, 150, 300, 150);

		ImageIcon background1 = new ImageIcon(VehicleManageFrame.class.getResource("dealer.PNG"));
		dealerLable = new JLabel(background1);
		dealerLable.setBounds(470, 350, background1.getIconWidth(), background1.getIconHeight());
		dealerComment = new JTextField("Dealer comment: " + lead.getDealerComment());
		dealerComment.setBounds(150, 350, 300, 150);

		jLable.add(jLeadIdLable);
		jLable.add(jDealerIdLable);
		jLable.add(jVehicleIdLable);
		jLable.add(jEmailLable);
		jLable.add(userComment);
		jLable.add(dealerComment);
		jLable.add(dealerLable);
		jLable.add(userLable);

		jFrame.add(jLable);
    }

    public void makeItVisible() {
		jFrame.setSize(600, 600);
		jFrame.setVisible(true);
	}

}
