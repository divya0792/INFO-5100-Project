package m4.Team4;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LeadInformation extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private JTextField carBrandTextField, carTypeTextField, carYearTextField, carModelTextField, customerFirstNameTextField, customerLastNameTextField, customerEmailTextField, customerPhoneNumberTextField;
	private JTextArea customerQueryTextArea, dealerResponseTextArea ;
	private JLabel carInfoLabel, customerInfoLabel, customerQueryLabel, dealerResponseLabel, carBrand, carType, carYear, carModel, customerFirstName, customerLastName, customerEmailId, customerPhoneNo;
	private JPanel panel, panel_1;
	JTextArea textAreas[] = {customerQueryTextArea, dealerResponseTextArea};
	JPanel panels[] = {panel, panel_1};
	JTextField textFields[] = {carBrandTextField, carTypeTextField, carYearTextField, carModelTextField, customerFirstNameTextField, customerLastNameTextField, customerEmailTextField, customerPhoneNumberTextField};
	JLabel labels[] = {carInfoLabel, carBrand, carModel, carYear, carType, customerInfoLabel, customerFirstName, customerLastName, customerEmailId, customerPhoneNo, customerQueryLabel, dealerResponseLabel};
	String str[] = {"Car Information","Car Brand", "Car Model", "Car Year", "Car Type", "Customer Information", "First Name", "Last Name","Email ID", "Phone No", "Customer comment:", "Dealer comment:"};

	private Lead lead;
	private Vehicle vehicle;

	public LeadInformation() {
		initializeAndAddComponents();
		setLayout();
	}

    public LeadInformation(Lead lead, Vehicle vehicle) {
        this();
        this.lead = lead;
        this.vehicle = vehicle;
        fillData();
        this.frame.setVisible(true);
    }

	private void fillData() {
		try {

            textFields[4].setText(lead.getFirstName());
            textFields[5].setText(lead.getLastName());
            textFields[6].setText(lead.getEmail());
            textFields[7].setText(lead.getContactNo());
			textAreas[0].setText(lead.getComment());
			textAreas[1].setText(lead.getDealerComment());


			textFields[0].setText(vehicle.getBrand());
			textFields[1].setText(vehicle.getType());
			textFields[2].setText(vehicle.getYear());
			textFields[3].setText(vehicle.getModel());
			for(JTextField tf:textFields){
				tf.setEditable(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initializeAndAddComponents() {
		frame = new JFrame();
		frame.setBounds(70, 70, 782, 778);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Font defaultFont = new Font("Tahoma", Font.PLAIN, 20);

		//initializing text areas
		for(int i = 0; i < textAreas.length; i++) {
			textAreas[i] = new JTextArea();
			textAreas[i].setFont(new Font("Monospaced", Font.PLAIN, 16));
			textAreas[i].setEditable(false);
		}

		//initializing panels
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			panels[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			panels[i].setLayout(null);
		}

		//initializing text fields
		for (int i = 0; i < textFields.length; i++) {
			textFields[i] = new JTextField(10);
			if( i < 4) {
				if( i == 0) {
					textFields[i].setBounds(133, 53, 96, 30);
				} else if( i == 1) {
					textFields[i].setBounds(399, 53, 96, 30);
				} else if( i == 2) {
					textFields[i].setBounds(133, 81, 96, 30);
				} else if( i == 3) {
					textFields[i].setBounds(399, 81, 96, 30);
				}
				panels[0].add(textFields[i]);
			} else {
				if( i == 4) {
					textFields[i].setBounds(133, 52, 96, 30);
				} else if( i == 5) {
					textFields[i].setBounds(399, 52, 96, 30);
				} else if( i == 6) {
					textFields[i].setBounds(133, 83, 300, 30);
				}else {
					textFields[i].setBounds(133, 119, 96, 30);
				}
				panels[1].add(textFields[i]);
			}
		}

		//initializing labels
		for(int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(str[i]);
			if( i < 5) {
				if( i == 0) {
					labels[i].setFont(defaultFont);
					labels[i].setBounds(10, 11, 219, 30);
				} else if( i == 1) {
					labels[i].setBounds(25, 53, 69, 30);
				} else if( i == 2) {
					labels[i].setBounds(311, 81, 69, 30);
				}else if( i == 3){
					labels[i].setBounds(25, 81, 69, 30);
				}else {
					labels[i].setBounds(311, 52, 69, 30);
				}
				panels[0].add(labels[i]);
			} else if( i > 4 & i < 10) {
				if( i == 5) {
					labels[i].setFont(defaultFont);
					labels[i].setBounds(15, 16, 242, 30);
				} else if( i == 6) {
					labels[i].setBounds(25, 52, 69, 30);
				} else if( i == 7) {
					labels[i].setBounds(311, 52, 69, 30);
				}else if( i == 8){
					labels[i].setBounds(25, 83, 69, 30);
				}else {
					labels[i].setBounds(25, 119, 69, 30);
				}
				panels[1].add(labels[i]);
			}else {
				labels[i].setFont(defaultFont);
			}
		}
	}

	private void setLayout() {
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(textAreas[1], GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE).addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(labels[10], GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE).addContainerGap(469, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(16).addComponent(panels[0], GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE).addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addGap(16).addComponent(panels[1], GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE).addContainerGap()).addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addContainerGap().addComponent(labels[11], GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE).addContainerGap(491, Short.MAX_VALUE)).addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addContainerGap().addComponent(textAreas[0], GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(panels[0], GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE).addGap(33)
						.addComponent(panels[1], GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE).addGap(18).addComponent(labels[10]).addGap(18)
						.addComponent(textAreas[0], GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(32).addComponent(labels[11]).addGap(18)
						.addComponent(textAreas[1], GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE).addGap(29).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE))));
		frame.getContentPane().setLayout(groupLayout);
	}

}
