package m1.team14.model;

import dataproto.Dealer;
import dataproto.RichText;

import m1.team14.Events;
import java.lang.Integer;

public class HomePageModel extends AbstractModel {
  private String dealerID;
  private Dealer dealer;
  // private

  public HomePageModel() {
    super();
    this.dealer = new Dealer();
    // this.rawData = getData();
  }
  public HomePageModel(Dealer dealer) {
    super();
    this.dealerID = "";
    this.dealer = dealer;
    // this.rawData = getData();
  }

  private Object getData() {
    //TOD
    return new Object();
  }

  public void setDealerId(String value) {
    String oldValue = this.dealerID;
    if (!oldValue.equals(value))  {
      this.dealerID = value;
      firePropertyChange(Events.DEALER_ID_CHANGE, oldValue, value);
    }
  }

  public String getDealerId() {
    return dealerID;
  }
}
