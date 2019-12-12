package m1.team14.view;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class HomePage extends JFrame{
	private JPanel basicPanel;
	private JScrollPane HeaderPanel,FooterPanel, MidLeftPanel, MidRightPanel;
	private JEditorPane HeadEdp, Sec1Edp, Sec2Edp, FootEdp;
	private JButton ClickForDetailBtn, ContactMeBtn;
  private static final long serialVersionUID = 4L; 

    private void create() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(500,500);
    	basicPanel = new JPanel();
    	basicPanel.setBorder(new EmptyBorder(6,6,6,6));
    	setContentPane(basicPanel);
    	basicPanel.setLayout(new GridBagLayout());
    	ClickForDetailBtn = new JButton("Click For Detail");
    	ContactMeBtn = new JButton("Contact Me");
    	newHeaderPanel();
    	addMidLeftPanel();
    	addMidRightPanel();
    	addComponent(basicPanel, ClickForDetailBtn, 4, 5, 1, 2, 0.3, 0.3);
    	addComponent(basicPanel, ContactMeBtn,6, 5, 2, 3, 0.3, 0.3);
    	newFooterPanel();
    }

    public HomePage() {
    	create();
    	display();
    }

	private void display() {
		setVisible(true);
	}

	public void addScrollPanel(JPanel panel1, JScrollPane jsp, int col, int row, int width, int height, double weightx , double weighty) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10,10,2,2);
		gbc.gridx = col;
		gbc.gridy = row;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		panel1.add(jsp,gbc);
	}

	public void addComponent(JPanel panel1, Component cop, int col, int row, int width, int height, double weightx , double weighty) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20,2,2,2);
		gbc.gridx = col;
		gbc.gridy = row;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		panel1.add(cop,gbc);
	}

	private void newFooterPanel() {
		FootEdp = new JEditorPane();
		FooterPanel = new JScrollPane(FootEdp,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		FootEdp.setEditable(false);
		FooterPanel.setBorder(new LineBorder(new Color(1,1,1),2,true));
		addScrollPanel(basicPanel, FooterPanel, 0,9,11,2,1,1);
	}

	private void addMidRightPanel() {
		Sec2Edp = new JEditorPane();
		MidRightPanel = new JScrollPane(Sec2Edp,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Sec2Edp.setEditable(false);
		MidRightPanel.setBorder(new LineBorder(new Color(0,0,0),2,true));
		addScrollPanel(basicPanel, MidRightPanel,4,2,6,1,3,2.5);
	}


	private void addMidLeftPanel() {
		Sec1Edp = new JEditorPane();
		MidLeftPanel = new JScrollPane(Sec1Edp,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Sec1Edp.setEditable(false);
		//test
		/*try {
			Sec1Edp.setPage("http://www.google.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		MidLeftPanel.setBorder(new LineBorder(new Color(0,0,0),2,true));
		addScrollPanel(basicPanel, MidLeftPanel,0,2,2,5,3,3);
	}

	private void newHeaderPanel() {
		HeadEdp = new JEditorPane();
		HeaderPanel = new JScrollPane(HeadEdp, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		HeadEdp.setEditable(false);
		HeaderPanel.setBorder(new LineBorder(new Color(1,1,1),2,true));
		addScrollPanel(basicPanel, HeaderPanel, 0,0,11,2,1,1);
	}

	 public static void main(String[] args) {
		new HomePage();
	 }



}
