package m1.team14.view;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import m1.team14.controller.DemoController;

public class DemoViewPanel extends JFrame implements IViewPanel {
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
    this.btn=new JButton("add");
    this.btn.addActionListener(e -> {
      this.demoController.addNumber(this.textField.getText());
    });
    this.btn.setBounds(130,100,100, 40);//x axis, y axis, width, height
    this.textField = new JTextField("0");
    this.textField.setBounds(130,40,100, 40);//x axis, y axis, width, height
    this.label = new JLabel("0");
    this.label.setBounds(130,200,100, 40);//x axis, y axis, width, height
    this.add(this.btn);
    this.add(this.textField);
    this.add(this.label);
    this.setSize(400,500);
    this.setLayout(null);
    this.setVisible(true);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
