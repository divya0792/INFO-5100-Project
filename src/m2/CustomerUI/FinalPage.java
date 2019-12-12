package m2.CustomerUI;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;
import javax.swing.*;

public class FinalPage extends JFrame implements ItemListener {


    //global variable to save elements
    private HashMap<String,String> filterList = new HashMap<String,String>();
    // frame
    private JFrame frame;

    // label
    private JLabel l, l1, l2, l3, l4, l5, l6, l6a, l6b, l7, l7a, l7b, l8;
    // comboBoxModel
    private DefaultComboBoxModel BMWComboBoxModel, HondaComboBoxModel, AudiComboBoxModel,FordComboBoxModel,TeslaComboBoxModle;
    // ComBobox
    private JComboBox brand, model, type, category, color, priceMin, priceMax, yearSta, yearTo, mileage;
    //search and clear buttons
    private JButton b, b1;

    private JLabel brand1, model1,year,type1,category1,color1,price,mileage1,saleprice;
    private JLabel brandvalue, modelvalue,yearvalue,typevalue,categoryvalue,pricevalue,colorvalue,mileagevalue,salepricevalue;
    private JLabel space, empty;
    private Button seedetail;
//    private CarManagerFileImp manager ;

    private ModuleIntegrator manager;

    public FinalPage() throws Exception {
    }

    // main class
    public static void main(String[] args) throws Exception {
        FinalPage finalpage = new FinalPage();
        finalpage.setFrame();
        finalpage.addComponent();
        finalpage.setPanel();
        finalpage.makeVisible();
    }

    public void setFrame() {
        // create a new frame
        frame = new JFrame("Search A Car");
    }

    public void setComboBoxModel() {
        BMWComboBoxModel = new DefaultComboBoxModel();
        BMWComboBoxModel.addElement("X1");
        BMWComboBoxModel.addElement("X2");
        BMWComboBoxModel.addElement("X3");
        BMWComboBoxModel.addElement("X4");

        HondaComboBoxModel = new DefaultComboBoxModel();
        HondaComboBoxModel.addElement("H1");
        HondaComboBoxModel.addElement("H2");
        HondaComboBoxModel.addElement("H3");
        HondaComboBoxModel.addElement("H4");

        AudiComboBoxModel = new DefaultComboBoxModel();
        AudiComboBoxModel.addElement("A3");
        AudiComboBoxModel.addElement("A4");
        AudiComboBoxModel.addElement("Q3");
        AudiComboBoxModel.addElement("Q4");

        FordComboBoxModel = new DefaultComboBoxModel();
        FordComboBoxModel.addElement("F1");
        FordComboBoxModel.addElement("F2");
        FordComboBoxModel.addElement("F3");
        FordComboBoxModel.addElement("F4");

        TeslaComboBoxModle = new DefaultComboBoxModel();
        TeslaComboBoxModle.addElement("X");
        TeslaComboBoxModle.addElement("Y");
        TeslaComboBoxModle.addElement("3");
        TeslaComboBoxModle.addElement("S");
    }

    public void addComponent() {
        // create checkbox
        brand = new JComboBox(new String[] {"choose brand", "HONDA", "BMW", "AUDI", "FORD", "TESLA"}
                /*Need data from DB, suach as Honda, BMW, ...*/);
        model = new JComboBox(new String[] {"choose brand"});
        type = new JComboBox(new String[] {"choose type", "SEDAN", "SUV", "TRUCK", "ELECTRIFIED"});
        category = new JComboBox(new String[] {"choose category", "NEW", "USED"});
        color = new JComboBox(new String[]{"choose color", "BLACK", "WHITE", "RED", "BLUE", "YELLOW", "GRAY", "SILVER"});
        priceMin = new JComboBox(new String[]{"from", "0", "10000", "20000", "30000", "40000", "50000"});
        priceMax = new JComboBox(new String[]{"to", "10000", "20000", "30000", "40000", "50000", "50000+"});
        yearSta = new JComboBox(new String[]{"from", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"});
        yearTo = new JComboBox(new String[]{"to", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"});
        mileage = new JComboBox(new String[]{"choose mileage", "0-2000", "2000-4000", "4000-6000", "6000-10000", "10000+"});
        //add search and clear button
        b = new JButton("Search");
        b1 = new JButton("Clear All");
        //add element
        setComboBoxModel();
        // add ItemListners
        brandListener BRAND = new brandListener();
        brand.addItemListener(BRAND);
        modelByBrand CHANGE = new modelByBrand();
        brand.addItemListener(CHANGE);
        modelListener MODEL = new modelListener();
        model.addItemListener(MODEL);
        typeListener TYPE = new typeListener();
        type.addItemListener(TYPE);
        categoryListener CATE = new categoryListener();
        category.addItemListener(CATE);
        colorListener COLOR = new colorListener();
        color.addItemListener(COLOR);
        priceMinListener PRICEMIN = new priceMinListener();
        priceMin.addItemListener(PRICEMIN);
        priceMaxListener PRICEMAX = new priceMaxListener();
        priceMax.addItemListener(PRICEMAX);
        yearStartListener YEARSTART = new yearStartListener();
        yearSta.addItemListener(YEARSTART);
        yearToListener YEARTO = new yearToListener();
        yearTo.addItemListener(YEARTO);
        mileageListener MILEAGE = new mileageListener();
        mileage.addItemListener(MILEAGE);
        searchListener SEARCH = new searchListener();
        b.addActionListener(SEARCH);
        clearListener CLEAR = new clearListener();
        b1.addActionListener(CLEAR);
        // set the checkbox as editable
        brand.setEditable(false);
        model.setEditable(false);
        type.setEditable(false);
        category.setEditable(false);
        color.setEditable(false);
        priceMin.setEditable(false);
        priceMax.setEditable(false);
        yearSta.setEditable(false);
        yearTo.setEditable(false);
        mileage.setEditable(false);

        // create labels
        l = new JLabel("Choose Your Car Preference");
        l1 = new JLabel("  Brand");
        l2 = new JLabel("  Model");
        l3 = new JLabel("  Type");
        l4 = new JLabel("  Category");
        l5 = new JLabel("  Color");
        l6 = new JLabel("  Price");
        l6a = new JLabel("Min");
        l6b = new JLabel("Max");
        l7 = new JLabel("  Year");
        l7a = new JLabel("From");
        l7b = new JLabel("To");
        l8 = new JLabel("  Mileage");


        //Set the pattern of labels
        Font font1 = new Font("Courier", Font.PLAIN,16);
        l1.setFont(font1);
        l2.setFont(font1);
        l3.setFont(font1);
        l4.setFont(font1);
        l5.setFont(font1);
        l6.setFont(font1);
        l6a.setFont(font1);
        l6b.setFont(font1);
        l7.setFont(font1);
        l7a.setFont(font1);
        l7b.setFont(font1);
        l8.setFont(font1);



        //Set the pattern of title label l
        Font font2 = new Font("Courier", Font.BOLD,20);
        l.setFont(font2);
        l.setForeground(Color.BLUE.darker());
    }

    public void setPanel() {
        // create a new panel
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(400, 0));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel(); //panel of price filter
        JPanel p3 = new JPanel(); //panel of year filter

        // add ComboBox to panel
        p1.add(l);

        // add brand
        p.add(l1);
        p.add(brand);

        // add model
        p.add(l2);
        p.add(model);

        // add type
        p.add(l3);
        p.add(type);

        // add category
        p.add(l4);
        p.add(category);

        // add color
        p.add(l5);
        p.add(color);

        // add mileage
        p.add(l8);
        p.add(mileage);

        // add price
        p.add(l6);
        p.add(p2);
        p2.add(l6a);
        p2.add(priceMin);
        p2.add(l6b);
        p2.add(priceMax);

        // add year
        p.add(l7);
        p.add(p3);
        p3.add(l7a);
        p3.add(yearSta);
        p3.add(l7b);
        p3.add(yearTo);

        // add search button
        p.add(b);
        p.add(b1);

        // set a layout for panel
        p.setLayout(new GridLayout(0,2));
        p2.setLayout(new GridLayout(2,2));
        p3.setLayout(new GridLayout(2,2));

        try {
            manager = new ModuleIntegrator();
        } catch (Exception e) {
        }
        Container con = getContentPane();
        add(con);


        // add panel to frame
        frame.add(p, BorderLayout.WEST);
        frame.add(p1, BorderLayout.NORTH);
        frame.add(con,BorderLayout.EAST);
    }


    public void add(Container con){
        ArrayList<VehicleObj> list = manager.integratorGetAllVehicles();
        //GridLayout gl = new GridLayout(list.size(),1);
        JPanel basepanel = new JPanel();
        BoxLayout bl = new BoxLayout(basepanel,BoxLayout.Y_AXIS);
        con.add(basepanel);
        //con.setBackground(Color.white);
        JScrollPane sp = new JScrollPane(basepanel);
        con.add(sp);
        basepanel.setLayout(bl);

        if(list.size() ==0){
            JPanel panelempty = new JPanel();
            panelempty.setLayout(new FlowLayout(FlowLayout.CENTER));
            this.empty = new JLabel("No Results, Please Try Again.");
            panelempty.add(empty);
            basepanel.add(panelempty);

        }

        for(int i = 0; i< list.size();i++){
            VehicleObj car = list.get(i);
            JPanel panel = new JPanel();
            //BoxLayout bl1 = new BoxLayout(panel,BoxLayout.Y_AXIS);
            FlowLayout fl =  new FlowLayout();
            panel.setLayout(fl);
            newComponent(panel,car,i);
            panel.setBorder(BorderFactory.createBevelBorder(1));
            basepanel.add(panel);
            basepanel.add(Box.createVerticalStrut(15));

        }
    }

    public void newComponent(JPanel panel,VehicleObj car, int i){

        this.brand1 = new JLabel("Brand : ");
        this.brandvalue = new JLabel(car.getBrand() + "  - ");
        this.model1 = new JLabel("Model : ");
        this.modelvalue = new JLabel(car.getModel()  + "                    ");
        this.year = new JLabel("Year : ");
        this.yearvalue = new JLabel(String.valueOf(car.getYear()) + "                ");
        this.type1 = new JLabel("Type : ");
        this.typevalue = new JLabel(car.getType()  + "         " );
        this.category1 = new JLabel("Category : ");
        this.categoryvalue = new JLabel(car.getCategory() + "                 ");
        this.color1 = new JLabel("Color : ");
        this.colorvalue = new JLabel(car.getColor() + "\n\n\n");
        this.price = new JLabel("Price : ");
        this.pricevalue = new JLabel(String.valueOf(car.getPrice()) + "0" + "         ");
        this.mileage1 = new JLabel("Mileage: ");
        this.mileagevalue = new JLabel(String.valueOf(car.getMileage()) + "                       ");
        this.saleprice = new JLabel("Saleprice:");
        this.salepricevalue = new JLabel(String.valueOf("$" + car.getSalePrice()) + "0" + "         ");
        this.seedetail = new Button("see detail");
        this.space = new JLabel("");

        addPanelLeft(panel,brandvalue,modelvalue,year,yearvalue,categoryvalue,mileage1,mileagevalue);
        addPanelRight(i,panel,colorvalue,saleprice,salepricevalue,space,seedetail);

    }

    public void addPanelLeft(JPanel panel, JLabel brandvalue, JLabel modelvalue, JLabel year, JLabel yearvalue,JLabel categoryvalue,JLabel mileage,JLabel mileagevalue){
        JPanel jp = new JPanel();
        BoxLayout bl1 = new BoxLayout(jp,BoxLayout.Y_AXIS);
        jp.setLayout(bl1);
        addPanel2(jp,brandvalue,modelvalue);
        addPanel2(jp,year, yearvalue);
        addPanel1(jp,categoryvalue);
        addPanel2(jp,mileage,mileagevalue);
        panel.add(jp);
    }

    public void addPanelRight(int i,JPanel panel, JLabel colorvalue,JLabel saleprice,JLabel salepricevalue,JLabel space,Button seedetail){
        String i1 = Integer.toString(i);
        JPanel jp1 = new JPanel();
        BoxLayout bl2 = new BoxLayout(jp1,BoxLayout.Y_AXIS);
        jp1.setLayout(bl2);
        addPanel1(jp1,colorvalue);
        addPanel1(jp1,space);
        addPanel2(jp1,saleprice,salepricevalue);
        addPanel1(jp1,space);
        jp1.add(seedetail);
        seedetail.setName(i1);
        seedetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new DetailPage(seedetail.getName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        panel.add(jp1);
    }

    public void addPanel1(JPanel panel,JLabel value){
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp2.add(value);
        panel.add(jp2);
    }

    public void addPanel2(JPanel panel, JLabel value1,JLabel value2) {
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp2.add(value1);
        jp2.add(value2);
        panel.add(jp2);
    }

    public void makeVisible() {
        // set the attribute of frame
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String[] convertRange(String s) {
        String[] parts = s.trim().split("-");
            if(parts.length==1) {
                String c =s.substring(s.length()-1);
                if(c.equals("+")) {
                    parts[0] = s.substring(0,s.length()-1);
                    parts[1] = String.valueOf(Integer.MAX_VALUE);
                }
            }
        return parts;
    }

    public String sendChoices() {
        StringBuilder sb = new StringBuilder();
        if(filterList.containsKey("brand")) {
            if(sb.length() > 0)
            {
                //System.out.println(sb.substring(0,1));
                sb.append(" and ");
            }
            sb.append("brand =  '"+filterList.get("brand")+"'");
        }
        if(filterList.containsKey("model")) {
            if(sb.length() > 0) {
                sb.append(" and ");
            }
            sb.append("model = '"+filterList.get("model")+"'");
        }

        if(filterList.containsKey("type")) {
            if(sb.length() > 0) {
                sb.append(" and ");
            }
            sb.append("type = '"+filterList.get("type")+"'");
        }
        if(filterList.containsKey("category")) {
            if(sb.length() > 0) {
                sb.append(" and ");
            }
            sb.append("category = '"+filterList.get("category")+"'");
        }
        if(filterList.containsKey("color")) {
            if(sb.length() > 0) {
                sb.append(" and ");
            }
            sb.append("color = '"+filterList.get("color")+"'");
        }
        if(filterList.containsKey("priceMin")) {
            if(filterList.containsKey("priceMax")) {
                if(sb.length() > 0) {
                    sb.append(" and ");
                }
                sb.append("price between"+Integer.parseInt(filterList.get("priceMin"))+" and "+Integer.parseInt(filterList.get("priceMax")));
            }
        }
        if(filterList.containsKey("yearSta")) {
            if(filterList.containsKey("yearTo")) {
                if(sb.length() > 0) {
                    sb.append(" and ");
                }
                sb.append("dateofmanufacturing between" + Integer.parseInt(filterList.get("yearSta"))+" and "+Integer.parseInt(filterList.get("yearTo")));
            }
        }
        if(filterList.containsKey("mileageSta")) {
            if(filterList.containsKey("mileageTo")) {
                if(sb.length() > 0) {
                    sb.append(" and ");
                }
                sb.append("mileage between "+Integer.parseInt(filterList.get("mileageSta"))+" and "+Integer.parseInt(filterList.get("mileageTo")));
            }
        }
        return sb.toString();
    }
    @Override
    public void itemStateChanged(ItemEvent e) {}

    public class searchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchString = sendChoices();



            //update UI using new filtered list;
        }

    }

    private class clearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            filterList.clear();
        }
    }

    private class brandListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                filterList.put("brand", (String) brand.getSelectedItem());
            }
        }
    }

    private class modelByBrand implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                if(brand.getSelectedItem()=="BMW") {
                    model.setModel(BMWComboBoxModel);
                }else if(brand.getSelectedItem()=="AUDI") {
                    model.setModel(AudiComboBoxModel);
                }else if(brand.getSelectedItem()=="HONDA") {
                    model.setModel(HondaComboBoxModel);
                }else if(brand.getSelectedItem()=="TESLA") {
                    model.setModel(TeslaComboBoxModle);
                }else if(brand.getSelectedItem()=="FORD") {
                    model.setModel(FordComboBoxModel);
                }
            }
        }
    }

    private class modelListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                filterList.put("model", (String)model.getSelectedItem());
            }
        }
    }

    private class typeListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                filterList.put("type", (String) type.getSelectedItem());
            }
        }
    }

    private class categoryListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                filterList.put("category", (String) category.getSelectedItem());
            }
        }
    }

    private class colorListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                filterList.put("color", (String) color.getSelectedItem());
            }
        }
    }

    private class priceMinListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                filterList.put("priceMin", (String) priceMin.getSelectedItem());
            }
        }
    }

    private class priceMaxListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                filterList.put("priceMax", (String) priceMax.getSelectedItem());
            }
        }
    }

    private class yearStartListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                filterList.put("yearSta", (String) yearSta.getSelectedItem());
            }
        }
    }

    private class yearToListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                filterList.put("yearTo", (String) yearTo.getSelectedItem());
            }
        }
    }

    private class mileageListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                String[] bounds = convertRange((String)mileage.getSelectedItem());
                filterList.put("mileageSta",bounds[0]);
                filterList.put("mileageTo", bounds[1]);
            }
        }
    }
}


