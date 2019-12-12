package m1.team14.controller;
import java.util.List;
import dataproto.Dealer;
import dataproto.RichText;
import m1.team2.DealerAllContent;
import m1.team3.login.VMSLoginFrame;
import m1.DAO.DealerDAOImpl;
import m1.DAO.DealerContentDAOImpl;
import m4.Team4.UserUI;
// For demo///////////////////
import javax.swing.JOptionPane;
//////////////////////////////
public class HomePageController extends AbstractController {
  public List<Dealer> getDealers() {
    List<Dealer> ret = DealerDAOImpl.INSTANCE.getAllDealer();
    return ret;
  }
  public DealerAllContent getRichTextsByDealer(Dealer dealer) {
    return DealerContentDAOImpl.INSTANCE.getContents(dealer);
  }
  public void changeDealer(Dealer val) {
    try {
      this.setModelProperty("CurrentDealer", val);
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void gotoLogin() {
    new VMSLoginFrame();
  }
  public void gotoHistory() {
    new UserUI();
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
