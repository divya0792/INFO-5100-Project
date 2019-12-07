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

public class SecondHalfViewPanel extends JPanel implements IViewPanel {
	private JScrollPane HeaderPanel,FooterPanel, MidLeftPanel, MidRightPanel;
	private JEditorPane HeadEdp, Sec1Edp, Sec2Edp, FootEdp;
	private JButton ClickForDetailBtn, ContactMeBtn;
  private HomePageController controller;

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
    ContactMeBtn = new JButton("Contact Me");
    ContactMeBtn.addActionListener(e -> {
     this.controller.gotoDetail();
    });
    newHeaderPanel();
    addMidLeftPanel();
    addMidRightPanel();
    addComponent(ClickForDetailBtn, 4, 5, 1, 2, 0.3, 0.3);
    addComponent(ContactMeBtn,6, 5, 2, 3, 0.3, 0.3);
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
    addScrollPanel(FooterPanel, 0,9,11,2,1,1);
  }

  private void addMidRightPanel() {
    Sec2Edp = new JEditorPane();
    MidRightPanel = new JScrollPane(Sec2Edp,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    Sec2Edp.setEditable(false);
    MidRightPanel.setBorder(new LineBorder(new Color(0,0,0),2,true));
    addScrollPanel(MidRightPanel,4,2,6,1,3,2.5);
  }

  private void addMidLeftPanel() {
    Sec1Edp = new JEditorPane();
    MidLeftPanel = new JScrollPane(Sec1Edp,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    Sec1Edp.setEditable(false);
    MidLeftPanel.setBorder(new LineBorder(new Color(0,0,0),2,true));
    addScrollPanel(MidLeftPanel,0,2,2,5,3,3);
  }

  private void newHeaderPanel() {
    HeadEdp = new JEditorPane();
    HeaderPanel = new JScrollPane(HeadEdp, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    HeadEdp.setEditable(false);
    HeaderPanel.setBorder(new LineBorder(new Color(1,1,1),2,true));
    addScrollPanel(HeaderPanel, 0,0,11,2,1,1);
  }
  private void localInitialization() {

  }
  @Override
  @SuppressWarnings("unchecked")
  public void modelPropertyChange(final PropertyChangeEvent evt) {
    if (evt.getPropertyName().equals(Events.DEALER_ID_CHANGE)) {
      Dealer newDealer = (Dealer)evt.getNewValue();
      DealerAllContent allContent = controller.getRichTextsByDealer(newDealer);


      JEditorPane[] widgets = new JEditorPane[]{HeadEdp, Sec1Edp, Sec2Edp, FootEdp};
      Stream.of(widgets).forEach(widget -> widget.setContentType("text/html"));

      HeadEdp.setText(allContent.getHeader().getHtmlString());
      Sec1Edp.setText(allContent.getLeft().getHtmlString());
      Sec2Edp.setText(allContent.getRight().getHtmlString());
      FootEdp.setText(allContent.getFooter().getHtmlString());




    }
  }
}
