package m1.team14.model;

import m1.team14.Events;

class DealerSelectModel extends AbstractModel {
  private int currentDealerId;

  public void setCurrentDealerId(int id) {
    int oldId = this.currentDealerId;
    this.currentDealerId = id;
    if (oldId != id)  {
      firePropertyChange(Events.DEALER_ID_CHANGE, oldId, id);
    }
  }

  public int getCurrentDealerId() {
    return currentDealerId;
  }
}
