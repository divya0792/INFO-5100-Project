package m1.team14.model;

import m1.team14.Events;
import java.lang.Integer;

public class SecondHalfModel extends AbstractModel {
  private Object rawData;
  private int width;
  private Dealer dealer;

  public SecondHalfModel(Dealer dealer) {
    super();
    this.width = 0;
    this.dealer = dealer;
    this.rawData = getData();
  }

  private Object getData() {
    //TOD
    return new Object();
  }

  public void setWidth(Integer value) {
    int oldValue = this.width;
    this.width = value;
    if (oldValue != width)  {
      firePropertyChange(Events.SECOND_LEFT_WIDTH_CHANGE, oldValue, value);
    }
  }

  public int getWidth() {
    return width;
  }
}
