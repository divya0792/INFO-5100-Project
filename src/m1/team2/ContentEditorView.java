package m1.team2;

import dataproto.Dealer;
import dataproto.RichText;
import m1.DAO.DealerContentDAOImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.List;

class ContentEditorView extends JFrame {
    enum POSITION {
        HEADER,
        FOOTER,
        LEFT,
        RIGHT
    }
    private static final long serialVersionUID = 4L;

    private Dealer dealer;


    RichText rTextTop, rTextBot, rTextLeft, rTextRight, editingRichText;
    private JPanel contentPane;
    private JTextPane txtpnPlaintext;
    private JTextPane txtpnHeaderData, txtpnFootenData, txtpnContent_2, txtpnContent_1;
    private JPanel panelButtonArea, panel_Content_1, panel_Content_2, panelFontArea, panel_Header, panel_Setting, panel_Footen, panelCenter, panelPlainTextArea, panel_CheckBoxArea;
    private JComboBox<String> comboBox_Size, comboBox_Color, comboBox_BackGroundColor;
    private JComboBox<POSITION> comboBox_Position;
    private JButton btnSubmit, btnPreview, btnReset;
    JCheckBox chckbxIsBold, chckbxIsItalic;

    public ContentEditorView(Dealer dealer) {
        this.dealer = dealer;
        initData();
        createComponents();
    }

    public void initData() {
        DealerAllContent richTexts = DealerContentDAOImpl.INSTANCE.getContents(this.dealer);
        System.out.println("get returns " + richTexts);
        rTextTop = richTexts != null && richTexts.getHeader() != null ? richTexts.getHeader() : new RichText();
        rTextLeft = richTexts != null && richTexts.getLeft() != null ? richTexts.getLeft() : new RichText();
        rTextRight = richTexts != null && richTexts.getRight() != null ? richTexts.getRight() : new RichText();
        rTextBot = richTexts != null && richTexts.getFooter() != null ? richTexts.getFooter() : new RichText();
    }

    public void display() {
        this.setVisible(true);
    }

    private void createComponents() {
        setTitle("Content Editing");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 587, 502);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        newHeaderPanel();
        newCenterPanel();
        updatePreviewData();

        newFontAreaPanel();
        newPlainTextAreaPanel();
        newButtonAreaPanel();
        newSettingPanel();
    }



    private void previewEventHandler() {
        editingRichText.setBold(chckbxIsBold.isSelected());
        editingRichText.setItalic(chckbxIsItalic.isSelected());

        if (comboBox_Size.getSelectedItem() != null) {
            editingRichText.setFontSize(Integer.parseInt(comboBox_Size.getSelectedItem().toString()));
        }
        if (comboBox_BackGroundColor.getSelectedItem() != null) {
            editingRichText.setBackgroundColor(comboBox_BackGroundColor.getSelectedItem().toString());
        }
        if (comboBox_Color.getSelectedItem() != null ){
            editingRichText.setFontColor(comboBox_Color.getSelectedItem().toString());
        }
        editingRichText.setPlainText(txtpnPlaintext.getText());
        editingRichText.setHtmlString(HTMLGenerator.generateHTML(editingRichText));
        updatePreviewData();
    }

    private void submitEventHandler() {
        editingRichText.setBold(chckbxIsBold.isSelected());
        editingRichText.setItalic(chckbxIsItalic.isSelected());
        editingRichText.setPlainText(txtpnPlaintext.getText());

        if (comboBox_Size.getSelectedItem() != null) {
            editingRichText.setFontSize(Integer.parseInt(comboBox_Size.getSelectedItem().toString()));
        }
        if (comboBox_BackGroundColor.getSelectedItem() != null) {
            editingRichText.setBackgroundColor(comboBox_BackGroundColor.getSelectedItem().toString());
        }
        if (comboBox_Color.getSelectedItem() != null ){
            editingRichText.setFontColor(comboBox_Color.getSelectedItem().toString());
        }


        editingRichText.setHtmlString(HTMLGenerator.generateHTML(editingRichText));

        DealerContentDAOImpl.INSTANCE.updateContents(dealer, new DealerAllContent(rTextTop, rTextBot, rTextLeft, rTextRight));
    }

    private void resetEventHandler() {
        System.out.println("start reset");
        initData();
        // default
        comboBox_Position.setSelectedItem(POSITION.HEADER);
        editingRichText = rTextTop;
        initConfigData(editingRichText);
    }

    private void newHeaderPanel() {
        panel_Header = new JPanel();
        txtpnHeaderData = new JTextPane();
        txtpnHeaderData.setContentType("text/html");
        panel_Header.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        contentPane.add(panel_Header, BorderLayout.NORTH);
        panel_Header.setLayout(new GridLayout(1, 2, 0, 0));
//        txtpnHeaderData.setText(rTextTop.getHtmlString());
        panel_Header.add(txtpnHeaderData);
    }
	private void newContent_1Panel() {
		panel_Content_1 = new JPanel();
		panelCenter.add(panel_Content_1, BorderLayout.WEST);
		txtpnContent_1 = new JTextPane();
		txtpnContent_1.setContentType("text/html");
		txtpnContent_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_Content_1.setBorder(new EmptyBorder(20, 5, 20, 5));
		panel_Content_1.setLayout(new GridLayout(0, 1, 0, 0));
		txtpnContent_1.setText(rTextLeft.getPlainText());
		panel_Content_1.add(txtpnContent_1);
	}
	private void newContent_2Panel() {
		panel_Content_2 = new JPanel();
		panelCenter.add(panel_Content_2, BorderLayout.CENTER);
		txtpnContent_2 = new JTextPane();
		txtpnContent_2.setContentType("text/html");
		txtpnContent_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_Content_2.setBorder(new EmptyBorder(20, 5, 20, 5));
		panel_Content_2.setLayout(new GridLayout(2, 1, 0, 0));
		txtpnContent_2.setText(rTextRight.getPlainText());
		panel_Content_2.add(txtpnContent_2);
	}
	private void newFootenPanel() {
		panel_Footen = new JPanel();
		panelCenter.add(panel_Footen, BorderLayout.SOUTH);
		panel_Footen.setLayout(new GridLayout(0, 1, 0, 0));
		txtpnFootenData = new JTextPane();
		txtpnFootenData.setContentType("text/html");
		txtpnFootenData.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_Footen.add(txtpnFootenData);
		txtpnFootenData.setText(rTextBot.getPlainText());
	}
	private void newCenterPanel() {
		panelCenter = new JPanel();

		panelCenter.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));

		newFootenPanel();
		newContent_1Panel();
		newContent_2Panel();
	}
    private void updatePreviewData() {
        txtpnHeaderData.setText(rTextTop.getHtmlString());
        txtpnFootenData.setText(rTextBot.getHtmlString());
        txtpnContent_1.setText(rTextLeft.getHtmlString());
        txtpnContent_2.setText(rTextRight.getHtmlString());
    }

    private void newFontAreaPanel() {
        comboBox_BackGroundColor = new JComboBox<>();
        comboBox_Size = new JComboBox<>();
        comboBox_Color = new JComboBox<>();

        panelFontArea = new JPanel();
        panelFontArea.setLayout(new GridLayout(5, 2, 0, 0));

        panelFontArea.add(newHorizontalCenterAlignLabel("Position"));
        newPositionComboBox();
        panelFontArea.add(comboBox_Position);

        panelFontArea.add(newHorizontalCenterAlignLabel("Font Size"));
        comboBox_Size.setModel(new DefaultComboBoxModel<String>(new String[] {"4","8", "12", "15", "20"}));
        panelFontArea.add(comboBox_Size);

        panelFontArea.add(newHorizontalCenterAlignLabel("Format"));
        newCheckBoxAreaPanel();
        panelFontArea.add(panel_CheckBoxArea);

        panelFontArea.add(newHorizontalCenterAlignLabel("Font Color"));
        comboBox_Color.setModel(new DefaultComboBoxModel<String>(new String[] {"red", "black", "white", "green", "blue"}));
        panelFontArea.add(comboBox_Color);

        panelFontArea.add(newHorizontalCenterAlignLabel("BackGround Color"));
        comboBox_BackGroundColor.setModel(new DefaultComboBoxModel<String>(new String[] {"black", "white", "green", "red", "blue"}));
        panelFontArea.add(comboBox_BackGroundColor);
    }

    private JLabel newHorizontalCenterAlignLabel(String name) {
        JLabel ret = new JLabel(name);
        ret.setHorizontalAlignment(SwingConstants.CENTER);
        return ret;
    }

    private void newPlainTextAreaPanel() {
        panelPlainTextArea = new JPanel();
        txtpnPlaintext = new JTextPane();
        panelPlainTextArea.setLayout(new BorderLayout(0, 0));
        panelPlainTextArea.add(txtpnPlaintext, BorderLayout.CENTER);

    }
    private void newButtonAreaPanel() {
        panelButtonArea = new JPanel();

        btnSubmit = new JButton("Submit");
        btnPreview = new JButton("Preview");
        btnReset = new JButton("Reset");

        btnPreview.addActionListener(ae -> previewEventHandler());
        btnSubmit.addActionListener(ae -> submitEventHandler());
        btnReset.addActionListener(ae -> resetEventHandler());

        panelButtonArea.add(btnPreview);
        panelButtonArea.add(btnReset);
        panelButtonArea.add(btnSubmit);
    }
    private void newSettingPanel() {
    	panel_Setting = new JPanel();
		panel_Setting.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel_Setting, BorderLayout.SOUTH);
		panel_Setting.setLayout(new BorderLayout(0, 0));
		panel_Setting.add(panelFontArea, BorderLayout.NORTH);
		panel_Setting.add(panelButtonArea, BorderLayout.SOUTH);
		panel_Setting.add(panelPlainTextArea, BorderLayout.CENTER);

        // default using topData
        comboBox_Position.setSelectedItem(POSITION.HEADER);
        editingRichText = rTextTop;
        initConfigData(editingRichText);
    }
    private void newCheckBoxAreaPanel() {
        panel_CheckBoxArea = new JPanel();
        panel_CheckBoxArea.setLayout(new GridLayout(0, 2, 0, 0));
        chckbxIsBold = new JCheckBox("Is Bold");
        panel_CheckBoxArea.add(chckbxIsBold);
        chckbxIsItalic = new JCheckBox("Is Italic");
        panel_CheckBoxArea.add(chckbxIsItalic);
    }

    private void newPositionComboBox() {
        comboBox_Position = new JComboBox<>();
        comboBox_Position.addItemListener(e -> {
            switch (e.getStateChange()) {
                case ItemEvent.SELECTED:
                    POSITION item = (POSITION) e.getItem();
                    switch (item) {
                        case HEADER:
                            editingRichText = rTextTop;
                            initConfigData(rTextTop);
                            break;
                        case LEFT:
                            editingRichText = rTextLeft;
                            initConfigData(rTextLeft);
                            break;
                        case RIGHT:
                            editingRichText = rTextRight;
                            initConfigData(rTextRight);
                            break;
                        case FOOTER:
                            editingRichText = rTextBot;
                            initConfigData(rTextBot);
                            break;
                        default:
                            throw new RuntimeException("wrong content position " + item);
                    }
            }
        });
        comboBox_Position.setModel(
                new DefaultComboBoxModel<>(new POSITION[] {
                        POSITION.HEADER,
                        POSITION.FOOTER,
                        POSITION.LEFT,
                        POSITION.RIGHT})
        );

    }

    private void initConfigData(RichText rText) {
        System.out.println("init rText" + rText);
        chckbxIsBold.setSelected(rText.isBold());
        chckbxIsItalic.setSelected(rText.isItalic());
        txtpnPlaintext.setText(rText.getPlainText() == null ? "Please Edit Your Content Here" : rText.getPlainText());
        comboBox_Size.setSelectedItem(String.valueOf(rText.getFontSize()));
        comboBox_Color.setSelectedItem(rText.getFontColor());
        comboBox_BackGroundColor.setSelectedItem(rText.getBackgroundColor());
    }

    //public static void main(String[] args) {

    //}


}
