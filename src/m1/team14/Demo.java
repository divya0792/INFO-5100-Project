package m1.team14;

import m1.team14.view.*;
import m1.team14.model.*;
import m1.team14.controller.*;

public class Demo {
  public static void main(String args[]){
    DemoController c = new DemoController();
    DemoModel m = new DemoModel();
    DemoViewPanel v =new DemoViewPanel(c);
    c.addModel(m);
    c.addView(v);
  }
}
