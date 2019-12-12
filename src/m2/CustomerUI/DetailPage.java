package m2.CustomerUI;

import dataproto.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DetailPage extends JFrame {
    private int i;
    private JLabel brand, model, year, type, category, color, price, mileage, saleprice;
    private JLabel brandvalue, modelvalue, yearvalue, typevalue, categoryvalue, pricevalue, colorvalue, mileagevalue, salepricevalue;
    private JLabel space;
    private Button interest;
    private String dealerID;

    private ModuleIntegrator manager;

    public DetailPage(String i, String dealerID) throws Exception {
        this.i = Integer.parseInt(i);
        this.dealerID = dealerID;
        create(this.i);
        makeItVisible();
    }

    public void makeItVisible() {
        setSize(600, 300);
        setVisible(true);
    }

    public void create(int i) {
        try {
            manager = new ModuleIntegrator(dealerID);
        } catch (Exception e) {
        }
        Container con = getContentPane();

        add(con, i);
    }

    public void add(Container con, int i) {
        ArrayList<dataproto.Vehicle> list = manager.integratorGetAllVehicles();

        dataproto.Vehicle car = list.get(i);
        //GridLayout gl = new GridLayout(list.size(),1);
        JPanel basepanel = new JPanel();
        FlowLayout fl = new FlowLayout();
        con.add(basepanel);
        con.setSize(50, 30);
        basepanel.setLayout(fl);
        newComponent(basepanel, car);

    }

    public void newComponent(JPanel panel, dataproto.Vehicle car) {

        this.brand = new JLabel("Brand : ");
        this.brandvalue = new JLabel(car.getBrand() + "  - ");
        this.model = new JLabel("Model : ");
        this.modelvalue = new JLabel(car.getModel() + "                    ");
        this.year = new JLabel("Year : ");
        this.yearvalue = new JLabel(String.valueOf(car.getYear()) + "                ");
        this.type = new JLabel("Type : ");
        this.typevalue = new JLabel(car.getType() + "         ");
        this.category = new JLabel("Category : ");
        this.categoryvalue = new JLabel(car.getCategory() + "                 ");
        this.color = new JLabel("Color : ");
        this.colorvalue = new JLabel(car.getColor() + "\n\n\n");
        this.price = new JLabel("Price : ");
        this.pricevalue = new JLabel(String.valueOf("$" + car.getPrice()) + "0" + "         ");
        this.mileage = new JLabel("Mileage: ");
        this.mileagevalue = new JLabel(String.valueOf(car.getMileage()) + "                       ");
        this.saleprice = new JLabel("Saleprice:");
        this.salepricevalue = new JLabel(String.valueOf("$" + car.getSalePrice()) + "0" + "         ");
        this.space = new JLabel("");
        this.interest = new Button("Interest");
        addPanelLeft(panel, brandvalue, modelvalue, year, yearvalue, type, typevalue, color, colorvalue, categoryvalue, mileage, mileagevalue);
        addPanelRight(panel, price, pricevalue, saleprice, salepricevalue, space, interest);
    }

    public void addPanelLeft(JPanel panel, JLabel brandvalue, JLabel modelvalue, JLabel year, JLabel yearvalue, JLabel type, JLabel typevalue, JLabel color, JLabel colorvalue, JLabel categoryvalue, JLabel mileage, JLabel mileagevalue) {
        JPanel jp = new JPanel();
        BoxLayout bl1 = new BoxLayout(jp, BoxLayout.Y_AXIS);
        jp.setLayout(bl1);
        addPanel2(jp, brandvalue, modelvalue);
        addPanel2(jp, year, yearvalue);
        addPanel2(jp, type, typevalue);
        addPanel2(jp, color, colorvalue);
        addPanel1(jp, categoryvalue);
        addPanel2(jp, mileage, mileagevalue);
        panel.add(jp);
    }

    public void addPanelRight(JPanel panel, JLabel price, JLabel pricevalue, JLabel saleprice, JLabel salepricevalue, JLabel space, Button interest) {
        JPanel jp1 = new JPanel();
        BoxLayout bl2 = new BoxLayout(jp1, BoxLayout.Y_AXIS);
        jp1.setLayout(bl2);
        addPanel2(jp1, price, pricevalue);
        addPanel1(jp1, space);
        addPanel2(jp1, saleprice, salepricevalue);
        addPanel1(jp1, space);
        addPanelButton(jp1, interest);

        panel.add(jp1);
    }

    public void addPanel1(JPanel panel, JLabel value) {
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp2.add(value);
        panel.add(jp2);
    }

    public void addPanelButton(JPanel panel, Button button) {
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp2.add(button);
        panel.add(jp2);
    }

    public void addPanel2(JPanel panel, JLabel value1, JLabel value2) {
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp2.add(value1);
        jp2.add(value2);
        panel.add(jp2);
    }
}
