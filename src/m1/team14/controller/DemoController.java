package m1.team14.controller;

import java.beans.PropertyChangeEvent;

public class DemoController extends AbstractController {

  public void addNumber(String val) {
    try {
      int currentNumber = Integer.parseInt(val);
      currentNumber++;
      this.setModelProperty("TotalNumber", currentNumber);
    } catch(Exception e) {
      System.out.println("DemoController.addNumber Error: " + e);
    }
  }
}
