package m2.CustomerUI;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import dataproto.Dealer;
import dataproto.Vehicle;

public class FilterUI extends JFrame implements ItemListener {
    private JFrame frame;
    private JLabel headingLabel, brandLabel, modelLabel, typeLabel, categoryLabel, colorLabel, priceLabel,
            priceMinLabel, priceMaxLabel, yearLabel, yearFromLabel, yearToLabel, mileageLabel;
    JComboBox brand, model, type, category, color, priceMin, priceMax, selectYear, mileage;
    private JButton clearButton;

    private JLabel brand1, model1, year, type1, category1, color1, price, mileage1, saleprice;
    private JLabel brandvalue, modelvalue, yearvalue, typevalue, categoryvalue, pricevalue, colorvalue, mileagevalue, salepricevalue;
    private JLabel space, empty;
    private Button seeDetail;
    Container con = getContentPane();


    private ModuleIntegrator manager;
    SelectData sd = new SelectData();
    String dealerID = "";
    DBManager mg;

    public FilterUI(Dealer dealer) {
        dealerID = dealer.getId();
        mg = new DBManager(dealerID);

        try {

            createFilterUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createFilterUI() throws Exception {
        this.setFrame();
        this.addComponent();
        this.setPanel();
        this.addListener();
        this.makeVisible();

    }

    public void setFrame() {
        frame = new JFrame("Search A Car");
    }

    public void addComponent() throws SQLException {

        //sd.addListner();
        brand = new JComboBox(sd.getDataFromSQL(mg.filterValues("brand")));
        type = new JComboBox(sd.getDataFromSQL(mg.filterValues("type")));
        category = new JComboBox(sd.getDataFromSQL(mg.filterValues("category")));
        color = new JComboBox(sd.getDataFromSQL(mg.filterValues("color")));
        mileage = new JComboBox(new String[]{"0-2000", "2000-3000", "3000-5000", "5000+"});
        model = new JComboBox(new String[]{""});
        priceMin = new JComboBox(new String[]{"0", "10000", "20000", "30000", "40000", "50000"});
        priceMax = new JComboBox(new String[]{"10000", "20000", "30000", "40000", "50000", "50000+"});
        //yearSta = new JComboBox(new String[]{"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"});
        selectYear = new JComboBox(new String[]{"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"});
        //yearTo = new JComboBox(new String[]{"2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"});
        reset();
        clearButton = new JButton("Clear All");

        brand.setEditable(false);
        //model.setEditable(false);
        type.setEditable(false);
        category.setEditable(false);
        color.setEditable(false);
        priceMin.setEditable(false);
        priceMax.setEditable(false);
        selectYear.setEditable(false);
        //yearSta.setEditable(false);
        //yearTo.setEditable(false);
        mileage.setEditable(false);

        headingLabel = new JLabel("Choose Your Car Preference");
        brandLabel = new JLabel("  Brand");
        modelLabel = new JLabel("  Model");
        typeLabel = new JLabel("  Type");
        categoryLabel = new JLabel("  Category");
        colorLabel = new JLabel("  Color");
        priceLabel = new JLabel("  Price");
        priceMinLabel = new JLabel("Min");
        priceMaxLabel = new JLabel("Max");
        yearLabel = new JLabel("  Year");
        //yearFromLabel = new JLabel("From");
        //yearToLabel = new JLabel("To");
        mileageLabel = new JLabel("  Mileage");

        Font font1 = new Font("Courier", Font.PLAIN, 16);
        brandLabel.setFont(font1);
        modelLabel.setFont(font1);
        typeLabel.setFont(font1);
        categoryLabel.setFont(font1);
        colorLabel.setFont(font1);
        priceLabel.setFont(font1);
        priceMinLabel.setFont(font1);
        priceMaxLabel.setFont(font1);
        yearLabel.setFont(font1);
        //yearFromLabel.setFont(font1);
        //yearToLabel.setFont(font1);
        mileageLabel.setFont(font1);

        //Set the pattern of title label l
        Font font2 = new Font("Courier", Font.BOLD, 20);
        headingLabel.setFont(font2);
        headingLabel.setForeground(Color.BLUE.darker());
    }

    public void setPanel() {
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(400, 0));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel(); //panel of price filter
        JPanel p3 = new JPanel(); //panel of year filter

        p1.add(headingLabel);

        p.add(brandLabel);
        p.add(brand);

        p.add(modelLabel);
        p.add(model);

        p.add(typeLabel);
        p.add(type);

        p.add(categoryLabel);
        p.add(category);

        p.add(colorLabel);
        p.add(color);

        p.add(mileageLabel);
        p.add(mileage);

        p.add(priceLabel);
        p.add(p2);
        p2.add(priceMinLabel);
        p2.add(priceMin);
        p2.add(priceMaxLabel);
        p2.add(priceMax);

        p.add(yearLabel);
        p.add(selectYear);
        //p3.add(yearFromLabel);
        //p3.add(yearSta);
        //p3.add(yearToLabel);
        //p3.add(yearTo);

        p.add(clearButton);

        p.setLayout(new GridLayout(0, 2));
        p2.setLayout(new GridLayout(2, 2));
        //p3.setLayout(new GridLayout(2, 2));

        try {
            manager = new ModuleIntegrator(dealerID);
        } catch (Exception e) {
        }

        //FinalPage finalPage = new FinalPage();

        addFullResult(con);

        frame.add(p, BorderLayout.WEST);
        frame.add(p1, BorderLayout.NORTH);


    }

    public void addFullResult(Container con) {
        con.revalidate();
        frame.add(con, BorderLayout.EAST);
        manager = new ModuleIntegrator(dealerID);
        ArrayList<dataproto.Vehicle> list = manager.integratorGetAllVehicles();
        //GridLayout gl = new GridLayout(list.size(),1);
        JPanel basepanel = new JPanel();
        BoxLayout bl = new BoxLayout(basepanel, BoxLayout.Y_AXIS);
        con.add(basepanel);
        //con.setBackground(Color.white);
        JScrollPane sp = new JScrollPane(basepanel);
        con.add(sp);
        basepanel.setLayout(bl);

        if (list.size() == 0) {
            JPanel panelempty = new JPanel();
            panelempty.setLayout(new FlowLayout(FlowLayout.CENTER));
            this.empty = new JLabel("No Results, Please Try Again.");
            panelempty.add(empty);
            basepanel.add(panelempty);

        }

        for (int i = 0; i < list.size(); i++) {
            dataproto.Vehicle car = list.get(i);
            JPanel panel = new JPanel();
            //BoxLayout bl1 = new BoxLayout(panel,BoxLayout.Y_AXIS);
            FlowLayout fl = new FlowLayout();
            panel.setLayout(fl);
            newComponent(panel, car, i);
            panel.setBorder(BorderFactory.createBevelBorder(1));
            basepanel.add(panel);
            basepanel.add(Box.createVerticalStrut(15));

        }
    }

    public void addFilteredResult(Container conFiltered, String searchString) {

        ArrayList<dataproto.Vehicle> list = manager.integratorGetFilteredVehiclesFor(searchString);

        //GridLayout gl = new GridLayout(list.size(),1);
        JPanel basePanel = new JPanel();
        BoxLayout bl = new BoxLayout(basePanel, BoxLayout.Y_AXIS);
        conFiltered.add(basePanel);
        //con.setBackground(Color.white);
        JScrollPane sp = new JScrollPane(basePanel);
        conFiltered.add(sp);
        basePanel.setLayout(bl);

        if (list.size() == 0) {
            JPanel panelempty = new JPanel();
            panelempty.setLayout(new FlowLayout(FlowLayout.CENTER));
            this.empty = new JLabel("No Results, Please Try Again.");
            panelempty.add(empty);
            basePanel.add(panelempty);

        }

        for (int i = 0; i < list.size(); i++) {

            dataproto.Vehicle car = list.get(i);
            JPanel panel = new JPanel();
            //BoxLayout bl1 = new BoxLayout(panel,BoxLayout.Y_AXIS);
            FlowLayout fl = new FlowLayout();
            panel.setLayout(fl);
            newComponent(panel, car, i);
            panel.setBorder(BorderFactory.createBevelBorder(1));
            basePanel.add(panel);
            basePanel.add(Box.createVerticalStrut(15));

        }
        con.revalidate();


    }

    public void newComponent(JPanel panel, dataproto.Vehicle car, int i) {

        this.brand1 = new JLabel("Brand : ");
        this.brandvalue = new JLabel(car.getBrand() + "  - ");
        this.model1 = new JLabel("Model : ");
        this.modelvalue = new JLabel(car.getModel() + "                    ");
        this.year = new JLabel("Year : ");
        this.yearvalue = new JLabel(String.valueOf(car.getYear()) + "                ");
        this.type1 = new JLabel("Type : ");
        this.typevalue = new JLabel(car.getType() + "         ");
        this.category1 = new JLabel("Category : ");
        this.categoryvalue = new JLabel(car.getCategory() + "                 ");
        this.color1 = new JLabel("Color : ");
        this.colorvalue = new JLabel(car.getColor() + "\n\n\n");
        this.price = new JLabel("Price : ");
        this.pricevalue = new JLabel(String.valueOf(car.getPrice()) + "0" + "         ");
        this.mileage1 = new JLabel("Mileage: ");
        this.mileagevalue = new JLabel(String.valueOf(car.getMileage()) + "                       ");
        this.saleprice = new JLabel("Price:");
        this.salepricevalue = new JLabel(String.valueOf("$" + car.getSalePrice()) + "0" + "         ");
        this.seeDetail = new Button("see detail");
        this.space = new JLabel("");

        addPanelLeft(panel, brandvalue, modelvalue, year, yearvalue, categoryvalue, mileage1, mileagevalue);
        addPanelRight(car, panel, colorvalue, saleprice, salepricevalue, space, seeDetail);

    }

    public void addPanelLeft(JPanel panel, JLabel brandvalue, JLabel modelvalue, JLabel year, JLabel yearvalue, JLabel categoryvalue, JLabel mileage, JLabel mileagevalue) {
        JPanel jp = new JPanel();
        BoxLayout bl1 = new BoxLayout(jp, BoxLayout.Y_AXIS);
        jp.setLayout(bl1);
        addPanel2(jp, brandvalue, modelvalue);
        addPanel2(jp, year, yearvalue);
        addPanel1(jp, categoryvalue);
        addPanel2(jp, mileage, mileagevalue);
        panel.add(jp);
    }

    public void addPanelRight(Vehicle selectedVehicle, JPanel panel, JLabel colorvalue, JLabel saleprice, JLabel salepricevalue, JLabel space, Button seeDetail) {
//        String i1 = Integer.toString(i);
        JPanel jp1 = new JPanel();
        BoxLayout bl2 = new BoxLayout(jp1, BoxLayout.Y_AXIS);
        jp1.setLayout(bl2);
        addPanel1(jp1, colorvalue);
        addPanel1(jp1, space);
        addPanel2(jp1, saleprice, salepricevalue);
        addPanel1(jp1, space);
        jp1.add(seeDetail);
//        seeDetail.setName(i1);
        seeDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new DetailPage(selectedVehicle, dealerID);

//                    new DetailPage(seeDetail.getName(), dealerID);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        panel.add(jp1);
    }

    public void addPanel1(JPanel panel, JLabel value) {
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp2.add(value);
        panel.add(jp2);
    }

    public void addPanel2(JPanel panel, JLabel value1, JLabel value2) {
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp2.add(value1);
        jp2.add(value2);
        panel.add(jp2);
    }

    public void addListener() {
        brand.addItemListener(this);
        modelByBrand mbd = new modelByBrand();
        brand.addItemListener(mbd);
        model.addItemListener(this);
        type.addItemListener(this);
        color.addItemListener(this);
        category.addItemListener(this);
        priceMin.addItemListener(this);
        priceMax.addItemListener(this);
        selectYear.addItemListener(this);
//        yearTo.addItemListener(this);
        mileage.addItemListener(this);
        clearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                getSelectData().clear();
            }
        });
    }

    public HashMap<String, String> getSelectData() {
        HashMap<String, String> selectData = new HashMap<>();
        if (!(brand.getSelectedItem() == null)) {
            selectData.put("brand", (String) brand.getSelectedItem());
        }
        if (!(model.getSelectedItem() == null)) {
            selectData.put("model", (String) model.getSelectedItem());
        }
        if (!(type.getSelectedItem() == null)) {
            selectData.put("type", (String) type.getSelectedItem());
        }
        if (!(category.getSelectedItem() == null)) {
            selectData.put("category", (String) category.getSelectedItem());
        }
        if (!(color.getSelectedItem() == null)) {
            selectData.put("color", (String) color.getSelectedItem());
        }
        if (!(selectYear.getSelectedItem() == null)) {
            selectData.put("yearSta", (String) selectYear.getSelectedItem());
        }
//        if (!(yearTo.getSelectedItem() == null)) {
//            selectData.put("yearTo", (String) yearTo.getSelectedItem());
//        }
        if (!(priceMin.getSelectedItem() == null)) {
            selectData.put("priceMin", (String) priceMin.getSelectedItem());
        }
        if (!(priceMax.getSelectedItem() == null)) {
            selectData.put("priceMax", (String) priceMax.getSelectedItem());
        }
        if (!(mileage.getSelectedItem() == null)) {
            selectData.put("mileage", (String) mileage.getSelectedItem());
        }
    	/*
        selectData.add(0,(String) brand.getSelectedItem());
        selectData.add(1,(String) model.getSelectedItem());
        selectData.add(2,(String) type.getSelectedItem());
        selectData.add(3,(String) category.getSelectedItem());
        selectData.add(4,(String) color.getSelectedItem());
        selectData.add(5,(String) yearSta.getSelectedItem());
        selectData.add(6,(String) yearTo.getSelectedItem());
        selectData.add(7,(String) priceMin.getSelectedItem());
        selectData.add(8,(String) priceMax.getSelectedItem());
        selectData.add(9,(String) mileage.getSelectedItem());
		*/
        return selectData;
    }

    public void updateData() {
        //frame.remove(con);
        con.removeAll();

        HashMap<String, String> res = getSelectData();
        String searchString = sd.sendSelectData(res);
        System.out.println("search string:" + searchString);
        addFilteredResult(con, searchString);
        //con.repaint();
        //frame.add(con,BorderLayout.EAST);

    }


    public void makeVisible() {
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void reset() {
        brand.setSelectedItem(null);
        type.setSelectedItem(null);
        category.setSelectedItem(null);
        color.setSelectedItem(null);
        mileage.setSelectedItem(null);
        model.setSelectedItem(null);
        priceMin.setSelectedItem(null);
        priceMax.setSelectedItem(null);
        selectYear.setSelectedItem(null);
        //yearSta.setSelectedItem(null);
        //yearTo.setSelectedItem(null);
        con.removeAll();
        addFullResult(con);


    }

    public static void main(String[] args) throws Exception {
      Dealer testDealer = new Dealer();
      testDealer.setId("0");
        FilterUI ui = new FilterUI(testDealer);
        ui.createFilterUI();


    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {

            //con.removeAll();
            updateData();

        }
    }

    public class modelByBrand implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                try {
                    Vector<String> RES = sd.getDataFromSQL(mg.getAllModels((String) brand.getSelectedItem()));
                    DefaultComboBoxModel modelList = new DefaultComboBoxModel(RES);
                    model.setModel(modelList);
                    model.setSelectedItem(null);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


}
