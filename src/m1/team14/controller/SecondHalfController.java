package m1.team14.controller;

public class SecondHalfController extends AbstractController {

  public void changeStyle(String val) {
    try {
      //TODO
      int currentNumber = Integer.parseInt(val);
      currentNumber++;
      this.setModelProperty("Width", currentNumber);
    } catch(Exception ex) {
      //  Handle exception.
      ex.printStackTrace();
    }
  }
}
