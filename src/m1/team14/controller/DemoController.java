package m1.team14.controller;

public class DemoController extends AbstractController {

  public void addNumber(String val) {
    try {
      int currentNumber = Integer.parseInt(val);
      currentNumber++;
      this.setModelProperty("TotalNumber", currentNumber);
    } catch(Exception ex) {
      //  Handle exception.
      ex.printStackTrace();
    }
  }
}
