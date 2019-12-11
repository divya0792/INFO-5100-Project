package m3;

import dataproto.Dealer;
import m3.view.MenuPage;

public class Main {
  public static void main(String args[]) {
      Dealer dealer = new Dealer();
      dealer.setName("ABC");
      MenuPage page = new MenuPage(dealer);
  }
}
