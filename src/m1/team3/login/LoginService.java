package m1.team3.login;

public interface LoginService {
	
	
	public boolean validateLogin(String userID, String pwd) ;
	
	public boolean rememberMe(String uName) ;
	
	public User getUser(String loginID) ;

}
