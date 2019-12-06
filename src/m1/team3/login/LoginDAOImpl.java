package m1.team3.login;

import java.util.ArrayList;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {
	private static List<User> defaultUsers = new ArrayList<>();
	
	static {
		
		User user = new User();
		user.setUserID("u1");
		user.setPwd("p1");
		user.setEmailID("u1@gmail.com");
		user.setPhoneNumber("123456789");
		defaultUsers.add(user);
	}

	@Override
	public List<User> getAllUsers() {
		return defaultUsers;
	}

	@Override
	public User signUpUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
