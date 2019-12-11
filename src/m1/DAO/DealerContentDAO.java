package m1.DAO;

import dataproto.Dealer;
import m1.team2.DealerAllContent;

public interface DealerContentDAO {
    DealerAllContent getContents(Dealer dealer);
    boolean updateContents(Dealer dealer, DealerAllContent dealerAllContent);
}
