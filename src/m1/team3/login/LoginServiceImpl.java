package m1.team3.login;

import java.util.Optional;

import dataproto.Dealer;
import m1.DAO.DealerDAO;
import m1.DAO.DealerDAOImpl;

public class LoginServiceImpl implements LoginService {

	private DealerDAO dealerDAO = DealerDAOImpl.INSTANCE;



	public Dealer validateLogin(String loginID, String pwd) {

		Dealer dealer = getDealer(loginID);
		if (null != dealer && pwd.equals(dealer.getPassword())) {
				return dealer;
			}
		return null;
	}


	public Dealer getDealer(String loginID) {
		Dealer foundUser = null;

		Optional<Dealer> optional = dealerDAO.getDealerWithEmail(loginID);
		if(optional.isPresent()) {
			foundUser  = optional.get();
		}else {
			Optional<Dealer> dealerWithPhone = dealerDAO.getDealerWithPhone(loginID);
			if(dealerWithPhone.isPresent()) {
				foundUser  = dealerWithPhone.get();
			}
		}
		return foundUser;
	}

}
