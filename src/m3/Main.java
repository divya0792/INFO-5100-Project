package m3;

import dataproto.Dealer;
import m3.view.MenuPage;

public class Main {
  public static void main(String args[]) {
      Dealer dealer = new Dealer("0", "Bob", "rtyui");
      MenuPage page = new MenuPage(dealer);
  }
}
