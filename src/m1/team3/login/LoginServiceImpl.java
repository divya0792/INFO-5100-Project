package m1.team3.login;

import java.util.List;

public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDAO = new LoginDAOImpl();

	public boolean validateLogin(String loginID, String pwd) {

		User user = getUser(loginID);
		if (null != user) {
			if (rememberMe(loginID)) {
				return true;
			} else if (pwd.equals(user.getPwd())) {
				return true;
			}
		}
		return false;
	}

	public boolean rememberMe(String loginID) {
		User user = getUser(loginID);

		return user != null ? user.isRememberMe() : false;
	}

	public User getUser(String loginID) {
		List<User> allUsers = loginDAO.getAllUsers();

		User foundUser = null;
		for (User user : allUsers) {

			if (user.getUserID().equals(loginID)) {
				foundUser = user;
				break;

			} else if (user.getEmailID().equals(loginID)) {
				foundUser = user;
				break;

			} else if (user.getPhoneNumber().equals(loginID)) {
				foundUser = user;
				break;
			}

		}
		return foundUser;
	}

}
