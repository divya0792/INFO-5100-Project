package m1.DAO;

import dataproto.Dealer;

import java.util.List;
import java.util.Optional;

public interface DealerDAO {
    List<Dealer> getAllDealer();
    // use ret.isPresent() to check if the dealer exist;
    Optional<Dealer> getDealerWithEmail(String email);
    Optional<Dealer> getDealerWithName(String name);
    Optional<Dealer> getDealerWithPhone(String phone);

    // update dealer
    // return false if failed
    boolean updateDealer(Dealer dealer);

    // insert new Dealer
    boolean insertDealer(Dealer dealer);

}
