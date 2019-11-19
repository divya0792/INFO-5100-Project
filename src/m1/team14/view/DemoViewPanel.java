package m1.team14.view;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import m1.team14.controller.DemoController;

public class DemoViewPanel extends JFrame implements AbstractViewPanel {
  private DemoController demoController;
  private JButton btn;
  private JTextField textField;
  private JLabel label;
  private static final long serialVersionUID = 4L;

  public DemoViewPanel(DemoController demoController) {
    this.demoController = demoController;
    this.initComponent();
    this.localInitialization();
  }
  private void initComponent() {
    this.btn=new JButton("add");//creating instance of JButton
    this.btn.addActionListener(e -> {
      this.demoController.addNumber(this.textField.getText());
    });
    this.btn.setBounds(130,100,100, 40);//x axis, y axis, width, height
    this.textField = new JTextField("0");
    this.textField.setBounds(130,40,100, 40);//x axis, y axis, width, height
    this.label = new JLabel("0");
    this.label.setBounds(130,200,100, 40);//x axis, y axis, width, height
    this.add(this.btn);//adding button in JFrame
    this.add(this.textField);//adding button in JFrame
    this.add(this.label);//adding button in JFrame
    this.setSize(400,500);//400 width and 500 height
    this.setLayout(null);//using no layout managers
    this.setVisible(true);//making the frame visible
  }
  private void localInitialization() {

  }
  @Override
  public void modelPropertyChange(final PropertyChangeEvent evt) {
    Integer newValue = (Integer)evt.getNewValue();
    String valString = Integer.toString(newValue);
    this.textField.setText(valString);
    this.label.setText(valString);
  }
}
