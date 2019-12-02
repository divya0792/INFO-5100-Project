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
import java.awt.Font;
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

	private JPanel panel_ButtonArea, panel_Content_1, panel_Content_2, panel_FontArea, panel_Header, panel_Footen, panel_Center, panel_PreviewArea, panel_CheckBoxArea;

	private JComboBox comboBox_Size, comboBox_Color, comboBox_Position, comboBox_BackGroundColor;

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
		
		newHeaderPanel();	
		newContent_1Panel();
		newContent_2Panel();
		newFootenPanel();
		newCheckBoxAreaPanel();
		newPositionComboBox();
		newFontAreaPanel();
		newPreviewAreaPanel();
		newButtonAreaPanel();
		newCenterPanel();
		
	}
	
	private void newHeaderPanel() {
		panel_Header = new JPanel();
		txtpnHeaderData = new JTextPane();
		
		panel_Header.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_Header, BorderLayout.NORTH);
		panel_Header.setLayout(new GridLayout(1, 2, 0, 0));
		txtpnHeaderData.setText("Header Data : ");
		panel_Header.add(txtpnHeaderData);
	}
	private void newContent_1Panel() {
		panel_Content_1 = new JPanel();
		txtpnContent_1 = new JTextPane();
		
		panel_Content_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_Content_1, BorderLayout.WEST);
		panel_Content_1.setLayout(new GridLayout(0, 1, 0, 0));		
		txtpnContent_1.setText("Content 1: ");
		panel_Content_1.add(txtpnContent_1);
	}
	private void newContent_2Panel() {
		panel_Content_2 = new JPanel();
		txtpnContent_2 = new JTextPane();
		
		panel_Content_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_Content_2, BorderLayout.EAST);
		panel_Content_2.setLayout(new GridLayout(0, 1, 0, 0));
		txtpnContent_2.setText("Content 2: ");
		panel_Content_2.add(txtpnContent_2);
	}
	private void newFootenPanel() {
		panel_Footen = new JPanel();
		txtpnFootenData = new JTextPane();
		
		panel_Footen.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_Footen, BorderLayout.SOUTH);
		panel_Footen.setLayout(new GridLayout(0, 1, 0, 0));
		txtpnFootenData.setText("Footen Data : ");
		panel_Footen.add(txtpnFootenData);
	}
	private void newFontAreaPanel() {
		comboBox_BackGroundColor = new JComboBox();
		comboBox_Size = new JComboBox();
		comboBox_Color = new JComboBox();
		lblNewLabel_4 = new JLabel("Position");
		lblNewLabel = new JLabel("Font Size");
		lblNewLabel_2 = new JLabel("Format");
		lblNewLabel_5 = new JLabel("Font Color");
		lblNewLabel_1 = new JLabel("Background Color");
		
		panel_FontArea = new JPanel();
		panel_FontArea.setLayout(new GridLayout(5, 2, 0, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_FontArea.add(lblNewLabel_4);	
		panel_FontArea.add(comboBox_Position);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_FontArea.add(lblNewLabel);
		comboBox_Size.setModel(new DefaultComboBoxModel(new String[] {"9", "10", "11", "12", "13"}));
		panel_FontArea.add(comboBox_Size);
		panel_FontArea.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_FontArea.add(panel_CheckBoxArea);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_FontArea.add(lblNewLabel_5);
		comboBox_Color.setModel(new DefaultComboBoxModel(new String[] {"red", "black", "white", "green", "blue"}));
		panel_FontArea.add(comboBox_Color);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_FontArea.add(lblNewLabel_1);
		comboBox_BackGroundColor.setModel(new DefaultComboBoxModel(new String[] {"black", "white", "grey"}));
		panel_FontArea.add(comboBox_BackGroundColor);
	}
	private void newPreviewAreaPanel() {
		panel_PreviewArea = new JPanel();
		txtpnPlaintext = new JTextPane();
		btnSubmit = new JButton("Submit");
		btnPreview = new JButton("Preview");
		btnReset = new JButton("Reset");
		
		panel_PreviewArea.setLayout(new BorderLayout(0, 0));
		setTxtPaneText(txtpnPlaintext, txtpnHeaderData.getText(), txtpnHeaderData.getFont().isBold(), txtpnHeaderData.getFont().isItalic(), txtpnHeaderData.getFont().getSize() );
		panel_PreviewArea.add(txtpnPlaintext, BorderLayout.CENTER);
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
	private void newButtonAreaPanel() {
		panel_ButtonArea = new JPanel();
		panel_ButtonArea.add(btnPreview);
		panel_ButtonArea.add(btnReset);
		panel_ButtonArea.add(btnSubmit);
	}
	private void newCenterPanel() {
		panel_Center = new JPanel();
		panel_Center.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new BorderLayout(0, 0));
		panel_Center.add(panel_FontArea, BorderLayout.NORTH);
		panel_Center.add(panel_ButtonArea, BorderLayout.SOUTH);
		panel_Center.add(panel_PreviewArea, BorderLayout.CENTER);
	}
	private void newCheckBoxAreaPanel() {
		panel_CheckBoxArea = new JPanel();
		panel_CheckBoxArea.setLayout(new GridLayout(0, 2, 0, 0));
		JCheckBox chckbxNewCheckBox = new JCheckBox("Is Bold");
		panel_CheckBoxArea.add(chckbxNewCheckBox);
		JCheckBox chckbxIsItalic = new JCheckBox("Is Italic");
		panel_CheckBoxArea.add(chckbxIsItalic);
	}
	private void newPositionComboBox() {
		comboBox_Position = new JComboBox();
		comboBox_Position.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch (e.getStateChange())
					{
						case ItemEvent.SELECTED: 
							String item = e.getItem().toString();
							if(item.equals("Header Data")) {
								setTxtPaneText(txtpnPlaintext, txtpnHeaderData.getText(), txtpnHeaderData.getFont().isBold(), txtpnHeaderData.getFont().isItalic(), txtpnHeaderData.getFont().getSize());
							}else if(item.equals("Content 1")) {
								setTxtPaneText(txtpnPlaintext, txtpnContent_1.getText(), txtpnContent_1.getFont().isBold(), txtpnContent_1.getFont().isItalic(), txtpnContent_1.getFont().getSize());
							}else if(item.equals("Content 2")) {
								setTxtPaneText(txtpnPlaintext, txtpnContent_2.getText(), txtpnContent_2.getFont().isBold(), txtpnContent_2.getFont().isItalic(), txtpnContent_2.getFont().getSize());
							}else if(item.equals("Footen Data")) {
								setTxtPaneText(txtpnPlaintext, txtpnFootenData.getText(), txtpnFootenData.getFont().isBold(), txtpnFootenData.getFont().isItalic(), txtpnFootenData.getFont().getSize());
							}
						break;
					}
			}
		});
		comboBox_Position.setModel(new DefaultComboBoxModel(new String[] {"Header Data", "Content 1", "Content 2", "Footen Data"}));
		
	}
	
	public void setTxtPaneText(JTextPane textPane, String text, Boolean isBold, Boolean isItalic, int size) {
		textPane.setText(text);
		int temp = 0;		
		if(isBold) {
			temp += Font.BOLD;
		}
		if(isItalic) {
			temp += Font.ITALIC;
		}
		Font f = new Font("Default", temp,size);
		textPane.setFont(f);
	}

	
}
