package m1.DAO;

import dataproto.Dealer;
import m1.team3.Dealers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DealerDAOImpl implements DealerDAO{
    public static final DealerDAOImpl INSTANCE = new DealerDAOImpl();

    private List<Dealer> dealers;



    private DealerDAOImpl() {
        dealers = new ArrayList<>();
        mockData(dealers);
    }

    @Override
    public List<Dealer> getAllDealer() {
        return dealers.stream().map(this::copy).collect(Collectors.toList());
    }
    // use ret.isPresent() to check if the dealer exist;
    public Optional<Dealer> getDealerWithEmail(String email) {
        if (email == null) {
            return Optional.empty();
        }
        return dealers.stream().filter(dealer -> email.equals(dealer.getEmailId())).map(this::copy).findFirst();
    }

    // return null if name not exist
    public Optional<Dealer> getDealerWithName(String name) {
        if (name == null) {
            return Optional.empty();
        }
        return dealers.stream().filter(dealer -> name.equals(dealer.getName())).map(this::copy).findFirst();
    }

    // update or insert new dealer
    // return false if failed
    public boolean updateDealer(Dealer dealer) {
        Optional<Dealer> targetOption = getDealerWithName(dealer.getName());

        if (targetOption.isPresent()) {
            // update
            Dealer dealerInData = targetOption.get();
            copy(dealerInData, dealer);

        } else {
            // insert
            dealers.add(copy(dealer));

        }
        return true;
    }


    private Dealer copy(Dealer ori) {
        Dealer dealer = new Dealer();
        copy(ori, dealer);
        return dealer;
    }

    private void copy(Dealer ori, Dealer target) {

        target.setId(ori.getId());
        target.setName(ori.getName());
        target.setPassword(ori.getPassword());
        target.setPhone(ori.getPhone());
        target.setEmailId(ori.getEmailId());
    }

    private void mockData(List<Dealer> dealers) {
        Dealer t1 = new Dealer();
        t1.setId("u1");
        t1.setName("dealer 1");
        t1.setPassword("p1");
        t1.setPhone("1111111111");
        t1.setEmailId("u1@gmail.com");
        Dealer t2 = new Dealer();
        t2.setId("u2");
        t2.setName("dealer 2");
        t2.setPassword("p2");
        t2.setPhone("1111111112");
        t2.setEmailId("u2@gmail.com");
        Dealer t3 = new Dealer();
        t3.setId("u3");
        t3.setName("dealer 3");
        t3.setPassword("p3");
        t3.setPhone("1111111113");
        t3.setEmailId("u3@gmail.com");
        Dealer t4 = new Dealer();
        t4.setId("u4");
        t4.setName("dealer 4");
        t4.setPassword("p4");
        t4.setPhone("1111111114");
        t4.setEmailId("u4@gmail.com");
        Dealer t5 = new Dealer();
        t5.setId("u5");
        t5.setName("dealer 5");
        t5.setPassword("p5");
        t5.setPhone("1111111115");
        t5.setEmailId("u5@gmail.com");
        Dealer t6 = new Dealer();
        t6.setId("u6");
        t6.setName("dealer 6");
        t6.setPassword("p6");
        t6.setPhone("1111111116");
        t6.setEmailId("u6@gmail.com");
        Dealer t7 = new Dealer();
        t7.setId("u7");
        t7.setName("dealer 7");
        t7.setPassword("p7");
        t7.setPhone("1111111117");
        t7.setEmailId("u7@gmail.com");
        Dealer t8 = new Dealer();
        t8.setId("u8");
        t8.setName("dealer 8");
        t8.setPassword("p8");
        t8.setPhone("1111111118");
        t8.setEmailId("u8@gmail.com");

        dealers.add(t1);
        dealers.add(t2);
        dealers.add(t3);
        dealers.add(t4);
        dealers.add(t5);
        dealers.add(t6);
        dealers.add(t7);
        dealers.add(t8);
    }
}
