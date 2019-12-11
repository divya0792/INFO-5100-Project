package m1.DAO;

import dataproto.Dealer;

import java.util.List;
import java.util.Optional;

public interface DealerDAO {
    List<Dealer> getAllDealer();
    // return null if email not exist
    Optional<Dealer> getDealerWithEmail(String email);

    // return null if name not exist
    Optional<Dealer> getDealerWithName(String name);

    // update or insert new dealer
    // return false if failed
    boolean updateDealer(Dealer dealer);

}
