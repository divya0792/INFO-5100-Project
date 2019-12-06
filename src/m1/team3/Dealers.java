package m1.team3;

import dataproto.Dealer;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Dealers {
  static private Dealers _instance;
  static public Dealers getInstance() {
    if (_instance == null) {
      _instance = new Dealers();
    }
    return _instance;
  };
  private ArrayList<Dealer> l;
  private Dealers() {
    l = new ArrayList<Dealer>();
  }
  public List<Dealer> getAllDealers() {
    return l;
  }
  public boolean add(Dealer dealer) {
    return l.add(dealer);
  }
}
