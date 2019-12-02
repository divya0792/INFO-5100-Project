import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ContentPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContentPage frame = new ContentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JTextPane txtpnPlaintext, txtpnHeaderData, txtpnFootenData, txtpnContent_2, txtpnContent_1;

	private JPanel panel, panel_1, panel_2, panel_3, panel_4, panel_5, panel_6, panel_7, panel_8;

	private JComboBox comboBox, comboBox_1, comboBox_5, comboBox_4;

	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_4, lblNewLabel_5;

	private JButton btnSubmit, btnPreview, btnReset;

	
	/**
	 * Create the frame.
	 */
	public ContentPage() {
		setTitle("Content Editing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		newPanel_4();	
		newPanel_1();
		newPanel_2();
		newPanel_5();
		newPanel_8();
		newComboBox_5();
		newPanel_3();
		newPanel_7();
		newPanel();
		newPanel_6();
		
	}
	
	private void newPanel_4() {
		panel_4 = new JPanel();
		txtpnHeaderData = new JTextPane();
		
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));
		txtpnHeaderData.setText("Header Data : ");
		panel_4.add(txtpnHeaderData);
	}
	private void newPanel_1() {
		panel_1 = new JPanel();
		txtpnContent_1 = new JTextPane();
		
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));		
		txtpnContent_1.setText("Content 1: ");
		panel_1.add(txtpnContent_1);
	}
	private void newPanel_2() {
		panel_2 = new JPanel();
		txtpnContent_2 = new JTextPane();
		
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		txtpnContent_2.setText("Content 2: ");
		panel_2.add(txtpnContent_2);
	}
	private void newPanel_5() {
		panel_5 = new JPanel();
		txtpnFootenData = new JTextPane();
		
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		txtpnFootenData.setText("Footen Data : ");
		panel_5.add(txtpnFootenData);
	}
	private void newPanel_3() {
		comboBox_4 = new JComboBox();
		comboBox = new JComboBox();
		comboBox_1 = new JComboBox();
		lblNewLabel_4 = new JLabel("Position");
		lblNewLabel = new JLabel("Font Size");
		lblNewLabel_2 = new JLabel("Format");
		lblNewLabel_5 = new JLabel("Font Color");
		lblNewLabel_1 = new JLabel("Background Color");
		
		panel_3 = new JPanel();
		panel_3.setLayout(new GridLayout(5, 2, 0, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4);	
		panel_3.add(comboBox_5);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"9", "9.5", "10", "10.5", "11", "11.5", "12"}));
		panel_3.add(comboBox);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(panel_8);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"red", "black", "white", "green", "blue"}));
		panel_3.add(comboBox_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"black", "white", "grey"}));
		panel_3.add(comboBox_4);
	}
	private void newPanel_7() {
		panel_7 = new JPanel();
		txtpnPlaintext = new JTextPane();
		btnSubmit = new JButton("Submit");
		btnPreview = new JButton("Preview");
		btnReset = new JButton("Reset");
		
		panel_7.setLayout(new BorderLayout(0, 0));
		setTxtPaneText(txtpnPlaintext, txtpnHeaderData.getText());
		panel_7.add(txtpnPlaintext, BorderLayout.CENTER);
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Save data
				System.out.println("data saved!");
			}
		});
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Clear data
				System.out.println("data cleared!");
			}
		});
	}
	private void newPanel() {
		panel = new JPanel();
		panel.add(btnPreview);
		panel.add(btnReset);
		panel.add(btnSubmit);
	}
	private void newPanel_6() {
		panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		panel_6.add(panel_3, BorderLayout.NORTH);
		panel_6.add(panel, BorderLayout.SOUTH);
		panel_6.add(panel_7, BorderLayout.CENTER);
	}
	private void newPanel_8() {
		panel_8 = new JPanel();
		panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		JCheckBox chckbxNewCheckBox = new JCheckBox("Is Bold");
		panel_8.add(chckbxNewCheckBox);
		JCheckBox chckbxIsItalic = new JCheckBox("Is Italic");
		panel_8.add(chckbxIsItalic);
	}
	private void newComboBox_5() {
		comboBox_5 = new JComboBox();
		comboBox_5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch (e.getStateChange())
					{
						case ItemEvent.SELECTED: 
							String item = e.getItem().toString();
							if(item.equals("Header Data")) {
								setTxtPaneText(txtpnPlaintext, txtpnHeaderData.getText());
							}else if(item.equals("Content 1")) {
								setTxtPaneText(txtpnPlaintext, txtpnContent_1.getText());
							}else if(item.equals("Content 2")) {
								setTxtPaneText(txtpnPlaintext, txtpnContent_2.getText());
							}else if(item.equals("Footen Data")) {
								setTxtPaneText(txtpnPlaintext, txtpnFootenData.getText());
							}
						break;
					}
			}
		});
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Header Data", "Content 1", "Content 2", "Footen Data"}));
		
	}
	
	public void setTxtPaneText(JTextPane textPane, String text) {
		textPane.setText(text);
	}

	
}
