package m1.team14.view;

import m1.team14.controller.AbstractController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;

public class HomepageFrame extends BaseGuiFrame implements IViewPanel, ActionListener {
    // dealer icon image path(absolute path)
    private final String curDealerIconPath = "../../images/businessman64px.png";
    private final String scrollIconPath = "../../images/businessman32px.png";
    // private final String curDealerIconPath = "/INFO-5100-Project/src/m1/team14/images/businessman64px.png";
    // private final String scrollIconPath = "/INFO-5100-Project/src/m1/team14/images/businessman32px.png";
    private List<String> dealers;
    private static int numOfDealers = 8;  // for test

    List<String> getDealers(int num){
        List<String> allDealers = new ArrayList<>();

        for (int i = 1; i <= num; i++){
            String dealerId = "Dealer " + i;
            allDealers.add(dealerId);
        }

        return allDealers;
    }

    // include the header part, like current dealer img, search, login, history
    private JPanel headPanel;

    private JPanel curDealerIconPanel;
    private JLabel curDealerImg;
    private ImageIcon curDealerIcon;
    private JLabel curDealerLabel;

    private JPanel buttonPanel;
    private JButton searchBtn;
    private JButton loginBtn;
    private JButton historyBtn;
     private JLabel headerLabel;

    // scrollable bar
    private JScrollPane scrollPanel;
    private JPanel viewPanel;

    // test panel for the layout testing
    private JPanel blankPanel;

    // Page controller
    private AbstractController homepageUpCtrl;

    public HomepageFrame() {
    }

    public HomepageFrame(AbstractController homepageUpCtrl) {
        this.homepageUpCtrl = homepageUpCtrl;
    }


    @Override
    public void create() {
        headPanel = new JPanel();

        // current dealer panel
        curDealerIconPanel = new JPanel();
        curDealerIcon = new ImageIcon(getClass().getResource(curDealerIconPath));
        curDealerImg = new JLabel(curDealerIcon);
        curDealerLabel = new JLabel("Current Dealer");

        // button components
        buttonPanel = new JPanel();
        searchBtn = new JButton("Search");
        searchBtn.setBounds(0, 0, 100, 100);
        searchBtn.addActionListener(this);
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        historyBtn = new JButton("History");
        historyBtn.addActionListener(this);

        // scroll panel
//        scrollPanel = new JScrollPane();
        viewPanel = new JPanel();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginBtn)
        {
            // call the team 3's login/register page
        }
        if(e.getSource() == historyBtn) {
            // call the team 1's Customer phone number request page
        }
        if(e.getSource() == searchBtn) {
            // call the search option
        }
    }

    @Override
    void add(Container container) {
        // addCurDealerIcon
        Container mainPanel = getContentPane();
        addCurDealerIcon(curDealerIconPanel);

        addButtons(buttonPanel);

        addViewPanel(viewPanel);

        addHeadPanel(headPanel);

        addToMain(mainPanel);
    }

    private void addViewPanel(JPanel viewPanel) {
        this.dealers = getDealers(numOfDealers);

        for (String dealer : dealers){
            viewPanel.add(createIconPanel(dealer));
        }
    }

    private JPanel createIconPanel(String dealer) {
        JPanel padPanel = new JPanel();
        padPanel.setBorder(new EmptyBorder(2,1,2,1));

        JPanel dealerPanel = new JPanel(new BorderLayout());

        JPanel iconPanel = new JPanel();
        ImageIcon dealImg = new ImageIcon(getClass().getResource(scrollIconPath));
        JLabel iconLabel = new JLabel(dealImg);
        iconPanel.add(iconLabel);

        JPanel labelPanel = new JPanel();
        JLabel dealerIdLabel = new JLabel(dealer);
        labelPanel.add(dealerIdLabel);

        dealerPanel.add(iconPanel, BorderLayout.CENTER);
        dealerPanel.add(labelPanel, BorderLayout.SOUTH);
        padPanel.add(dealerPanel);
        return padPanel;
    }

    private void addHeadPanel(JPanel headPanel) {
        Box hbox1 = Box.createHorizontalBox();
        Box hbox2 = Box.createHorizontalBox();

        hbox1.add(curDealerIconPanel);
        hbox1.add(Box.createHorizontalStrut(140));
        hbox1.add(buttonPanel);

        scrollPanel = new JScrollPane(viewPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(400, 100));
        hbox2.add(scrollPanel);

        Box vbox1 = Box.createVerticalBox();
        vbox1.add(hbox1);
        vbox1.add(Box.createVerticalStrut(30));
        vbox1.add(hbox2);

        headPanel.add(vbox1);
        headPanel.setBorder(new EmptyBorder(20, 10, 20, 10));
    }

    private void addButtons(JPanel buttonPanel) {
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        fillButtonPanel(buttonPanel, searchBtn, constraints, 0, 0, 1, 1, 0.6, 1, GridBagConstraints.NONE, GridBagConstraints.NORTH);
        fillButtonPanel(buttonPanel, historyBtn, constraints, 1, 0, 1, 1, 0.2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTH);
        fillButtonPanel(buttonPanel, loginBtn, constraints, 2, 0, 1, 1, 0.2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTH);

    }

    /*
    * Add component to container with the GridBagConstrains
    * @param: target container
    * @param: added component
    * @param: GridBagConstrain
    * @param: x coordinator of grid
    * @param: y coordinator of grid
    * @param: grid width
    * @param: grid height
    * @param: the grid's weight of the whole grid width
    * @param: the grid's weight of the whole grid height
    * @param: grid fill strategy
    * @param: grid anchor strategy
    * */
    private void fillButtonPanel(JPanel container,
                                 JComponent component,
                                 GridBagConstraints constraints,
                                 int gridx, int gridy,
                                 int gridWidth, int gridHeight,
                                 double weightx, double weighty,
                                 int fill, int anchor) {

        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridWidth;
        constraints.gridheight = gridHeight;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.fill = fill;
        constraints.anchor = anchor;

        container.add(component, constraints);
    }

    private void addToMain(Container mainPanel) {
        mainPanel.add(headPanel, BorderLayout.NORTH);
    }

    private void addCurDealerIcon(JPanel curDealerIconPanel) {
        BorderLayout borderLayout = new BorderLayout();
        curDealerIconPanel.setLayout(borderLayout);

        JPanel imagePanel = new JPanel();
        imagePanel.add(curDealerImg);
        curDealerIconPanel.add(imagePanel, BorderLayout.CENTER);
        curDealerIconPanel.add(curDealerLabel, BorderLayout.SOUTH);
    }

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {

    }
}
