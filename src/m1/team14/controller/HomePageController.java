package m1.team14.controller;

// For demo///////////////////
import javax.swing.JOptionPane;
//////////////////////////////
public class HomePageController extends AbstractController {

  public void changeDealer(String val) {
    try {
      this.setModelProperty("DealerId", val);
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void gotoLogin() {
    //TODO
  }
  public void gotoHistory() {
    //TODO
  }
  public void gotoSearch() {
    // For demo///////////////////
    JOptionPane.showMessageDialog(null, "Go to search page");
    //////////////////////////////
  }
  public void gotoDetail() {
    // For demo///////////////////
    JOptionPane.showMessageDialog(null, "Go to detail page");
    //////////////////////////////
  }
  public void contactMe() {
    // For demo///////////////////
    JOptionPane.showMessageDialog(null, "Contact me");
    //////////////////////////////
  }
}
