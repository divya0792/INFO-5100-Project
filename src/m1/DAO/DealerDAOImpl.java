package m1.DAO;

import dataproto.Dealer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DealerDAOImpl implements DealerDAO{

    public static final String DEALER_INSERT_PATTERN = "INSERT INTO Dealer " +
            "(EmailID, Name, Phone, Password, Address, icon_url) " +
            "VALUES " +
            "(?, ?, ?, ?, ?, ?)";

    public static final String GET_DEALER_BY_NAME = "SELECT * from Dealer WHERE Name = ?";
    public static final String GET_DEALER_BY_EMAIL = "SELECT * from Dealer WHERE EmailID = ?";
    public static final String GET_DEALER_BY_PHONE = "SELECT * from Dealer WHERE Phone = ?";

    public static final String GET_ALL_DEALERS = "select * from Dealer ";
    // UPDATE table_name
//    SET column1 = value1, column2 = value2, ...
//    WHERE condition;
    public static final String DEALER_UPDATE_PATTERN = "UPDATE Dealer " +
            "set " +
            "EmailID = ?, " +
            "Name = ?, " +
            "Phone = ?, " +
            "Password = ?, " +
            "Address = ?, " +
            "icon_url = ?, " +
            "head_info_id = ?, " +
            "foot_info_id = ?, " +
            "left_info_id = ?, " +
            "right_info_id = ? " +
            "WHERE " +
            "id = ?";
    public static final DealerDAOImpl INSTANCE = new DealerDAOImpl();

    private List<Dealer> dealers;

    private DealerDAOImpl() {
        dealers = new ArrayList<>();
        mockData(dealers);
    }

//    @Override
//    public List<Dealer> getAllDealer() {
//
//        return dealers.stream().map(this::copy).collect(Collectors.toList());
//    }

    @Override
    public List<Dealer> getAllDealer() {
        List<Dealer> ret = new ArrayList<>();
        try {
            ResultSet r = DBConnector.INSTANCE.getStmt().executeQuery(GET_ALL_DEALERS);
            while (r.next()) {
                ret.add(DataConverter.toDealer(r));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
    // use ret.isPresent() to check if the dealer exist;
//    @Override
//    public Optional<Dealer> getDealerWithEmail(String email) {
//        if (email == null) {
//            return Optional.empty();
//        }
//        return dealers.stream().filter(dealer -> email.equals(dealer.getEmailId())).map(this::copy).findFirst();
//    }

    @Override
    public Optional<Dealer> getDealerWithEmail(String email) {
        try {
            ResultSet r = DBConnector.INSTANCE.query(GET_DEALER_BY_EMAIL, new String[]{email});
            if (r.next()) {
                return Optional.of(DataConverter.toDealer(r));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

//    @Override
//    public Optional<Dealer> getDealerWithPhone(String phone) {
//        if (phone == null) {
//            return Optional.empty();
//        }
//        return dealers.stream().filter(dealer -> phone.equals(dealer.getPhone())).map(this::copy).findFirst();
//    }

    @Override
    public Optional<Dealer> getDealerWithPhone(String phone) {
        try {
            ResultSet r = DBConnector.INSTANCE.query(GET_DEALER_BY_PHONE, new String[]{phone});
            if (r.next()) {
                return Optional.of(DataConverter.toDealer(r));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

//    @Override
//    public Optional<Dealer> getDealerWithName(String name) {
//        if (name == null) {
//            return Optional.empty();
//        }
//        return dealers.stream().filter(dealer -> name.equals(dealer.getName())).map(this::copy).findFirst();
//    }

    @Override
    public Optional<Dealer> getDealerWithName(String name) {
        try {
            ResultSet r = DBConnector.INSTANCE.query(GET_DEALER_BY_NAME, new String[]{name});
            if (r.next()) {
                return Optional.of(DataConverter.toDealer(r));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // updatedealer
    // return false if failed
//    @Override
//    public boolean updateDealer(Dealer dealer) {
//        Optional<Dealer> targetOption = getDealerWithName(dealer.getName());
//
//        if (targetOption.isPresent()) {
//            // update
//            Dealer dealerInData = targetOption.get();
//            copy(dealerInData, dealer);
//            return true;
//
//        } else {
//            // insert
//            return false;
//
//        }
//    }

//    "set " +
//            "EmailID = ?, " +
//            "Name = ?, " +
//            "Phone = ?, " +
//            "Password = ?, " +
//            "head_info_id = ?, " +
//            "foot_info_id = ?, " +
//            "left_info_id = ?, " +
//            "right_info_id = ? " +
//            "WHERE " +
//            "DealerId = ?";
    @Override
    public boolean updateDealer(Dealer dealer) {
        try {
            DBConnector.INSTANCE.update(DEALER_UPDATE_PATTERN, new String[]{
                    dealer.getEmailId(),
                    dealer.getName(),
                    dealer.getPhone(),
                    dealer.getPassword(),
                    dealer.getAddress(),
                    dealer.getIconURL(),
                    dealer.getHeadInfoId(),
                    dealer.getFootInfoId(),
                    dealer.getLeftInfoId(),
                    dealer.getRightInfoId(),
                    dealer.getId()
            });
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // isert dealer
    // return false if failed
//    @Override
//    public boolean insertDealer(Dealer dealer) {
//        Optional<Dealer> targetOption = getDealerWithName(dealer.getName());
//
//        if (targetOption.isPresent()) {
//            // update
//            return false;
//
//        } else {
//            // insert
//            dealers.add(copy(dealer));
//            return true;
//
//        }
//
//    }

    //EmailID, Name, Phone, Password, head_info_id, foot_info_id, left_info_id, right_info_id
    @Override
    public boolean insertDealer(Dealer dealer) {
        try {
            DBConnector.INSTANCE.update(DEALER_INSERT_PATTERN, new String[]{
                    dealer.getEmailId(),
                    dealer.getName(),
                    dealer.getPhone(),
                    dealer.getPassword(),
                    dealer.getAddress(),
                    dealer.getIconURL()
            });
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




    private static Dealer copy(Dealer ori) {
        Dealer dealer = new Dealer();
        copy(ori, dealer);
        return dealer;
    }

    private static void copy(Dealer ori, Dealer target) {

        target.setId(ori.getId());
        target.setName(ori.getName());
        target.setPassword(ori.getPassword());
        target.setPhone(ori.getPhone());
        target.setEmailId(ori.getEmailId());
    }

    private static void mockData(List<Dealer> dealers) {
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


    public static void main(String[] args) {
        System.out.println(DealerDAOImpl.INSTANCE.getAllDealer());
        System.out.println(DealerDAOImpl.INSTANCE.getDealerWithName("John"));
        System.out.println(DealerDAOImpl.INSTANCE.getDealerWithName("e"));

        Dealer d = DealerDAOImpl.INSTANCE.getDealerWithName("test").get();
//        d.setName("test");
        d.setPhone("111");
        d.setEmailId("test");
        d.setAddress("testAddress");

        System.out.println(DealerDAOImpl.INSTANCE.updateDealer(d));
//        System.out.println(DealerDAOImpl.INSTANCE.);
    }
}
