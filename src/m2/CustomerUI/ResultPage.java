package m2.CustomerUI;
//package FinalProject;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.awt.*;
//
//import FinalProject.ModuleIntegrator;
//
//public class ResultPage extends BaseFrame{
//    private JLabel brand, model,year,type,category,color,price,mileage,saleprice;
//    private JLabel brandvalue, modelvalue,yearvalue,typevalue,categoryvalue,pricevalue,colorvalue,mileagevalue,salepricevalue;
//    private JLabel space, empty;
//    private Button seedetail;
////    private CarManagerFileImp manager ;
//    private ModuleIntegrator manager;
//
//    public ResultPage() throws Exception {
//    }
//
//    public void create(){
//
//        try {
//            manager = new ModuleIntegrator(); // new CarManagerFileImp();
//        } catch (Exception e) {
//        }
//        Container con = getContentPane();
//        add(con);
//    }
//
//    public void add(Container con) {
//        ArrayList<FinalProject.dataproto.Vehicle> list = manager.integratorGetAllVehicles();
//        //GridLayout gl = new GridLayout(list.size(),1);
//        JPanel basepanel = new JPanel();
//        BoxLayout bl = new BoxLayout(basepanel,BoxLayout.Y_AXIS);
//        con.add(basepanel);
//        //con.setBackground(Color.white);
//        JScrollPane sp = new JScrollPane(basepanel);
//        con.add(sp);
//        basepanel.setLayout(bl);
//
//        if(list.size() ==0){
//            JPanel panelempty = new JPanel();
//            panelempty.setLayout(new FlowLayout(FlowLayout.CENTER));
//            this.empty = new JLabel("No Results, Please Try Again.");
//            panelempty.add(empty);
//            basepanel.add(panelempty);
//
//        }
//
//        for(int i = 0; i< list.size();i++){
//            FinalProject.dataproto.Vehicle car = list.get(i);
//            JPanel panel = new JPanel();
//            //BoxLayout bl1 = new BoxLayout(panel,BoxLayout.Y_AXIS);
//            FlowLayout fl =  new FlowLayout();
//            panel.setLayout(fl);
//            newComponent(panel,car,i);
//            panel.setBorder(BorderFactory.createBevelBorder(1));
//            basepanel.add(panel);
//            basepanel.add(Box.createVerticalStrut(15));
//
//        }
//    }
//
//    public void newComponent(JPanel panel,FinalProject.dataproto.Vehicle car, int i){
//
//        this.brand = new JLabel("Brand : ");
//        this.brandvalue = new JLabel(car.getBrand() + "  - ");
//        this.model = new JLabel("Model : ");
//        this.modelvalue = new JLabel(car.getModel()  + "                    ");
//        this.year = new JLabel("Year : ");
//        this.yearvalue = new JLabel(String.valueOf(car.getYear()) + "                ");
//        this.type = new JLabel("Type : ");
//        this.typevalue = new JLabel(car.getType()  + "         " );
//        this.category = new JLabel("Category : ");
//        this.categoryvalue = new JLabel(car.getCategory() + "                 ");
//        this.color = new JLabel("Color : ");
//        this.colorvalue = new JLabel(car.getColor() + "\n\n\n");
//        this.price = new JLabel("Price : ");
//        this.pricevalue = new JLabel(String.valueOf(car.getPrice()) + "0" + "         ");
//        this.mileage = new JLabel("Mailage: ");
//        this.mileagevalue = new JLabel(String.valueOf(car.getMileage()) + "                       ");
//        this.saleprice = new JLabel("Saleprice:");
//        this.salepricevalue = new JLabel(String.valueOf("$" + car.getSalePrice()) + "0" + "         ");
//        this.seedetail = new Button("see detail");
//        this.space = new JLabel("");
//
//        addPanelLeft(panel,brandvalue,modelvalue,year,yearvalue,categoryvalue,mileage,mileagevalue);
//        addPanelRight(i,panel,colorvalue,saleprice,salepricevalue,space,seedetail);
//
//    }
//
//    public void addPanelLeft(JPanel panel, JLabel brandvalue, JLabel modelvalue, JLabel year, JLabel yearvalue,JLabel categoryvalue,JLabel mileage,JLabel mileagevalue){
//        JPanel jp = new JPanel();
//        BoxLayout bl1 = new BoxLayout(jp,BoxLayout.Y_AXIS);
//        jp.setLayout(bl1);
//        addPanel2(jp,brandvalue,modelvalue);
//        addPanel2(jp,year, yearvalue);
//        addPanel1(jp,categoryvalue);
//        addPanel2(jp,mileage,mileagevalue);
//        panel.add(jp);
//    }
//
//    public void addPanelRight(int i,JPanel panel, JLabel colorvalue,JLabel saleprice,JLabel salepricevalue,JLabel space,Button seedetail){
//        String i1 = Integer.toString(i);
//        JPanel jp1 = new JPanel();
//        BoxLayout bl2 = new BoxLayout(jp1,BoxLayout.Y_AXIS);
//        jp1.setLayout(bl2);
//        addPanel1(jp1,colorvalue);
//        addPanel1(jp1,space);
//        addPanel2(jp1,saleprice,salepricevalue);
//        addPanel1(jp1,space);
//        jp1.add(seedetail);
//        seedetail.setName(i1);
//        seedetail.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    new DetailPage(seedetail.getName());
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//
//            }
//        });
//
//        panel.add(jp1);
//    }
//
//    public void addPanel1(JPanel panel,JLabel value){
//        JPanel jp2 = new JPanel();
//        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
//        jp2.add(value);
//        panel.add(jp2);
//    }
//
//    public void addPanel2(JPanel panel, JLabel value1,JLabel value2) {
//        JPanel jp2 = new JPanel();
//        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
//        jp2.add(value1);
//        jp2.add(value2);
//        panel.add(jp2);
//    }
//
//    @Override
//    public void addListeners() {
//
//    }
//
//    public static void main(String[] args) throws Exception {
//        new ResultPage();
//
//    }
//}
//
