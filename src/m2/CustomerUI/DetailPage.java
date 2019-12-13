package m2.CustomerUI;

import dataproto.Vehicle;
import m4.Team1.RequestFormAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DetailPage extends JFrame {
    //    private int i;
    private JLabel brand, model, year, type, category, color, price, mileage, saleprice,incentive;
    private JLabel brandValue, modelValue, yearValue, typeValue, categoryValue, priceValue, colorValue, mileageValue, salePriceValue,incentiveValue;
    private JLabel space;
    private Button interest;
    private String dealerID;
    private Vehicle selectedVehicle;

    private ModuleIntegrator manager;


    public DetailPage(Vehicle selectedVehicle, String dealerID) {
        this.selectedVehicle = selectedVehicle;
        this.dealerID = dealerID;

        displayDetails();
    }

    public void displayDetails() {
        makeItVisible();

        Container con = getContentPane();

        add(con);
    }

    public void makeItVisible() {
        setSize(900, 300);
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

    public void add(Container con) {
        JPanel basepanel = new JPanel();
        FlowLayout fl = new FlowLayout();
        con.add(basepanel);
        con.setSize(50, 30);
        basepanel.setLayout(fl);
        newComponent(basepanel, this.selectedVehicle);
    }

    public void newComponent(JPanel panel, dataproto.Vehicle car) {

        this.brand = new JLabel("Brand : ");
        this.brandValue = new JLabel(car.getBrand() + "  - ");
        this.model = new JLabel("Model : ");
        this.modelValue = new JLabel(car.getModel() + "                    ");
        this.year = new JLabel("Year : ");
        this.yearValue = new JLabel(String.valueOf(car.getYear()) + "                ");
        this.type = new JLabel("Type : ");
        this.typeValue = new JLabel(car.getType() + "         ");
        this.category = new JLabel("Category : ");
        this.categoryValue = new JLabel(car.getCategory() + "                 ");
        this.color = new JLabel("Color : ");
        this.colorValue = new JLabel(car.getColor() + "\n\n\n");
        this.price = new JLabel("Original Price : ");
        this.priceValue = new JLabel(String.valueOf("$" + car.getPrice()) + "0" + "         ");
        this.mileage = new JLabel("Mileage: ");
        this.mileageValue = new JLabel(String.valueOf(car.getMileage()) + "                       ");
        this.saleprice = new JLabel("Sale Price:");
        this.salePriceValue = new JLabel(String.valueOf("$" + car.getSalePrice()) + "0" + "         ");

        this.incentive = new JLabel("Incentive(s) Applied: ");
        manager = new ModuleIntegrator(dealerID);
        this.incentiveValue = new JLabel(manager.getIncentiveForVehicle(this.selectedVehicle));
        this.space = new JLabel("");
        this.interest = new Button("I am interested!");

        this.interest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("User is interested!!");
                new RequestFormAPI(selectedVehicle.getId(), dealerID);
            }
        });

        addPanelLeft(panel, brandValue, modelValue, year, yearValue, type, typeValue, color, colorValue, categoryValue, mileage, mileageValue);
        addPanelRight(panel, price, priceValue, saleprice, salePriceValue, space, interest,incentive,incentiveValue);
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

    public void addPanelRight(JPanel panel, JLabel price, JLabel pricevalue, JLabel saleprice, JLabel salepricevalue, JLabel space, Button interest,JLabel incentive, JLabel incentiveValue) {
        JPanel jp1 = new JPanel();
        BoxLayout bl2 = new BoxLayout(jp1, BoxLayout.Y_AXIS);
        jp1.setLayout(bl2);
        addPanel2(jp1, price, pricevalue);
        addPanel1(jp1, space);
        if(selectedVehicle.getMatchedIncentives().size() > 0){
            addPanel2(jp1, saleprice, salepricevalue);
            addPanel1(jp1, space);
            addPanel2(jp1,incentive,incentiveValue);

            //incentive
        }

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

    //Action listeners

}
