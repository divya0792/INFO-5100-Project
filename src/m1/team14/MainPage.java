package m1.team14;

import m1.team14.view.*;
import m1.team14.model.*;
import m1.team14.controller.*;

public class MainPage {
  public MainPage() {
    HomePageController hpController = new HomePageController();
    HomePageModel hpModel = new HomePageModel();
    hpController.addModel(hpModel);
    SecondHalfViewPanel sfView = new SecondHalfViewPanel(hpController);
    HomepageFrame hpfView = new HomepageFrame(hpController, sfView);
    hpController.addView(hpfView);
  }
}
