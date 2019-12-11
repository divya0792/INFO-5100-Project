package m1.team3.login;

import dataproto.Dealer;

public interface LoginService {
	
	
	public boolean validateLogin(String userID, String pwd) ;
	
	public Dealer getDealer(String loginID) ;
}
