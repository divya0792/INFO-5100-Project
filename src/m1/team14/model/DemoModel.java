package m1.team14.model;

import m1.team14.DemoEvents;
import java.lang.Integer;

public class DemoModel extends AbstractModel {
  private int totalNumber;

  public void setTotalNumber(Integer id) {
    int oldId = this.totalNumber;
    this.totalNumber = id;
    if (oldId != id)  {
      firePropertyChange(DemoEvents.BTN_ADD, oldId, id);
    }
  }

  public int getTotalNumber() {
    return totalNumber;
  }
}
