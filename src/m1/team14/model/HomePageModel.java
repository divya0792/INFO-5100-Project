package m1.team14.model;

import dataproto.Dealer;
import m1.team14.Events;

public class HomePageModel extends AbstractModel {
  private Dealer currentDealer;

  public HomePageModel() {
    super();
  }

  public void setCurrentDealer(Dealer value) {
    Dealer oldValue = this.currentDealer;
    if (oldValue != value)  {
      this.currentDealer = value;
      firePropertyChange(Events.DEALER_ID_CHANGE, oldValue, value);
    }
  }

  public Dealer getCurrentDealer() {
    return currentDealer;
  }
}
