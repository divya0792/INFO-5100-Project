package m1.team14.view;

import dataproto.RichText;
import dataproto.Dealer;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import m1.team14.controller.HomePageController;
import java.beans.PropertyChangeEvent;
import java.util.stream.Stream;

import m1.team14.Events;
import m1.team2.DealerAllContent;

public class SecondHalfViewPanel extends JPanel {
	private JScrollPane HeaderPanel,FooterPanel, MidLeftPanel, MidRightPanel;
	private JEditorPane HeadEdp, Sec1Edp, Sec2Edp, FootEdp;
	private JButton ClickForDetailBtn;
  private HomePageController controller;
  private static final long serialVersionUID = 4L;

  public SecondHalfViewPanel(HomePageController controller) {
    this.controller = controller;
    this.initComponent();
    this.localInitialization();
  }
  private void initComponent() {
    setBorder(new EmptyBorder(6,6,6,6));
    setLayout(new GridBagLayout());
    ClickForDetailBtn = new JButton("Click For Detail");
    ClickForDetailBtn.addActionListener(e -> {
     this.controller.gotoDetail();
    });
    newHeaderPanel();
    addMidLeftPanel();
    addMidRightPanel();
    addComponent(ClickForDetailBtn, 4, 5, 3, 2, 0.1, 0.1);
    newFooterPanel();
  }
  public void addScrollPanel(JScrollPane jsp, int col, int row, int width, int height, double weightx , double weighty) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(10,10,2,2);
    gbc.gridx = col;
    gbc.gridy = row;
    gbc.gridwidth = width;
    gbc.gridheight = height;
    gbc.weightx = weightx;
    gbc.weighty = weighty;
    this.add(jsp,gbc);
  }
  public void addComponent(Component cop, int col, int row, int width, int height, double weightx , double weighty) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(20,2,2,2);
    gbc.gridx = col;
    gbc.gridy = row;
    gbc.gridwidth = width;
    gbc.gridheight = height;
    gbc.weightx = weightx;
    gbc.weighty = weighty;
    this.add(cop,gbc);
  }

  private void newFooterPanel() {
    FootEdp = new JEditorPane();
    FooterPanel = new JScrollPane(FootEdp,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    FootEdp.setEditable(false);
    FooterPanel.setBorder(new LineBorder(new Color(1,1,1),2,true));
    FooterPanel.setPreferredSize(new Dimension(300,150));
    addScrollPanel(FooterPanel, 0,9,11,2,1,0.2);

  }

  private void addMidRightPanel() {
    Sec2Edp = new JEditorPane();
    MidRightPanel = new JScrollPane(Sec2Edp,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    Sec2Edp.setEditable(false);
    MidRightPanel.setBorder(new LineBorder(new Color(0,0,0),2,true));
    MidRightPanel.setPreferredSize(new Dimension(100,150));
    addScrollPanel(MidRightPanel,4,2,6,1,0.6,0.6);
  }

  private void addMidLeftPanel() {
    Sec1Edp = new JEditorPane();
    MidLeftPanel = new JScrollPane(Sec1Edp,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    Sec1Edp.setEditable(false);
    MidLeftPanel.setBorder(new LineBorder(new Color(0,0,0),2,true));
    MidLeftPanel.setPreferredSize(new Dimension(100,150));
    addScrollPanel(MidLeftPanel,0,2,2,5,0.4,0.6);
  }

  private void newHeaderPanel() {
    HeadEdp = new JEditorPane();
    HeaderPanel = new JScrollPane(HeadEdp, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    HeadEdp.setEditable(false);
    HeaderPanel.setBorder(new LineBorder(new Color(1,1,1),2,true));
    HeaderPanel.setPreferredSize(new Dimension(300,50));
    addScrollPanel(HeaderPanel, 0,0,11,2,1,0.2);
  }
  private void localInitialization() {

  }
  private String checkAndReturnString(String input) {
    return input == null ? "<html><body bgcolor='white'></body></html>" : input;
  }
  public void setNewDealer(Dealer newDealer) {
    DealerAllContent allContent = controller.getRichTextsByDealer(newDealer);
    JEditorPane[] widgets = new JEditorPane[]{HeadEdp, Sec1Edp, Sec2Edp, FootEdp};
    Stream.of(widgets).forEach(widget -> widget.setContentType("text/html"));
    HeadEdp.setText(checkAndReturnString(allContent.getHeader().getHtmlString()));
    Sec1Edp.setText(checkAndReturnString(allContent.getLeft().getHtmlString()));
    Sec2Edp.setText(checkAndReturnString(allContent.getRight().getHtmlString()));
    FootEdp.setText(checkAndReturnString(allContent.getFooter().getHtmlString()));
  }
}
